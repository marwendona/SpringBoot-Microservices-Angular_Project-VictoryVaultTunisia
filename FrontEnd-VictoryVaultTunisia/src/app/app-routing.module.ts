import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { HomeComponent } from './components/home/home.component';
import { ClassementComponent } from './components/classement/classement.component';

const routes: Routes = [
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
