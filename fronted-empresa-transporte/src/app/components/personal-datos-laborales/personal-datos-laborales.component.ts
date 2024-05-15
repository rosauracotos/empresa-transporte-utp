import { Component } from '@angular/core';
import {ApiBackendService} from "../../services/ApiBackendService/api.backend.service";
import {SweetAlertService} from "../../services/SweetAlertService/sweet.alert.service";
import {LocalStorageService} from "../../services/LocalStorageService/local.storage.service";
import {Router} from "@angular/router";

@Component({
  selector: 'app-personal-datos-laborales',
  templateUrl: './personal-datos-laborales.component.html',
  styleUrl: './personal-datos-laborales.component.css'
})
export class PersonalDatosLaboralesComponent {



  numeroCuenta: string = '';
  numeroCupss: string = '';
  selectedCondicionLaboral: any ;
  selectedArea: any ;
  selectedBanco: any ;
  selectedRegimenPensionario: any ;
  selectedComision: any ;
  selectedSede: any ;
  selectedCargo: any ;

  condicionLaboral : any[] = [];
  area : any[] = [];
  banco : any[] = [];
  regimenPensionario : any[] = [];
  comision : any[] = [];
  sedes : any[] = [];
  cargos : any[] = [];

  constructor(private apiBackendService: ApiBackendService,
              private sweetAlertService: SweetAlertService,
              private localStorageService: LocalStorageService,
              private router: Router) {}

  ngOnInit() {

    this.apiBackendService.obtenerCondicionLaboral().subscribe(
      (response) => {
        this.condicionLaboral = response;
      },
      (error) => {
        this.sweetAlertService.showAlertError("Ocurrió un error al conectar al servidor");
      }
    );
    this.apiBackendService.obtenerArea().subscribe(
      (response) => {
        this.area = response;
      },
      (error) => {
        this.sweetAlertService.showAlertError("Ocurrió un error al conectar al servidor");
      }
    );
    this.apiBackendService.obtenerBanco().subscribe(
      (response) => {
        this.banco = response;
      },
      (error) => {
        this.sweetAlertService.showAlertError("Ocurrió un error al conectar al servidor");
      }
    );
    this.apiBackendService.obtenerRegimenPensionario().subscribe(
      (response) => {
        this.regimenPensionario = response;
      },
      (error) => {
        this.sweetAlertService.showAlertError("Ocurrió un error al conectar al servidor");
      }
    );
    this.apiBackendService.obtenerComision().subscribe(
      (response) => {
        this.comision = response;
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
    this.apiBackendService.obtenerSedes().subscribe(
      (response) => {
        this.sedes = response;
      },
      (error) => {
        this.sweetAlertService.showAlertError("Ocurrió un error al conectar al servidor");
      }
    );
  }

  onSubmit() {
    let colaboradorId = this.localStorageService.getItem('colaboradorId');
    this.apiBackendService.guardarColaboradorLaboral(this.numeroCupss, this.numeroCuenta, colaboradorId,
      this.selectedComision, this.selectedSede, this.selectedCondicionLaboral, this.selectedArea,
      this.selectedRegimenPensionario, this.selectedCargo, this.selectedBanco).subscribe(
      (response) =>{
        this.sweetAlertService.showAlertSuccess(response.mensaje);
        this.localStorageService.removeItem('colaboradorId');
        this.router.navigate(['/personal'])
      },
      (error) => {
        this.sweetAlertService.showAlertError("Ocurrió un error al conectar al servidor");
      }
    );
  }

}
