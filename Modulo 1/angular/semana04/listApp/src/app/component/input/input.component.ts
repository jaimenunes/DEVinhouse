import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-input',
  templateUrl: './input.component.html',
  styleUrls: ['./input.component.css']
})
export class InputComponent implements OnInit {

  constructor() { }
  tarefaAdd: string = ""
  listaTarefas: string[] = []
  ngOnInit(): void {
  }

  adicionarTarefa(){
    if(this.tarefaAdd){
      this.listaTarefas.push(this.tarefaAdd)
    }else{
      alert('Campo vazio')
    }
  }
}
