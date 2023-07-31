import { Component, Inject, OnInit } from '@angular/core';
import { FormBuilder, FormControl, FormGroup, Validators } from '@angular/forms';
import { MatDialogRef, MAT_DIALOG_DATA } from '@angular/material/dialog';
import { Customer } from '../Model/customer.model';

@Component({
  selector: 'app-mat-confirm-dialog',
  templateUrl: './mat-confirm-dialog.component.html',
  styleUrls: ['./mat-confirm-dialog.component.scss']
})
export class MatConfirmDialogComponent implements OnInit {

  customerForm!:FormGroup;
  customer!:Customer;
  constructor(public dialogConf: MatDialogRef<MatConfirmDialogComponent>, @Inject(MAT_DIALOG_DATA) public data:any,
  private fb:FormBuilder
   ) { }

  ngOnInit(): void {
    this.customerForm = this.fb.group({
   
      cooptedById: new FormControl('', [Validators.required]),});
  }

}
