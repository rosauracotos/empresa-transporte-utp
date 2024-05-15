import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import {LoginComponent} from "./components/login/login.component";
import {InicioComponent} from "./components/inicio/inicio.component";
import {PersonalComponent} from "./components/personal/personal.component";
import {PersonalFormularioComponent} from "./components/personal-formulario/personal-formulario.component";
import {BoletasComponent} from "./components/boletas/boletas.component";
import {TurnosComponent} from "./components/turnos/turnos.component";

const routes: Routes = [
  { path: '', component: LoginComponent },
  { path: 'inicio', component: InicioComponent },
  { path: 'personal', component: PersonalComponent },
  { path: 'personal-formulario', component: PersonalFormularioComponent },
  { path: 'boletas', component: BoletasComponent },
  { path: 'turnos', component: TurnosComponent },
  { path: '', redirectTo: '/inicio', pathMatch: 'full' },
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
