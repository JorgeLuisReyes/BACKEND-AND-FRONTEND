import { Component, ViewChild } from '@angular/core';
import { DetallesService } from '../../services/detalles.service';
import { DataTableDirective } from 'angular-datatables';
import { Subject } from 'rxjs';
import { Detalles } from 'src/app/interfaces/detalles';

@Component({
  selector: 'app-detalles',
  templateUrl: './detalles.component.html',
  styleUrls: ['./detalles.component.css']
})
export class DetallesComponent {

  detalles: Detalles[]=[];
  anoActual = new Date().getFullYear();

  @ViewChild(DataTableDirective, { static: false }) 
  dtElement: DataTableDirective;
  dtOptions: DataTables.Settings = {};
  dtTrigger = new Subject();

  constructor(public detallesService: DetallesService) { 
    this.dtOptions = {
      pagingType: 'full_numbers',
      pageLength: 5,
      lengthMenu: [5, 10, 15],
      processing: true      
    };

    this.obtenerCursos();
  }

  obtenerCursos = () => this.detallesService.getDetalles().then(res => {
    this.detalles = res.data;
    this.dtTrigger.next();
  })

}
