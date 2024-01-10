import { Component, OnInit } from '@angular/core';
import { FormControl, FormGroup, Validators } from '@angular/forms';
import { MatTableDataSource } from '@angular/material/table';
import { Coach } from 'src/app/models/Coach';
import { CoachService } from 'src/app/services/matchServices/coachService/coach.service';
import Swal from 'sweetalert2';

@Component({
  selector: 'app-coach',
  templateUrl: './coach.component.html',
  styleUrls: ['./coach.component.css']
})
export class CoachComponent implements OnInit{

coachFormAdd!: FormGroup;
coachFormEdit!: FormGroup;

isSubmitCoachButtonDisabled: boolean=false;
dataCoach!: any;
displayedColumns: string[] = ['firstName', 'lastName','nationality','action'];
isRowHovered = false;

//declaration not used yet 
  firstNameError: String="";
  nationalityError: String="";
  lastNameError: String="";
//declaration not used yet 

constructor(private coachService:CoachService){}

ngOnInit(): void {
  this.initFormAddAccount();
  this.initFormEditCoach();
  this.getCoach();
}
  
addCoach() {
  const coach: Coach = {
    id:1,
    firstName: this.coachFormAdd.value.firstName,
    lastName: this.coachFormAdd.value.lastName,
    nationality: this.coachFormAdd.value.nationality
  };
  console.log(coach)
  this.coachService.addCoach(coach).subscribe(()=>{
    this.isSubmitCoachButtonDisabled=true;
    window.location.reload();
  })}

getCoach(){
  this.coachService.getCoach().subscribe(coachs => {
    this.dataCoach = new MatTableDataSource<Coach>(coachs);
    this.dataCoach = this.dataCoach._data.value.content
  })
}  
  initFormAddAccount() {
    this.coachFormAdd = new FormGroup({
      firstName: new FormControl('', Validators.required),
      lastName: new FormControl('', Validators.required),
      nationality: new FormControl('', Validators.required)
  });
  }

  initFormEditCoach() {
    this.coachFormEdit = new FormGroup({
      id: new FormControl('', Validators.required), 
      firstNameEdit: new FormControl('', Validators.required), // Match the form control name in HTML
      lastNameEdit: new FormControl('', Validators.required),
      nationalityEdit: new FormControl('', Validators.required),
    });
  }
  
  LoadInfoCoach(coach: any) {
    this.coachFormEdit.patchValue({
      id:coach.id,
      firstNameEdit: coach.firstName,
      lastNameEdit: coach.lastName,
      nationalityEdit: coach.nationality,
    });
  }
  

  EditCoach() {
    console.log(this.coachFormEdit.value , this.coachFormEdit.value.id)
    const coach: Coach = {
      id: 0,
      firstName: this.coachFormEdit.value.firstNameEdit,
      lastName: this.coachFormEdit.value.lastNameEdit,
      nationality: this.coachFormEdit.value.nationalityEdit,
    };
  
    this.coachService.editCoach(coach,this.coachFormEdit.value.id).subscribe(()=>{
      console.log("player changed successfuly")
      window.location.reload();
    })
  }
  confirmDelete(playerId:number): void {
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
        this.deleteFunction(playerId);
      }
    });
  }
  deleteFunction(coachId:number): void {
    this.coachService.deleteCoach(coachId).subscribe(()=>{
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

  applyFilter(event: Event) { 
    const filterValue = (event.target as HTMLInputElement).value;
    this.dataCoach.filter = filterValue.trim().toLowerCase();
  }



// configuration table
  onRowHover(hovered: boolean) {
    this.isRowHovered = hovered;
  }
  onRowClick(row: any){
    console.log(row.id)
  }
}
