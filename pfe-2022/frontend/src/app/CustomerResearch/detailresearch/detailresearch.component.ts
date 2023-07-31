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
  selector: 'app-detailresearch',
  templateUrl: './detailresearch.component.html',
  styleUrls: ['./detailresearch.component.scss']
})
export class DetailresearchComponent implements OnInit {
 ServiceTypeId!:ServiceType;
 lang:any
recherche:any
id:any
   re:CustomerResearchResultMou3inaList[]=[];
   reservations: CustomerResearch[]=[];
     mou3ina:Mou3ina[]= [ ];
   constructor(private ResearchService: ResearchService,private Http:HttpClient,private route: ActivatedRoute,
       private router: Router,public dialog: MatDialog,private datePipe: DatePipe,private Mou3inaService:Mou3inaService) {

      this.ResearchService.getList().subscribe((data:CustomerResearch[])=>{
            this.reservations=data;
            console.log(this.reservations)
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
 this.id = this.route.snapshot.params['id'];

    this.ResearchService.get(this.id)
      .subscribe(data => {
        this.recherche = data;
          console.log(this.recherche)
      }, error => console.log(error));
}

}
