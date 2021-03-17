package com.leaguemanager.premierleaguemanager.repository;

import com.leaguemanager.premierleaguemanager.model.Match;
import com.leaguemanager.premierleaguemanager.model.SportsClub;

import java.io.*;
import java.util.ArrayList;

public class PremierLeagueRepository {

    public static void saveDetails(ArrayList <Match> matches, ArrayList <SportsClub> league) throws IOException {

        try {
            FileOutputStream fileOutputStream = new FileOutputStream("data.txt");  // writing data to a data.txt
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);  // writes primitive data types

            FileOutputStream teamsFOS = new FileOutputStream("teams.txt"); // writing data to a teams.txt
            ObjectOutputStream teamOOS = new ObjectOutputStream(teamsFOS);

            for (Match club : matches) { //writes matches arraylist
                objectOutputStream.writeObject(club);
            }

            for (SportsClub team : league) {
                teamOOS.writeObject(team);
            }

            objectOutputStream.flush();
            teamOOS.flush();

            objectOutputStream.close();
            teamOOS.close();

            fileOutputStream.close();
            teamsFOS.close();

            System.out.println("Successfully saved to file");
        } catch (FileNotFoundException fe) {     //handle file not found
            System.out.println("ERROR: Couldn't Load in");
        }
    }



    public static ArrayList<Match> loadMatchDetails() {
        ArrayList<Match> matches = new ArrayList<>();
        try {
            FileInputStream fileInputStream = new FileInputStream("data.txt");
            ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);

            for (; ; ) {
                try {
                    Match club = (Match) objectInputStream.readObject();
                    matches.add(club);
                } catch (IOException e) {
                    break;
                }
            }
            fileInputStream.close();
            objectInputStream.close();
        } catch (EOFException ignored) {
        } catch (IOException | ClassNotFoundException fe) {
            System.out.println("ERROR: Couldn't Load in");
        }
        return matches;
    }

    public static ArrayList<SportsClub> loadClubDetails(){
        ArrayList<SportsClub> league = new ArrayList<>();
        try {
            FileInputStream teamFIS = new FileInputStream("teams.txt");
            ObjectInputStream teamOIS = new ObjectInputStream(teamFIS);
            for (; ; ) {
                try {
                    SportsClub team = (SportsClub) teamOIS.readObject();
                    league.add(team);
                } catch (IOException e) {
                    break;
                }
            }
            teamFIS.close();
            teamOIS.close();
        } catch (EOFException ignored) {
        } catch (IOException | ClassNotFoundException fe) {
            System.out.println("ERROR: Couldn't Load in");
        }
        return league;
    }

}
