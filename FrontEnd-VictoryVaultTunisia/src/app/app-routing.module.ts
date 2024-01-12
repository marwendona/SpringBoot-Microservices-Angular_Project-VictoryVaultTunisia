import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { HomeComponent } from './components/home/home.component';
import { ClassementComponent } from './components/classement/classement.component';
import { TeamComponent } from './components/team/team.component';
import { CoachComponent } from './components/coach/coach.component';
import { AddteamComponent } from './components/addteam/addteam.component';
import { TeamdetailComponent } from './components/teamdetail/teamdetail.component';
import { StadeComponent } from './components/stade/stade.component';
import { EditTeamComponent } from './components/edit-team/edit-team.component';
import { RefereeComponent } from './components/referee/referee.component';
import { PlayersComponent } from './components/players/players.component';
import { MatchComponent } from './components/match/match.component';
import { RemplacementComponent } from './components/remplacement/remplacement.component';
import { LineupComponent } from './components/lineup/lineup.component';
import { CreateMatchComponent } from './components/create-match/create-match.component';
import { MatchDetailComponent } from './components/match-detail/match-detail.component';

const routes: Routes = [
  {
    path: 'matchDetail',
    pathMatch:'full',
    component: MatchDetailComponent
  },
  {
    path: 'creatematch',
    pathMatch:'full',
    component: CreateMatchComponent
  },
  {
    path: 'lineup',
    pathMatch:'full',
    component: LineupComponent
  },
  {
    path: 'remplacement',
    pathMatch:'full',
    component: RemplacementComponent
  },
  {
    path: 'match',
    pathMatch:'full',
    component: MatchComponent
  },
  {
    path: 'referee',
    pathMatch:'full',
    component: RefereeComponent
  },
  {
    path: 'editTeam',
    pathMatch:'full',
    component: EditTeamComponent
  },
  {
    path: 'stade',
    pathMatch:'full',
    component: StadeComponent
  },
  {
    path: 'teamDetail',
    pathMatch:'full',
    component: TeamdetailComponent
  },
  {
    path: 'addteams',
    pathMatch:'full',
    component: AddteamComponent
  },
  {
    path: 'coach',
    pathMatch:'full',
    component: CoachComponent
  },
  {
    path: 'players',
    pathMatch:'full',
    component: PlayersComponent
  },
  {
    path: 'team',
    pathMatch:'full',
    component: TeamComponent
  },
  {
    path: 'classement',
    pathMatch:'full',
    component: ClassementComponent
  },
  {
    path: 'home',
    pathMatch:'full',
    component: HomeComponent
  },
    //default
    {
      path:'**',
      pathMatch:'full',
      redirectTo:'home'
    }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
