import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup } from '@angular/forms';
import { Router } from '@angular/router';
import { ComplainType } from '../Model/complainType';
import { CustomerComplain } from '../Model/customerComplain';
import { SousTypes } from '../Model/SousTypes';
import { ComplaintypeService } from '../service/complaintype.service';
import { CustomercomplainService } from '../service/customercomplain.service';
import { SoustypesService } from '../service/soustypes.service';
import { TokenStorageService } from '../_services/token-storage.service';

@Component({
  selector: 'app-complainlist',
  templateUrl: './complainlist.component.html',
  styleUrls: ['./complainlist.component.scss']
})
export class ComplainlistComponent implements OnInit {
  ALlcomplains:any
  complains:ComplainType[]=[];
  sousTypes:SousTypes[]=[];
  complainForm!:FormGroup;
  souTypeFrom:FormGroup;
  complainSelect =  new ComplainType();
  CategoryForm!:FormGroup
  data:CustomerComplain
  complain:any
  log = 0;
  showLog = false;
CategorySubCategory:any;
currentUser:any;
term: string;
idComplain:any
  constructor( 
    private httpClient:HttpClient, 
    private router: Router,
   
    private fb: FormBuilder,
    private complaintypeservice:ComplaintypeService,
    private CustomerComplains :CustomercomplainService,
     private soustypesService: SoustypesService,
     private category:ComplaintypeService,
     private token:TokenStorageService) { }

  onShowLog(){
    this.showLog = true;
   }

  ngOnInit(): void {
    this.currentUser = this.token.getUser();

    this.ALlcomplains= this.CustomerComplains.getComplainList().subscribe((data:any)=>{
      this.ALlcomplains=data

    })
    this.complaintypeservice.getcomplains().subscribe(
      (  data:any) =>{this.complains = data 
        console.log(this.complains)
      }
     
      
      
    );
    this.soustypesService.getsoustypes().subscribe(
      (  data:SousTypes[] ) =>this.sousTypes = data
      
    );
   
     
      
     
    
    }
  
  
  
    checked:boolean
   
  
    closeResult: string = '';
    
   

   
httpOptions:any
params:any
onSend(emailAdress:String){
  this.httpOptions = {
    headers: new HttpHeaders({
      'Content-Type': 'application/json'
    }),
    params:({'email':emailAdress})
  }
  this.httpClient.post('http://localhost:8081/api/test/sendemail/',{},this.httpOptions).subscribe(data => {
  });
}

/*onAjouter(id:any,data :CustomerComplain,content:any){
  this.data=data
  this.idComplain=id

//console.log(this.data.autres)
    this.modalService.open(content,{ ariaLabelledBy: 'modal-basic-title',centered:true, windowClass : "myCustomModalClass"}).result.then((result) => {

  
      this.closeResult = `Closed with: ${result}`;
    }, (reason) => {
      this.closeResult = `Dismissed ${this.getDismissReason(reason)}`;
    });
}*/
}
