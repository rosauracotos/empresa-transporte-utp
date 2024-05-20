import { Component } from '@angular/core';
import {ColaboradorDto} from "../../models/ColaboradorDto";
import {ApiBackendService} from "../../services/ApiBackendService/api.backend.service";
import {SweetAlertService} from "../../services/SweetAlertService/sweet.alert.service";
import {LocalStorageService} from "../../services/LocalStorageService/local.storage.service";
import {Router} from "@angular/router";
import {MatTableDataSource} from "@angular/material/table";
import {MatDateRangePicker} from "@angular/material/datepicker";
import {Utilidades} from "../../../utils/utilidades";

@Component({
  selector: 'app-turnos',

  templateUrl: './turnos.component.html',
  styleUrl: './turnos.component.css'
})
export class TurnosComponent {

  displayedColumns: string[] = ['select','numdocumento','persona'];
  dataSource = new MatTableDataSource<ColaboradorDto>();

  startDate: Date | undefined;
  endDate: Date | undefined;



  areas : any[] = [];
  cargos : any[] = [];
  turnos : any[] = [];
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
  selectedTurno: any;

  masterSelected: boolean = false;

  constructor(private apiBackendService: ApiBackendService,
              private sweetAlertService: SweetAlertService,
              private localStorageService: LocalStorageService,
              private router: Router) {}

  isAllSelected(): boolean {
    const numSelected = this.dataSource.data.filter(row => row.seleccionado).length;
    const numRows = this.dataSource.data.length;
    return numSelected === numRows;
  }

  masterToggle() {
    this.masterSelected = !this.masterSelected;
    this.dataSource.data.forEach((item, index) => {
      item.seleccionado = this.masterSelected;
    });
  }

  toggleRow(row: ColaboradorDto) {
    row.seleccionado = !row.seleccionado;
    this.masterSelected = this.isAllSelected();
  }

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

    this.apiBackendService.obtenerTurnos().subscribe(
      (response) => {
        this.turnos = response;
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
        this.dataSource.data.forEach((item, index) => {
          item.seleccionado = false;
        });
      },
      (error) => {
        this.sweetAlertService.showAlertError("Ocurrió un error al conectar al servidor");
      }
    );
  }

  guardar() {
    let colaboradoresSel: number = 0;
    let idsColaboradores: number[] = [];
    this.dataSource.data.forEach((item, index) => {
      if (item.seleccionado) {
        idsColaboradores.push(item.colaboradorid)
        colaboradoresSel++;
      }
    });
    if (colaboradoresSel == 0) {
      this.sweetAlertService.showAlertError("Debe seleccionar como mínimo un colaborador");
      return;
    }
    if (Utilidades.esNullOUndefinedoVacio(this.startDate) || Utilidades.esNullOUndefinedoVacio(this.endDate)) {
      this.sweetAlertService.showAlertError("Debe seleccionar un rango de fechas válidos");
      return;
    }
    if (Utilidades.esNullOUndefinedoVacio(this.selectedTurno)) {
      this.sweetAlertService.showAlertError("Debe seleccionar un turno");
      return;
    }

    const body = {
      colaboradoresIds: idsColaboradores,
      turno: {
        id: this.selectedTurno
      },
      fechaInicio: this.startDate,
      fechaFin: this.endDate
    };

    this.apiBackendService.guardarTurnos(body).subscribe(
      (response) =>{
        this.sweetAlertService.showAlertSuccess(response.mensaje);
      },
      (error) => {
        this.sweetAlertService.showAlertError("Ocurrió un error al conectar al servidor");
      }
    );

  }

}
