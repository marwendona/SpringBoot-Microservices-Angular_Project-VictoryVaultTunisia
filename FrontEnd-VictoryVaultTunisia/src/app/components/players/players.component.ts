import { Component, OnInit } from '@angular/core';
import { FormControl, FormGroup, Validators } from '@angular/forms';
import { MatTableDataSource } from '@angular/material/table';
import { Players } from 'src/app/models/Players';
import { PlayerService } from 'src/app/services/matchServices/playerService/player.service';

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


constructor(private playerService:PlayerService){}

  ngOnInit(): void {
    this.getPlayers();
    this.initFormAddPlayer();
    this.initFormEditPlayer();
  }


getPlayers(){
  this.playerService.getPlayers().subscribe(players=>{
    this.dataPlayers= new MatTableDataSource<Players>(players);
    this.dataPlayers = this.dataPlayers._data.value.content;
  })
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
  };

  this.playerService.editPlayer(player,this.playerFormEdit.value.id).subscribe(()=>{
    console.log("player changed successfuly")
    window.location.reload();
  })
}
  

  isRowHovered = false;
  onRowHover(hovered: boolean) {
    this.isRowHovered = hovered;
  }
}