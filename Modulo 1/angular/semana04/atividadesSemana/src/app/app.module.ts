import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { CaptalizePhillipsPipe } from './pipes/captalize-phillips.pipe';
import { NavbarComponent } from './components/navbar/navbar.component';
import { CardListComponent } from './components/card-list/card-list.component';

@NgModule({
  declarations: [AppComponent, CaptalizePhillipsPipe, NavbarComponent, CardListComponent],
  imports: [BrowserModule, AppRoutingModule],
  providers: [],
  bootstrap: [AppComponent],
})
export class AppModule {}
