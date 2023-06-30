import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormControl, FormGroup, Validators } from '@angular/forms';
import { MatDialog } from '@angular/material/dialog';
import { Router } from '@angular/router';
import { ComplainType } from '../Model/complainType';
import { SousTypes } from '../Model/SousTypes';
import { ComplaintypeService } from '../service/complaintype.service';
import { CustomercomplainService } from '../service/customercomplain.service';
import { SoustypesService } from '../service/soustypes.service';
import { TokenStorageService } from '../_services/token-storage.service';

@Component({
  selector: 'app-reclam-customer',
  templateUrl: './reclam-customer.component.html',
  styleUrls: ['./reclam-customer.component.scss']
})
export class ReclamCustomerComponent implements OnInit {
  complains:ComplainType[]=[];
  sousTypes:SousTypes[]=[];
  complainForm!:FormGroup;
  currentUser:any
  complainSelect =  new ComplainType();
  constructor(public dialog: MatDialog, private fb: FormBuilder,private complaintypeservice:ComplaintypeService, private soustypesService: SoustypesService, private customercomplainService:CustomercomplainService,
    private router: Router ,private token:TokenStorageService ) { }
  
 

  ngOnInit(): void {
this.currentUser=this.token.getUser();
    this.complaintypeservice.getcomplains().subscribe(
      (  data:ComplainType[] ) =>this.complains = data
      
    );
    this.soustypesService.getsoustypes().subscribe(
      (  data:SousTypes[] ) =>this.sousTypes = data
      
    );
    
      
      
      this.complainForm = this.fb.group({
        
          
          
             complainDate: new FormControl(''),

             complainType: new FormControl(''),
              sousTypes: new FormControl(''),
              autre: new FormControl(''),
              customer:new FormControl(this.currentUser)
     } )}
  
     selectComplain(comp:any){
      this.complainSelect= comp;
    } 
    submit(){
    
      this.customercomplainService.createCustomerComplain(this.complainForm.value).subscribe(
        (res:any)=>{
          console.log(res.id);
          this.router.navigate(['/list'])
          
        })
}}
