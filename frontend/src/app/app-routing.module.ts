import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { CursosAddComponent } from './pages/cursos/cursos-add/cursos-add.component';
import { CursosEditComponent } from './pages/cursos/cursos-edit/cursos-edit.component';
import { CursosComponent } from './pages/cursos/cursos.component';
import { DetallesComponent } from './pages/detalles/detalles.component';
import { InstructoresComponent } from './pages/instructores/instructores.component';

const routes: Routes = [
  { path: 'cursos', component: CursosComponent },
  { path: 'cursos/cursos-add', component: CursosAddComponent },
  { path: 'cursos/cursos-edit', component: CursosEditComponent },
  { path: 'instructores', component: InstructoresComponent },
  { path: 'detalles', component: DetallesComponent }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
