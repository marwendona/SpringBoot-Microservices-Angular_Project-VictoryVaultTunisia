import { Component } from '@angular/core';
import { CommonModule } from '@angular/common';
import { HeaderComponent } from "../tools/header/header.component";
import { FooterComponent } from "../tools/footer/footer.component";
import { MatTableDataSource } from '@angular/material/table';

@Component({
    selector: 'app-journee',
    standalone: true,
    templateUrl: './journee.component.html',
    styleUrl: './journee.component.css',
    imports: [CommonModule, HeaderComponent, FooterComponent]
})
export class JourneeComponent {

}