import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { HomeComponent } from './components/home/home.component';
import { ClassementComponent } from './components/classement/classement.component';
import { TeamComponent } from './components/team/team.component';
import { PlayersComponent } from './components/players/players.component';
import { CoachComponent } from './components/coach/coach.component';
import { AddteamComponent } from './components/addteam/addteam.component';
import { TeamdetailComponent } from './components/teamdetail/teamdetail.component';

const routes: Routes = [
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
