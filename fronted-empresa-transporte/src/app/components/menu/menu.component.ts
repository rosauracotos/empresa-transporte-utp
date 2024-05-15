import { Component } from '@angular/core';
import {AuthService} from "../../services/AuthService/auth.service";
import {LocalStorageService} from "../../services/LocalStorageService/local.storage.service";

@Component({
  selector: 'app-menu',
  templateUrl: './menu.component.html',
  styleUrl: './menu.component.css'
})
export class MenuComponent {
  menuItems: any[] = [];
  constructor(private authService: AuthService,
              private localStorageService: LocalStorageService) {}

  ngOnInit() {
    if (this.authService.isLoggedIn()) {
      let menuData = this.localStorageService.getItem('menuData');
      this.menuItems = menuData || [];
    }
  }
  logout() {
    this.authService.logout();
  }

}
