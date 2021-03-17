import { Injectable } from '@angular/core';
import {HttpClient} from "@angular/common/http";

@Injectable({
  providedIn: 'root'
})
export class PremierLeagueService {

  constructor(private httpClient: HttpClient) {

  }

  public getRandomMatch(){
    return this.httpClient.get<any>("http://localhost:8080/Controller/getRandomMatch");
  }

  public getMatches(){
    return this.httpClient.get<any>("http://localhost:8080/Controller/getMatches");
  }

  public getLeague(){
    return this.httpClient.get<any>("http://localhost:8080/Controller/getLeague");
  }

}
