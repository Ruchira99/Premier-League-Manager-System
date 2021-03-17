import { Component, OnInit } from '@angular/core';
import {FootballMatch} from "../model/football-match";
import {PremierLeagueService} from "../services/premier-league.service";

@Component({
  selector: 'app-random-played-match',
  templateUrl: './random-played-match.component.html',
  styleUrls: ['./random-played-match.component.scss']
})
export class RandomPlayedMatchComponent implements OnInit {

  matches: FootballMatch[] = [];

  constructor(private premierLeagueService: PremierLeagueService) { }

  ngOnInit(): void {
  }

  generateMatch() {
    this.premierLeagueService.getRandomMatch().subscribe(val => {
      if (val != null) {
        this.matches.push(val);
      }
    })
  }
}
