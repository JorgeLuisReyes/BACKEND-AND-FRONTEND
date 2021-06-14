import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { HttpClientModule } from "@angular/common/http";


import { CursosComponent } from './pages/cursos/cursos.component';
import { DataTablesModule } from 'angular-datatables';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { NgbModalModule } from '@ng-bootstrap/ng-bootstrap';

import { CursosAddComponent } from './pages/cursos/cursos-add/cursos-add.component';
import { CursosEditComponent } from './pages/cursos/cursos-edit/cursos-edit.component';
import { InstructoresComponent } from './pages/instructores/instructores.component';
import { DetallesComponent } from './pages/detalles/detalles.component';


@NgModule({
  declarations: [
    AppComponent,
    InstructoresComponent,
    DetallesComponent,
    CursosComponent,
    CursosAddComponent,
    CursosEditComponent,
  ],
  imports: [
    BrowserModule,
    FormsModule,
    AppRoutingModule,
    HttpClientModule,
    DataTablesModule,
    ReactiveFormsModule,
    NgbModalModule,
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
