package com.leaguemanager.premierleaguemanager;

import com.leaguemanager.premierleaguemanager.service.PremierLeagueManagerService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import java.io.IOException;
import java.util.Scanner;

@SpringBootApplication

public class PremierLeagueManagerApplication {
	private static PremierLeagueManagerService premierLeagueManagerService =new PremierLeagueManagerService();

	public static void main(String[] args) throws IOException, ClassNotFoundException {
		SpringApplication.run(PremierLeagueManagerApplication.class, args);

		premierLeagueManagerService.loadDetails();
		String option;
			Scanner input = new Scanner(System.in);
			while(true) {


				System.out.print("A - Add Football Club to Premier League"+ "\nM -Add Played Match Details" +
						"\nR - Relegate Club from Premier League\n" + "G - Open GUI\n"+
						"D - Display Statistics of a Club\nP - Display Premier League Table\nQ - Exit Application & Save data\n- ");
				System.out.print("Select an Option from the Menu  : ");
				option = input.nextLine();
				try {
					if (option.equalsIgnoreCase("a")) {
						if (premierLeagueManagerService.isFull()) {
							System.out.println("League is Full !");
							continue;
						}
						Methods.addSportsClub();
					} else if (option.equalsIgnoreCase("M")) {
						// TODO : remove this (Automate)
						Methods.addPlayedMatchDetails();
					}
					else if (option.equalsIgnoreCase("G")) {
						Methods.openGui();
					} else if (option.equalsIgnoreCase("R")) {
						if (premierLeagueManagerService.isEmpty()) {
							System.out.println("League is Empty !");
							continue;
						}
						Methods.deleteSportsClub();
					} else if (option.equalsIgnoreCase("D")) {
						if (premierLeagueManagerService.isEmpty()) {
							System.out.println("League is Empty !");
							continue;
						}
						Methods.displayStatistics();
					} else if (option.equalsIgnoreCase("P")) {
						if (premierLeagueManagerService.isEmpty()) {
							System.out.println("League is Empty !");
							continue;
						}
						Methods.displayTable();
					} else if (option.equalsIgnoreCase("Q")) {
						premierLeagueManagerService.saveDetails();
						break;
					} else {
						System.out.println("Invalid selection. Please check your input!!!!!");
					}
				} catch (Exception e) {
					// TODO stacktrace remove
					e.printStackTrace();
					System.out.println("Error occurred -> " + e.getMessage());
				}
			}
		}
}

