import { HttpClient } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';
import { FormControl, FormGroup, Validators } from '@angular/forms';
import { MatTableDataSource } from '@angular/material/table';
import { Stadium } from 'src/app/models/Stadium';
import { StadiumService } from 'src/app/services/matchServices/stadiumService/stadium.service';
import Swal from 'sweetalert2';

@Component({
  selector: 'app-stade',
  templateUrl: './stade.component.html',
  styleUrls: ['./stade.component.css'],
})
export class StadeComponent implements OnInit {
  dataPlayers: any;
  stadeForm!: FormGroup<any>;
  stadeFormEdit!: FormGroup<any>;
  dataStadium!: any;
  selectedFile!: File;
  eventImage!: any;
  displayedColumns: string[] = ['name', 'capacity','photo','action'];
  isRowHovered = false;
  fileName!: string;

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
      photo: new FormControl('', Validators.required),
    });
  }

  addStadium() {
    const file: File = this.eventImage.target.files[0];
    if (file) {
      this.fileName = file.name;
      const formData = new FormData();
      formData.append('stadeImage', file);
      this.stadiumService.uploadImage(formData).subscribe(
        (response) => {
          console.log('Image uploaded successfully.', response);
        }
      );
    }
    if (this.selectedFile) {
      const stadeImage = new FormData();
      stadeImage.append('image', this.selectedFile, this.selectedFile.name);
    }

    const stade: Stadium = {
      id: 0,
      name: this.stadeForm.value.name,
      capacity: this.stadeForm.value.capacity,
      photo: "this.fileName",
      matches: [],
    };

    this.stadiumService.addStadiums(stade,file).subscribe(() => {
      console.log('stade added successfuly!!');
      console.log(stade)
    });

    console.log("aaa",this.eventImage)
  }

  getStadium() {
    this.stadiumService.getStadiums().subscribe((dataStadium) => {
      this.dataStadium = new MatTableDataSource<Stadium>(dataStadium);
      this.dataStadium = this.dataStadium._data.value.content
    });
  }

  onImageSelected(event: any) {
    this.eventImage=event
  }

  initFormEditStadium() {
    this.stadeFormEdit = new FormGroup({
      id: new FormControl('', Validators.required), 
      nameEdit: new FormControl('', Validators.required),
      capacityEdit: new FormControl('', Validators.required),
      photoEdit: new FormControl('', Validators.required),
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
    const stade: Stadium = {
      id: 0,
      name: this.stadeFormEdit.value.nameEdit,
      capacity: this.stadeFormEdit.value.capacityEdit,
      photo: this.stadeFormEdit.value.photoEdit,
      matches: []
    };
  console.log(stade)
    this.stadiumService.editStadium(stade,this.stadeFormEdit.value.id).subscribe(()=>{
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
