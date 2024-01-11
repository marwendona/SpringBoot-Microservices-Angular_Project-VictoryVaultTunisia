import { HttpClient } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';
import { FormControl, FormGroup, Validators } from '@angular/forms';
import { Stadium } from 'src/app/models/Stadium';
import { StadiumService } from 'src/app/services/matchServices/stadiumService/stadium.service';
import Swal from 'sweetalert2';
import {PageEvent, MatPaginatorModule} from '@angular/material/paginator';

@Component({
  selector: 'app-stade',
  templateUrl: './stade.component.html',
  styleUrls: ['./stade.component.css'],
})
export class StadeComponent implements OnInit {
  stadeForm!: FormGroup<any>;
  stadeFormEdit!: FormGroup<any>;
  dataStadium!: any;
  selectedFile!: File;
  eventImage!: any;
  displayedColumns: string[] = ['name', 'capacity','photo','action'];
  isRowHovered = false;
  fileName!: string;

  pageIndex: number=0;
  pageSize: number=5 ;
  length!: number;
  pageSizeOptions = [5, 10, 25];
  constructor(
    private stadiumService: StadiumService,
    private _httpClient: HttpClient
  ) {}
  ngOnInit(): void {
    this.initFormAddAccount();
    this.initFormEditStadium();
    this.getStadium();
  }

  initFormAddAccount() {
    this.stadeForm = new FormGroup({
      name: new FormControl('', Validators.required),
      capacity: new FormControl('', Validators.required),

    });
  }

  handlePageEvent(e: any) {
    this.length = e.length;
    this.pageSize = e.pageSize;
    this.pageIndex = e.pageIndex;
    console.log("e",this.pageIndex,this.pageSize,this.length);
    
    this.getStadium()
  }
  addStadium() {
    var file;
    if(this.eventImage){
      console.log("dd");
      
    file = this.eventImage.target.files[0];
    }
    const stade: Stadium = {
      id: 0,
      name: this.stadeForm.value.name,
      capacity: this.stadeForm.value.capacity,
      photo: "",
      matches: [],
    };
    this.stadiumService.addStadiums(stade,file).subscribe((stad) => {
      window.location.reload();
    });
  }

  getStadium() {
    this.stadiumService.getStadiums(this.pageIndex,this.pageSize).subscribe((stadiumPage) => {
      this.dataStadium= stadiumPage.content;
      this.length=stadiumPage.totalElements;
    });
  }

  onImageSelected(event: any) {
    if(event){
      
      this.eventImage=event
    }
  }

  initFormEditStadium() {
    this.stadeFormEdit = new FormGroup({
      id: new FormControl('', Validators.required), 
      nameEdit: new FormControl('', Validators.required),
      capacityEdit: new FormControl('', Validators.required)
    });
  }
  
  LoadInfoStadium(stadium: any) {
    console.log(stadium)
    this.stadeFormEdit.patchValue({
      id:stadium.id,
      nameEdit: stadium.name,
      capacityEdit: stadium.capacity,
      photoEdit: stadium.photo,
    });
  }
  

  EditStadium() {
    var file
    if(this.eventImage){

    file = this.eventImage.target.files[0];
    }
    const stade: Stadium = {
      id: 0,
      name: this.stadeFormEdit.value.nameEdit,
      capacity: this.stadeFormEdit.value.capacityEdit,
      photo: "",
      matches: []
    };
    this.stadiumService.editStadium(stade,this.stadeFormEdit.value.id,file).subscribe(() => {
      window.location.reload();
    });
    
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
    this.stadiumService.deleteStadium(coachId).subscribe(()=>{
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

  // configuration table
  onRowHover(hovered: boolean) {
    this.isRowHovered = hovered;
  }
  onRowClick(row: any){
    console.log(row.id)
  }
}
