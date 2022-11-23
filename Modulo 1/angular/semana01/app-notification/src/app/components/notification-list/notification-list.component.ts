import { Component } from '@angular/core';

@Component({
  selector: 'ntap-notification-list',
  templateUrl: './notification-list.component.html',
  styleUrls: ['./notification-list.component.scss'],
})
export class NotificationListComponent {
  titulo: string = 'Sua encomenda chegou';
  dias: number = 1;
  mensagem: string = 'Seu pedido número #123, acabou de chegar.';
  recebido: string = 'Por favor, confirme o recebimento!';
}
