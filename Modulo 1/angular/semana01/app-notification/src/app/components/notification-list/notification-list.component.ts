import { NOTIFICATIONS } from './../../constants/notification';
import { Component } from '@angular/core';
@Component({
  selector: 'ntap-notification-list',
  templateUrl: './notification-list.component.html',
  styleUrls: ['./notification-list.component.scss'],
})
export class NotificationListComponent {
  notifications = NOTIFICATIONS
}
