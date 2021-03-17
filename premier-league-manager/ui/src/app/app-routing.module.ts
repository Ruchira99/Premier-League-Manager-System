import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import {StatisticsTableComponent} from "./statistics-table/statistics-table.component";
import {RandomPlayedMatchComponent} from "./random-played-match/random-played-match.component";
import {PlayedMatchComponent} from "./played-match/played-match.component";

const routes: Routes = [
  {path:'',redirectTo: '/statisticTable', pathMatch:'full'},
  {path:'playedMatch', component: PlayedMatchComponent},
  {path:'statisticTable',component: StatisticsTableComponent},
  {path:'random',component: RandomPlayedMatchComponent}

];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
