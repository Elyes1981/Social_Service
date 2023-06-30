import { Component, OnInit } from '@angular/core';
import { Mou3ina } from 'src/app/Model/mou3ina';
import { Gender } from 'src/app/Model/gender';
import { CollaborationStatus } from 'src/app/Model/collaboration-status.model';
import { Status } from 'src/app/Model/statuscus'; 
import { Mou3inaService } from 'src/app/service/mou3ina.service';
import { ServiceType } from 'src/app/Model/service-type.module';
import { ActivatedRoute, Router } from '@angular/router';
import { CollaborationStatusService } from 'src/app/service/collaboration-status.service';
@Component({
  selector: 'app-detailmouiina',
  templateUrl: './detailmouiina.component.html',
  styleUrls: ['./detailmouiina.component.scss']
})

export class DetailmouiinaComponent implements OnInit {
  mou3ina!: Mou3ina;
id:any
 interval:any
  lang:any;
 genders!:Gender[];
 serviceType!: ServiceType [];
  post!: Mou3ina;
  Mou3inas: Mou3ina[] = [];
 collaborationStatus: CollaborationStatus[]=[];
  constructor( public mou3inaService: Mou3inaService,public CollaborationStatusService:CollaborationStatusService,
                  private route: ActivatedRoute) { }

   ngOnInit(): void {
            this.interval = setInterval(() => {
              this.lang=localStorage.getItem('lang'|| 'en-US');
            }, 1);
    this.id = this.route.snapshot.params['id'];
    this.mou3inaService.find(this.id).subscribe((data: Mou3ina)=>{
         this.post = data;
         console.log('Mouina:',data);
       });





}

}
