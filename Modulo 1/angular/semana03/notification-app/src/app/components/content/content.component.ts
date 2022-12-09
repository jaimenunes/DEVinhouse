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
  constructor(private route: Router, private activeRoute: ActivatedRoute) {}

  ngOnInit(): void {
    this.activeRoute.params.subscribe((params) => {
      let page = params['status'];
      switch (page) {
        case 'todos':
          this.listaDeNotificacoes = NOTIFICATIONS_MOCK;
          break;
        case 'lidos':
          this.listaDeNotificacoes = NOTIFICATIONS_MOCK.filter(
            (val) => val.lido == true
          );
          break;
        case 'nao-lidos':
          this.listaDeNotificacoes = NOTIFICATIONS_MOCK.filter(
            (val) => val.lido == false
          );
          break;
        default:
          this.route.navigate(['home/todos']);
      }
    });
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

  filtrandoNotificacao(btnClicado: string) {
    switch (btnClicado) {
      case 'Todos':
        this.route.navigate(['home/todos']);
        break;
      case 'Lidos':
        this.route.navigate(['home/lidos']);
        break;
      case 'Não lidos':
        this.route.navigate(['home/nao-lidos']);
        break;
    }
  }
}
