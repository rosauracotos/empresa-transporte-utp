import { Component } from '@angular/core';
import {ApiBackendService} from "../../services/ApiBackendService/api.backend.service";
import {SweetAlertService} from "../../services/SweetAlertService/sweet.alert.service";
import {Utilidades} from "../../../utils/utilidades";
import {MatTableDataSource} from "@angular/material/table";
import {ColaboradorDto} from "../../models/ColaboradorDto";
import {Router} from "@angular/router";
import {LocalStorageService} from "../../services/LocalStorageService/local.storage.service";


@Component({
  selector: 'app-personal',
  templateUrl: './personal.component.html',
  styleUrl: './personal.component.css'
})
export class PersonalComponent {
  displayedColumns: string[] = ['numdocumento','persona','grupolaboral','cargo', 'estadoempleado', 'acciones'];
  dataSource = new MatTableDataSource<ColaboradorDto>();

  areas : any[] = [];
  cargos : any[] = [];
  tiposDocumentos : any[] = [];
  estadosEmpleados : any[] = [];
  gruposLaborales : any[] = [];
  numeroDocumento: string = '';
  nombre: string = '';
  apellidoPaterno: string = '';
  apellidoMaterno: string = '';
  selectedArea: any;
  selectedCargo: any;
  selectedTipoDocumento: any ;
  selectedEstadoEmpleado: any;
  selectedGrupoLaboral: any;

  isReadOnly: boolean = false;

  constructor(private apiBackendService: ApiBackendService,
              private sweetAlertService: SweetAlertService,
              private localStorageService: LocalStorageService,
              private router: Router) {}

  ngOnInit() {

    this.apiBackendService.obtenerAreas().subscribe(
      (response) => {
        this.areas = response;
      },
      (error) => {
        this.sweetAlertService.showAlertError("Ocurrió un error al conectar al servidor");
      }
    );

    this.apiBackendService.obtenerCargos().subscribe(
      (response) => {
        this.cargos = response;
        },
      (error) => {
        this.sweetAlertService.showAlertError("Ocurrió un error al conectar al servidor");
      }
    );

    this.apiBackendService.obtenerTiposDocumentos().subscribe(
      (response) => {
        this.tiposDocumentos = response;
      },
      (error) => {
        this.sweetAlertService.showAlertError("Ocurrió un error al conectar al servidor");
      }
    );

    this.apiBackendService.obtenerEstadosEmpleados().subscribe(
      (response) => {
        this.estadosEmpleados = response;
      },
      (error) => {
        this.sweetAlertService.showAlertError("Ocurrió un error al conectar al servidor");
      }
    );

    this.apiBackendService.obtenerGruposLaborales().subscribe(
      (response) => {
        this.gruposLaborales = response;
      },
      (error) => {
        this.sweetAlertService.showAlertError("Ocurrió un error al conectar al servidor");
      }
    );

    this.onSubmit();
  }

  onSubmit() {
    this.apiBackendService.busquedaPaginadaPersonal(this.numeroDocumento, this.nombre, this.apellidoPaterno,
      this.apellidoMaterno, this.selectedArea, this.selectedCargo, this.selectedTipoDocumento, this.selectedEstadoEmpleado,
      this.selectedGrupoLaboral, 100).subscribe(
      (response) =>{
        const colaboradores: ColaboradorDto[] = response.data.map((data: any) => new ColaboradorDto(data));
        this.dataSource.data = colaboradores;
      },
      (error) => {
        this.sweetAlertService.showAlertError("Ocurrió un error al conectar al servidor");
      }
    );
  }

  redirectNuevoPersonal() {
    this.localStorageService.removeItem('colaboradorId');
    this.localStorageService.setItem('ocultarBotonGuardar', false);
    this.router.navigate(['/personal-formulario']);
  }

  editarPersonal(colaborador:ColaboradorDto) {
    console.log(colaborador);
    this.localStorageService.setItem('colaboradorId', colaborador.colaboradorid);
    this.localStorageService.setItem('ocultarBotonGuardar', false);
    this.router.navigate(['/personal-formulario'])
  }

  visualizarPersonal(colaborador:ColaboradorDto) {
    console.log(colaborador);
    this.localStorageService.setItem('colaboradorId', colaborador.colaboradorid);
    this.localStorageService.setItem('ocultarBotonGuardar', true);
    this.router.navigate(['/personal-formulario'], { queryParams: { readOnly: 'true' } })
  }

  editarPersonalLaborales(colaborador:ColaboradorDto) {
    this.localStorageService.setItem('colaboradorId', colaborador.colaboradorid);
    this.router.navigate(['/personal-laborales-formulario'])
  }

  anularPersonal(colaborador:ColaboradorDto) {
    this.sweetAlertService.showAlertPregunta("¿Desea anular al colaborador?", "Aceptar")
      .then((result) => {
        if (result.isConfirmed) {
          this.apiBackendService.anularColaborador(colaborador.colaboradorid).subscribe(
            (response) =>{
              if (Utilidades.dataDeServerEsCorrecta(response)) {
                this.sweetAlertService.showAlertSuccess(response.mensaje);
              } else {
                this.sweetAlertService.showAlertError(response.mensaje);
              }
              this.onSubmit();
            },
            (error) => {
              this.sweetAlertService.showAlertError("Ocurrió un error al conectar al servidor");
            }
          );
        }
      });
  }

  cesarPersonal(colaborador:ColaboradorDto) {
    this.sweetAlertService.showAlertPregunta("¿Desea cesar al colaborador?", "Aceptar")
      .then((result) => {
        if (result.isConfirmed) {
          this.apiBackendService.cesarColaborador(colaborador.colaboradorid).subscribe(
            (response) =>{
              if (Utilidades.dataDeServerEsCorrecta(response)) {
                this.sweetAlertService.showAlertSuccess(response.mensaje);
              } else {
                this.sweetAlertService.showAlertError(response.mensaje);
              }
              this.onSubmit();
            },
            (error) => {
              this.sweetAlertService.showAlertError("Ocurrió un error al conectar al servidor");
            }
          );
        }
      });
  }

}
