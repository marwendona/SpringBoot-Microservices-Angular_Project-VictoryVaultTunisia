import { Component, OnInit } from '@angular/core';
import { FormControl, FormGroup, Validators } from '@angular/forms';
import { MatTableDataSource } from '@angular/material/table';
import { ActivatedRoute } from '@angular/router';
import { Coach } from 'src/app/models/Coach';
import { Players } from 'src/app/models/Players';
import { Team } from 'src/app/models/Team';
import { CoachService } from 'src/app/services/matchServices/coachService/coach.service';
import { PlayerService } from 'src/app/services/matchServices/playerService/player.service';
import { TeamService } from 'src/app/services/matchServices/teamService/team.service';
import Swal from 'sweetalert2';

@Component({
  selector: 'app-edit-team',
  templateUrl: './edit-team.component.html',
  styleUrls: ['./edit-team.component.css'],
})
export class EditTeamComponent  implements OnInit{

  teamFormEdit!: FormGroup<any>;
  dataCoach!: any;////
  dataPlayersOfTeam!:any;
  players!:any;
  isRowHovered = false;
  displayedColumns: string[] = ['firstName', 'lastName','nationality','action'];
  selectedPlayerId: number | undefined;
  playersChoosenIDs: number[] = [];
  playerSelections: { [key: string]: number | undefined } = {};
  paramsTeam: any;
  dataPlayers!: any;

  constructor(private teamService:TeamService,private coachService: CoachService, private playerService:PlayerService,private route: ActivatedRoute) {}
  ngOnInit(): void {
    this.initForm();
    this.getCoach();
    this.getPlayers();

    this.route.queryParams.subscribe((params) => {
      console.log(params)
      this.paramsTeam = params;
    //getPlayers
    this.getPlayer(this.paramsTeam);
    this.LoadInfoTeam(params)
    //getCoach
    // this.getCoach(this.paramsTeam);
    })
    
  }

  initForm(){
    this.teamFormEdit = new FormGroup({
      NameEdit: new FormControl('', Validators.required),
      CoachIdEdit: new FormControl('', Validators.required),
      PL1Edit: new FormControl('', Validators.required),
    });
  }
  LoadInfoTeam(team: any) {
    this.teamFormEdit.patchValue({
      NameEdit: team.name,
      CoachIdEdit: team.coachId,
    });
  }
  
  async getCoach() {
    this.coachService.getCoach().subscribe((coachs) => {
      this.dataCoach = new MatTableDataSource<Coach>(coachs);
      this.dataCoach = this.dataCoach._data.value.content;
    });
  }

  getPlayer(paramsTeam:any){
    this.teamService.getPlayersByTeams(paramsTeam.id).subscribe(players=>{
      this.dataPlayers = new MatTableDataSource<Players>(players);
      this.dataPlayers = this.dataPlayers.filteredData;
      // if(this.dataPlayers[0]==null){
      //   this.hidden=false;
      // }
    })
  }
  playersVierge:Players[]=[];

  async getPlayers(){
    this.playerService.getPlayers().subscribe( players => {
     this.players=players.content
     this.players.forEach((p: Players)=>{
       if(p.teamId==null){
         this.playersVierge.push(p)
       }
     })

   })
 }

 playersList:Players[]=[];
  EditTeam() {
    console.log("ahoa",Object.values(this.playerSelections))


    // this.teamService.updateTeam(team,this.paramsTeam.id).subscribe(()=>{})
    //fix me
    Object.values(this.playerSelections).forEach(playerId =>{
      console.log("players",Number(playerId))
      this.playerService.getPlayerById(Number(playerId)).subscribe(player=>{
        this.playersList.push(player);
      })})

      const team:Team ={
        id: 0,
        name: this.teamFormEdit.value.NameEdit,
        players: this.playersList,
        coachId: this.teamFormEdit.value.CoachIdEdit
      }
      console.log(this.paramsTeam.id);
      
    this.teamService.updateTeam(team,this.paramsTeam.id).subscribe(()=>{
      // alert('Modification réussie')
      // window.location.reload();
    })


      
  }
  onSelectOption(event: any, key: string) {
    const selectedPlayerId = parseInt(event.target.value, 10);
    console.log(`Selected Player ID for ${key}:`, selectedPlayerId);
    this.playerSelections[key] = selectedPlayerId;
    console.log('Updated Player Selections:', this.playerSelections);
  }

  hiddenPlayers = [true, true, true, true, true, true, true, true, true, true,
    true, true, true, true, true, true, true, true, true, true,true, true];
  

  onSelectPlayer1(): void {
    this.hiddenPlayers[0] = false; 
    console.log(this.hiddenPlayers);
  }
  isPlayerSelected(playerId: number): boolean {
    return Object.values(this.playerSelections).includes(playerId);
  }
  shouldHidePlayer(playerIndex: number): boolean {
    return this.hiddenPlayers[playerIndex];
  }
  onSelectPlayern(playerIndex: number) {
    this.hiddenPlayers[playerIndex + 1] = false;
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
    this.playerService.deletePlayerFromTeam(playerId,500).subscribe(()=>{
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
