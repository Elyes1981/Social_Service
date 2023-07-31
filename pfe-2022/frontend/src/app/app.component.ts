import { BreakpointObserver } from '@angular/cdk/layout';
import { Component, ViewChild } from '@angular/core';
import { MatSidenav } from '@angular/material/sidenav';
import { Router } from '@angular/router';
import { TranslateService } from '@ngx-translate/core';
import {MatMenuModule} from '@angular/material/menu';
import { TokenStorageService } from './_services/token-storage.service';
@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.scss']
})

export class AppComponent {
  @ViewChild(MatSidenav)
  sidenav!: MatSidenav;


  title = 'operation-admin-fe';
  time: any;
  lang:any;
  lang1:any;
   username: string;
   private roles: string[];
    isLoggedIn = false;
    currentUser:any;
constructor(private tokenStorageService: TokenStorageService,private translateService: TranslateService,private router :Router,private observer: BreakpointObserver) {
}
ngOnInit(): void {
  this.currentUser = this.tokenStorageService.getUser();

   this.isLoggedIn = !!this.tokenStorageService.getToken();
    this.router.navigate(["home"]);

    if (this.isLoggedIn) {
      const user = this.tokenStorageService.getUser();
      this.roles = user.roles;
      this.isLoggedIn =true;
        this.username = user.username;
      }
this.lang=localStorage.getItem('lang'||'en_US');
 this.translateService.setDefaultLang(this.lang);
this.translateService.currentLang=this.lang;
console.log('Language: ', this.translateService.currentLang)
// console.log(this.translateService.use(this.lang.target.value))

}
 logout() {
    this.tokenStorageService.signOut();
    window.location.reload();
  }
public selectLanguage(lang:any) {
this.translateService.use(lang.target.value);
  localStorage.setItem('lang',lang.target.value);
  this.lang=localStorage.getItem('lang');
  console.log(this.lang)
console.log('Language: ', this.translateService.currentLang)

var initialPage = window.location.pathname;
        window.location.replace(initialPage);
  console.log(this.translateService.use(lang.target.value))




}
  ngAfterViewInit() {
      this.observer.observe(['(max-width: 800px)']).subscribe((res) => {
        if (res.matches) {
          this.sidenav.mode = 'over';
          this.sidenav.close();
        } else {
          this.sidenav.mode = 'side';
          this.sidenav.open();
        }
      });
    }

}
