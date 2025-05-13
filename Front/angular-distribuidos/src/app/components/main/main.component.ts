import { Component } from '@angular/core';
import { CrearComponent } from "../crear/crear.component";
import { ListarComponent } from "../listar/listar.component";
import { CommonModule } from '@angular/common';

@Component({
  selector: 'app-main',
  imports: [CrearComponent, ListarComponent,CommonModule],
  templateUrl: './main.component.html',
  styleUrl: './main.component.scss'
})
export class MainComponent {
  currentComponent: string = '';  // Variable para controlar el componente visible

  items = [
  { title: 'Crear', action: () => this.crear() },
  { title: 'Listar', action: () => this.listar() }
];

crear() {
  this.currentComponent = 'create';
  // lógica de creación
}

listar() {
  this.currentComponent = 'list';
  // lógica de listado
}

}
