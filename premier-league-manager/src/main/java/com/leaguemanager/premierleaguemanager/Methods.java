package com.leaguemanager.premierleaguemanager;

import com.leaguemanager.premierleaguemanager.model.FootBallClub;
import com.leaguemanager.premierleaguemanager.model.SportsClub;
import com.leaguemanager.premierleaguemanager.service.PremierLeagueManagerService;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Methods {
    private static PremierLeagueManagerService premierLeagueManagerService = new  PremierLeagueManagerService();
    private static boolean angular = false;

    public static void addSportsClub() throws Exception{
        if (premierLeagueManagerService.isFull()) {
            System.out.println("FULL");
            return;
        }
        Scanner scan  = new Scanner(System.in);
        FootBallClub footBallClub;

        System.out.println("Enter SportsClub name   :");
        String sportsClubName = scan.nextLine().toLowerCase();


        System.out.println("Enter SportsClub location   :");
        String sportsClubLocation = scan.nextLine();

        System.out.println("Enter SportsClub statistics   :");
        String sportsClubStatistics = scan.nextLine();

        footBallClub = new FootBallClub(sportsClubName,sportsClubLocation,sportsClubStatistics);
        premierLeagueManagerService.addSportsClub(footBallClub);

    }


    public static void deleteSportsClub(){
        if (premierLeagueManagerService.isEmpty()) {
            System.out.println("FULL");
            return;
        }
        System.out.println("Please enter name of The SportsClub you want to remove:");
        Scanner sc = new Scanner(System.in);
        String sportsClubName = sc.nextLine();
        premierLeagueManagerService.deleteSportsClub(sportsClubName);

    }

    public static void displayStatistics(){
        if (premierLeagueManagerService.isEmpty()) {
            System.out.println("FULL");
            return;
        }
        Scanner scan  = new Scanner(System.in);
        System.out.println("Enter SportsClub name   :");
        String displayName = scan.nextLine().toLowerCase();
        premierLeagueManagerService.displayStatistics(displayName);

    }

    public static void addPlayedMatchDetails() throws Exception {
        if (premierLeagueManagerService.isEmpty()) {
            System.out.println("FULL");
            return;
        }
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter date [yyyy-MM-dd]  :");
        String format = sc.nextLine();

        LocalDate date;
        try {
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
            date = LocalDate.parse(format, formatter);
        } catch (Exception e) {
            System.out.println("You have to enter date in format yyyy-MM-dd");
            return;
        }
        System.out.println("Enter Team A name :  ");
        String teamAName = sc.nextLine();

        System.out.println("Enter Team b name :  ");
        String teamBName = sc.nextLine();

        System.out.println("Enter Team A score:  ");
        int teamAScore = sc.nextInt();

        System.out.println("Enter Team B score:  ");
        int teamBScore = sc.nextInt();

        premierLeagueManagerService.addPlayedMatchDetails(teamAName,teamBName,teamAScore,teamBScore,date);

    }

    public static void openGui() {
        if (angular) {
            System.out.println("open browser");
            return;
        }
        Thread guiThread = new Thread(new GuiThread());
        guiThread.start();
        angular = true;
    }

    public static void displayTable() {

        ArrayList<SportsClub>footBallClubArrayList = premierLeagueManagerService.getLeague();

        Collections.sort(footBallClubArrayList);
        String leftAlignFormat = "| %-15s | %-6d | %-6d | %-6d | %-6d | %-6d | %-6d | %-6d | %-6d |%n";
        System.out.format("+-----------------+--------+--------+--------+--------+--------+--------+--------+--------+%n");
        System.out.format("| Club Name       | Played | Won    | Lost   | Draw   | GF     | GA     | GD     | Points |%n");

        System.out.format("+-----------------+--------+--------+--------+--------+--------+--------+--------+--------+%n");
        for (SportsClub temp : footBallClubArrayList) {
            FootBallClub footBallClub = (FootBallClub) temp;
            System.out.format(leftAlignFormat, footBallClub.getName(), footBallClub.getNumberOfMatchesPlayed()
                    , footBallClub.getNumberOfWins(), footBallClub.getNumberOfLoss()
                    , footBallClub.getNumberOfMatchDraw(), footBallClub.getNumberOfGoalsScored()
                    , footBallClub.getNumberOfGoalsAgainst(),
                    (footBallClub.getNumberOfGoalsScored() - footBallClub.getNumberOfGoalsAgainst())
                    , footBallClub.getNumberOfPoints()
            );
        }
        System.out.format("+-----------------+--------+--------+--------+--------+--------+--------+--------+--------+%n");
        System.out.println("\n\n\n\n");
        System.out.println(" GF=Goal Scored \n GA= Goal Received \n GD=Goal Difference");
    }


}
