import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { HomeComponent } from './components/home/home.component';
import { ClassementComponent } from './components/classement/classement.component';
import { TeamComponent } from './components/team/team.component';
import { PlayersComponent } from './components/players/players.component';
import { CoachComponent } from './components/coach/coach.component';

const routes: Routes = [
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
