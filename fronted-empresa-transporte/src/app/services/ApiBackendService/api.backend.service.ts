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

  obtenerSedes(): Observable<any> {
    const headers = new HttpHeaders({
      'Content-Type': 'application/json'
    });
    return this.http.get<any>(environment.apiUrl +`api/sede/all`, { headers: headers });
  }

  obtenerTiposDocumentos(): Observable<any> {
    const headers = new HttpHeaders({
      'Content-Type': 'application/json'
    });
    return this.http.get<any>(environment.apiUrl +`api/tipoDocumento/all`, { headers: headers });
  }

  obtenerCondicionLaboral(): Observable<any> {
    const headers = new HttpHeaders({
      'Content-Type': 'application/json'
    });
    return this.http.get<any>(environment.apiUrl +`api/grupoLaboral/all`, { headers: headers });
  }

  obtenerArea(): Observable<any> {
    const headers = new HttpHeaders({
      'Content-Type': 'application/json'
    });
    return this.http.get<any>(environment.apiUrl +`api/areaDenominacion/all`, { headers: headers });
  }

  obtenerBanco(): Observable<any> {
    const headers = new HttpHeaders({
      'Content-Type': 'application/json'
    });
    return this.http.get<any>(environment.apiUrl +`api/bancos/all`, { headers: headers });
  }

  obtenerRegimenPensionario(): Observable<any> {
    const headers = new HttpHeaders({
      'Content-Type': 'application/json'
    });
    return this.http.get<any>(environment.apiUrl +`api/regimenPensionario/all`, { headers: headers });
  }

  obtenerComision(): Observable<any> {
    const headers = new HttpHeaders({
      'Content-Type': 'application/json'
    });
    return this.http.get<any>(environment.apiUrl +`api/comisionafp/listar`, { headers: headers });
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

  obtenerGeneros(): Observable<any> {
    const headers = new HttpHeaders({
      'Content-Type': 'application/json'
    });
    return this.http.get<any>(environment.apiUrl +`api/tipoGenero/all`, { headers: headers });
  }

  obtenerEstadoCiviles(): Observable<any> {
    const headers = new HttpHeaders({
      'Content-Type': 'application/json'
    });
    return this.http.get<any>(environment.apiUrl +`api/estadoCivil/all`, { headers: headers });
  }

  obtenerDepartamentos(): Observable<any> {
    const headers = new HttpHeaders({
      'Content-Type': 'application/json'
    });
    return this.http.get<any>(environment.apiUrl +`api/ubigeoDepartamento/all`, { headers: headers });
  }

  obtenerProvinciasPorDepartamento(departamentoId: number): Observable<any> {
    const headers = new HttpHeaders({
      'Content-Type': 'application/json'
    });
    return this.http.get<any>(environment.apiUrl +`api/ubigeoProvincia/departamento/`+ departamentoId, { headers: headers });
  }

  obtenerDistrirosPorProvincia(provinciaId: number): Observable<any> {
    const headers = new HttpHeaders({
      'Content-Type': 'application/json'
    });
    return this.http.get<any>(environment.apiUrl +`api/ubigeoDistrito/provincia/`+ provinciaId, { headers: headers });
  }

  guardarColaborador(apellidoPaterno: string, apellidoMaterno: string, nombre: string, numeroIdentificacion: string,
                     fechaNacimiento: string, celular: string, direccion: string, correo: string, tipoDocumentoId: number,
                     tipoGeneroId: number, estadoCiviloId: number, distritoId: number): Observable<any> {

    const body = {
      apellidoPaterno: apellidoPaterno,
      apellidoMaterno: apellidoMaterno,
      nombre: nombre,
      numeroIdentificacion: numeroIdentificacion,
      fechaNacimiento: fechaNacimiento,
      celular: celular,
      direccion: direccion,
      correo: correo,
      tipoDocumento: {
        id :tipoDocumentoId
      },
      tipoGenero: {
        id :tipoGeneroId
      },
      estadoCivil: {
        id :estadoCiviloId
      },
      distrito: {
        id :distritoId
      }
    };
    console.log(body);
    const headers = new HttpHeaders({
      'Content-Type': 'application/json'
    });
    return this.http.post<any>(environment.apiUrl +`api/colaborador/guardar`, body, { headers: headers });
  }

  guardarColaboradorLaboral(numCupss: string, numeroCuenta: string,
                            colaboradorId: number, comisionafpId: number,
                            sedeId: number, grupoLaboralId: number, areaDenominacionId: number,
                            regimenPensionarioId: number, cargoId:number, bancoId: number): Observable<any> {

    const body = {
      numCupss: numCupss,
      numeroCuenta: numeroCuenta,
      colaborador: {
        id :colaboradorId
      },
      sede: {
        id :sedeId
      },
      cargo: {
        id :cargoId
      },
      grupoLaboral: {
        id :grupoLaboralId
      },
      areaDenominacion: {
        id :areaDenominacionId
      },
      banco: {
        id :bancoId
      },
      regimenPensionario: {
        id :regimenPensionarioId
      },
      comisionafp: {
        id: comisionafpId
      }
    };
    const headers = new HttpHeaders({
      'Content-Type': 'application/json'
    });
    return this.http.post<any>(environment.apiUrl +`api/colaboradorLaboral/guardar`, body, { headers: headers });
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
