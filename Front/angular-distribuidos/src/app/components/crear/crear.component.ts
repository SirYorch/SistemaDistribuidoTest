import { CommonModule } from '@angular/common';
import { Component, inject } from '@angular/core';
import { FormsModule, NgModel } from '@angular/forms';
import { EstudiantesService } from '../../services/estudiantes.service';

@Component({
  selector: 'app-crear',
  imports: [CommonModule,FormsModule],
  templateUrl: './crear.component.html',
  styleUrl: './crear.component.scss'
})
export class CrearComponent {
  estudiante: any = { nombre: '', email: '' };
  private estudiantesService = inject(EstudiantesService);

  crearEstudiante() {
    this.estudiantesService.crearEstudiante(this.estudiante).subscribe(() => {
      console.log('Estudiante creado');
      this.estudiante = { nombre: '', email: '' };
    });
  }
}
