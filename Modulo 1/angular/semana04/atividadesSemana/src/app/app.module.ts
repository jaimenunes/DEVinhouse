import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { CaptalizePhillipsPipe } from './pipes/captalize-phillips.pipe';
import { NavbarComponent } from './components/navbar/navbar.component';
import { CardListComponent } from './components/card-list/card-list.component';
import { ModalComponent } from './components/modal/modal.component';
import { CardInfoComponent } from './components/card-info/card-info.component';
import { InputValidationComponent } from './components/input-validation/input-validation.component';
import { FormsModule } from '@angular/forms';

@NgModule({
  declarations: [AppComponent, CaptalizePhillipsPipe, NavbarComponent, CardListComponent, ModalComponent, CardInfoComponent, InputValidationComponent],
  imports: [BrowserModule, AppRoutingModule, FormsModule],
  providers: [],
  bootstrap: [AppComponent],
})
export class AppModule {}
