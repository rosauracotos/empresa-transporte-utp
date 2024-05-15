import { Component } from '@angular/core';
import {ApiBackendService} from "../../services/ApiBackendService/api.backend.service";
import {SweetAlertService} from "../../services/SweetAlertService/sweet.alert.service";
import {Router} from "@angular/router";
import {LocalStorageService} from "../../services/LocalStorageService/local.storage.service";

@Component({
  selector: 'app-personal-formulario',
  templateUrl: './personal-formulario.component.html',
  styleUrl: './personal-formulario.component.css'
})
export class PersonalFormularioComponent {
  codigo: string = '';
  nombre: string = '';
  apellidoPaterno: string = '';
  apellidoMaterno: string = '';
  selectedDateNacimiento: string = '';
  selectedTipoDocumento: any ;
  numeroDocumento: string = '';
  numeroCelular: string = '';
  direccion: string = '';
  email: string = '';
  selectedGenero: any ;
  selectedEstadoCivil: any ;
  selectedDepartamento: any ;
  selectedProvincia: any ;
  selectedDistrito: any ;

  tiposDocumentos : any[] = [];
  generos : any[] = [];
  estadosCiviles : any[] = [];
  departamentos : any[] = [];
  provincias : any[] = [];
  distritos : any[] = [];

  constructor(private apiBackendService: ApiBackendService,
              private sweetAlertService: SweetAlertService,
              private localStorageService: LocalStorageService,
              private router: Router) {}

  ngOnInit() {
    this.apiBackendService.obtenerTiposDocumentos().subscribe(
      (response) => {
        this.tiposDocumentos = response;
      },
      (error) => {
        this.sweetAlertService.showAlertError("Ocurrió un error al conectar al servidor");
      }
    );
    this.apiBackendService.obtenerGeneros().subscribe(
      (response) => {
        this.generos = response;
      },
      (error) => {
        this.sweetAlertService.showAlertError("Ocurrió un error al conectar al servidor");
      }
    );
    this.apiBackendService.obtenerEstadoCiviles().subscribe(
      (response) => {
        this.estadosCiviles = response;
      },
      (error) => {
        this.sweetAlertService.showAlertError("Ocurrió un error al conectar al servidor");
      }
    );
    this.apiBackendService.obtenerDepartamentos().subscribe(
      (response) => {
        this.departamentos = response;
      },
      (error) => {
        this.sweetAlertService.showAlertError("Ocurrió un error al conectar al servidor");
      }
    );
  }
  onSubmit() {
    const fecha = new Date(this.selectedDateNacimiento);
    const año = fecha.getFullYear();
    const mes = fecha.getMonth() + 1; // Los meses en JavaScript son base 0, por lo que necesitas sumar 1
    const dia = fecha.getDate();
    const fechaFormateada = `${año}-${mes.toString().padStart(2, '0')}-${dia.toString().padStart(2, '0')}`;

    this.apiBackendService.guardarColaborador(this.apellidoPaterno, this.apellidoMaterno, this.nombre,
      this.numeroDocumento, fechaFormateada, this.numeroCelular, this.direccion, this.email,
      this.selectedTipoDocumento, this.selectedGenero, this.selectedEstadoCivil, this.selectedDistrito).subscribe(
      (response) =>{
        this.sweetAlertService.showAlertSuccess(response.mensaje);
        this.localStorageService.setItem('colaboradorId', response.extraInfo);
        this.router.navigate(['/personal-laborales-formulario'])
      },
      (error) => {
        this.sweetAlertService.showAlertError("Ocurrió un error al conectar al servidor");
      }
    );
  }

  onDepartamentoSelectionChange(event: any) {
    this.selectedProvincia = null;
    this.selectedDistrito = null;
    this.apiBackendService.obtenerProvinciasPorDepartamento(this.selectedDepartamento).subscribe(
      (response) => {
        this.provincias = response;
      },
      (error) => {
        this.sweetAlertService.showAlertError("Ocurrió un error al conectar al servidor");
      }
    );
  }

  onProvinciaSelectionChange(event:any) {
    this.selectedDistrito = null;
    this.apiBackendService.obtenerDistrirosPorProvincia(this.selectedProvincia).subscribe(
      (response) => {
        this.distritos = response;
      },
      (error) => {
        this.sweetAlertService.showAlertError("Ocurrió un error al conectar al servidor");
      }
    );
  }



}
