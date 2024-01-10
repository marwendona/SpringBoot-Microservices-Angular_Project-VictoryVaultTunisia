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
  playerForm!: FormGroup<any>;


constructor(private playerService:PlayerService){}

  ngOnInit(): void {
    this.getPlayers();
    this.initFormAddPlayer();
  }


getPlayers(){
  this.playerService.getPlayers().subscribe(players=>{
    this.dataPlayers= new MatTableDataSource<Players>(players);
    this.dataPlayers = this.dataPlayers._data.value.content;
  })
}


initFormAddPlayer(){
  this.playerForm = new FormGroup({
    firstName: new FormControl('', Validators.required),
    lastName: new FormControl('', Validators.required),
    nationality: new FormControl('', Validators.required),
    equipe:new FormControl('', Validators.required),
});
}


addPlayer() {
  const player: Players = {
    id: 0,
    firstName: this.playerForm.value.firstName,
    lastName: this.playerForm.value.lastName,
    nationality: this.playerForm.value.nationality,
    teamId: this.playerForm.value.teamId,
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


  isRowHovered = false;
  onRowHover(hovered: boolean) {
    this.isRowHovered = hovered;
  }
}
