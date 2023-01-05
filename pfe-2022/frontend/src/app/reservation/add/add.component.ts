import { Component, OnInit ,NgModule,Inject} from '@angular/core';
import { FormControl, FormGroup, Validators, ReactiveFormsModule  } from '@angular/forms';
import {Router} from "@angular/router";
import { FormBuilder } from '@angular/forms'
import { Reservation } from 'src/app/Model/reservation';
import { ServiceType } from 'src/app/Model/service-type.module';
import { StatusReservation }      from 'src/app/Model/status';
import { ReservationService } from "src/app/service/reservation.service";
import { ServiceTypeService } from "src/app/service/service-type.service";
import{ RecurrentService } from "src/app/service/recurrent.service";
import { StatusService } from 'src/app/service/status.service';
import { loadCldr, L10n } from '@syncfusion/ej2-base';
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
import { HttpClient, HttpErrorResponse, HttpEvent, HttpEventType } from '@angular/common/http';

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
  selector: 'app-add',
  templateUrl: './add.component.html',
  styleUrls: ['./add.component.css']
})

export class AddComponent implements OnInit {
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
  reservationForm = new FormGroup({
  desiredDate: new FormControl('', [Validators.required]),
  desiredHour: new FormControl('', [Validators.required]),
  morning:new FormControl('' ),
 // recurrent:new FormControl(''),
  afternoon:new FormControl('' ),
  evening:new FormControl('' ),
  gradeAverage: new FormControl('', [Validators.required]),
  numberOfMou3ina: new FormControl('1', [Validators.required,Validators.min(1),Validators.max(3)]),
  statuscode: new FormControl(''),
  PaymentStatus: new FormControl('', [Validators.required]),
  serviceTypes: new FormControl('', [Validators.required]),
  frequency:new FormControl('' ),
  rate:new FormControl('' ),
  });


 minDate = new Date();


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

constructor(private modalService:NgbModal,private fb: FormBuilder,  private calendar:NgbCalendar,
public formatter: NgbDateParserFormatter,
private RecurrentService:RecurrentService,private ReservationService: ReservationService,
private serviceTypeService: ServiceTypeService,private router: Router,private StatusService :StatusService,private dataservice: DataserviceService) {
this.startDate = new NgbDate(this.now.getFullYear(), this.now.getMonth() + 1, 1);
      this.selectThisMonth();
}
 selectThisMonth(): void {
    const year: number = this.now.getFullYear();
    const month: number = this.now.getMonth() + 1;
    const day: number = new Date(year, month, 0).getDate();
    this.endDate = new NgbDate(year, month, day);
  }
//newName: Reservation[]=[];
  newName!: Reservation;
  id:any
//newName: any[] = [];
  ngOnInit(): void {
 this.dataservice.name.subscribe((data:any)=>{
      this.newName = data;
      console.log( this.newName)
    });
    this.dataservice.id.subscribe((data:any)=>{
    this.id = data;
    console.log( this.id)
     });

   this.today=this.calendar.getToday();
   this.initRecurringForm();
   this.subscribeToFormValue();
   this.reloadData();
   this.interval = setInterval(() => {
   this.lang=localStorage.getItem('lang'|| 'en-US'); }, 1);

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
          }
        },

    'en': {
           'datepicker': {
            placeholder: "chose date",
            today: "tody"
             }
          }
    });
   }

    reloadData() {

      this.serviceTypeService.getList().subscribe(data => {
        this.serviceTypess = data;
      });

      this.StatusService.getList().subscribe(data => {
        this.status = data;
      });

      this.ReservationService.getList().subscribe(data => {
        this.reservations = data;
      });

      this.RecurrentService.getList().subscribe(data => {
         this.recurrents=data;
      });

    }
 compareWithIdFn(c1: any, c2: any) {
      return c1 && c2 ? c1.code === c2.code : c1 === c2;
    }
    save() {
      this.ReservationService.create(this.reservationForm.value).subscribe(data => {
          console.log("success");
        },
        error => console.log(error));
    }


    gotoList() {
      this.router.navigate(['/list']);
    }

    setNewserviceType(serviceTypes: ServiceType): void {
      this.currentServiceType = serviceTypes;
    }
    setNewstatus(status: StatusReservation): void {
          console.log(status);
          this.currentStatus = status;
        }

    onReset() {
            this.submitted = false;
            this.reservationForm.reset();
   }



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



recurrent:any =false


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

 initRecurringForm(): void {
  this.dates.forEach(element=>{
    const datepipe:DatePipe=new DatePipe('en-US')
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


    this.research={

            "recurrents":this.arr1,

    }

    });

  this.reservationForm = this.fb.group({
  serviceTypes:[ ],
  recurrents:this.arr1,
  PaymentStatus:[],
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


  this.dates.forEach(element=>{
    const datepipe:DatePipe=new DatePipe('en-US')
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
 this.ReservationService.addmou3ina(this.id,this.reservationForm.value).subscribe(data => {
console.log("Add Mou3ina no recurent successs");
console.log("successWITHrecurrent");
},);
 /*this.ReservationService.create(this.reservationForm.value).subscribe(data => {

},);*/
}else{
this.reservationForm.value.recurrents=[];
 this.ReservationService.addmou3ina(this.id,this.reservationForm.value).subscribe(data => {
 console.log("Add Mou3ina no recurent successs");
 console.log("successWITH-no-recurrent");
 },);
/* this.ReservationService.create(this.reservationForm.value).subscribe(data => {

},);*/

}

this.isValidFormSubmitted = true;
this.submitted = true;
if (this.reservationForm.invalid) {
return;
}

           if(this.isValidFormSubmitted == true|| this.submitted == true){
        //   alert('SUCCESS!! :-)\n\n' );


           this.router.navigate(['/list'])

           }

                 console.log(" successs Reservation");
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
    recurrents:this.arr1,
    startDate: this.today,
    endDate: this.calendar.getNext(this.today, 'd', 6),
    frequency: Frequency.DAILY,
    desiredDate: [],

  });
}

private getWeekday(byWeekday: boolean[]): any {
  const result = byWeekday
    .map((v, i) => v && this.weekdayMap[i] || null)
    .filter(v => !!v);
  return result.length ? result : null;
}
}
