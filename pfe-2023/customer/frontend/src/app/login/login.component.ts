import { Component, OnInit } from '@angular/core';
import { AuthService } from '../_services/auth.service';
import { TokenStorageService } from '../_services/token-storage.service';
import { Router } from '@angular/router';
import { FormControl, FormGroup, Validators, FormBuilder } from '@angular/forms';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.scss']
})
export class LoginComponent implements OnInit {


isValidFormSubmitted = false;
 submitted = false;
     loginForm = new FormGroup({
     username: new FormControl('', [Validators.required,Validators.minLength(2)]),
     password: new FormControl('', [Validators.required,Validators.minLength(6)])
     });




  form: any = {};
  isLoggedIn = false;
  isLoginFailed = false;
  errorMessage = '';
  roles: string[] = [];

  constructor(private authService: AuthService,private router: Router, private tokenStorage: TokenStorageService) { }

  ngOnInit() {
    if (this.tokenStorage.getToken()) {
      this.isLoggedIn = true;
      this.roles = this.tokenStorage.getUser().roles;
    }
  }

  onSubmit() {

          //  this.isValidFormSubmitted = false;
                        // if (this.form.username.trim().length<2) {
                        //    return ;
                        //    }
                        //     if (this.form.password.trim().length<6) {
                        //                             return;
                        //                             }

          this.isValidFormSubmitted = true;
          this.submitted = true;

    this.authService.login(this.form.username,this.form.password).subscribe(
      data => {
        this.tokenStorage.saveToken(data.accessToken);
        this.tokenStorage.saveUser(data);

        this.isLoginFailed = false;
        this.isLoggedIn = true;
        this.roles = this.tokenStorage.getUser().roles;
        this.reloadPage();
        //this.reloadPage();
      },
      err => {
        this.errorMessage = err.error.message;
        this.isLoginFailed = true;
      }
    );
  }
  onReset() {
          this.submitted = false;
          this.loginForm.reset();
      }

  reloadPage() {
    window.location.reload();

  }

}
