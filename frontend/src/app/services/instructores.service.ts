import { URL_SERVICIOS } from '../shared/config/config';
import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';

@Injectable({
  providedIn: 'root'
})
export class InstructoresService {

  constructor(private http: HttpClient) {}  

  getInstructores = () => this.http.get<any>(`${URL_SERVICIOS}instructores/`).toPromise();

}
