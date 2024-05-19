package empresaTransporte.utp.util.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PDFInfoDTO {

    private int year;
    private int month;
    private String monthName;
    private long lastModified;

    public PDFInfoDTO(int year, int month, String monthName, long lastModified) {
        this.year = year;
        this.month = month;
        this.monthName = monthName;
        this.lastModified = lastModified;
    }

}
