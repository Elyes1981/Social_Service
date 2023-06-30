import { Component, OnInit } from '@angular/core';
import { FormGroup } from '@angular/forms';
import { DomSanitizer } from '@angular/platform-browser';
import { ActivatedRoute, Router } from '@angular/router';
import { Gouvernorat } from '../Model/gouvernorat';
import { CustomersService } from '../service/customers-service.service'; 
import { TokenStorageService } from '../_services/token-storage.service'; 
@Component({
  selector: 'app-profile',
  templateUrl: './profile.component.html',
  styleUrls: ['./profile.component.scss']
})
export class ProfileComponent implements OnInit {
  currentUser: any;
  customerForm!:FormGroup;
  gouvSelect = new Gouvernorat()
checked2=false;
checked=false;
checked1=false;
lang:any;
interval:any;
gouvs!:Gouvernorat[];
  customer:any;
  id!:number;
  logo!:any;

  constructor(private token: TokenStorageService,private route: ActivatedRoute,private router: Router,
    private customersService: CustomersService,private sanitizer: DomSanitizer) { }

  ngOnInit(): void {
    this.currentUser = this.token.getUser();
    console.log("helllooo");
    console.log(this.currentUser)
    this.interval=setInterval(()=>{this.lang=localStorage.getItem('lang'|| 'en-US');})
    this.customersService.getgouvernorat().subscribe(
      data => this.gouvs = data
    );
    this.id = this.route.snapshot.params['id'];
    
    /*this.customersService.getCustomer(this.id)
      .subscribe(data => {
        console.log(data)
        this.customer = data;
      }, error => console.log(error));*/

  }
  getLogo() {
    if (this.customer?.image && !this.logo) {
      this.logo = this.sanitizer.bypassSecurityTrustResourceUrl('data:image/jpg;base64,' + this.customer.image);
    }
    return this.logo;
  } 
  list(){
    this.router.navigate(['customers']);
  }
  selectGouvernorat(gouv:any){
    this.gouvSelect= gouv
  }  
  updateCustomer(id: number){
    
    this.router.navigate(['/update', id]);
    
  }
}