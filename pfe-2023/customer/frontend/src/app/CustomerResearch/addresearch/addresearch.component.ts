import { Component, OnInit ,NgModule,Injectable,AfterViewInit  } from '@angular/core';
import { FormBuilder,FormControl, FormGroup, Validators, ReactiveFormsModule  } from '@angular/forms';
import {Router,ParamMap } from "@angular/router";

import{CustomerResearchResultMou3inaList} from 'src/app/Model/customer-research-result-mou3ina-list';
import { ServiceType } from 'src/app/Model/service-type.module';
import { NgxSpinnerService } from 'ngx-spinner';
import { Reservation } from 'src/app/Model/reservation';
import { StatusReservation }      from 'src/app/Model/status';
import { Mou3ina } from 'src/app/Model/mou3ina';
import { CollaborationStatus } from 'src/app/Model/collaboration-status.model';
import { CustomerPreferences } from 'src/app/Model/customer-preferences.model';
import { Recurrent } from 'src/app/Model/recurrent';
import { CustomerResearch } from 'src/app/Model/customer-research';
import { Customer } from 'src/app/Model/customer.model'
import{Mou3inapreferenceService} from "src/app/service/mou3inapreference.service";
import { ServiceTypeService } from "src/app/service/service-type.service";
import { CustomersService } from 'src/app/service/customers-service.service';
import{ RecurrentService } from "src/app/service/recurrent.service";
import { ResearchService } from "src/app/service/research.service";
import { Mou3inaService } from 'src/app/service/mou3ina.service';
import { StatusService } from 'src/app/service/status.service';
import { AddComponent } from 'src/app/reservation/add/add.component';

import { PreferencesMou3ina } from 'src/app/Model/preferences-mou3ina.model';

import {NgbCalendar, NgbDate, NgbDateParserFormatter,NgbDatepicker} from '@ng-bootstrap/ng-bootstrap';
import { DateRangePicker } from '@syncfusion/ej2-calendars';
import {ThemePalette} from '@angular/material/core';
import {Frequency, Options, RRule} from 'rrule';
import {Subject} from 'rxjs';
import {takeUntil} from 'rxjs/operators';

import { CustomDatepickerI18nService, I18n } from 'src/app/service/custom-datepicker-i18n-service';
import {NgbDatepickerI18n,NgbDateStruct,NgbModal} from '@ng-bootstrap/ng-bootstrap';
import { loadCldr, L10n } from '@syncfusion/ej2-base';

import { DatePickerComponent } from "@syncfusion/ej2-angular-calendars";
import { DateFilterFn } from '@angular/material/datepicker';
import{ DatePipe } from'@angular/common';

import {MatDialog} from '@angular/material/dialog';
import { DataserviceService } from 'src/app/service/dataservice.service';
import * as L from 'leaflet';
import { OpenStreetMapProvider } from 'leaflet-geosearch';

import {Icon} from 'leaflet';
export function toNativeDate(ngbDate: NgbDate): Date {
  return new Date(Date.UTC(ngbDate.year, ngbDate.month - 1, ngbDate.day));
}

declare var require: any;

loadCldr(
require('cldr-data/supplemental/numberingSystems.json'),
require('cldr-data/main/ar/ca-gregorian.json'),
require('cldr-data/main/ar/timeZoneNames.json'),
require('cldr-data/main/ar/numbers.json'),
require('cldr-data/main/fr/ca-gregorian.json'),
require('cldr-data/main/fr/timeZoneNames.json'),
require('cldr-data/main/fr/numbers.json'),

require('cldr-data/main/ar-TN/ca-gregorian.json'),
require('cldr-data/main/ar-TN/numbers.json'),
require('cldr-data/main/ar-TN/timeZoneNames.json'),
require('cldr-data/main/ar-TN/dateFields.json'),
require('cldr-data/supplemental/weekdata.json') // To load the culture based first day of week
);

@Component({
  selector: 'app-addresearch',
  templateUrl: './addresearch.component.html',
  styleUrls: ['./addresearch.component.scss'],
    providers: [I18n,{provide: NgbDatepickerI18n, useClass: CustomDatepickerI18nService}]

})

export class AddresearchComponent implements OnInit ,AfterViewInit {
   markerIcon = {
      icon: L.icon({
        iconSize: [25, 41],
        iconAnchor: [10, 41],
        popupAnchor: [2, -40],
        // specify the path here
        iconUrl:   "./node_modules/leaflet/dist/leaflet.css",
        shadowUrl: "https://unpkg.com/leaflet@1.5.1/dist/images/marker-shadow.png"
      })
     }


typeSelected: string;
model:any
private today: NgbDate;
masterSelected:boolean;
day:any
checked0:boolean

hoveredDate: NgbDate | null = null;
Frequency = Frequency;
fromDate: NgbDate | null;
toDate: NgbDate | null;
 myCheckbox:boolean
checkedList:any;
a: any[]=[]
resultidservice:any[]=[]
 re:CustomerResearchResultMou3inaList[]=[];
 private destroy$ = new Subject();
  reservations: any;
  recurents:any
  mou3inaId:any;
  collaborationStatus:any;
  status: any;
  currentServiceType!: ServiceType;
  currentStatus!: StatusReservation;
  currentCustomer!:Customer;
  isValidFormSubmitted = false;
  submitted = false;
  interval:any;
  lang:any;
  home_Adress_GPS_latt:any;
  home_Adress_GPS_long:any;
  min = '06:00';
  max = '18:00';

oui:any
rf:FormGroup;
recurringForm: FormGroup;
dates: Date[] = [];
times: Date[] = [];
reccurentes:any[]=[];
  private weekdayMap = [
    RRule.MO,
    RRule.TU,
    RRule.WE,
    RRule.TH,
    RRule.FR,
    RRule.SA,
    RRule.SU
  ];
myCheckbox10:boolean
myCheckbox7:boolean
myCheckbox6:boolean
myCheckbox2:boolean
myCheckbox3:boolean
myCheckbox4:boolean
myCheckbox5:boolean
myCheckbox1:boolean
id:any

myCheckbox0:boolean
minDate = new Date();
get f() { return this.reservationForm.controls; }
optionsDuration=2
optionsDate=this.dates[0]
optionsMonday=[
{name:'morning',value:1,checked:true},
{name:'afternoon',value:2,checked:true},
{name:'evening',value:3,checked:true},
{name:'duration',value:3},
]
optionsFriday=[
{name:'morning',value:1,checked:true},
{name:'afternoon',value:2,checked:true},
{name:'evening',value:3,checked:true},
{name:'duration',value:3},
]
optionsSaturday=[
{name:'morning',value:1,checked:true},
{name:'afternoon',value:2,checked:true},
{name:'evening',value:3,checked:true},
{name:'duration',value:3},
]
optionsThursday=[
{name:'morning',value:1,checked:true},
{name:'afternoon',value:2,checked:true},
{name:'evening',value:3,checked:true},
{name:'duration',value:3},
]

optionsTuesday=[
{name:'morning',value:1,checked:true},
{name:'afternoon',value:2,checked:true},
{name:'evening',value:3,checked:true},
{name:'duration',value:3},
]

optionsWednesday=[
{name:'morning',value:1,checked:true},
{name:'afternoon',value:2,checked:true},
{name:'evening',value:3,checked:true},
{name:'duration',value:3},
 ]

optionsSunday=[
{name:'morning',value:1,checked:true},
{name:'afternoon',value:2,checked:true},
{name:'evening',value:3,checked:true},
{name:'duration',value:3},

]
preferencesMou3ina !: PreferencesMou3ina;

b1:any
research:any
tt:any
arr1: any[] = [];
preferencesCustomer: any[] = [];
listofservicetypesid: any[] = [];
recurrents:any;
recurrentsMonday:any
recurrentsFriday:any
recurrentsSaturday:any
recurrentsThursday:any
recurrentsTuesday:any
recurrentsWednesday:any
recurrentsSunday:any
map:any;
 s!:ServiceType;
 serviceTypess:ServiceType[];
 customers:Customer[];
 isLoading: boolean = false;
 error: string;
 customerC:any
 now: Date = new Date();
 startDate: NgbDate | null;
 endDate: NgbDate | null;
constructor(private ResearchService: ResearchService, private modalService:NgbModal,
private fb: FormBuilder,private CustomersService:CustomersService,  private calendar: NgbCalendar,public formatter: NgbDateParserFormatter,private dataservice: DataserviceService,
private serviceTypeService: ServiceTypeService,private RecurrentService:RecurrentService,private router: Router,
private StatusService :StatusService,private Mou3inapreferenceService:Mou3inapreferenceService,private Mou3inaService:Mou3inaService,private _i18n: I18n,private spinnerService: NgxSpinnerService) {
     this.typeSelected = 'ball-fussion';
  this._i18n=_i18n;
  this.startDate = new NgbDate(this.now.getFullYear(), this.now.getMonth() + 1, 1);
      this.selectThisMonth();

}

  public showSpinner(): void {
    this.spinnerService.show();

    setTimeout(() => {
      this.spinnerService.hide();
    }, 5000); // 5 seconds
  }

 selectThisMonth(): void {
    const year: number = this.now.getFullYear();
    const month: number = this.now.getMonth() + 1;
    const day: number = new Date(year, month, 0).getDate();
    this.endDate = new NgbDate(year, month, day);
  }
    ngOnInit(): void {
    this.today=this.calendar.getToday();
    this.initRecurringForm();
    this.subscribeToFormValue();
    this.reloadData();

      this.interval = setInterval(() => {

this.customerC = sessionStorage.getItem('id');

       this.lang=localStorage.getItem('lang');
       this.home_Adress_GPS_latt=localStorage.getItem('home_Adress_GPS_latt');
       this.home_Adress_GPS_long=localStorage.getItem('home_Adress_GPS_long');
       if(this.lang=='en-US'){
        this._i18n.language= 'en';
       }else if(this.lang=='fr-FR'){
       this._i18n.language= 'fr';
       }else{
       this._i18n.language= 'ar';
       }
         });

    L10n.load({
    'ar-TN': {
      'datepicker': {
          placeholder: "إختر اليوم",
          today: "اليوم",
      }
    },

    'fr': {
          'datepicker': {
              placeholder: "choisir date",
              today: "aujourd'hui"
          },
        },

     'en': {
           'datepicker': {
            placeholder: "chose date",
            today: "today"
             },

          }
   });

let daterangepicker: DateRangePicker = new DateRangePicker({
    keyConfigs: {
    select: "space",
    home: "ctrl+home",
    end: "ctrl+end"
  }
})
daterangepicker.appendTo('#daterangepicker');
   }



    reloadData() {
    this.serviceTypeService.getList().subscribe(data => {
            this.serviceTypess = data;
            //console.log(data)
          });
    this.Mou3inapreferenceService.getAll().subscribe(data => {
                     this.preferencesMou3ina = data;
                    //  console.log(data)
                   });
    this.CustomersService.getCustomersList().subscribe(data => {
                  this.customers = data;
               console.log(data)
                });
      this.serviceTypeService.getList().subscribe(data => {
        this.serviceTypess = data;
        console.log(data)
      });
      this.StatusService.getList().subscribe(data => {
         this.status = data;
       });
      this.RecurrentService.getList().subscribe(data => {
      this.recurrents=data;
       });
      this.ResearchService.getList().subscribe(data => {
        this.reservations = data;
          console.log(data)
      });

       this.Mou3inaService.getAll().subscribe(data => {
              this.mou3inaId = data;
              console.log(this.mou3inaId)
       });
       this.Mou3inaService.getALLCollaborationStatus().subscribe(data => {
                    this.collaborationStatus = data;
                   console.log(this.collaborationStatus)
             });


    }


 da :any;
r:boolean
 reservationForm = new FormGroup({
  desiredDate: new FormControl('', [Validators.required]),
  recurrent:new FormControl(''),
  //recurrents:new FormControl(this.arr1),
  desiredHour: new FormControl('', [Validators.required,Validators.min(6),Validators.max(19)]),
  morning:new FormControl('' ),
  afternoon:new FormControl('' ),
  evening:new FormControl('' ),
  gradeAverage: new FormControl('', [Validators.required]),
  numberOfMou3ina: new FormControl('1', [Validators.required,Validators.min(1),Validators.max(3)]),
  statuscode: new FormControl('', [Validators.required]),
  frequency:new FormControl('' ),
  serviceTypes: new FormControl('', [Validators.required]),
  customers: new FormControl('', [Validators.required]),
 });




onDateSelection(date: NgbDate): void {
  if (!this.f.startDate.value && !this.f.endDate.value) {
    this.f.startDate.setValue(date);
  } else if (this.f.startDate.value && !this.f.endDate.value && date && date.after(this.f.startDate.value)) {
    this.f.endDate.setValue(date);
  }else {
    this.f.endDate.setValue(null);
    this.f.startDate.setValue(date);
  }
}

validateInput(currentValue: NgbDate | null, input: string): NgbDate | null {
  const parsed = this.formatter.parse(input);
  return parsed && this.calendar.isValid(NgbDate.from(parsed)) ? NgbDate.from(parsed) : currentValue;
}
isHovered(date: NgbDate): boolean {
  return this.f.startDate.value &&
    !this.f.endDate.value &&
    this.hoveredDate &&
    date.after(this.f.startDate.value) &&
    date.before(this.hoveredDate);
}
setStartDate(value: string): void {
  this.f.startDate.setValue(this.validateInput(this.f.startDate.value, value));
}
valuu:any
value1:any
setEndDate(value: string): void {
  this.f.endDate.setValue(this.validateInput(this.f.endDate.value, value));
}

isInside(date: NgbDate): boolean {
  return this.f.endDate.value && date.after(this.f.startDate.value) && date.before(this.f.endDate.value);
}

isRange(date: NgbDate): boolean {
  return date.equals(this.f.startDate.value) ||
    (this.f.endDate.value && date.equals(this.f.endDate.value)) ||
    this.isInside(date) || this.isHovered(date);
}

    gotoList() {
      this.router.navigate(['/listresearch']);
    }

    setNewserviceType(serviceTypes: ServiceType): void {
      console.log(serviceTypes);
      this.currentServiceType = serviceTypes;
      console.log(this.currentServiceType)
    }
    setNewstatus(status: StatusReservation): void {
          console.log(status);
          this.currentStatus = status;
        }
     setNewcustomer(customer:Customer):void{
     console.log(customer);
      console.log(customer.home_Adress_GPS_long);
       console.log(customer.home_Adress_GPS_latt);
     this.currentCustomer=customer;
     localStorage.setItem('home_Adress_GPS_latt',customer.home_Adress_GPS_latt.toString());
     localStorage.setItem('home_Adress_GPS_long',customer.home_Adress_GPS_long.toString());
     }
    onReset() {
            this.submitted = false;
            this.reservationForm.reset();
   }
   recurrent:any =false

setRecuurent(): void {

if(this.recurrent == true){
  this.recurrent = false;
}else{
  this.recurrent = true;
}
 }

 initRecurringForm(): void {

  this.dates.forEach(element=>{
    const datepipe:DatePipe=new DatePipe('en-US')
    this.day=datepipe.transform(element,'EEEE')
    this.tt=datepipe.transform(element,'EEEE')
    this.day=datepipe.transform(element,'yyyy-MM-dd')
    console.log(this.day)
     //console.log(this.tt=="Sunday")

    if(this.tt=="Sunday"){

    this.recurrentsSunday=[{

            "morning": this.optionsSunday[0].checked,
            "afternoon":this.optionsSunday[1].checked,
            "evening": this.optionsSunday[2].checked,
            "duration": this.optionsSunday[3].value,
            "recurrentday": this.day
 }]
 //this.da.push(...this.recurrentsSunday.clone());
this.arr1.push(...this.recurrentsSunday)

    }
    //console.log(this.tt=="Monday")
     if(this.tt=="Monday"){
     this.recurrentsMonday=[{
         "duration": this.optionsMonday[3].value,
         "afternoon":this.optionsMonday[1].checked,
         "evening": this.optionsMonday[2].checked,
         "recurrentday": this.day,
         "morning": this.optionsMonday[0].checked}]
         this.arr1.push(...this.recurrentsMonday)

        }

     if(this.tt=="Tuesday"){
     this.recurrentsTuesday=[{
         "duration": this.optionsTuesday[3].value,
         "afternoon":this.optionsTuesday[1].checked,
         "evening": this.optionsTuesday[2].checked,
         "recurrentday": this.day,
         "morning": this.optionsTuesday[0].checked
         }
         ]

    this.arr1.push(...this.recurrentsTuesday)
                }
           if(this.tt=="Wednesday"){
             this.recurrentsWednesday=[{
            "duration": this.optionsWednesday[3].value,
            "afternoon":this.optionsWednesday[1].checked,
            "evening": this.optionsWednesday[2].checked,
            "recurrentday": this.day,
            "morning": this.optionsWednesday[0].checked
             }
                                           ]
       this.arr1.push(...this.recurrentsWednesday)

}
  if(this.tt=="Thursday"){
               this.recurrentsThursday=[{
            "duration": this.optionsThursday[3].value,
            "afternoon":this.optionsThursday[1].checked,
            "evening": this.optionsThursday[2].checked,
            "recurrentday": this.day,
            "morning": this.optionsThursday[0].checked
            }
         ]
         this.arr1.push(...this.recurrentsThursday)

}
  if(this.tt=="Friday"){
         this.recurrentsFriday=[{
            "duration": this.optionsFriday[3].value,
            "afternoon":this.optionsFriday[1].checked,
            "evening": this.optionsFriday[2].checked,
            "recurrentday": this.day,
            "morning": this.optionsFriday[0].checked
          }]

this.arr1.push(...this.recurrentsFriday)
}

  if(this.tt=="Saturday"){
      this.recurrentsSaturday=[{
        "duration": this.optionsSaturday[3].value,
        "afternoon":this.optionsSaturday[1].checked,
        "evening": this.optionsSaturday[2].checked,
        "recurrentday": this.day,
        "morning": this.optionsSaturday[0].checked
         }
      ]
      this.arr1.push(...this.recurrentsSaturday)
      }


    this.research={

            "recurrents":this.arr1,
    }

    });

  this.reservationForm = this.fb.group({
  serviceTypes:[ ],
  customers:[],
  recurrents:this.arr1,
  recurrent:[],
  desiredDate:[],
  desiredHour:[],
  numberOfMou3ina:[],
  statuscode:[],
  gradeAverage:[],
  frequency: [Frequency.DAILY],
  morning:[],
  afternoon:[],
  evening:[],
  startDate: [this.today, Validators.required],
  endDate: [this.calendar.getNext(this.today, 'd', 6), Validators.required],
  onWeekday: this.fb.array(
      [false, false, false, false, false, false, false].map(val => this.fb.control(val))
    ),
    onMonthday: [this.today],
  });

}

 onSubmit() {
 console.log( this.reservationForm.value.customers.location)
    const datepipe:DatePipe=new DatePipe('en-US')
    this.dates.forEach(element=>{
    this.day=datepipe.transform(element,'EEEE')
    this.tt=datepipe.transform(element,'EEEE')
    this.day=datepipe.transform(element,'yyyy-MM-dd')
    console.log(this.day)

    if(this.tt=="Sunday"){
    this.recurrentsSunday=[{
            "morning": this.optionsSunday[0].checked,
            "afternoon":this.optionsSunday[1].checked,
            "evening": this.optionsSunday[2].checked,
            "duration": this.optionsSunday[3].value,
    "recurrentday": this.day
 }]
this.arr1.push(...this.recurrentsSunday)
    }
     if(this.tt=="Monday"){
     this.recurrentsMonday=[{
         "duration": this.optionsMonday[3].value,
         "afternoon":this.optionsMonday[1].checked,
         "evening": this.optionsMonday[2].checked,
         "recurrentday": this.day,
         "morning": this.optionsMonday[0].checked}]
         this.arr1.push(...this.recurrentsMonday)
        }
             if(this.tt=="Tuesday"){
             this.recurrentsTuesday=[{
             "duration": this.optionsTuesday[3].value,
             "afternoon":this.optionsTuesday[1].checked,
             "evening": this.optionsTuesday[2].checked,
             "recurrentday": this.day,
             "morning": this.optionsTuesday[0].checked
             }]

    this.arr1.push(...this.recurrentsTuesday)
                }
            if(this.tt=="Wednesday"){
             this.recurrentsWednesday=[{
             "duration": this.optionsWednesday[3].value,
             "afternoon":this.optionsWednesday[1].checked,
             "evening": this.optionsWednesday[2].checked,
             "recurrentday": this.day,
             "morning": this.optionsWednesday[0].checked
             }]
       this.arr1.push(...this.recurrentsWednesday)

    }
  if(this.tt=="Thursday"){
            this.recurrentsThursday=[{
            "duration": this.optionsThursday[3].value,
            "afternoon":this.optionsThursday[1].checked,
            "evening": this.optionsThursday[2].checked,
            "recurrentday": this.day,
            "morning": this.optionsThursday[0].checked
             }
                                           ]
         this.arr1.push(...this.recurrentsThursday)

}
  if(this.tt=="Friday"){
           this.recurrentsFriday=[{
            "duration": this.optionsFriday[3].value,
            "afternoon":this.optionsFriday[1].checked,
            "evening": this.optionsFriday[2].checked,
            "recurrentday": this.day,
            "morning": this.optionsFriday[0].checked
            }
                                           ]
this.arr1.push(...this.recurrentsFriday)
}

  if(this.tt=="Saturday"){
            this.recurrentsSaturday=[{
            "duration": this.optionsSaturday[3].value,
            "afternoon":this.optionsSaturday[1].checked,
            "evening": this.optionsSaturday[2].checked,
            "recurrentday": this.day,
            "morning": this.optionsSaturday[0].checked
            }
      ]
      this.arr1.push(...this.recurrentsSaturday)
      }

    });
 var b=JSON.stringify(this.arr1);
 var str = b.replace(/\\/g, '');
this.valuu={'reccurents':this.arr1}

  this.isValidFormSubmitted = false;
if(this.recurrent == true){


this.ResearchService.create(this.reservationForm.value).subscribe(data => {
console.log(this.reservationForm.value);
console.log("successWITHrecurrent");
},);
}else{
 var b1=JSON.stringify(this.reservationForm.value.desiredHour);
 var str1 = b.replace(/\\/g, '');
 console.log(this.b1)

this.reservationForm.value.recurrents=[];

this.ResearchService.create(this.reservationForm.value).subscribe(data => {

console.log("successWITH-no-recurrent");


},);
}

this.isValidFormSubmitted = true;
this.submitted = true;
if (this.reservationForm.invalid) {
return;
}
 if(this.isValidFormSubmitted == true|| this.submitted == true){
       /* this.router.navigate(['/listresearch'])
            .then(() => {
              window.location.reload();
            });
*/
console.log( localStorage.getItem('home_Adress_GPS_latt'))
console.log( localStorage.getItem('home_Adress_GPS_long'))
this.reservationForm.value.serviceTypes.forEach(elem =>{
elem.idService;this.resultidservice.push(elem.idService  );
                     console.log(elem.idService )})
   console.log(this.resultidservice )
 this.ResearchService.getlistresult(
 datepipe.transform(this.reservationForm.value.desiredDate,'yyyy-MM-dd'),
 this.reservationForm.value.morning,
 this.reservationForm.value.evening,
 this.reservationForm.value.afternoon,
 this.resultidservice,
 //this.reservationForm.value.customers.home_Adress_GPS_latt,
localStorage.getItem('home_Adress_GPS_latt'),
localStorage.getItem('home_Adress_GPS_long'),
(this.reservationForm.value.numberOfMou3ina*3)

// this.reservationForm.value.customers.home_Adress_GPS_long
).subscribe(data => {
              this.reservations = data;
              console.log(this.reservations)
             //  console.log("favoris",this.reservationForm.value.customers.preferences.id)
             // console.log("limit",(this.reservationForm.value.numberOfMou3ina*2))
              });
          }


 this.spinnerService.show();

    setTimeout(() => {
      this.spinnerService.hide();
    }, 500);


           //alert('SUCCESS!! :-)\n\n'  + JSON.stringify(this.reservationForm.value) );


        }

  private subscribeToFormValue(): void {
  this.reservationForm.valueChanges.pipe(
    takeUntil(this.destroy$)
  ).subscribe((value) => {

    const options: Partial<Options> = {


      freq: value.frequency || Frequency.DAILY,
      dtstart: toNativeDate(value.startDate || this.today),
      until: toNativeDate(value.endDate || this.today),
      byweekday: value.frequency === Frequency.WEEKLY ?
        this.getWeekday(value.onWeekday) : null,
      bymonthday: value.frequency === Frequency.MONTHLY ?
        (value.onMonthday && value.onMonthday.day || this.today.day) : null,


    };



    const rule = new RRule(options);
    this.dates = rule.all();

  });
  this.reservationForm.patchValue({
    desiredHour:this.reservationForm.value.desiredHour,
    recurrents:this.arr1,
    startDate: this.today,
    endDate: this.calendar.getNext(this.today, 'd', 6),
    frequency: Frequency.DAILY,
    desiredDate: [],

  });
}

changeName(id1:number) {
console.log(this.reservationForm.value)
console.log(this.reservationForm.value)
    this.dataservice.changeName(this.reservationForm.value,id1);
      this.router.navigate(['add']);
  }

  DetailMou3ina(id1: number){
        this.Mou3inaService.find(id1);
        this.router.navigate(['detailMou3ina',id1]);
      }

private getWeekday(byWeekday: boolean[]): any {
  const result = byWeekday
    .map((v, i) => v && this.weekdayMap[i] || null)
    .filter(v => !!v);
  return result.length ? result : null;
}
/*
 reservationmodel(id1:number) {
   console.log(id1)
   console.log(this.reservationForm.value)
    this.dialog.open(AddComponent,{
      data: {
        id:id1 ,
        reservationForm:this.reservationForm.value,

      },
    });

    }*/

     ngAfterViewInit(): void {
   var map = L.map('map', {
        center: [localStorage.getItem('home_Adress_GPS_latt'),localStorage.getItem('this.home_Adress_GPS_long') ],
        zoom: 3
      });


           //var map = L.map('map', {zoom: 3 });

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

        });
        //Moving Marker


     // popup on mapclick
    var popup = new L.Popup();

    L.marker([51.0, -0.09]).addTo(map).bindPopup('A pretty CSS3 popup.<br> Easily customizable.'); //Creates a marker at [latitude, longitude] coordinates.

    function onMapClick(e:any) {

    	popup
    		.setLatLng(e.latlng)
    		.setContent("You clicked the map at " + e.latlng.toString());
       /// .openOn(map);

       var marker = new L.Marker(new L.LatLng(e.latlng.lat, e.latlng.lng),{draggable:true},{icon: L.markerIcon});

       marker.addTo(map);

        var marker = new L.Marker(new L.LatLng(localStorage.getItem('home_Adress_GPS_latt'),localStorage.getItem('home_Adress_GPS_long')),{draggable:true},{icon: L.markerIcon});
        marker.addTo(map);
       //.bindPopup("Getting your New Location").openPopup();
       console.log("You clicked the map at latitude: " + e.latlng.lat + " and longitude: " + e.latlng.lng);
       window.alert('getting data successfully!');
       localStorage.setItem('home_Adress_GPS_latt',e.latlng.lat);
       localStorage.setItem('home_Adress_GPS_long',e.latlng.lng);

    }


    map.on('click', onMapClick);

    }



}
