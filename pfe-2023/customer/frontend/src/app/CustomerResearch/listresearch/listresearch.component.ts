import {AfterViewInit, Component, OnInit, ViewChild } from '@angular/core';
import {Observable} from "rxjs";
import {Router} from "@angular/router";
import { EditresearchComponent } from 'src/app/CustomerResearch/editresearch/editresearch.component';
import { ServiceTypeService } from 'src/app/service/service-type.service';
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
import{CustomerResearchResultMou3inaList} from 'src/app/Model/customer-research-result-mou3ina-list';
const ELEMENT_DATA: CustomerResearch[] = [ ];
@Component({
  selector: 'app-listresearch',
  templateUrl: './listresearch.component.html',
  styleUrls: ['./listresearch.component.scss']
})
export class ListresearchComponent implements OnInit {

 date=new Date();
 d=new Date();
   lang:any;
   service!:string;
   interval: any;
   ServiceTypeId!:ServiceType;
   ServiceTypes:ServiceType[]=[];
   reservations: CustomerResearch[]=[];
   re:CustomerResearchResultMou3inaList[]=[];
   filterValues= [] as  any;
   filterSelectObj = [] as  any;
  mou3ina:Mou3ina[]= [ ];
  showAdminBoard = false;
   displayedColumns:string[] = ['DesiredDate','recurrent','DesiredHour',
   'GradeAverage','NumberOfMou3ina','Status','star'];
   displayedColumnsar:string[] = ['star','DesiredDate','DesiredHour',
   'GradeAverage','NumberOfMou3ina','Status'];
   dataSource!: MatTableDataSource<CustomerResearch>;

   @ViewChild(MatPaginator) paginator!: MatPaginator;
   @ViewChild(MatSort) sort!: MatSort;

    constructor(private _liveAnnouncer: LiveAnnouncer,private ResearchService: ResearchService,private Http:HttpClient,
     private router: Router,public dialog: MatDialog,private datePipe: DatePipe,private ServiceTypeService:ServiceTypeService,
     private Mou3inaService:Mou3inaService) {
    this.ResearchService.getList().subscribe((data:CustomerResearch[])=>{
          this.reservations=data;
          console.log(this.reservations)
        })
        this.ServiceTypeService.getList().subscribe((data: ServiceType[])=>{
          this.ServiceTypes = data;
          console.log(this.ServiceTypes);
          }  );
      this.Mou3inaService.getAll().subscribe(data => {
                   this.mou3ina = data;
                   console.log(this.mou3ina)
            });
            /*
      this.ResearchService.getlistresult().subscribe(data => {
       this.reservations = data;
       console.log(this.reservations)
       });*/
      this.ResearchService.getlistresearchmou3ina().subscribe(data => {
                 this.re = data;
                  console.log(this.re)
           });
       }
       ngAfterViewInit() {
         this.dataSource.paginator = this.paginator;
         this.dataSource.sort = this.sort;
       }

     ngOnInit() {
       this.reloadData();
         this.interval = setInterval(() => {
           this.lang=localStorage.getItem('lang'|| 'en-US');
         }, 1);
      const datepipe:DatePipe =new DatePipe('en-US');

       this.dataSource = new MatTableDataSource<CustomerResearch>(this.reservations)
       this.reloadData();

     }

     reloadData() {
       let resp = this.ResearchService.getList();
       resp.subscribe(report =>this.dataSource.data = report as CustomerResearch[])

       this.ResearchService.getList().subscribe((data:CustomerResearch[])=>{
         this.reservations=data;
         console.log(this.reservations)
       })
     }

   deletemodel(id1:number) {
    console.log(id1)
     this.dialog.open(DeleteModalComponent,{
       data: {
         id:id1 ,
       },
     });
   }



   applyFiltertime(event: Event) {
         const filterValue = (event.target as HTMLInputElement).value;
         this.dataSource.filter = filterValue.trim().toLowerCase();
       }




     detail(id: number){
       this.router.navigate(['detailresearch', id]);
      }
     edit(id: number){
     this.router.navigate(['editresearch', id]);
      }

      add() {
      this.router.navigate(['addresearch']);
        }



     filterChange(filter:any, event: Event) {
      const filterValue = (event.target as HTMLInputElement).value;
       this.dataSource.filter = filterValue;
      }

     announceSortChange(sortState: Sort) {
      if (sortState.direction) {
       this._liveAnnouncer.announce(`Sorted ${sortState.direction}ending`);
      } else {
       this._liveAnnouncer.announce('Sorting cleared');
      }
     }

     refresh(): void {
      this.reloadData();
     }

}
