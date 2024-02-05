
import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { LoginComponent } from './login/login.component';
<<<<<<< HEAD:Frontend/tourism/src/app/app.module.ts
import { FormsModule } from '@angular/forms';
import { RegisterComponent } from './register/register.component';
=======
>>>>>>> Ajay:Frontend/tourism_website/src/app/app.module.ts
import { HeaderComponent } from './header/header.component';

@NgModule({
  declarations: [
    AppComponent,
    LoginComponent,
<<<<<<< HEAD:Frontend/tourism/src/app/app.module.ts
    RegisterComponent,
=======
>>>>>>> Ajay:Frontend/tourism_website/src/app/app.module.ts
    HeaderComponent
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
