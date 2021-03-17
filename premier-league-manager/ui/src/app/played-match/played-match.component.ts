import { Component, OnInit } from '@angular/core';
import {PremierLeagueService} from "../services/premier-league.service";
import {FootballClub} from "../model/football-club";
import {FootballMatch} from "../model/football-match";

@Component({
  selector: 'app-played-match',
  templateUrl: './played-match.component.html',
  styleUrls: ['./played-match.component.scss']
})
export class PlayedMatchComponent implements OnInit {

  match: FootballMatch[] = [];
  temp: FootballMatch[] = [];
  searchVal: string = '';
  constructor(private premierLeagueService: PremierLeagueService) { }

  ngOnInit(): void {
    this.premierLeagueService.getMatches().subscribe(value => {
      this.match = value;
      this.temp = value;
    })
  }

  search() {
    if (this.searchVal === '' || this.searchVal === ' ') {
      this.match = this.temp;
    }
    this.match = [];
    this.temp.forEach(val => {
      if (val.date.toString().includes(this.searchVal)) {
        this.match.push(val);
      } else if (val.teamBScore.toString().includes(this.searchVal)) {
        this.match.push(val);
      }
    })
  }
}
