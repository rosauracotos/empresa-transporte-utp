import { Component } from '@angular/core';
import {LocalStorageService} from "./services/LocalStorageService/local.storage.service";

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrl: './app.component.css'
})
export class AppComponent {
  title = 'fronted-empresa-transporte';

  constructor(private localStorageService: LocalStorageService) {
  }

  ngOnInit(): void {
    const existingData = this.localStorageService.getItem('isAuthenticated');
    const existingDataPersona = this.localStorageService.getItem('persona');
    if (!existingData) {
      this.localStorageService.setItem('isAuthenticated', 'false');
    }
    if (!existingDataPersona) {
      this.localStorageService.removeItem('persona');
    }
  }

}
