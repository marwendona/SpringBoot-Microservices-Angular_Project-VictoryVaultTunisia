import { Component } from '@angular/core';
import { CommonModule } from '@angular/common';
import { FooterComponent } from "../tools/footer/footer.component";
import { HeaderComponent } from "../tools/header/header.component";
import { MatFormFieldModule } from '@angular/material/form-field';
import { MatSelectModule } from '@angular/material/select';


interface Food {
  value: string;
  viewValue: string;
}

@Component({
  selector: 'app-classement',
  standalone: true,
  imports: [CommonModule, HeaderComponent, FooterComponent, MatFormFieldModule,MatSelectModule,],
  
  templateUrl: './classement.component.html',
  styleUrl: './classement.component.css'
})
export class ClassementComponent {

  foods: Food[] = [
    {value: 'steak-0', viewValue: 'Steak'},
    {value: 'pizza-1', viewValue: 'Pizza'},
    {value: 'tacos-2', viewValue: 'Tacos'},
  ];
}
