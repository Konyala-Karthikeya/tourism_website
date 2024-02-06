
import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { LoginComponent } from './login/login.component';

import { FormsModule } from '@angular/forms';
import { RegisterComponent } from './register/register.component';


import { HeaderComponent } from './header/header.component';
import { PackagesComponent } from './packages/packages.component';
import { PaymentComponent } from './payment/payment.component';

@NgModule({
  declarations: [
    AppComponent,
    LoginComponent,

    RegisterComponent,


    HeaderComponent,
PackagesComponent,
PaymentComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    FormsModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
