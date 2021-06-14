import { Component, EventEmitter, Input, OnInit, Output } from '@angular/core';
import { FormBuilder, FormControl, FormGroup, Validators } from '@angular/forms';
import { NgbModal, NgbActiveModal } from '@ng-bootstrap/ng-bootstrap';
import { Cursos } from 'src/app/interfaces/cursos';
import { CursosService } from 'src/app/services/cursos.service';
import { swalError, swalSuccessMessage, swalWarning } from 'src/app/shared/config/swalCommon';
import Swal from 'sweetalert2';

@Component({
  selector: 'app-cursos-edit',
  templateUrl: './cursos-edit.component.html',
  styleUrls: ['./cursos-edit.component.css']
})
export class CursosEditComponent implements OnInit {

  @Input() modal: boolean;

  formCursos: FormGroup;
  curso: Cursos;
  id: number;
  nombre: string;
  status: boolean;

  constructor(
    public cursosService: CursosService,
    public activeModal: NgbActiveModal,
    private formBuilder: FormBuilder,
  ) {

    this.formCursos = new FormGroup({
      nombre: new FormControl()
    });
   }

  ngOnInit() {
  }

  saveCursos() {

    const cursos: Cursos = {
      id: this.id,
      nombre: this.nombre,
      status: this.status
    };

    this.cursosService.createCurso(cursos).then((resp)=>{      
      if(resp.code == 200) {        
        Swal.fire(swalSuccessMessage('Operacion exitosa')).then(() => {
          this.activeModal.close();
          window.location.reload();
        });
      } else {
        Swal.fire(swalWarning('Nombre del curso ya existe'))  
      }
    })
    .catch((error) => {
      Swal.fire(swalError(`Error al gurdar curso`))
    });
  }
}
