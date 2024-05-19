import { Component } from '@angular/core';
import {ApiBackendService} from "../../services/ApiBackendService/api.backend.service";
import {SweetAlertService} from "../../services/SweetAlertService/sweet.alert.service";
import {LocalStorageService} from "../../services/LocalStorageService/local.storage.service";
import {Router} from "@angular/router";
import {Utilidades} from "../../../utils/utilidades";
import {ColaboradorDto} from "../../models/ColaboradorDto";
import {BoletaPagoDto} from "../../models/BoletaPagoDto";
import {MatTableDataSource} from "@angular/material/table";

@Component({
  selector: 'app-boletas',
  templateUrl: './boletas.component.html',
  styleUrl: './boletas.component.css'
})
export class BoletasComponent {
  pdfData: string = '';

  displayedColumns: string[] = ['year','month','lastModified','acciones'];
  dataSource = new MatTableDataSource<BoletaPagoDto>();

  selectedYear: any;
  years: number[] = [];
  nombre: string = '';
  numeroIdentificacion: string = '';

  constructor(private apiBackendService: ApiBackendService,
              private sweetAlertService: SweetAlertService,
              private localStorageService: LocalStorageService,
              private router: Router) {
  }

  ngOnInit() {
    this.nombre = this.localStorageService.getItem('nombreUsuarioLogueado');
    this.numeroIdentificacion = this.localStorageService.getItem('numeroIdentificacion');
    console.log(this.nombre);
    console.log(this.numeroIdentificacion);
    this.loadYears();
    this.buscarPorDNI();
  }

  loadYears() {
    const currentYear = new Date().getFullYear();
    for (let year = 2020; year <= 2024; year++) {
      this.years.push(year);
    }
    this.selectedYear = currentYear;
  }

  buscarPorDNI() {
    this.apiBackendService.obtenerListaPDFs(this.numeroIdentificacion, this.selectedYear).subscribe(
      (response) =>{
        const datos: BoletaPagoDto[] = response.map((data: any) => new BoletaPagoDto(data));
        this.dataSource.data = datos;
      },
      (error) => {
        this.sweetAlertService.showAlertError("Ocurrió un error al conectar al servidor");
      }
    );
  }

  visualizarPDF(datos: BoletaPagoDto) {
    const nombreArchivo = this.numeroIdentificacion + '_' + datos.year.toString() + '_' + Utilidades.formatMesNumero(datos.month) + '.pdf';
    this.apiBackendService.visualizarPDF(nombreArchivo).subscribe(
      (response: Blob) => {
        const reader = new FileReader();
        reader.onloadend = () => {
          this.pdfData = reader.result as string;
        };
        reader.readAsDataURL(response);
      },
      (error) => {
        this.sweetAlertService.showAlertError("Ocurrió un error al conectar al servidor");
      }
    );
  }


  arrayBufferToBase64(buffer: ArrayBuffer): string {
    let binary = '';
    const bytes = new Uint8Array(buffer);
    const len = bytes.byteLength;
    for (let i = 0; i < len; i++) {
      binary += String.fromCharCode(bytes[i]);
    }
    return btoa(binary);
  }


}
