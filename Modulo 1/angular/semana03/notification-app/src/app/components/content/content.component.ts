import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { INotificacao } from 'src/app/models/notificacao.model';
import { NOTIFICATIONS_MOCK } from 'src/app/utils/notifications-mock';

@Component({
  selector: 'ntap-content',
  templateUrl: './content.component.html',
  styleUrls: ['./content.component.scss'],
})
export class ContentComponent implements OnInit {
  listaDeNotificacoes: INotificacao[] = [];

  constructor(private route: Router, private activeRoute: ActivatedRoute){}

  ngOnInit(): void {
    this.listaDeNotificacoes = NOTIFICATIONS_MOCK;
  }

  lerNotificacao(indice: number) {
    console.log('indice', indice);

    this.listaDeNotificacoes.forEach((item, index) => {
      if (index === indice) {
        item.lido = true;
      }

      return item;
    });
  }

  filtrandoNotificacao(btnClicado: string){
    console.log(btnClicado)
    switch (btnClicado){
      case 'Todos':
        this.route.navigate(['home/todos'])
        this.rendeirizarPagina()
        break
      case 'Lidos':
        this.route.navigate(['home/lidos'])
        break
      case 'Não lidos':
        this.route.navigate(['home/nao-lidos'])
        break
    }

  }

  rendeirizarPagina(){
    this.activeRoute.params.subscribe(params =>{
      console.log(params)
    })
  }
}
