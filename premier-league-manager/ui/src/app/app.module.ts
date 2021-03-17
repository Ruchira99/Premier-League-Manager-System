import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { StatisticsTableComponent } from './statistics-table/statistics-table.component';
import { RandomPlayedMatchComponent } from './random-played-match/random-played-match.component';
import { PlayedMatchComponent } from './played-match/played-match.component';
import {PremierLeagueService} from "./services/premier-league.service";
import {HttpClientModule} from "@angular/common/http";
import {FormsModule} from "@angular/forms";

@NgModule({
  declarations: [
    AppComponent,
    PlayedMatchComponent,
    StatisticsTableComponent,
    RandomPlayedMatchComponent,
    PlayedMatchComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    HttpClientModule,
    FormsModule
  ],
  providers: [PremierLeagueService],
  bootstrap: [AppComponent]
})
export class AppModule { }
