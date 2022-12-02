import { Component, OnInit, Output, EventEmitter } from '@angular/core';


@Component({
  selector: 'app-search',
  templateUrl: './search.component.html',
  styleUrls: ['./search.component.css']
})
export class SearchComponent implements OnInit {
  constructor() { }
  @Output() valueOutput: EventEmitter<string> = new EventEmitter()
  value:string = ''

  ngOnInit(): void {

  }
  emitir(){
    this.valueOutput.emit(this.value)
  }

}
