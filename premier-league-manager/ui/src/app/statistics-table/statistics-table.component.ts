import { Component, OnInit } from '@angular/core';
import {PremierLeagueService} from "../services/premier-league.service";
import {FootballClub} from "../model/football-club";

@Component({
  selector: 'app-statistics-table',
  templateUrl: './statistics-table.component.html',
  styleUrls: ['./statistics-table.component.scss']
})
export class StatisticsTableComponent implements OnInit {

  league: FootballClub[] = [];
  btnPoint: boolean=false;
  btnGoal: boolean=false;
  btnWin: boolean=false;

  constructor(private premierLeagueService: PremierLeagueService) { }

  ngOnInit(): void {
    this.loadData();
  }

  changesort(number: number) {
    if (number === 0) {
      this.loadData()
    } else if (number === 1) {
      this.league.sort((a,b) => b.numberOfGoalsScored - a.numberOfGoalsScored);
    } else if (number === 2) {
      this.league.sort((a,b) => b.numberOfWins - a.numberOfWins);
    }
  }

  private loadData() {
    this.premierLeagueService.getLeague().subscribe(value => {
      this.league = value;
    })
  }
}
