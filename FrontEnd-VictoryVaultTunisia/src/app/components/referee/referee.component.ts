import { Component, OnInit } from '@angular/core';
import { FormControl, FormGroup, Validators } from '@angular/forms';
import { MatTableDataSource } from '@angular/material/table';
import { Referee } from 'src/app/models/Referee';
import { RefereeService } from 'src/app/services/matchServices/refereeService/referee.service';
import Swal from 'sweetalert2';

@Component({
  selector: 'app-referee',
  templateUrl: './referee.component.html',
  styleUrls: ['./referee.component.css']
})
export class RefereeComponent implements OnInit{
  displayedColumns: string[] = ['firstName', 'lastName','nationality','action'];
  dataReferee: any;
  refereeFormEdit!: FormGroup<any>;
  refereeFormAdd!: FormGroup<any>;
  isRowHovered = false;

  constructor(private refereeService:RefereeService) {}

  ngOnInit(): void {
    this.initFormAddReferee();
    this.initFormEditReferee();
    this.getReferee();
  }

  initFormAddReferee() {
    this.refereeFormAdd = new FormGroup({
      firstName: new FormControl('', Validators.required),
      lastName: new FormControl('', Validators.required),
      nationality: new FormControl('', Validators.required)
  });
  }

  initFormEditReferee() {
    this.refereeFormEdit = new FormGroup({
      id: new FormControl('', Validators.required), 
      firstNameEdit: new FormControl('', Validators.required), // Match the form control name in HTML
      lastNameEdit: new FormControl('', Validators.required),
      nationalityEdit: new FormControl('', Validators.required),
    });
  }

  getReferee(){
    this.refereeService.getReferee().subscribe(referee => {
      this.dataReferee = referee.content;
      this.dataReferee = this.dataReferee._data.value.content
    })
  }
  
  LoadInfoReferee(coach: any) {
    this.refereeFormEdit.patchValue({
      id:coach.id,
      firstNameEdit: coach.firstName,
      lastNameEdit: coach.lastName,
      nationalityEdit: coach.nationality,
    });
  }
  
  EditReferee() {
    console.log(this.refereeFormEdit.value , this.refereeFormEdit.value.id)
    const referee: Referee = {
      id: 0,
      firstName: this.refereeFormEdit.value.firstNameEdit,
      lastName: this.refereeFormEdit.value.lastNameEdit,
      nationality: this.refereeFormEdit.value.nationalityEdit,
    };
  
    this.refereeService.editReferee(referee,this.refereeFormEdit.value.id).subscribe(()=>{
      console.log("player changed successfuly")
      window.location.reload();
    })
  }
  confirmDelete(refereeId:number): void {
    Swal.fire({
      title: 'Are you sure?',
      text: 'You won\'t be able to revert this!',
      icon: 'warning',
      showCancelButton: true,
      confirmButtonColor: '#d51d1d',
      cancelButtonColor: '#3085d6',
      confirmButtonText: 'Yes, delete it!'
    }).then((result) => {
      if (result.isConfirmed) {
        // Call your delete function here
        this.deleteFunction(refereeId);
      }
    });
  }
  deleteFunction(refereeId:number): void {
    this.refereeService.deleteReferee(refereeId).subscribe(()=>{
      Swal.fire({
        title: 'Deleted!',
        text: 'Your file has been deleted.',
        icon: 'success'
      }).then((result) => {
        if (result.isConfirmed) {
          window.location.reload();
        }
      });
    
  
    })
   
  }




addReferee() {
  const referee: Referee = {
    id:null,
    firstName: this.refereeFormAdd.value.firstName,
    lastName: this.refereeFormAdd.value.lastName,
    nationality: this.refereeFormAdd.value.nationality
  };
  console.log(referee)
  this.refereeService.addReferee(referee).subscribe(()=>{
    window.location.reload();
  })}


// configuration table
onRowHover(hovered: boolean) {
  this.isRowHovered = hovered;
}
onRowClick(row: any){
  console.log(row.id)
}




}
