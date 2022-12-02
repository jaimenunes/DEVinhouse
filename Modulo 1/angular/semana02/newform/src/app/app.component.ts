import { Component } from '@angular/core';
import { LocalStorageService } from './services/local-storage.service';



@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})

export class AppComponent {
  userEmail: string = '';
  userPassword: string = '';

  constructor(private localStorageService: LocalStorageService){

  }
  onSubmit(){
    this.localStorageService.setUserToLocalStorage(this.userEmail, this.userPassword)
  }
  logarSearch(event:string){
    console.log(event)
  }
}
