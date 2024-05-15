import { Injectable } from '@angular/core';
import {HttpClient, HttpHeaders} from "@angular/common/http";
import {LocalStorageService} from "../LocalStorageService/local.storage.service";
import {Observable} from "rxjs";
import {environment} from "../../../environments/enviroment";
import {Utilidades} from "../../../utils/utilidades";

@Injectable({
  providedIn: 'root'
})
export class ApiBackendService {
  constructor(private http: HttpClient,
              private localStorageService: LocalStorageService) { }


  obtenerAreas(): Observable<any> {
    const headers = new HttpHeaders({
      'Content-Type': 'application/json'
    });
    return this.http.get<any>(environment.apiUrl +`api/area/all`, { headers: headers });
  }

  obtenerCargos(): Observable<any> {
    const headers = new HttpHeaders({
      'Content-Type': 'application/json'
    });
    return this.http.get<any>(environment.apiUrl +`api/cargo/all`, { headers: headers });
  }

  obtenerTiposDocumentos(): Observable<any> {
    const headers = new HttpHeaders({
      'Content-Type': 'application/json'
    });
    return this.http.get<any>(environment.apiUrl +`api/tipoDocumento/all`, { headers: headers });
  }

  obtenerEstadosEmpleados(): Observable<any> {
    const headers = new HttpHeaders({
      'Content-Type': 'application/json'
    });
    return this.http.get<any>(environment.apiUrl +`api/estadoEmpleado/all`, { headers: headers });
  }

  obtenerGruposLaborales(): Observable<any> {
    const headers = new HttpHeaders({
      'Content-Type': 'application/json'
    });
    return this.http.get<any>(environment.apiUrl +`api/grupoLaboral/all`, { headers: headers });
  }

  busquedaPaginadaPersonal(numeroDocumento: string, nombre:string, apellidoPaterno: string, apellidoMaterno:string ,
                           selectedArea: any, selectedCargo:any, selectedTipoDocumento: any, selectedEstadoEmpleado: any,
                           selectedGrupoLaboral: any): Observable<any> {
    const body = {
      numeroDocumento: Utilidades.esNullOUndefinedoVacio(numeroDocumento) ? null : numeroDocumento,
      nombre: Utilidades.esNullOUndefinedoVacio(nombre) ? null : nombre,
      apellidoPaterno: Utilidades.esNullOUndefinedoVacio(apellidoPaterno) ? null : apellidoPaterno,
      apellidoMaterno: Utilidades.esNullOUndefinedoVacio(apellidoMaterno) ? null : apellidoMaterno,
      areaId: Utilidades.esNullOUndefinedoVacio(selectedArea) ? null : selectedArea,
      cargoId: Utilidades.esNullOUndefinedoVacio(selectedCargo) ? null : selectedCargo,
      tipoDocumentoId: Utilidades.esNullOUndefinedoVacio(selectedTipoDocumento) ? null : selectedTipoDocumento,
      estadoEmpleadoId: Utilidades.esNullOUndefinedoVacio(selectedEstadoEmpleado) ? null : selectedEstadoEmpleado,
      grupoLaboralId: Utilidades.esNullOUndefinedoVacio(selectedGrupoLaboral) ? null : selectedGrupoLaboral,
      max: 10,
      limite: 0,
    };
    const headers = new HttpHeaders({
      'Content-Type': 'application/json'
    });
    return this.http.post<any>(environment.apiUrl +`api/colaborador/busquedaPagina`, body, { headers: headers });
  }

}
