package com.leaguemanager.premierleaguemanager.model;

import java.io.Serializable;
import java.time.LocalDate;

public class Match implements Serializable {
    private SportsClub teamA;
    private SportsClub teamB;
    private int teamAScore;
    private int teamBScore;
    private LocalDate date;


    public Match(SportsClub teamA, SportsClub teamB, int teamAScore, int teamBScore,LocalDate date) {
        this.teamA = teamA;
        this.teamB = teamB;
        this.teamAScore = teamAScore;
        this.teamBScore = teamBScore;
        this.date = date;
    }

    //Getters and Setters
    public SportsClub getTeamA() {
        return this.teamA;
    }

    public void setTeamA(SportsClub teamA) {
        this.teamA = teamA;
    }

    public SportsClub getTeamB() {
        return this.teamB;
    }

    public void setTeamB(SportsClub teamB) {
        this.teamB = teamB;
    }

    public int getTeamAScore() {
        return this.teamAScore;
    }

    public void setTeamAScore(int teamAScore) {
        this.teamAScore = teamAScore;
    }

    public int getTeamBScore() {
        return this.teamBScore;
    }

    public void setTeamBScore(int teamBScore) {
        this.teamBScore = teamBScore;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public int compareTo(Match teamA){
        return this.date.compareTo(teamA.getDate());
    }

}
