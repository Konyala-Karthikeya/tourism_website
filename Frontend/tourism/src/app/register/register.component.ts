import { Component } from '@angular/core';

@Component({
  selector: 'app-register',
  templateUrl: './register.component.html',
  styleUrls: ['./register.component.css']
})
export class RegisterComponent {
  constructor() { }

  onSubmit(formData: any) {
    // Handle form submission logic here
    console.log(formData); // Example: Log form data to the console
  }
}
