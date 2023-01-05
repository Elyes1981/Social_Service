import { Component, OnInit ,Injectable} from '@angular/core';
import {FormBuilder, FormControl, FormGroup, Validators} from '@angular/forms';
import {NgbCalendar, NgbDate, NgbDateParserFormatter} from '@ng-bootstrap/ng-bootstrap';
import {Frequency, Options, RRule} from 'rrule';
import {Subject} from 'rxjs';
import{DatePipe} from'@angular/common';
import {takeUntil} from 'rxjs/operators';
import {Router} from "@angular/router";
import { DateType } from 'ngx-hijri-gregorian-datepicker';
import {NgbDatepickerI18n, NgbDateStruct} from '@ng-bootstrap/ng-bootstrap';
import { CustomDatepickerI18nService, I18n } from 'src/app/service/custom-datepicker-i18n-service';
import { RecurrentService } from 'src/app/service/recurrent.service';


import { ServiceTypeService } from "src/app/service/service-type.service";
import { Mou3inaService } from 'src/app/service/mou3ina.service';
import { StatusService } from 'src/app/service/status.service';

import { ResearchService } from "src/app/service/research.service";
import{CustomerResearchResultMou3inaList} from 'src/app/Model/customer-research-result-mou3ina-list';
import { ServiceType } from 'src/app/Model/service-type.module';
import { Reservation } from 'src/app/Model/reservation';
import { StatusReservation }      from 'src/app/Model/status';
import { Mou3ina } from 'src/app/Model/mou3ina';


export function toNativeDate(ngbDate: NgbDate): Date {
  return new Date(Date.UTC(ngbDate.year, ngbDate.month - 1, ngbDate.day));
}

@Component({
  selector: 'app-reccurente',
  templateUrl: './reccurente.component.html',
  styleUrls: ['./reccurente.component.scss'],
  providers: [I18n,{provide: NgbDatepickerI18n, useClass: CustomDatepickerI18nService}]


})
export class ReccurenteComponent implements OnInit {
model:any
day:any
interval:any
lang:any;
myb:boolean
myCheckbox:boolean
myCheckbox0:boolean
myCheckbox6:boolean
myCheckbox2:boolean
myCheckbox3:boolean
myCheckbox4:boolean
myCheckbox5:boolean
myCheckbox1:boolean
Frequency = Frequency;
reservationForm: FormGroup;
selectedDateType  =  DateType.Hijri;
hoveredDate: NgbDate | null = null;




  reservations: any;
  serviceTypes: any;

  status: any;
  currentServiceType!: ServiceType;
  currentStatus!: StatusReservation;
    min = '06:00';
    max = '18:00';
  isValidFormSubmitted = false;
  submitted = false;
    dates: Date[] = [];
    reccurentes:any[]=[];
    private today: NgbDate;
    private weekdayMap = [
      RRule.MO,
      RRule.TU,
      RRule.WE,
      RRule.TH,
      RRule.FR,
      RRule.SA,
      RRule.SU
    ];
    private destroy$ = new Subject();
 minDate = new Date();


  constructor ( public fb: FormBuilder,private calendar: NgbCalendar,private _i18n: I18n,private ResearchService:ResearchService,
  public formatter: NgbDateParserFormatter,
  private ServiceTypeService:ServiceTypeService,
  private StatusService:StatusService, private router:Router,private RecurrentService:RecurrentService) {
  this._i18n=_i18n}


  ngOnInit(): void {
//  this.optionsSunday;
  this.today=this.calendar.getToday();
  this.initRecurringForm();

  this.subscribeToFormValue();
  this.interval = setInterval(() => {
   this.lang=localStorage.getItem('lang');
   if(this.lang=='en-US'){
    this._i18n.language= 'en';
   }else if(this.lang=='fr-FR'){
   this._i18n.language= 'fr';
   }else{
   this._i18n.language= 'ar';
   }
     });
  }


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
isHovered(date: NgbDate): boolean {
  return this.f.startDate.value &&
    !this.f.endDate.value &&
    this.hoveredDate &&
    date.after(this.f.startDate.value) &&
    date.before(this.hoveredDate);
}

isInside(date: NgbDate): boolean {
  return this.f.endDate.value && date.after(this.f.startDate.value) && date.before(this.f.endDate.value);
}

isRange(date: NgbDate): boolean {
  return date.equals(this.f.startDate.value) ||
    (this.f.endDate.value && date.equals(this.f.endDate.value)) ||
    this.isInside(date) || this.isHovered(date);
}

validateInput(currentValue: NgbDate | null, input: string): NgbDate | null {
  const parsed = this.formatter.parse(input);
  return parsed && this.calendar.isValid(NgbDate.from(parsed)) ? NgbDate.from(parsed) : currentValue;
}
availibility :any;
data:any
setStartDate(value: string): void {
  this.f.startDate.setValue(this.validateInput(this.f.startDate.value, value));
}

setEndDate(value: string): void {
  this.f.endDate.setValue(this.validateInput(this.f.endDate.value, value));
}

private initRecurringForm(): void {

  this.reservationForm = this.fb.group({
    startDate: [this.today, Validators.required],
    endDate: [this.calendar.getNext(this.today, 'd', 7), Validators.required],
    frequency: [Frequency.DAILY],
    onWeekday: this.fb.array(
      [false, false, false, false, false, false, false].map(val => this.fb.control(val))
    ),
    onMonthday: [this.today]
  });
}

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

arr1: any[] = [];
recurrents:any
recurrentsSunday:any
recurrentsMonday:any
recurrentsFriday:any
recurrentsSaturday:any
recurrentsThursday:any
recurrentsTuesday:any
recurrentsWednesday:any
rSunday:any
resu: any[] = [];
research:any
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
        (value.onMonthday && value.onMonthday.day || this.today.day) : null
    };
    //console.log('options', options);


    const rule = new RRule(options);
    this.dates = rule.all();
    //console.log(this.dates);

  });
this.arr1 = [];


  this.reservationForm.patchValue({
    startDate: this.today,
    endDate: this.calendar.getNext(this.today, 'd', 7),
    frequency: Frequency.DAILY
  });
}
  tt:any

private getWeekday(byWeekday: boolean[]): any {
  const result = byWeekday
    .map((v, i) => v && this.weekdayMap[i] || null)
    .filter(v => !!v);
  return result.length ? result : null;
}
  get f(): any {
    return this.reservationForm.controls;
  }

 test() {
  this.dates.forEach(element=>{
    const datepipe:DatePipe=new DatePipe('en-US')
    this.day=datepipe.transform(element,'EEEE')
    this.tt=datepipe.transform(element,'EEEE')
     this.day=datepipe.transform(element,'yyyy-MM-dd')
   // console.log(this.day)
     //console.log(this.tt=="Sunday")

    if(this.tt=="Sunday"){
 //console.log(this.fu)
    this.recurrentsSunday=[{

            "morning": this.optionsSunday[0].checked,
            "afternoon":this.optionsSunday[1].checked,
            "evening": this.optionsSunday[2].checked,
            "duration": this.optionsSunday[3].value,
            "recurrentday": this.day,
 }]
this.arr1.push(...this.recurrentsSunday)
  //console.log(this.recurrentsSunday)
   //this.RecurrentService.create(this.Sunday).subscribe(data => {
         //console.log(this.Sunday)
         //console.log("success1Sunday");
        //},);
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



    });



    this.research={

            "recurrents":this.arr1,

    }

this.RecurrentService.create(this.research).subscribe(data => {
         console.log(this.research)
         console.log("success1Sunday");
        },);

    }
    /*
     save() {

        console.log(this.reservationForm.value)
          this.ResearchService.create(this.reservationForm.value).subscribe(data => {
              console.log("success");
            },
            error => console.log(error));
        }
*/
     gotoList() {
      this.router.navigate(['/listresearch']);
    }

}


