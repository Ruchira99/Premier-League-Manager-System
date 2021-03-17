package com.leaguemanager.premierleaguemanager.controller;


import com.leaguemanager.premierleaguemanager.model.Match;
import com.leaguemanager.premierleaguemanager.model.SportsClub;
import com.leaguemanager.premierleaguemanager.service.PremierLeagueManagerService;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;


@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/Controller")
public class PremierLeagueController {

    private static PremierLeagueManagerService premierLeagueManagerService = new PremierLeagueManagerService();

    @GetMapping(path = "/getLeague", produces = MediaType.APPLICATION_JSON_VALUE)
    public ArrayList<SportsClub> getLeague(){
        return premierLeagueManagerService.getLeague();
    }

    @GetMapping(path = "/getMatches", produces = MediaType.APPLICATION_JSON_VALUE)
    public ArrayList<Match> getMatches(){
        return premierLeagueManagerService.getMatches();
    }

    @GetMapping(path = "/getRandomMatch", produces = MediaType.APPLICATION_JSON_VALUE)
    public Match getRandomMatch(){
        return premierLeagueManagerService.generateRandomMatch();
    }

}
