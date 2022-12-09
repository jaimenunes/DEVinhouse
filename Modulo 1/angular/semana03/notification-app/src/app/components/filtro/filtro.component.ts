import { Component, EventEmitter, Output } from '@angular/core';

@Component({
  selector: 'ntap-filtro',
  templateUrl: './filtro.component.html',
  styleUrls: ['./filtro.component.scss'],
})
export class FiltroComponent {
  @Output() filtrarOutput: EventEmitter<string> = new EventEmitter();
  valores: string[] = ['Todos', 'Lidos', 'Não lidos'];

  filtrar(evento: string) {
    console.log(evento, ' filtro')
    this.filtrarOutput.emit(evento);
  }
}
