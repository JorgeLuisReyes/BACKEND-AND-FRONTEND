import { Component, OnInit, OnDestroy, ViewChild } from '@angular/core';
import { CursosService } from '../../services/cursos.service';
import { DataTableDirective } from 'angular-datatables';
import { Subject } from 'rxjs';
import { data } from 'jquery';
import { Cursos } from 'src/app/interfaces/cursos';

@Component({
  selector: 'app-cursos',
  templateUrl: './cursos.component.html',
  styleUrls: ['./cursos.component.css']
})
export class CursosComponent {

  cursos: Cursos[]=[];
  anoActual = new Date().getFullYear();

  @ViewChild(DataTableDirective, { static: false }) 
  dtElement: DataTableDirective;
  dtOptions: DataTables.Settings = {};
  dtTrigger = new Subject();

  constructor(public cursosService: CursosService) { 
    this.dtOptions = {
      pagingType: 'full_numbers',
      pageLength: 5,
      lengthMenu: [5, 10, 15],
      processing: true      
    };

    this.obtenerCursos();
  }

  obtenerCursos = () => this.cursosService.getCursos().then(res => {
    this.cursos = res.data;
    this.dtTrigger.next();
  })

}