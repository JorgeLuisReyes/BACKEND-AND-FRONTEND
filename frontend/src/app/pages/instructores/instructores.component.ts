import { Component, OnInit, ViewChild } from '@angular/core';
import { InstructoresService } from '../../services/instructores.service';
import { DataTableDirective } from 'angular-datatables';
import { Subject } from 'rxjs';

@Component({
  selector: 'app-instructores',
  templateUrl: './instructores.component.html',
  styleUrls: ['./instructores.component.css']
})
export class InstructoresComponent {

  instructores: any;
  anoActual = new Date().getFullYear();
  
  @ViewChild(DataTableDirective, { static: false }) 
  dtElement: DataTableDirective;
  dtOptions: DataTables.Settings = {};
  dtTrigger = new Subject();
  
  constructor(public instructoresService: InstructoresService) {}

  ngOnInit() {
    this.dtOptions = {
      pagingType: 'full_numbers',
      pageLength: 5,
      lengthMenu: [5, 10, 15],
      processing: true
    };

    this.obtenerInstrustores();

  }

  obtenerInstrustores = () => this.instructoresService.getInstructores().then(res => {
    this.instructores = res.data;
    this.dtTrigger.next();
  });
  
}
