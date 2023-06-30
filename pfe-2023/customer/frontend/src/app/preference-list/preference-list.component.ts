import { AfterViewInit, Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Customer } from '../Model/customer.model';
import { CustomersService } from '../service/customers-service.service';
import { TokenStorageService } from '../_services/token-storage.service';
declare const $: any;
@Component({
  selector: 'app-preference-list',
  templateUrl: './preference-list.component.html',
  styleUrls: ['./preference-list.component.scss']
})
export class PreferenceListComponent implements OnInit,AfterViewInit {
  currentUser:any;
  tabIndex = 0;

  constructor( private token:TokenStorageService,private router: Router,private customersService:CustomersService ) {}

  ngOnInit(): void {
    this.currentUser = this.token.getUser();
    console.log(this.currentUser.mou3inas_blacklist.length)
  //console.log( this.currentUser.mou3inas_preferences[0].id)
  } 

  test:any
  customer:any;
  customerTest:Customer
  deletefromBlacklist(blacklist){
   
    this.currentUser.mou3inas_blacklist.splice(blacklist)
    console.log( "heloo"+this.currentUser.mou3inas_blacklist)

    this.customersService.updateCustomer(this.currentUser.id, this.currentUser).subscribe((res:any) => {


  this.customerTest=res;
 

 //  this.router.navigateByUrl('list');
    
  })};
  deletefromPreference(preference){
   
    this.currentUser.mou3inas_preferences.splice(preference)
    console.log( "heloo"+this.currentUser.mou3inas_preferences)

    this.customersService.updateCustomer(this.currentUser.id, this.currentUser).subscribe((res:any) => {


  this.customerTest=res;
 
  this.ngOnInit();
  // this.router.navigateByUrl('list');
    
  })};
  ngAfterViewInit() {
    const preBtn = <HTMLElement>document.getElementById('preBtn');
    const moveTab = <HTMLElement>document.querySelector('.move-tab');
    preBtn.style.visibility = 'hidden';
    // to ensure moveTab can stay correct position
    $(window).resize(() => {
      const screenWidth = document.body.clientWidth;
      if (screenWidth > 990) {
        moveTab.style.width = 'calc((100% - 260px) / 2)';
        if (this.tabIndex === 1) {
          moveTab.style.left = '20vw';
        } else if (this.tabIndex === 2) {
          moveTab.style.left = '42vw';
        }
      } else {
        moveTab.style.width = '34%';
        if (this.tabIndex === 1) {
          moveTab.style.left = '30vw';
        } else if (this.tabIndex === 2) {
          moveTab.style.left = '61.5vw';
        }
      }
    });
    const tabs = document.getElementsByClassName('wizard-tab');
    for (let i = 1; i < tabs.length; i++) {
      (<HTMLElement>tabs[i]).style.display = 'none';
    }
  }

  preOnClick() {
    const moveTab = <HTMLElement>document.querySelector('.move-tab');
    const nextBtn = <HTMLElement>document.getElementById('nextBtn');
    const preBtn = <HTMLElement>document.getElementById('preBtn');
    const tabs = document.getElementsByClassName('wizard-tab');
    const screenWidth = document.body.clientWidth;
    for (let i = 0; i < tabs.length; i++) {
      (<HTMLElement>tabs[i]).style.display = 'none';
    }
    if (this.tabIndex === 2) {
      this.tabIndex--;
      moveTab.style.left = screenWidth > 990 ? '20vw' : '30vw';
      nextBtn.style.visibility = 'visible';
      moveTab.innerHTML = 'Blacklist';
    }else if (this.tabIndex === 1) {
      this.tabIndex--;
      moveTab.style.left = '-1vw';
      preBtn.style.visibility = 'hidden';
      moveTab.innerHTML = 'Favorite';
    }
    (<HTMLElement>tabs[this.tabIndex]).style.display = 'inherit';
  }

  nextOnClick() {
    const moveTab = <HTMLElement>document.querySelector('.move-tab');
    const nextBtn = <HTMLElement>document.getElementById('nextBtn');
    const preBtn = <HTMLElement>document.getElementById('preBtn');
    const tabs = document.getElementsByClassName('wizard-tab');
    const screenWidth = document.body.clientWidth;
    for (let i = 0; i < tabs.length; i++) {
      (<HTMLElement>tabs[i]).style.display = 'none';
    }
    if (this.tabIndex === 0) {
      this.tabIndex++;
      moveTab.style.left = screenWidth > 990 ? '20vw' : '30vw';
      preBtn.style.visibility = 'visible';
      moveTab.innerHTML = 'Blacklist';
    }
    (<HTMLElement>tabs[this.tabIndex]).style.display = 'inherit';
  }

}