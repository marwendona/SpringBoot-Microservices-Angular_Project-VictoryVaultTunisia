import { Component, OnInit } from '@angular/core';
import { FormControl, FormGroup, Validators } from '@angular/forms';
import { MatTableDataSource } from '@angular/material/table';
import { Coach } from 'src/app/models/Coach';
import { CoachService } from 'src/app/services/matchServices/coachService/coach.service';

@Component({
  selector: 'app-coach',
  templateUrl: './coach.component.html',
  styleUrls: ['./coach.component.css']
})
export class CoachComponent implements OnInit{
coachForm!: FormGroup;
isSubmitCoachButtonDisabled: boolean=false;
dataCoach!: any;
displayedColumns: string[] = ['firstName', 'lastName','nationality'];
isRowHovered = false;

//declaration not used yet 
  firstNameError: String="";
  nationalityError: String="";
  lastNameError: String="";
//declaration not used yet 

constructor(private coachService:CoachService){}

ngOnInit(): void {
  this.initFormAddAccount();
  this.getCoach();
}

  initFormAddAccount() {
    this.coachForm = new FormGroup({
      firstName: new FormControl('', Validators.required),
      lastName: new FormControl('', Validators.required),
      nationality: new FormControl('', Validators.required)
  });
  }

  addCoach() {
    const coach: Coach = {
      id:1,
      firstName: this.coachForm.value.firstName,
      lastName: this.coachForm.value.lastName,
      nationality: this.coachForm.value.nationality
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
