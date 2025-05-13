import { CommonModule } from '@angular/common';
import { Component, inject } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { EstudiantesService } from '../../services/estudiantes.service';

@Component({
  selector: 'app-listar',
  imports: [CommonModule,FormsModule],
  templateUrl: './listar.component.html',
  styleUrls: ['./listar.component.scss']
})
export class ListarComponent {
 estudiantes: any[] = [];
  private estudiantesService = inject(EstudiantesService);

  constructor() {
    this.cargarEstudiantes();
  }

  cargarEstudiantes() {
    this.estudiantesService.getEstudiantes().subscribe(data => {
      this.estudiantes = data.map(est => {
                          return {
                            id: est['id'],
                            nombre: est['nombre'],
                            email: est['email'],
                            estado: 'leer'
                          };
                        });
    });
  }

  actualizarEstudiante(est: any) {
    est.estado = 'actualizar';
  }

  guardarEstudiante(est: any) {
    this.estudiantesService.actualizarEstudiante(est).subscribe(() => {
      est.estado = 'leer';
    });
  }

  eliminarEstudiante(id: number) {
    this.estudiantesService.eliminarEstudiante(id).subscribe(() => {
      this.estudiantes = this.estudiantes.filter(e => e.id !== id);
    });
  }
}
