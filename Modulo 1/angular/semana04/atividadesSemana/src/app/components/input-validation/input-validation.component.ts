import { Component } from '@angular/core';

@Component({
  selector: 'app-input-validation',
  templateUrl: './input-validation.component.html',
  styleUrls: ['./input-validation.component.css']
})
export class InputValidationComponent {
  name:string =''
  isValid: boolean;
  submit(){
    if(this.name && this.name.length > 6){
      this.isValid = true
    }else{
      this.isValid = false
    }
  }
}
