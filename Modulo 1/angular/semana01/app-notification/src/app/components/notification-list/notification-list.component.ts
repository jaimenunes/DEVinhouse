import { Component } from '@angular/core';

@Component({
  selector: 'ntap-notification-list',
  templateUrl: './notification-list.component.html',
  styleUrls: ['./notification-list.component.scss'],
})
export class NotificationListComponent {
  cards: any = [
    {
      titulo: 'Sua encomenda chegou',
      ativo: true,
      dias: 1,
      mensagem: 'Seu pedido número #123, acabou de chegar',
      recebido: 'Por favor, confirme o recebimento!',
    },
    {
      titulo: 'Sua encomenda chegou',
      ativo: false,
      dias: 3,
      mensagem: 'Seu pedido número #85959, acabou de chegar',
      recebido: 'Por favor, confirme o recebimento!',
    },
  ];
}
