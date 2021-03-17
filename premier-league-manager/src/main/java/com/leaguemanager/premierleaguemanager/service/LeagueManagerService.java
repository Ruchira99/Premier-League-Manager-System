package com.leaguemanager.premierleaguemanager.service;

import com.leaguemanager.premierleaguemanager.model.FootBallClub;
import com.leaguemanager.premierleaguemanager.model.Match;
import com.leaguemanager.premierleaguemanager.model.SportsClub;
import javafx.collections.ObservableList;
import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;

public interface LeagueManagerService {
    ArrayList<SportsClub> getLeague ();

    void addSportsClub(FootBallClub footBallClub)throws Exception;
    void deleteSportsClub(String name);
    void displayStatistics(String name);
    void addPlayedMatchDetails(String teamAName, String teamBName, int teamAScore, int teamBScore, LocalDate date) throws Exception;
    void saveDetails() throws IOException;
    void loadDetails() throws IOException, ClassNotFoundException;
    ObservableList<FootBallClub> pointTable();
    ObservableList<Match> searchByDate(Date date);
    ArrayList<Match> allPlayedMatch();
}
