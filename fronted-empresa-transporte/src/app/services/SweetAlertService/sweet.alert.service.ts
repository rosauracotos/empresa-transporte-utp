import { Injectable } from '@angular/core';
import Swal, { SweetAlertOptions } from 'sweetalert2';
@Injectable({
  providedIn: 'root'
})
export class SweetAlertService {

  showAlertSuccess(mensaje:string): Promise<any> {
    let options:SweetAlertOptions = {
      title: 'Success',
      text: mensaje,
      icon: 'success',
      confirmButtonText: 'OK',
    }
    return Swal.fire(options);
  }

  showAlertError(mensaje:string): Promise<any> {
    let options:SweetAlertOptions = {
      title: 'Error',
      text: mensaje,
      icon: 'error',
      confirmButtonText: 'OK',
    }
    return Swal.fire(options);
  }
}
