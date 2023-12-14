import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { HomeComponent } from './components/home/home.component';
import { JourneeComponent } from './components/journee/journee.component';

const routes: Routes = [

  {
    path: 'journee',
    pathMatch:'full',
    component: JourneeComponent
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
