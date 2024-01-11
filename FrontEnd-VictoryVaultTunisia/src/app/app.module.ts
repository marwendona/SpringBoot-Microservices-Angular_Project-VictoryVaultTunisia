import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { provideAnimations } from '@angular/platform-browser/animations';
import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { HomeComponent } from './components/home/home.component';
import { HeaderComponent } from './components/tools/header/header.component';
import { FooterComponent } from './components/tools/footer/footer.component';
import { ClassementComponent } from './components/classement/classement.component';
import { MatTableModule } from '@angular/material/table';
import { TeamComponent } from './components/team/team.component';
import { CoachComponent } from './components/coach/coach.component';
import { MatFormFieldModule } from '@angular/material/form-field';
import { FormsModule }   from '@angular/forms';
import { ReactiveFormsModule } from '@angular/forms';
import { HttpClientModule } from '@angular/common/http';
import { AddteamComponent } from './components/addteam/addteam.component';
import {MatIconModule} from '@angular/material/icon';
import { TeamdetailComponent } from './components/teamdetail/teamdetail.component';
import { StadeComponent } from './components/stade/stade.component';
import Swal from 'sweetalert2';
import { EditTeamComponent } from './components/edit-team/edit-team.component';
import { RefereeComponent } from './components/referee/referee.component';
import { PlayersComponent } from './components/players/players.component';
import {MatPaginatorModule} from '@angular/material/paginator';
import { MatchComponent } from './components/match/match.component';
import { RemplacementComponent } from './components/remplacement/remplacement.component';
import { LineupComponent } from './components/lineup/lineup.component';
import { CreateMatchComponent } from './components/create-match/create-match.component';
import { MatchDetailComponent } from './components/match-detail/match-detail.component';


@NgModule({
  declarations: [
    AppComponent,
    HomeComponent,
    HeaderComponent,
    FooterComponent,
    ClassementComponent,
    TeamComponent,
    PlayersComponent,
    CoachComponent,
    AddteamComponent,
    TeamdetailComponent,
    StadeComponent,
    EditTeamComponent,
    RefereeComponent,
    MatchComponent,
    RemplacementComponent,
    LineupComponent,
    CreateMatchComponent,
    MatchDetailComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    MatTableModule,
    MatFormFieldModule,
    FormsModule,
    ReactiveFormsModule,
    HttpClientModule,
    MatIconModule,
    MatPaginatorModule,
    
    
  ],
  providers: [provideAnimations()],
  bootstrap: [AppComponent]
})
export class AppModule { }
