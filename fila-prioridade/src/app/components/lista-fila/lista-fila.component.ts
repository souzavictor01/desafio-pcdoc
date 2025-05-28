import { Component, OnInit, OnDestroy } from '@angular/core';
import { CommonModule } from '@angular/common';
import { FilaService } from '../../services/fila.service';
import { Cliente } from '../../models/cliente.model';
import { Subscription } from 'rxjs';
import { MatCardModule } from '@angular/material/card';
import { MatListModule } from '@angular/material/list';
import { MatButtonModule } from '@angular/material/button';


@Component({
  selector: 'app-lista-fila',
  standalone: true,
  imports: [CommonModule,
  MatCardModule,
  MatListModule,
  MatButtonModule],
  templateUrl: './lista-fila.component.html',
  styleUrls: ['./lista-fila.component.css']
})
export class ListaFilaComponent implements OnInit, OnDestroy {
  fila: Cliente[] = [];
  private sub!: Subscription;  // Para armazenar a inscrição

  constructor(private filaService: FilaService) {}

  ngOnInit(): void {
    this.carregarFila();


    this.sub = this.filaService.filaAtualizada$.subscribe(() => {
      this.carregarFila();
    });
  }

  carregarFila() {
    this.filaService.listar().subscribe(data => {
      console.log('Dados recebidos:', data);
      this.fila = data;
    });
  }

  atender(cliente: Cliente) {
    this.filaService.atender(cliente.id!).subscribe();

  }

  ngOnDestroy(): void {
    this.sub.unsubscribe();
  }
}
