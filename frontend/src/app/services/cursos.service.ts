import { httpOptions, URL_SERVICIOS } from '../shared/config/config';
import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Cursos } from '../interfaces/cursos';

@Injectable({
  providedIn: 'root'
})
export class CursosService {


  constructor(private http: HttpClient) {}

  getCursos = () => this.http.get<any>(`${URL_SERVICIOS}cursos/`).toPromise();

  createCurso = (curso: Cursos) => this.http.post<any>(`${URL_SERVICIOS}cursos/`, JSON.stringify(curso), httpOptions).toPromise();

  updateCurso = (curso: Cursos) => this.http.put<any>(`${URL_SERVICIOS}cursos/`, JSON.stringify(curso), httpOptions).toPromise();

  deleteCurso = (curso: Cursos) => this.http.delete<void>(`${URL_SERVICIOS}cursos/curso/${curso.id}`).toPromise();

  /**
   * comentario de demostracion git
   * modifificacion rama Jorge
   */

}
