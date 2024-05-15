import { Component } from '@angular/core';
import {ApiBackendService} from "../../services/ApiBackendService/api.backend.service";
import {SweetAlertService} from "../../services/SweetAlertService/sweet.alert.service";
import {Utilidades} from "../../../utils/utilidades";
import {MatTableDataSource} from "@angular/material/table";
import {ColaboradorDto} from "../../models/ColaboradorDto";
import {Router} from "@angular/router";

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

  constructor(private apiBackendService: ApiBackendService,
              private sweetAlertService: SweetAlertService,
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
  }

  onSubmit() {
    this.apiBackendService.busquedaPaginadaPersonal(this.numeroDocumento, this.nombre, this.apellidoPaterno,
      this.apellidoMaterno, this.selectedArea, this.selectedCargo, this.selectedTipoDocumento, this.selectedEstadoEmpleado,
      this.selectedGrupoLaboral).subscribe(
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
    this.router.navigate(['/personal-formulario']);
  }

}
