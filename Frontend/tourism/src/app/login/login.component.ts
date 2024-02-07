import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrl: './login.component.css'
})
export class LoginComponent implements OnInit {

  emailId: any;
  password: any;

  constructor() {
  }

  ngOnInit() {
  }

  loginSubmit(loginForm: any) {
    //alert(loginForm);
    //alert("EmailId:" + loginForm.value.emailId + "\nPassword:" + loginForm.value.password);

    console.log(loginForm);

    if(loginForm.emailId === "HR" && loginForm.password === "HR") {
      alert("Login Success!!!");
    } else {
      alert("Invalid Credentials");
    }


  }

  submit() {
    alert("EmailId: " + this.emailId + "\nPassword: " + this.password);
    console.log(this.emailId);
    console.log(this.password);
  }

}