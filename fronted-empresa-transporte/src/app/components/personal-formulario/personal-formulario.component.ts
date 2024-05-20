import { Component } from '@angular/core';
import {ApiBackendService} from "../../services/ApiBackendService/api.backend.service";
import {SweetAlertService} from "../../services/SweetAlertService/sweet.alert.service";
import {Router} from "@angular/router";
import {LocalStorageService} from "../../services/LocalStorageService/local.storage.service";
import {Utilidades} from "../../../utils/utilidades";
import { ActivatedRoute } from '@angular/router';

@Component({
  selector: 'app-personal-formulario',
  templateUrl: './personal-formulario.component.html',
  styleUrl: './personal-formulario.component.css'
})
export class PersonalFormularioComponent {
  ocultarBotonGuardar: boolean = false;
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

  colaboradorId: any;

  isReadOnly: boolean = false;

  constructor(private apiBackendService: ApiBackendService,
              private sweetAlertService: SweetAlertService,
              private localStorageService: LocalStorageService,
              private route: ActivatedRoute,
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
    this.colaboradorId = this.localStorageService.getItem("colaboradorId");
    this.ocultarBotonGuardar = this.localStorageService.getItem("ocultarBotonGuardar");
    console.log(this.colaboradorId);
    if (!Utilidades.esNullOUndefinedoVacio(this.colaboradorId)) {
      this.obtenerDatosColaborador(this.colaboradorId);
    };
    this.route.queryParams.subscribe(params => {
      this.isReadOnly = params['readOnly'] === 'true'; // Ejemplo de acceso a un parámetro
    });
  }

  obtenerDatosColaborador(colaboradorId: number) {
    this.apiBackendService.obtenerColaboradorPorId(colaboradorId).subscribe(
      (response) => {
        console.log(response);
        this.codigo = response.codigo;
        this.nombre = response.nombre;
        this.apellidoPaterno = response.apellidoPaterno;
        this.apellidoMaterno = response.apellidoMaterno;
        this.selectedTipoDocumento = response.tipoDocumento.id;
        this.numeroDocumento = response.numeroIdentificacion;
        this.numeroCelular = response.celular;
        this.direccion = response.direccion;
        this.email = response.correo;
        this.selectedGenero = response.tipoGenero.id;
        this.selectedEstadoCivil = response.estadoCivil.id;
        this.selectedDistrito = response.distrito.id;
        this.selectedDepartamento = response.distrito.provincia.departamento.id;
        this.selectedProvincia = response.distrito.provincia.id;
        this.selectedDateNacimiento = response.fechaNacimiento;

        this.apiBackendService.obtenerProvinciasPorDepartamento(this.selectedDepartamento).subscribe(
          (response) => {
            this.provincias = response;
          },
          (error) => {
            this.sweetAlertService.showAlertError("Ocurrió un error al conectar al servidor");
          }
        );

        this.apiBackendService.obtenerDistrirosPorProvincia(this.selectedProvincia).subscribe(
          (response) => {
            this.distritos = response;
          },
          (error) => {
            this.sweetAlertService.showAlertError("Ocurrió un error al conectar al servidor");
          }
        );

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

    if (!Utilidades.esNullOUndefinedoVacio(this.colaboradorId)) {
      this.apiBackendService.editarColaborador(this.apellidoPaterno, this.apellidoMaterno, this.nombre,
        this.numeroDocumento, fechaFormateada, this.numeroCelular, this.direccion, this.email,
        this.selectedTipoDocumento, this.selectedGenero, this.selectedEstadoCivil, this.selectedDistrito, this.colaboradorId).subscribe(
        (response) =>{
          this.sweetAlertService.showAlertSuccess(response.mensaje);
          this.localStorageService.setItem('colaboradorId', response.extraInfo);
          this.router.navigate(['/personal'])
        },
        (error) => {
          this.sweetAlertService.showAlertError("Ocurrió un error al conectar al servidor");
        }
      );
    } else {
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

  cancelar() {
    this.router.navigate(['/personal'])
  }



}
