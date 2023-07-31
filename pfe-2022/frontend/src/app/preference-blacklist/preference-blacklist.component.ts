import { Component, ElementRef, OnInit, ViewChild } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { CustomerOrderMou3inaList } from '../Model/customer-order-mou3ina-list';
import { Customer } from '../Model/customer.model';
import { Reservation } from '../Model/reservation';
import { CustomersService } from '../service/customers-service.service';
import { ReservationService } from '../service/reservation.service';
import { CustomerService } from '../_services/customer.service';
import { TokenStorageService } from '../_services/token-storage.service';

@Component({
  selector: 'app-preference-blacklist',
  templateUrl: './preference-blacklist.component.html',
  styleUrls: ['./preference-blacklist.component.scss']
})
export class PreferenceBlacklistComponent implements OnInit {


  @ViewChild('htmlData', { static: false }) htmlData!: ElementRef;

  id: any;
  reservations: Reservation[] = [];
  // customerOrderMou3inaLists:CustomerOrderMou3inaList[]=[];
  customerOrderMou3inaLists: CustomerOrderMou3inaList[] = [];
  customerOrderMou3inaList: CustomerOrderMou3inaList;
  reservation: Reservation;
  lang: any
  interval: any
  currentUser:Customer;


  constructor(private ReservationService: ReservationService, private route: ActivatedRoute,
    private router: Router,private customersService:CustomersService,private token:TokenStorageService) { }
  reloadData() {
    this.ReservationService.getList().subscribe((data: Reservation[]) => {
      this.reservations = data;
      console.log(this.reservation.id)
    })
    this.id = this.route.snapshot.params['id'];
    this.ReservationService.get(this.id)
      .subscribe(data => {
        //console.log(data)
        console.log("helloo")

        this.reservation = data;
        console.log(this.reservation.customerOrderMou3inaLists[0]);
      }, error => console.log(error));

   /* this.ReservationService.getOrder().subscribe((data: CustomerOrderMou3inaList[]) => {
      this.customerOrderMou3inaLists = data;


      console.log(data)
        ;
      console.log(this.customerOrderMou3inaLists[0].mou3ina.id);

    });*/
    this.ReservationService.getbymou3ina(this.id).subscribe((data: CustomerOrderMou3inaList[]) => {
      this.customerOrderMou3inaLists = data;
     console.log('------')
      console.log(data);
    })


  }


  ngOnInit() {
    this.currentUser=this.token.getUser();
    this.reloadData();
    this.interval = setInterval(() => {
      this.lang = localStorage.getItem('lang' || 'en-US');
    }, 1);

    this.id = this.route.snapshot.params['id'];

    this.ReservationService.get(this.id)
      .subscribe(data => {
        this.reservation = data;
        console.log(this.reservation)
      }, error => console.log(error));
  }

  list() {
    this.router.navigate(['list']);
  }


  test:any
  customer:any;
  customerTest:Customer
  submit(mou3ina){
     this.currentUser.mou3inas_preferences.push(mou3ina)

    this.customersService.updateCustomer(this.currentUser.id, this.currentUser).subscribe((res:any) => {


  this.customerTest=res;
 

   this.router.navigateByUrl('list');
  
    
  })};
  submit1(mou3ina){
   
    this.currentUser.mou3inas_blacklist.push(mou3ina)

    this.customersService.updateCustomer(this.currentUser.id, this.currentUser).subscribe((res:any) => {


  this.customerTest=res;
 

   this.router.navigateByUrl('list');
    
  })};
}
