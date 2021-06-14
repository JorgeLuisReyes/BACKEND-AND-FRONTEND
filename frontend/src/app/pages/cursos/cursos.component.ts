import { Component, OnInit, OnDestroy, ViewChild, Output, EventEmitter } from '@angular/core';
import { CursosService } from '../../services/cursos.service';
import { DataTableDirective } from 'angular-datatables';
import { Subject } from 'rxjs';
import { Cursos } from 'src/app/interfaces/cursos';
import { NgbModal } from '@ng-bootstrap/ng-bootstrap';
import { CursosAddComponent } from './cursos-add/cursos-add.component';
import Swal from 'sweetalert2';
import { swalDesition, swalError, swalSuccessMessage } from 'src/app/shared/config/swalCommon';
import { CursosEditComponent } from './cursos-edit/cursos-edit.component';

@Component({
  selector: 'app-cursos',
  templateUrl: './cursos.component.html',
  styleUrls: ['./cursos.component.css']
})
export class CursosComponent {

  cursos: Cursos[]=[];

  @ViewChild(DataTableDirective, { static: false }) dtElement: DataTableDirective;

  dtOptions: DataTables.Settings = {};
  dtTrigger = new Subject();

  constructor(
    public cursosService: CursosService,
    private modalAdd: NgbModal,
    private modalEdit: NgbModal
  ) {
    this.dtOptions = {
      pagingType: 'full_numbers',
      pageLength: 5,
      lengthMenu: [5, 10, 15],
      processing: true
    };

    this.getCursos();
  }

  getCursos = () => this.cursosService.getCursos().then(res => {
    this.cursos = res.data;
    this.cursos.filter(x => x.status == false);
    this.dtTrigger.next();
  })
 
  addCurso() {
    const modalRef = this.modalAdd.open(CursosAddComponent);
  }

  editCurso(curso: Cursos) {
    const modalRef = this.modalEdit.open(CursosEditComponent);
    
  }

  deleteCurso(curso: Cursos) {
    console.log(curso)
    Swal.fire(swalDesition('¿Desea eliminar el Curso?')).then(result =>
      (result.value) ? this.cursosService.deleteCurso(curso).then(() => {
        Swal.fire(swalSuccessMessage('Operacion exitosa'));
        window.location.reload();
      }, () => Swal.fire(swalError(`Error eliminando el curso`))) : null
      );
    }
}
