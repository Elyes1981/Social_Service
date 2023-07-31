import { Component, OnInit } from '@angular/core';
import { AuthService } from '../_services/auth.service';
import {defaultFormat as _rollupMoment, Moment} from 'moment';
import {  AbstractControl,FormBuilder, FormControl, FormGroup, FormGroupDirective, NgForm, Validators } from '@angular/forms';
import * as _moment from 'moment';
import { parsePhoneNumberFromString } from 'libphonenumber-js';
import { saveAs } from 'file-saver';

import { Gender } from '../Model/gender';
import { GenderService } from '../service/gender.service';
import { Status } from '../Model/statuscus'; 
import { StatusService } from '../service/status.service';
import { CustomersService } from '../service/customers-service.service';
import { Observable, Subscription, throwError } from 'rxjs';
import { HttpClient, HttpErrorResponse, HttpEvent, HttpEventType } from '@angular/common/http';
import * as L from 'leaflet';
import { Gouvernorat } from '../Model/gouvernorat';
import { Delegation } from '../Model/delegation';
import { cooptedByType } from '../Model/cooptedByType.model';
import { ActivatedRoute, Router } from '@angular/router';
import { MatDialog } from '@angular/material/dialog';
import { MatDatepicker } from '@angular/material/datepicker';
import { Residencetype } from '../Model/residencetype';
import { NotificationService } from '../service/notification.service';
import { CooptedbytypeService } from '../service/cooptedbytype.service';
import { FileServiceService } from '../service/file-service.service';
import { ResidencetypeService } from '../service/residencetype.service';
import { MatConfirmDialogComponent } from '../mat-confirm-dialog/mat-confirm-dialog.component';
import { StatuscusService } from '../service/statuscus.service';
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
  selector: 'app-register',
  templateUrl: './register.component.html',
  styleUrls: ['./register.component.scss']
})

export class RegisterComponent implements OnInit {
  
  cooptedById!:any;
  interval:any;
   swal: any;
  filenames: string[] = [];
  fileStatus = { status: '', requestType: '', percent: 0 };
  submitted!: boolean;
  selectedCountry: any = 'TN';
  selectedPhoneNumber: any;
  selectedFile: File | undefined;
  lang!:any;
  countries: any[]=[];
  gouvs!:Gouvernorat[];
  deleg!:Delegation[];
 // gouvs: {}={};
 // deleg: {}={};
 statuss:Status[]=[];
 genders:Gender[]=[];
 cooptedByTypes:cooptedByType[]=[];
 residencetypes:Residencetype[]=[];
  idgouv!:number;
  checked2 = false;
  checked = false;
  checked1 = false;
  

  id!:number;
  gouvSelect = new Gouvernorat();
  resiSelect = new Residencetype();
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
  isSuccessful = false;
  isSignUpFailed = false;
  errorMessage = '';
   
selectedFilees: File[] = [];
  home_Adress_GPS_latt!:number;
  home_Adress_GPS_long!:number;
  markerIcon = {
    icon: L.icon({
      iconSize: [25, 41],
      iconAnchor: [10, 41],
      popupAnchor: [2, -40],
      // specify the path here
      iconUrl: "https://unpkg.com/leaflet@1.5.1/dist/images/marker-icon.png",
      shadowUrl: "https://unpkg.com/leaflet@1.5.1/dist/images/marker-shadow.png"
    })
   }
   
  constructor(
    private authService: AuthService,
    public customersService: CustomersService,http:HttpClient,
    private router: Router,
    
    private dialogg: MatDialog,
    private route: ActivatedRoute,
    private fb: FormBuilder,
    private notificationService:NotificationService,
    private statusService:StatuscusService,
    private genderService:GenderService,
    private cooptedbytypeService:CooptedbytypeService,
    
    private residencetypeService:ResidencetypeService,
    private fs: FileServiceService 

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
      map.flyTo([position.coords.latitude, position.coords.longitude],12);
      console.log(
        `latt.${position.coords.latitude}, lon:${position.coords.longitude}` 
      )
      marker.addTo(map).bindPopup('Getting your Current Location details.').openPopup();
   /* var circle = new L.Circle(new L.LatLng(position.coords.latitude, position.coords.longitude), 500, {
       // color: 'red',
       // fillColor: '#f03',
       // fillOpacity: 0.9
      }).addTo(map).bindPopup("Exact Location");*/
    });
    //Moving Marker 

    
//.addTo(this.map).bindPopup("Exact Location");

 // popup on mapclick
var popup = new L.Popup();

function onMapClick(e:any) {

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

 
    
    test!:any
      ngOnInit(): void {
      
      this.fetchCountryList();
      this.initForm();
      this.customersService.getCustomersList();
      this.statusService.getstatus().subscribe(
        (  data:Status[] )=> this.statuss = data
          
        
        
      );
      this.interval=setInterval(()=>{this.lang=localStorage.getItem('lang'|| 'en-US');})
      this.genderService.getgender().subscribe(
        (  data:Gender[] ) =>this.genders = data
        
      );
      this.cooptedbytypeService.getcoopted().subscribe(
        (  data:cooptedByType[] ) =>this.cooptedByTypes = data
        
      );
      this.residencetypeService.getresidence().subscribe(
        (  data:Residencetype[] ) =>this.residencetypes = data
        
      );
      console.log("statuss");
      this.customersService.getgouvernorat().subscribe(
        data => this.gouvs = data
      );
      this.lang=localStorage.getItem('lang'|| 'en-US');
    
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
          username: new FormControl(''),
          password: new FormControl('' ),
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
              home_Adress_GPS_latt: new FormControl(Number(localStorage.getItem('home_Adress_GPS_latt'))),
              home_Adress_GPS_long: new FormControl(Number(localStorage.getItem('home_Adress_GPS_long'))),
              emailAdress : new FormControl('',Validators.email),
              paymentMean:new FormControl('',[Validators.required]),
              creditCardNumber:['',[Validators.required,this._validateCreditCardNumber.bind(this)]],
              
              creditCardCVV2:['',[Validators.required]],
              
              creditCardExpireDate:new FormControl(_moment()),
              residenceType:new FormControl('',[Validators.required]),
              residenceNumberOfrooms:new FormControl('',[Validators.required]),
              numberOfPersonInRes:new FormControl('',[Validators.required]),
              metrage:new FormControl('',[]),
              
           
             
              
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
    
      if(isValid) {
         alert("CC Number: valid!");
      } 
    }
  
    initializeFormGroup() {
      this.customerForm.setValue({
        
        firstName: '',
        lastName: '',
        gender: '',
        status: '',
        birthDate: '',
        phone:'',
        cooptedByType:'',
        cooptedById: '',
        gouvernerat: '',
    
        home_Adress:'',
        delegation:'',
        photo:'',
        home_Adress_GPS_long: '',
        home_Adress_GPS_latt:'',
        emailAdress: '',
        paymentMean:'',
        creditCardNumber:'',
        residenceType:'',
        creditCardCVV2:'',
        creditCardExpireDate:'',
        residenceNumberOfrooms:'',
        numberOfPersonInRes:'',
        metrage: '',
      });
    }
  
    onClear() {
      this.customerForm.reset();
      this.initializeFormGroup();
     
    }
  
    
    
    selectGouvernorat(gouv:any){
      this.gouvSelect= gouv
    } 
    selectresidence(residenceType:any){
      this.resiSelect= residenceType;
      if(residenceType.label=="Villa"||"Apartment"){
        this.checked=true;
        this.checked2=false;
        
      }
      if(residenceType.label_fr=="Villa"||"Appartement"){
        this.checked=true;
        this.checked2=false;
        
      }
      if(residenceType.label_ar=="فيلا"||"شقة"){
        this.checked=true;
        this.checked2=false;
        
      }
      if(residenceType.label=="Office"){
        this.checked=false;
        this.checked2=true;
        
      }
      if(residenceType.label_fr=="Bureau"){
        this.checked=false;
        this.checked2=true;
        
      }
      if(residenceType.label_ar=="مكتب"){
        this.checked=false;
        this.checked2=true;
        
      }
    }  
  submit(){
    
    this.customersService.create(this.customerForm.value).subscribe(
      (res:any)=>{
        console.log(res.id);
        this.isSuccessful = true;
        this.isSignUpFailed = false;
        //this.sendFileToBackend(res.id);
      console.log(res.id);
      if(this.isSuccessful==true){
      this.router.navigateByUrl('/login');
    }
     //this.customerForm.reset();
  //  this.ngOnInit();
     
      
     //this.notificationService.success('! Submitted successfully');
   
  },
  err => {
    this.errorMessage = err.error.message;
    this.isSignUpFailed = true;
  }) 
 }

 openConfirmDialog(){
  const dialogRef = this.dialogg.open(MatConfirmDialogComponent, {
    width: '250px',
    data:{cooptedById:this.cooptedById}
  });
  dialogRef.afterClosed().subscribe(result => {
 
    this.f['cooptedById'].setValue(result);
    this.cooptedById  = result;
  });

}

get f(){
  return this.customerForm.controls;
}
 
onUploadFiles(event: any): void {
  console.log(event);
  this.selectedFilees = <File[]>event.target.files;
}


sendFileToBackend(id: any) {
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
}
private resportProgress(httpEvent: HttpEvent<string[] | Blob>): void {
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
       
      }
      this.fileStatus.status = 'done';
      break;
    default:
      console.log(httpEvent);
      break;

  }
}
private updateStatus(loaded: number, total: number, requestType: string): void {
  this.fileStatus.status = 'progress';
  this.fileStatus.requestType = requestType;
  this.fileStatus.percent = Math.round(100 * loaded / total);
}
onSubmit(){
  console.log(this.customerForm.value);
  this.customersService.create(this.customerForm.value).subscribe((res:any) => {
       console.log('mou3ina created successfully!');

       // TODO
       // onUploadFiles(res.id)
       this.isSuccessful = true;
       this.isSignUpFailed = false;
       if(this.isSuccessful==true){
       // this.openAlert('close');
        //
      this.router.navigateByUrl('/login');
      }

  });
}

openAlert(type) {
  switch (type) {
   
    case 'close':
      this.swal({
        title: 'Registred!',
        text: 'Please Sign In !!.',
        timer: 4000,
        showConfirmButton: false
      }).then(
        function () {},
        // handling the promise rejection
        function (dismiss) {
          if (dismiss === 'timer') {
            console.log('I was closed by the timer');
          }
        }
      );
      break;
    
}
}
 }
        

