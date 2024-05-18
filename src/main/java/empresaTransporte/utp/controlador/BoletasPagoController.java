package empresaTransporte.utp.controlador;

import empresaTransporte.utp.util.dto.PDFInfoDTO;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.io.File;
import java.io.FilenameFilter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@RestController
@RequestMapping("/api/boletasPago")
public class BoletasPagoController {

    @Value("${pdf.directory}")
    private String pdfDirectory;

    @GetMapping("/count-pdfs")
    public int countPDFs(@RequestParam String dni, @RequestParam int year) {
        final String regex = Pattern.quote(dni) + "_" + year + "_\\d{2}.pdf";

        File directory = new File(pdfDirectory);
        if (!directory.exists() || !directory.isDirectory()) {
            throw new RuntimeException("El directorio de PDF no existe o no es un directorio válido.");
        }

        File[] matchingFiles = directory.listFiles(new FilenameFilter() {
            @Override
            public boolean accept(File dir, String name) {
                return name.matches(regex);
            }
        });

        return matchingFiles.length;
    }

    @GetMapping("/pdfs-info")
    public List<PDFInfoDTO> getPdfInfo(@RequestParam String dni, @RequestParam int year) {
        final String regex = Pattern.quote(dni) + "_" + year + "_(\\d{2})\\.pdf";

        File directory = new File(pdfDirectory);
        if (!directory.exists() || !directory.isDirectory()) {
            throw new RuntimeException("El directorio de PDF no existe o no es un directorio válido.");
        }

        File[] matchingFiles = directory.listFiles((dir, name) -> name.matches(regex));

        List<PDFInfoDTO> pdfInfoList = new ArrayList<>();

        if (matchingFiles != null) {
            Pattern pattern = Pattern.compile(regex);

            // Mapeo de número de mes a nombre de mes en español
            Map<Integer, String> monthNames = new HashMap<>();
            monthNames.put(1, "Enero");
            monthNames.put(2, "Febrero");
            monthNames.put(3, "Marzo");
            monthNames.put(4, "Abril");
            monthNames.put(5, "Mayo");
            monthNames.put(6, "Junio");
            monthNames.put(7, "Julio");
            monthNames.put(8, "Agosto");
            monthNames.put(9, "Septiembre");
            monthNames.put(10, "Octubre");
            monthNames.put(11, "Noviembre");
            monthNames.put(12, "Diciembre");

            for (File file : matchingFiles) {
                Matcher matcher = pattern.matcher(file.getName());
                if (matcher.find()) {
                    int month = Integer.parseInt(matcher.group(1));
                    long lastModified = file.lastModified();
                    String monthName = monthNames.get(month);
                    pdfInfoList.add(new PDFInfoDTO(year, month, monthName, lastModified));
                }
            }
        }

        return pdfInfoList;
    }

    @GetMapping(value = "/pdf/{filename}", produces = MediaType.APPLICATION_PDF_VALUE)
    public byte[] getPdf(@PathVariable String filename) throws IOException {
        Path file = Paths.get(pdfDirectory, filename);
        return Files.readAllBytes(file);
    }



}
