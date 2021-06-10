import { URL_SERVICIOS } from '../shared/config/config';
import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';

@Injectable({
  providedIn: 'root'
})
export class DetallesService {

  constructor(private http: HttpClient) {}  

  getDetalles = () => this.http.get<any>(`${URL_SERVICIOS}detalles/`).toPromise();
  
}
