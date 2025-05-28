import { Component } from '@angular/core';
import { FormFilaComponent } from './components/form-fila/form-fila.component';
import { ListaFilaComponent } from './components/lista-fila/lista-fila.component';

@Component({
  selector: 'app-root',
  standalone: true,
  imports: [FormFilaComponent, ListaFilaComponent],
  template: `

    <app-form-fila></app-form-fila>
    <app-lista-fila></app-lista-fila>
  `,
  styleUrls: ['./app.component.css']
})
export class AppComponent {
  title(title: any) {
    throw new Error('Method not implemented.');
  }
}
