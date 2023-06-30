import { Component, OnInit } from '@angular/core';
import {Router,ActivatedRoute} from "@angular/router";
import { Reservation } from 'src/app/Model/reservation';
import { StatusReservation }      from 'src/app/Model/status';
import { ServiceType } from 'src/app/Model/service-type.module';
import { ReservationService } from "src/app/service/reservation.service";
import { ServiceTypeService } from "src/app/service/service-type.service";
import { FormControl, FormGroup, Validators } from '@angular/forms';
import { Time } from '@angular/common';
import { StatusService } from 'src/app/service/status.service';
import { loadCldr, L10n } from '@syncfusion/ej2-base';
import {MatStepperModule} from '@angular/material/stepper';
import { TranslateLoader, TranslateModule } from '@ngx-translate/core';


import{ RecurrentService } from "src/app/service/recurrent.service";
import {NgbCalendar, NgbDate, NgbDateParserFormatter,NgbDatepicker} from '@ng-bootstrap/ng-bootstrap';
import { DateRangePicker } from '@syncfusion/ej2-calendars';
import {ThemePalette} from '@angular/material/core';
import {Frequency, Options, RRule} from 'rrule';
import {Subject} from 'rxjs';
import {takeUntil} from 'rxjs/operators';
import { CustomDatepickerI18nService, I18n } from 'src/app/service/custom-datepicker-i18n-service';
import {NgbDatepickerI18n,NgbDateStruct,NgbModal} from '@ng-bootstrap/ng-bootstrap';
import { DatePickerComponent } from "@syncfusion/ej2-angular-calendars";
import { DateFilterFn } from '@angular/material/datepicker';
import{ DatePipe } from'@angular/common';


import { DataserviceService } from 'src/app/service/dataservice.service';

export function toNativeDate(ngbDate: NgbDate): Date {
  return new Date(Date.UTC(ngbDate.year, ngbDate.month - 1, ngbDate.day));
}
declare var require: any;

loadCldr(
require('cldr-data/supplemental/numberingSystems.json'),
require('cldr-data/main/ar/ca-gregorian.json'),
require('cldr-data/main/ar/timeZoneNames.json'),
require('cldr-data/main/ar/numbers.json'),

require('cldr-data/main/ar-TN/ca-gregorian.json'),
require('cldr-data/main/ar-TN/numbers.json'),
require('cldr-data/main/ar-TN/timeZoneNames.json'),
require('cldr-data/main/ar-TN/dateFields.json'),

require('cldr-data/supplemental/weekdata.json'),
require('cldr-data/main/fr/ca-gregorian.json'),
require('cldr-data/main/fr/timeZoneNames.json'),
require('cldr-data/main/fr/numbers.json'),
require('cldr-data/supplemental/weekdata.json') // To load the culture based first day of week
);
@Component({
  selector: 'app-edit',
  templateUrl: './edit.component.html',
  styleUrls: ['./edit.component.css']
})

export class EditComponent implements OnInit {


model:any
serviceTypeId: any;
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
 private destroy$ = new Subject();
  reservations: any;
  serviceTypess: any;
  status: any;

  currentServiceType!: ServiceType;
  currentStatus!: StatusReservation;
  isValidFormSubmitted = false;
  submitted = false;
  interval:any;
  lang:any;
  min = '06:00';
  max = '18:00';
recurringForm: FormGroup;
dates: Date[] = [];

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
research:any
tt:any
arr1: any[] = [];
recurrents:any;
recurrentsMonday:any
recurrentsFriday:any
recurrentsSaturday:any
recurrentsThursday:any
recurrentsTuesday:any
recurrentsWednesday:any
recurrentsSunday:any
isLoading: boolean = false;
error: string;
now: Date = new Date();
startDate: NgbDate | null;
endDate: NgbDate | null;
name: string;

myCheckbox0:boolean

recurrent:any =true

setRecuurent(): void {

if(this.recurrent == true){
  this.recurrent = false;
}else{
  this.recurrent = true;
}

 if(this.recurrent== true){
console.log("HH")
 }else{
 console.log("hoh")
 console.log( this.reservationForm.value)

 }
 }
  id: any;


  currentServiceTypes!: ServiceType[];
  reservationForm!: FormGroup;
  reservation!: Reservation;
  constructor(  private calendar:NgbCalendar,
              public formatter: NgbDateParserFormatter,
              private RecurrentService:RecurrentService,private ReservationService: ReservationService,private route: ActivatedRoute,private serviceTypeService: ServiceTypeService,
  private StatusService :StatusService, private router: Router) {  }
   minDate = new Date();
   ngOnInit(): void {
    L10n.load({
       'ar': {
         'datepicker': {
             placeholder: "اختر تاريخا",
             today: "اليوم"
         }
       },
        'ar-TN': {
             'datepicker': {
                 placeholder: "اختر تاريخا",
                 today: "اليوم",


             }
           },
       'fr': {
             'datepicker': {
                 placeholder: "choisir date",
                 today: "aujourd'hui"
             }
           },
            'en': {
                     'datepicker': {
                         placeholder: "chose date",
                         today: "tody"
                     }
                   }
     });
   this.reloadData();
   this.interval = setInterval(() => {
   this.lang=localStorage.getItem('lang'|| 'en-US');
   }, 1);
   }


get f() { return this.reservationForm.controls; }

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


onDateSelection(date: NgbDate): void {

  if (!this.f.startDate.value && !this.f.endDate.value) {
    this.f.startDate.setValue(date);
  }
  else if (this.f.startDate.value && !this.f.endDate.value && date && date.after(this.f.startDate.value)) {
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

   reloadData() {
    this.id = this.route.snapshot.params['id'];
    this.serviceTypeService.getList().subscribe((data:ServiceType[]) => {
    this.serviceTypess = data;
    });
    this.StatusService.getList().subscribe(data => {
           this.status = data;
        });
    this.ReservationService.get(this.id).subscribe(( data:Reservation  ) => {
    this.reservation = data;
    });

  this.reservationForm = new FormGroup({
  desiredDate: new FormControl('', [Validators.required]),
  gradeAverage: new FormControl('', [Validators.required]),
  numberOfMou3ina: new FormControl('', [Validators.required]),
  statuscode: new FormControl('', [Validators.required]),
  paymentStatus: new FormControl('', [Validators.required]),
  desiredHour:  new FormControl('', [Validators.required]),
  serviceTypes: new FormControl('', [Validators.required]),
  morning:new FormControl('' ),
  afternoon:new FormControl('' ),
  evening:new FormControl('' ),
  recurrent:new FormControl('' ),
  frequency:new FormControl('' ),
  //rate: new FormControl(''),
  });

  }
  compareWithIdFn(c1: any, c2: any) {
      return c1 && c2 ? c1.idService === c2.idService : c1 === c2;
    }

  rangeFilter(date: Date): boolean {

    let currentDate: Date = new Date();
    let includeDatesWithinNextTwentyDays: boolean = date.valueOf() < (currentDate.valueOf() + 20*60*60*1000*24);
    return includeDatesWithinNextTwentyDays;
  }

   setNewType(serviceTypes: ServiceType[]): void {
    console.log(serviceTypes);
    this.currentServiceTypes = serviceTypes;
  }




   setNewStatus(NewStatus: StatusReservation): void {
    console.log(NewStatus);
    this.currentStatus = NewStatus;
  }
  onSubmit(){
    console.log(this.reservationForm.value);
    this.ReservationService.update(this.id, this.reservationForm.value).subscribe((res:any) => {
         console.log('Reservation updated successfully!');
         this.router.navigateByUrl('list');
    })
  }

}
