package com.leaguemanager.premierleaguemanager.service;

import com.leaguemanager.premierleaguemanager.model.FootBallClub;
import com.leaguemanager.premierleaguemanager.model.Match;
import com.leaguemanager.premierleaguemanager.model.SportsClub;
import com.leaguemanager.premierleaguemanager.repository.PremierLeagueRepository;
import javafx.collections.ObservableList;
import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

public class PremierLeagueManagerService implements LeagueManagerService{

    private static ArrayList<SportsClub> league = new ArrayList<>(); //array list get club details in to league
    private static ArrayList<SportsClub> relegate = new ArrayList<>();
    private static ArrayList<Match> matches = new ArrayList<>();



    public Boolean isFull(){
        return league.size() >= 20;
    }

    public Boolean isEmpty(){
        return league.isEmpty();
    }

    @Override
    public ArrayList<SportsClub> getLeague() {
        return league;
    }

    @Override
    public void addSportsClub(FootBallClub footBallClub) throws Exception {
        if (league.contains(footBallClub)) { //check name
            throw new Exception("exist");
        }
        league.add(footBallClub);
    }

    @Override
    public void deleteSportsClub(String name) {
        boolean flag = true;
        for(SportsClub club: league) {
            if (club.getName().equalsIgnoreCase(name)) {
                relegate.add(club);
                league.remove(club);
                flag = false;
                break;
            }
        }
        if (flag) { //This message will appear if the user enter invalid name to delete
            System.out.println("No Clubs found to delete!!!!");
        } else {
            System.out.println("------------Deleted---------");
        }
    }

    @Override
    public void displayStatistics(String name) {
        for (SportsClub team : league) {
            if (team.getName().equals(name)) {
                FootBallClub club = (FootBallClub) team;
                System.out.println("Club Name                 :" + club.getName());
                System.out.println("Club Location             :" + club.getLocation());
                System.out.println("Club Statistic            :" + club.getStatistic());
                System.out.println("Number of Wins            :" + club.getNumberOfWins());
                System.out.println("Number of Loss            :" + club.getNumberOfLoss());
                System.out.println("Number of MatchDraw       :" + club.getNumberOfMatchDraw());
                System.out.println("Number of Matches Played  :" + club.getNumberOfMatchesPlayed());
                System.out.println("Number of Goals Scored    :" + club.getNumberOfGoalsScored());
                System.out.println("Number of Goal Received   :" + club.getNumberOfGoalsAgainst());
                System.out.println("Number of Points          :" + club.getNumberOfPoints());
                return;
            }
        } //This message will appear if the user enter invalid club name
        System.out.println("No " + name + " club in the arraylist ");
    }



    @Override
    public void addPlayedMatchDetails(String teamAName, String teamBName, int teamAScore, int teamBScore, LocalDate date)
            throws Exception {
        SportsClub teamA = null;
        SportsClub teamB = null;
        for (SportsClub club: league) {  //select club from league
            if (club.getName().equalsIgnoreCase(teamAName)) {
                teamA = club;
            }
            if (club.getName().equalsIgnoreCase(teamBName)) {
                teamB = club;
            }
        }
        if (teamA == null || teamB == null) {
            throw new Exception("Teams do not exist");
        } else if (teamA == teamB) { //check teams are same or not
            throw new Exception("Same teams");
        } else {
            ArrayList<Match> played = new ArrayList<>();
            for (Match play: matches) {
                if (play.getTeamA() == teamA && play.getTeamB() == teamB) {
                    played.add(play);
                } else if (play.getTeamB() == teamA && play.getTeamA() == teamB) {
                    played.add(play);
                }
            }
            if (played.size() >= 2) {
                throw new Exception("Already Played");
            } else {
                Match match = new Match(teamA,teamB,teamAScore, teamBScore, date);
                updateTeamStat(match);
                matches.add(match);
            }
        }
    }

    public void updateTeamStat(Match match) {
        FootBallClub clubA = (FootBallClub) match.getTeamA();
        FootBallClub clubB = (FootBallClub) match.getTeamB();
        if (match.getTeamAScore() == match.getTeamBScore()) {
            clubA.incrementDraw();
            clubA.setNumberOfPoints(1);
            clubB.incrementDraw();
            clubB.setNumberOfPoints(1);
        } else if (match.getTeamAScore() < match.getTeamBScore()) {
            clubA.incrementLoss();
            clubB.incrementWins();
            clubB.setNumberOfPoints(3);
        } else {
            clubB.incrementLoss();
            clubA.incrementWins();
            clubA.setNumberOfPoints(3);
        }
        clubA.setNumberOfGoalsScored(match.getTeamAScore() + clubA.getNumberOfGoalsScored());
        clubB.setNumberOfGoalsScored(match.getTeamBScore() + clubB.getNumberOfGoalsScored());
        clubA.setNumberOfGoalsAgainst(match.getTeamBScore() + clubA.getNumberOfGoalsAgainst());
        clubB.setNumberOfGoalsAgainst(match.getTeamAScore() + clubB.getNumberOfGoalsAgainst());
        clubA.incrementMatch();
        clubB.incrementMatch();
    }

    @Override
    public void saveDetails() throws IOException {
        PremierLeagueRepository.saveDetails(matches,league);
    }

    @Override
    public void loadDetails() throws IOException, ClassNotFoundException {
        league = PremierLeagueRepository.loadClubDetails();
        matches = PremierLeagueRepository.loadMatchDetails();
    }

    @Override
    public ObservableList<FootBallClub> pointTable() {
        return null;
    }

    @Override
    public ObservableList<Match> searchByDate(Date date) {
        return null;
    }

    @Override
    public ArrayList<Match> allPlayedMatch() {
        return matches;
    }

    public ArrayList<Match> getMatches() {
        return matches;
    }

    public Match generateRandomMatch() {
        ArrayList<SportsClub> playable = new ArrayList<>();
        for (SportsClub club: league) {
            if (club.getNumberOfMatchesPlayed() < ((league.size()-1)*2)) {
                playable.add(club);
            }
        }
        if (playable.isEmpty()) {
            System.out.println("No playable teams");
            return null;
        }
        SportsClub teamA = playable.get(new Random().nextInt(playable.size()));
        ArrayList<SportsClub> opponent = new ArrayList<>();
        for (SportsClub club: playable) {
            int matchesCount = 0;
            for (Match match : matches) {
                if (match.getTeamA() == club || match.getTeamB() == club) {
                    if (match.getTeamA() == teamA || match.getTeamB() == teamA) {
                        matchesCount += 1;
                    }
                }
            }
            if (matchesCount < 2 && club!=teamA) {
                opponent.add(club);
            }
        }
        SportsClub teamB = opponent.get(new Random().nextInt(opponent.size()));
        LocalDate minimumDate = LocalDate.of(2004,12,31);
        long startingPoint = minimumDate.toEpochDay();
        LocalDate maximumDate = LocalDate.of(2019,12,31);
        long endPoint = maximumDate.toEpochDay();
        long randomDate = ThreadLocalRandom.current().longs(startingPoint,endPoint).findAny().getAsLong();
        LocalDate date = LocalDate.ofEpochDay(randomDate);
        Match match = new Match(teamA, teamB,
                new Random().nextInt(opponent.size()), new Random().nextInt(opponent.size()),
                date);
        match.setTeamAScore(new Random().nextInt(10));
        match.setTeamBScore(new Random().nextInt(10));
        matches.add(match);
        updateTeamStat(match);
        return match;
    }
}
