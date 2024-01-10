import { HttpClient } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';
import { FormControl, FormGroup, Validators } from '@angular/forms';
import { MatTableDataSource } from '@angular/material/table';
import { Stadium } from 'src/app/models/Stadium';
import { StadiumService } from 'src/app/services/matchServices/stadiumService/stadium.service';

@Component({
  selector: 'app-stade',
  templateUrl: './stade.component.html',
  styleUrls: ['./stade.component.css'],
})
export class StadeComponent implements OnInit {
  deleteStadium(arg0: any) {
    throw new Error('Method not implemented.');
  }
  editStadium(arg0: any) {
    throw new Error('Method not implemented.');
  }

  dataPlayers: any;
  stadeForm!: FormGroup<any>;
  dataStadium!: any;
  selectedFile!: File;
  eventImage!: any;
  constructor(
    private stadiumService: StadiumService,
    private _httpClient: HttpClient
  ) {}
  ngOnInit(): void {
    this.initFormAddAccount();
    this.getStadium();
  }

  initFormAddAccount() {
    this.stadeForm = new FormGroup({
      name: new FormControl('', Validators.required),
      capacity: new FormControl('', Validators.required),
      photo: new FormControl('', Validators.required),
    });
  }
  fileName!: string;

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

    this.stadiumService.addStadiums(stade).subscribe(() => {
      console.log('stade added successfuly!!');
      console.log(stade)
    });

    console.log("aaa",this.eventImage)
  }

  getStadium() {
    this.stadiumService.getStadiums().subscribe((dataStadium) => {
      this.dataStadium = dataStadium;
      this.dataStadium = this.dataStadium.content;
    });
  }

  onImageSelected(event: any) {
    this.eventImage=event
  }
}
