import { Component } from '@angular/core';
import { CommonModule } from '@angular/common';
import { FormsModule } from '@angular/forms';
import { FilaService } from '../../services/fila.service';
import { Cliente, TipoAtendimento } from '../../models/cliente.model';
import { MatCardModule } from '@angular/material/card';
import { MatFormFieldModule } from '@angular/material/form-field';
import { MatInputModule } from '@angular/material/input';
import { MatSelectModule } from '@angular/material/select';
import { MatButtonModule } from '@angular/material/button';


@Component({
  selector: 'app-form-fila',
  standalone: true,
  imports: [ CommonModule,
  FormsModule,
  MatCardModule,
  MatFormFieldModule,
  MatInputModule,
  MatSelectModule,
  MatButtonModule],
  templateUrl: './form-fila.component.html',
  styleUrls: ['./form-fila.component.css']
})
export class FormFilaComponent {
  cliente: Cliente = { nome: '', tipo: TipoAtendimento.GERAL };
  tipos = Object.values(TipoAtendimento);

  constructor(private filaService: FilaService) {}

  adicionar() {
    this.filaService.adicionar(this.cliente).subscribe(() => {
      alert('Cliente adicionado!');
      this.cliente = { nome: '', tipo: TipoAtendimento.GERAL };

    });
  }
}
