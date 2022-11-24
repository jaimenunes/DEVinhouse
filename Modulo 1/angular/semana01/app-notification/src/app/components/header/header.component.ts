import { URL } from './../../constants/url';
import { Component } from '@angular/core';

@Component({
  selector: 'ntap-header',
  templateUrl: './header.component.html',
  styleUrls: ['./header.component.scss'],
})
export class HeaderComponent {
  url = URL;
}
