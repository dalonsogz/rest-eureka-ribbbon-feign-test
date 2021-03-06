import { BrowserModule } from '@angular/platform-browser';
import { NgModule, CUSTOM_ELEMENTS_SCHEMA } from '@angular/core';

import { HttpClientModule } from '@angular/common/http';  // replaces previous Http service
import { FormsModule } from '@angular/forms';
import { DemoService } from './demo.service';   // our custom service, see below

import { AppComponent } from './app.component';

@NgModule({
  imports: [BrowserModule, FormsModule, HttpClientModule],
  declarations: [AppComponent],
  providers: [DemoService],
  schemas: [CUSTOM_ELEMENTS_SCHEMA],
  bootstrap: [AppComponent]
})
export class AppModule { }
