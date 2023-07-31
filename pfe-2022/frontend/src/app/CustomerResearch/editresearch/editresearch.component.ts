import {AfterViewInit, Component, OnInit, ViewChild } from '@angular/core';
import {Observable} from "rxjs";
import {Router} from "@angular/router";

import { Mou3inaService } from 'src/app/service/mou3ina.service';
import { CustomerResearch } from 'src/app/Model/customer-research';
import { Mou3ina } from 'src/app/Model/mou3ina';
import { ServiceType } from 'src/app/Model/service-type.module';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { ResearchService } from "src/app/service/research.service";
import { MatTableDataSource} from '@angular/material/table';
import { FormControl, Validators} from '@angular/forms';
import { MatSortModule } from '@angular/material/sort';
import { MatTableModule } from '@angular/material/table';
import { AddresearchComponent } from 'src/app/CustomerResearch/addresearch/addresearch.component';
import { DeleteModalComponent } from 'src/app/reservation/delete-modal/delete-modal.component';
import { MatPaginator } from '@angular/material/paginator';
import {LiveAnnouncer} from '@angular/cdk/a11y';
import {MatSort, Sort} from '@angular/material/sort';
import { DatePipe } from '@angular/common'
import {MatDialog} from '@angular/material/dialog';
import { Pipe, PipeTransform } from '@angular/core';
import {NgbActiveModal, NgbModal} from '@ng-bootstrap/ng-bootstrap';
import {ActivatedRoute} from "@angular/router";
import{CustomerResearchResultMou3inaList} from 'src/app/Model/customer-research-result-mou3ina-list';
@Component({
  selector: 'app-editresearch',
  templateUrl: './editresearch.component.html',
  styleUrls: ['./editresearch.component.scss']
})
export class EditresearchComponent implements OnInit {
 serviceTypes!:ServiceType;
 lang:any
 interval:any
recherche:CustomerResearch;

id:any
   re:CustomerResearchResultMou3inaList[]=[];
   reches: CustomerResearch;
   recherches: CustomerResearch[]=[];
     mou3ina:Mou3ina[]= [ ];
   constructor(private ResearchService: ResearchService,private Http:HttpClient,private route: ActivatedRoute,
       private router: Router,public dialog: MatDialog,private datePipe: DatePipe,private Mou3inaService:Mou3inaService) {

 }
 reloadData(){
      this.ResearchService.getList().subscribe((data:CustomerResearch[])=>{
            this.recherches=data;
            console.log(this.recherches)
      })

      this.Mou3inaService.getAll().subscribe(data => {
                     this.mou3ina = data;
                     console.log(this.mou3ina)
      });

      this.ResearchService.getlistresearchmou3ina().subscribe(data => {
                   this.re = data;
                    console.log(this.re)
             });

 }
 ngOnInit(): void {
  this.reloadData();
          this.interval = setInterval(() => {
            this.lang=localStorage.getItem('lang'|| 'en-US');
          }, 1);
 this.id = this.route.snapshot.params['id'];

    this.ResearchService.get(this.id)
      .subscribe(data => {
         this.recherche = data;
          console.log(this.recherche)
      }, error => console.log(error));
}}
