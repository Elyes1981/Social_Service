import { HttpClient, HttpErrorResponse, HttpEvent, HttpEventType } from '@angular/common/http';
import { parsePhoneNumberFromString } from 'libphonenumber-js';
import { Component, OnInit, ElementRef, NgZone, OnDestroy, AfterViewInit } from '@angular/core';

import { AbstractControl, FormBuilder, FormControl, FormGroup, FormGroupDirective, NgForm, Validators } from '@angular/forms';
import {MomentDateAdapter, MAT_MOMENT_DATE_ADAPTER_OPTIONS} from '@angular/material-moment-adapter';
import {DateAdapter, MAT_DATE_FORMATS, MAT_DATE_LOCALE} from '@angular/material/core';
import { Observable, Subscription, throwError } from 'rxjs';
//import { saveAs } from 'file-saver';
import { CustomersService } from '../service/customers-service.service';
import { Router, ActivatedRoute, ParamMap } from '@angular/router';
import * as L from 'leaflet';
//import { Gouvernorat } from '../model/gouvernorat';
//import { GouvernoratService } from '../services/gouvernorat.service';

//import { Delegation } from '../model/delegation';
//import { DelegationService } from '../services/delegation.service';
//import { NotificationService } from '../services/notification.service';
import { MatDialog, MatDialogConfig} from '@angular/material/dialog';


//import { MatConfirmDialogComponent } from '../mat-confirm-dialog/mat-confirm-dialog.component';

//import { FileServiceService } from '../services/file-service.service';

import { Status } from '../Model/statuscus';
import { StatusService } from '../service/status.service';

import * as _moment from 'moment';

import {defaultFormat as _rollupMoment, Moment} from 'moment';
import { MatDatepicker } from '@angular/material/datepicker';
import { Customer } from '../Model/customer.model'; 
//import { cooptedByType } from '../model/cooptedbytype';
//import { CooptedbytypeService } from '../services/cooptedbytype.service';
//import { Residencetype } from '../model/residencetype';
//import { ResidencetypeService } from '../services/residencetype.service';
import { Gender } from '../Model/gender';
import { GenderService } from '../service/gender.service'; 
import { TranslateService } from '@ngx-translate/core';
import { Reservation } from '../Model/reservation';
import { CustomerOrderMou3inaList } from '../Model/customer-order-mou3ina-list';
import { ReservationService } from '../service/reservation.service';

const moment = _rollupMoment || _moment;


export const MY_FORMATS = {
  parse: {
    dateInput: 'MM/YYYY',
  },
  display: {
    dateInput: 'MM/YYYY',
    monthYearLabel: 'MMM YYYY',
   
  },
};



@Component({
  selector: 'app-updatecustomer',
  templateUrl: './updatecustomer.component.html',
  styleUrls: ['./updatecustomer.component.scss'],
  providers: [

    {
      provide: DateAdapter,
      useClass: MomentDateAdapter,
      deps: [MAT_DATE_LOCALE, MAT_MOMENT_DATE_ADAPTER_OPTIONS]
    },

    {provide: MAT_DATE_FORMATS, useValue: MY_FORMATS},
  ],
  
})
export class UpdatecustomerComponent implements OnInit,OnDestroy,AfterViewInit {
 
  id:any;
  reservations: Reservation[]=[];
 // customerOrderMou3inaLists:CustomerOrderMou3inaList[]=[];
  customerOrderMou3inaLists:CustomerOrderMou3inaList[]=[];
  customerOrderMou3inaList:CustomerOrderMou3inaList;
  reservation: Reservation;
   lang:any
   interval:any
   
  cooptedById!:any;
  filenames: string[] = [];
  fileStatus = { status: '', requestType: '', percent: 0 };
  submitted!: boolean;
  selectedCountry: any = 'TN';
  selectedPhoneNumber: any;
  selectedFile: File | undefined;
  languaaa:any
  countries: any[]=[];
  //gouvs!:Gouvernorat[];
  //deleg!:Delegation[];
 // gouvs: {}={};
 // deleg: {}={};
 statuss:Status[]=[];
 //cooptedByTypes:cooptedByType[]=[];
 //residencetypes:Residencetype[]=[];
  idgouv!:number;
  checked2 = false;
  checked = false;
  checked1 = false;
  
  genders:Gender[]=[];
  //gouvSelect = new Gouvernorat()
  //resiSelect = new Residencetype()
  subscription!: Subscription;
  customerForm!:FormGroup;
  metrage:any;
  customer:any;
  map:any;
  
   
 
   arrayOfLatLngs = [];
    currentYear=Number(new Date().getFullYear())-18 ; 
    currentMonth= new Date().getMonth();
    currentDay= new Date().getDay();
    maxDate=new Date (this.currentYear, this.currentMonth,this.currentDay );
    minDate= new Date();
    maxDateExp=new Date (Number(new Date().getFullYear())+10, this.currentMonth );
  minRoom = 1;
  maxRoom=10;
   
selectedFilees: File[] = [];
 

   
  constructor(
    public customersService: CustomersService,http:HttpClient,
    private router: Router,
    public translateService:TranslateService,
    private dialogg: MatDialog,
    private route: ActivatedRoute,
    private fb: FormBuilder,
    private ReservationService: ReservationService,
    //private notificationService:NotificationService,
    //private statusService:StatusService,
    //private cooptedbytypeService:CooptedbytypeService,
    //private residencetypeService:ResidencetypeService,
    private genderService:GenderService,
  
    //private fs: FileServiceService 

      ) { }
  
    ngAfterViewInit(): void {
    
      var map = L.map('map', {
       center: [ 36.8315797, 10.2330051 ],
       zoom: 3
     });
 
     const tiles = L.tileLayer('http://{s}.google.com/vt/lyrs=m&x={x}&y={y}&z={z}', {
       maxZoom: 24,
       minZoom: 3,
       subdomains:['mt0','mt1','mt2','mt3'],
      
     });
     
 
     tiles.addTo(map);
    // add marker to the current position
 if(!navigator.geolocation){
     console.log('localisation is not supported');
   }
   navigator.geolocation.getCurrentPosition((position)=>
   {  var marker = new L.Marker(new L.LatLng(position.coords.latitude, position.coords.longitude));
     console.log(
       `latt.${position.coords.latitude}, lon:${position.coords.longitude}` 
     )
     marker.addTo(map).bindPopup('Getting your Current Location details.').openPopup();
     var circle = new L.Circle(new L.LatLng(position.coords.latitude, position.coords.longitude), 500, {
       color: 'red',
       fillColor: '#f03',
       fillOpacity: 0.5
     }).addTo(map).bindPopup("Exact Location");
   });
   //Moving Marker 

   
//.addTo(this.map).bindPopup("Exact Location");

// popup on mapclick
var popup = new L.Popup();

function onMapClick(e:any) {
var  home_Adress_GPS_latt;
var home_Adress_GPS_long;
 popup
   .setLatLng(e.latlng)
   .setContent("You clicked the map at " + e.latlng.toString());
  /// .openOn(map);
 
  var marker = new L.Marker(new L.LatLng(e.latlng.lat, e.latlng.lng),{draggable:true});
  marker.addTo(map).bindPopup("Getting your New Location").openPopup(); 
  console.log("You clicked the map at latitude: " + e.latlng.lat + " and longitude: " + e.latlng.lng);
  window.alert('getting data successfully!');
  localStorage.setItem('home_Adress_GPS_latt',e.latlng.lat);
  localStorage.setItem('home_Adress_GPS_long',e.latlng.lng);
 
}

map.on('click', onMapClick);




       
      
   }



 
    
   
      ngOnInit(): void {
      //console.log('HEU'+this.customerOrderMou3inaList[0].mou3ina)

      console.log(this.translateService.currentLang)
      //this.languaaa=this.translateService.currentLang;
      this.fetchCountryList();
      this.initForm();
      this.customersService.getCustomersList();

      /*this.statusService.getstatus().subscribe((data: Status[])=>{
        this.statuss = data;
        console.log(this.statuss);
        }  );*/
      console.log("statuss");
     /* this.customersService.getgouvernorat().subscribe(
        data => this.gouvs = data
      );*/
      this.genderService.getgender().subscribe(
        (  data:Gender[] ) =>this.genders = data
        
      );
      /*this.cooptedbytypeService.getcoopted().subscribe(
        (  data:cooptedByType[] ) =>this.cooptedByTypes = data
        
      );*/
     /* this.residencetypeService.getresidence().subscribe(
        (  data:Residencetype[] ) =>this.residencetypes = data
        
      );*/
      this.lang=localStorage.getItem('lang'|| 'en-US');
      this.interval=setInterval(()=>{this.lang=localStorage.getItem('lang'|| 'en-US');})

      this.id = this.route.snapshot.params['id'];
      this.customersService.getCustomer(this.id).subscribe((data: Customer)=>{
      this.customer = data;
      this.cooptedById=this.customer.cooptedById;
      this.ReservationService.getList().subscribe((data:Reservation[])=>{
        this.reservations=data;
        console.log(this.reservations)
  })
   this.ReservationService.getOrder().subscribe((data:CustomerOrderMou3inaList[])=>{
        this.customerOrderMou3inaLists=data;

        this.test=this.customerOrderMou3inaLists[0].mou3ina
          console.log(this.customerOrderMou3inaLists)
                                  });
    });
    
       }

    ngOnDestroy(): void {
      if(this.subscription){
        this.subscription.unsubscribe();
      }
    }
    private fetchCountryList(): void {
      this.subscription = this.customersService.getCountries().subscribe((res: any) => {
        this.countries = res;
      }, error => error);
    }
    private initForm(): void{
      
      
      this.customerForm = this.fb.group({
        
              firstName: new FormControl('', [Validators.required,Validators.min(2)]),
              lastName: new FormControl('',[Validators.required,Validators.minLength(2)]),
             gender: new FormControl('',[Validators.required]),
             photo: new FormControl('',[]),
             status: new FormControl('',[Validators.required]),
              birthDate: new FormControl('',[Validators.required]),
              phone: ['', [Validators.required, this._validatePhoneNumberInput.bind(this)]] ,
              home_Adress: new FormControl('',[Validators.required]),
              cooptedById: new FormControl('',[Validators.required]),
              cooptedByType: new FormControl('',[Validators.required]),
              gouvernerat: new FormControl(''),
              delegation: new FormControl(''),
              
              emailAdress : new FormControl('',Validators.email),
              paymentMean:new FormControl('',[Validators.required]),
              creditCardNumber:['',[Validators.required,this._validateCreditCardNumber.bind(this)]],
              
              creditCardCVV2:['',[Validators.required ]],
              
              creditCardExpireDate:new FormControl(_moment()),
              residenceType:new FormControl('',[Validators.required]),
              residenceNumberOfrooms:new FormControl('',[Validators.required]),
              numberOfPersonInRes:new FormControl('',[Validators.required]),
              metrage:new FormControl('',[]),
              mou3inas_preferences: new  FormControl(), 
              agent:new FormControl(), 

              
           
             
              
      });
      
     
    }
 
    chosenYearHandler(normalizedYear: Moment) {
      const ctrlValue = this.f['creditCardExpireDate'].value;
      ctrlValue.year(normalizedYear.year());
      this.f['creditCardExpireDate'].setValue(ctrlValue);
    }
   chosenMonthHandler(normalizedMonth: Moment, datepicker: MatDatepicker<Moment>) {
      const ctrlValue = this.f['creditCardExpireDate'].value;
      ctrlValue.month(normalizedMonth.month());
      this.f['creditCardExpireDate'].setValue(ctrlValue);
      datepicker.close();
    }
   
    _validatePhoneNumberInput(c: AbstractControl) {
      let inputValue: string = c.value.toString();
      let phoneNumber: any = parsePhoneNumberFromString(inputValue, this.selectedCountry);
      if(phoneNumber){
        if(phoneNumber.isValid()){
          return null;
        } else {
          return {
            phoneNumber: {
              valid: false
            }
          }
        }
      } else {
        return {
          phoneNumber: {
            valid: false
          }
        }
      }
    }
   
    resetPhoneNumber(event: any): void {
      this.customerForm.controls['phone'].setValue('');
    }
  
    formatPhoneNumber(event: any): void {
      let inputValue: any = this.customerForm.controls['phone'].value;
      let phoneNumber: any = parsePhoneNumberFromString(inputValue, this.selectedCountry);
      if(phoneNumber){
        this.selectedPhoneNumber = phoneNumber.number;
        this.customerForm.controls['phone'].setValue(phoneNumber.formatInternational());
      }
    }
    _validateCreditCardNumber(c:AbstractControl) {
      let ccNum = c.value.toString();;
     
      var visaRegEx = /^(?:4[0-9]{12}(?:[0-9]{3})?)$/;
      var mastercardRegEx = /^(?:5[1-5][0-9]{14})$/;
      var amexpRegEx = /^(?:3[47][0-9]{13})$/;
      var discovRegEx = /^(?:6(?:011|5[0-9][0-9])[0-9]{12})$/;
      var isValid = false;
    
      if (visaRegEx.test(ccNum)) {
        isValid = true;
      } else if(mastercardRegEx.test(ccNum)) {
        isValid = true;
      } else if(amexpRegEx.test(ccNum)) {
        isValid = true;
      } else if(discovRegEx.test(ccNum)) {
        isValid = true;
      }
    
     /* if(isValid) {
         alert("CC Number: valid!");
      } */
    }
    
    initializeFormGroup() {
      this.customerForm.setValue({
        
        firstName: '',
        lastName: '',
        gender: '',
        status: '',
        birthDate: '',
        phone: '',
        gouvernerat: '',
        delegation: '',
        emailAdress:''
      });
    }
 
    onClear() {
      this.customerForm.reset();
      this.initializeFormGroup();
     
    }
  
    
  
    
    /*selectGouvernorat(gouv:any){
      this.gouvSelect= gouv
    } */ 
    /*selectresidence(residenceType:any){
      this.resiSelect= residenceType;
      if(residenceType.label=="Villa"||"Apartment"){
        this.checked=true;
        this.checked2=false;
        
      }
      if(residenceType.label=="Office"){
        this.checked=false;
        this.checked2=true;
        
      }
    } */
    customerToUpdated:any
    test:any
    submit(){
      this.customersService.updateCustomer(this.id, this.customer).subscribe((res:any) => {
    console.log(this.customerOrderMou3inaLists[0].mou3ina)
  
      console.log("testttttt");
      this.customer.mou3inas_preferences=[this.test]

    
    //this.customer.mou3inas_preferences=[this.test]

     console.log(this.customer.mou3inas_preferences)
     console.log(this.customer);
     this.router.navigateByUrl('list');
    
      
    })};
    submit1(){
      this.customersService.updateCustomer(this.id, this.customer).subscribe((res:any) => {
    console.log(this.customerOrderMou3inaLists[0].mou3ina)
    this.customer.mou3inas_blacklist=[this.test]

     console.log(this.customer.mou3inas_blacklist)
     console.log(this.customer);
     this.router.navigateByUrl('list');
    
      
    })};

    submit_rate(){
      this.customersService.updateCustomer(this.id, this.customer).subscribe((res:any) => {
    //console.log(this.customerOrderMou3inaLists[0].mou3ina)
    //this.customer.mou3inas_blacklist=[this.test]

     console.log(this.customer.agent.rate)
     //console.log(this.customer);
     //this.router.navigateByUrl('list');
    
      
    })};
    compareWithIdFn(c1: any, c2: any) {
      return c1 && c2 ? c1.id === c2.id : c1 === c2;
    }

  
 /*openConfirmDialog(){
  const dialogRef = this.dialogg.open(MatConfirmDialogComponent, {
    width: '250px',
    data:{cooptedById:this.cooptedById}
  });
  dialogRef.afterClosed().subscribe(result => {
 
    this.f['cooptedById'].setValue(result);
    this.cooptedById  = result;
  });

}*/

get f(){
  return this.customerForm.controls;
}
 
onUploadFiles(event: any): void {
  console.log(event);
  this.selectedFilees = <File[]>event.target.files;
}


/*sendFileToBackend(id: any) {
  const formData = new FormData();
  formData.append('files', this.selectedFilees[0], this.selectedFilees[0].name)
  formData.append('id',id);
  this.fs.upload(formData).subscribe(
    event => {
      console.log(event);
      this.resportProgress(event);
    },
    (error: HttpErrorResponse) => {
      console.log(error);
    }
  );
}*/
/*private resportProgress(httpEvent: HttpEvent<string[] | Blob>): void {
  switch (httpEvent.type) {
    case HttpEventType.UploadProgress:
      this.updateStatus(httpEvent.loaded, httpEvent.total!, 'Uploading... ');
      break;
    case HttpEventType.DownloadProgress:
      this.updateStatus(httpEvent.loaded, httpEvent.total!, 'Downloading... ');
      break;
    case HttpEventType.ResponseHeader:
      console.log('Header returned', httpEvent);
      break;
    case HttpEventType.Response:
      if (httpEvent.body instanceof Array) {
        this.fileStatus.status = 'done';
        for (const filename of httpEvent.body) {
          this.filenames.unshift(filename);
        }
      } else {
        saveAs(new File([httpEvent.body!], httpEvent.headers.get('File-Name')!,
          { type: `${httpEvent.headers.get('Content-Type')};charset=utf-8` }));
        // saveAs(new Blob([httpEvent.body!], 
        //   { type: `${httpEvent.headers.get('Content-Type')};charset=utf-8`}),
        //    httpEvent.headers.get('File-Name'));
      }
      this.fileStatus.status = 'done';
      break;
    default:
      console.log(httpEvent);
      break;

  }
}
/*compareWithSelected(gouvSelect: Gouvernorat, c2: Gouvernorat){
  return gouvSelect && c2 ? gouvSelect.idgouv === c2.idgouv : gouvSelect === c2;
}*/
/*compareWithSelecteddeligation(delegation:Delegation,c2:Delegation){
  return delegation && c2 ? delegation.iddele === c2.iddele : delegation === c2;
}*/
private updateStatus(loaded: number, total: number, requestType: string): void {
  this.fileStatus.status = 'progress';
  this.fileStatus.requestType = requestType;
  this.fileStatus.percent = Math.round(100 * loaded / total);
}
 }