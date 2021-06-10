import { URL_SERVICIOS } from '../shared/config/config';
import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';

@Injectable({
  providedIn: 'root'
})
export class CursosService {
  
  constructor(private http: HttpClient) {}  

  getCursos = () => this.http.get<any>(`${URL_SERVICIOS}cursos/`).toPromise();

}

