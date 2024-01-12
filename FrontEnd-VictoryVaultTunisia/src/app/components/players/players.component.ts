import { Component, OnInit } from '@angular/core';
import { FormControl, FormGroup, Validators } from '@angular/forms';
import { Players } from 'src/app/models/Players';
import { PlayerService } from 'src/app/services/matchServices/playerService/player.service';
import Swal from 'sweetalert2';
import {PageEvent, MatPaginatorModule} from '@angular/material/paginator';
import { MatTableDataSource } from '@angular/material/table';

@Component({
  selector: 'app-players',
  templateUrl: './players.component.html',
  styleUrls: ['./players.component.css']
})
export class PlayersComponent implements OnInit{



  displayedColumns: string[] = ['rang', 'firstName','lastName', 'nationality','team','action'];
  dataPlayers!: any;
  playerFormAdd!: FormGroup<any>;
  playerFormEdit!: FormGroup<any>;

  pageIndex: number=0;
  pageSize: number=5 ;
  length!: number;
  pageSizeOptions = [5, 10, 25];

constructor(private playerService:PlayerService){}

  ngOnInit(): void {
    this.getPlayers();
    this.initFormAddPlayer();
    this.initFormEditPlayer();
  }


getPlayers(){
  this.playerService.getPlayers().subscribe(playerPage=>{
    this.dataPlayers=playerPage
    // this.dataPlayers= new MatTableDataSource<Players>(playerPage);
    // this.dataPlayers=this.dataPlayers._data.value.content
  })
}
handlePageEvent(e: any) {
  this.length = e.length;
  this.pageSize = e.pageSize;
  this.pageIndex = e.pageIndex;
  console.log("e",this.pageIndex,this.pageSize,this.length);
  
  this.getPlayers()
}

initFormAddPlayer(){
  this.playerFormAdd = new FormGroup({
    firstName: new FormControl('', Validators.required),
    lastName: new FormControl('', Validators.required),
    nationality: new FormControl('', Validators.required),
    equipe:new FormControl('', Validators.required),
});
}

addPlayer() {
  const player: Players = {
    id: 0,
    firstName: this.playerFormAdd.value.firstName,
    lastName: this.playerFormAdd.value.lastName,
    nationality: this.playerFormAdd.value.nationality,
    teamId: this.playerFormAdd.value.teamId,
    teamName: ''
  };
  console.log(player)
    if(player.firstName != "" && player.lastName != "" && player.nationality != "" ){
    this.playerService.addPlayers(player).subscribe(()=> {
      window.location.reload();
    })
  }
  else{
    alert("Please fill all fields")
  }



}


initFormEditPlayer() {
  this.playerFormEdit = new FormGroup({
    id: new FormControl('', Validators.required), 
    firstNameEdit: new FormControl('', Validators.required), // Match the form control name in HTML
    lastNameEdit: new FormControl('', Validators.required),
    nationalityEdit: new FormControl('', Validators.required),
  });
}

LoadInfoPlayer(player: any) {
  this.playerFormEdit.patchValue({
    id:player.id,
    firstNameEdit: player.firstName,
    lastNameEdit: player.lastName,
    nationalityEdit: player.nationality,
  });
}

EditPlayer() {
  console.log(this.playerFormEdit.value , this.playerFormEdit.value.id)
  const player: Players = {
    id: 0,
    firstName: this.playerFormEdit.value.firstNameEdit,
    lastName: this.playerFormEdit.value.lastNameEdit,
    nationality: this.playerFormEdit.value.nationalityEdit,
    teamId: 0,
    teamName: ''
  };

  this.playerService.editPlayer(player,this.playerFormEdit.value.id).subscribe(()=>{
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
deleteFunction(playerId:number): void {
  this.playerService.deletePlayer(playerId).subscribe(()=>{
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
  isRowHovered = false;
  onRowHover(hovered: boolean) {
    this.isRowHovered = hovered;
  }
}
