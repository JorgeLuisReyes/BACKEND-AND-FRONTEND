import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { CursosComponent } from './pages/cursos/cursos.component';
import { InstructoresComponent} from './pages/instructores/instructores.component';
import { DetallesComponent } from './pages/detalles/detalles.component';

const routes: Routes = [
  { path: 'cursos', component: CursosComponent },
  { path: 'instructores', component: InstructoresComponent },
  { path: 'detalles', component: DetallesComponent }  
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
