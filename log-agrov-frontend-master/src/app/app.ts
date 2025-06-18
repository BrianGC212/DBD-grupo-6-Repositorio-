
import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { HttpClientModule } from '@angular/common/http';
import { FormsModule } from '@angular/forms';
import { RouterModule } from '@angular/router';
import { CommonModule } from '@angular/common';

import { routes } from './app.routes';

import { AppComponent } from './app.component';
import {GestionEquiposComponent } from './app/gestion-equipos/gestion-equipos';
import { EquiposRegistradosComponent } from './app/equipos-registrados/equipos-registrados';

@NgModule({
  declarations: [
    AppComponent,
  ],
  imports: [
    BrowserModule,
    HttpClientModule,
    FormsModule,
    RouterModule.forRoot(routes),
    CommonModule,
    EquiposRegistradosComponent,
    GestionEquiposComponent
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
