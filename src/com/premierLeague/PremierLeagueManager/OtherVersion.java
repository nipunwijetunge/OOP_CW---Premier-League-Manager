package com.premierLeague.PremierLeagueManager;

import com.premierLeague.PremierLeagueClubs.FootballClub;

import java.io.*;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Date;
import java.util.InputMismatchException;
import java.util.Scanner;

public class OtherVersion {

    static LeagueManager PLManager = PremierLeagueManager.getInstance();
    static LeagueManager U23Manager = PremierLeagueManager.getInstance();
    static LeagueManager U18Manager = PremierLeagueManager.getInstance();

    final static Scanner USER_INPUT = new Scanner(System.in);

    static File PLFootballClubs = new File("PLFootballClubs.txt");
    static File PLMatches = new File("PLMatches.txt");

    static File U23FootballClubs = new File("U23FootballClubs.txt");
    static File U23Matches = new File("U23Matches.txt");

    static File U18FootballClubs = new File("U18FootballClubs.txt");
    static File U18Matches = new File("U18Matches.txt");

    public static void main (String[]args) {
        try {
            PLManager.loadData(PLFootballClubs, PLMatches);
            U23Manager.loadData(U23FootballClubs, U23Matches);
            U18Manager.loadData(U18FootballClubs, U18Matches);
            System.out.println("data has been successfully loaded!");
        } catch (IOException io) {
            System.out.println("File not found!");
        } catch (ClassNotFoundException classNotFoundException){
            System.out.println("Class not found!");
        }

        menu:
        while (true) {
            try {
                menu();
                int choice = USER_INPUT.nextInt();
                int pick;
                switch (choice) {
                    case 1:
                        pick = leagueSelection("Which League do you want to add a club to?");
                        createFootballClubAndAddToPL(pick);
                        break;
                    case 2:
                        pick = leagueSelection("Which League do you want to remove a club from?");
                        removeFootballClubFromPL(pick);
                        break;
                    case 3:
                        pick = leagueSelection("Select the League,");
                        displayStatsOnATeam(pick);
                        break;
                    case 4:
                        pick = leagueSelection("Select the League to show points table,");
                        displayPLTable(pick);
                        break;
                    case 5:
                        pick = leagueSelection("Select the league,");
                        addAPlayedMatch(pick);
                        break;
                    case 6:
                        saveData();
                        break;
                    case 7:
                        System.out.println("Program is exiting...");
                        break menu;
                    default:
                        System.out.println("Invalid Input! Please try again.");
                }
            } catch (InputMismatchException e) {
                System.out.println("Invalid Input! Please try again.");
                USER_INPUT.next();
            } catch (ParseException p){
                System.out.println("ParseException Occurred!");
            } catch (IOException io){
                System.out.println("IOException Occurred!");
            }
        }
    }

    private static void menu() {
        System.out.println("\nWelcome to Premier League");
        System.out.println("Select an Option,");
        System.out.println("'1' Create a new football club and add it to the premier league.");
        System.out.println("'2' Remove an existing football club from the premier league.");
        System.out.println("'3' Display various statistics about a selected football club.");
        System.out.println("'4' Display Premier League table.");
        System.out.println("'5' Add a played match.");
        System.out.println("'6' Save data into a file.");
        System.out.println("'7' Exit the program.");
    }

    private static void createFootballClubAndAddToPL(int pick) {
        if (pick == 1) {
            System.out.print("Enter the name of the club : ");
            String clubName = USER_INPUT.nextLine().toLowerCase();
            clubName += USER_INPUT.nextLine().toLowerCase();
            System.out.print("Enter the location of the club : ");
            String clubLocation = USER_INPUT.next().toLowerCase();

            FootballClub footballClub = new FootballClub(clubName, clubLocation);
            PLManager.createFootballClubAndAddToPL(footballClub);

        } else if (pick == 2) {
            System.out.print("Enter the name of the U-23 club : ");
            String clubName = USER_INPUT.nextLine().toLowerCase();
            clubName += USER_INPUT.nextLine().toLowerCase();
            System.out.print("Enter the location of the U-23 club : ");
            String clubLocation = USER_INPUT.next().toLowerCase();

            FootballClub footballClub = new FootballClub(clubName, clubLocation);
            U23Manager.createFootballClubAndAddToPL(footballClub);

        } else {
            System.out.print("Enter the name of the U-18 club : ");
            String clubName = USER_INPUT.nextLine().toLowerCase();
            clubName += USER_INPUT.nextLine().toLowerCase();
            System.out.print("Enter the location of the U-18 club : ");
            String clubLocation = USER_INPUT.next().toLowerCase();

            FootballClub footballClub = new FootballClub(clubName, clubLocation);
            U18Manager.createFootballClubAndAddToPL(footballClub);
        }
    }

    private static void removeFootballClubFromPL(int pick) throws InputMismatchException {
        if (pick == 1){
            System.out.print("Enter the name of the club : ");
            String clubName = USER_INPUT.nextLine().toLowerCase();
            clubName += USER_INPUT.nextLine().toLowerCase();
            System.out.print("Enter the Registration No. of the team : ");
            int regNo = USER_INPUT.nextInt();

            PLManager.removeFootballClubFromPL(clubName, regNo);

        } else if (pick == 2){
            System.out.println("Enter the name of the club : ");
            String clubName = USER_INPUT.nextLine().toLowerCase();
            clubName += USER_INPUT.nextLine().toLowerCase();
            System.out.println("Enter the Registration No. of the team : ");
            int regNo = USER_INPUT.nextInt();

            U23Manager.removeFootballClubFromPL(clubName, regNo);

        } else {
            System.out.println("Enter the name of the club : ");
            String clubName = USER_INPUT.nextLine().toLowerCase();
            clubName += USER_INPUT.nextLine().toLowerCase();
            System.out.println("Enter the Registration No. of the team : ");
            int regNo = USER_INPUT.nextInt();

            U18Manager.removeFootballClubFromPL(clubName, regNo);
        }
    }

    private static void displayStatsOnATeam(int pick) throws InputMismatchException{
        if (pick == 1){
            System.out.print("Enter the name of the club : ");
            String clubName = USER_INPUT.nextLine().toLowerCase();
            clubName += USER_INPUT.nextLine().toLowerCase();
            System.out.print("Enter the Registration No. of the club : ");
            int regNo = USER_INPUT.nextInt();

            PLManager.displayStatsOnATeam(clubName, regNo);

        } else if (pick == 2){
            System.out.print("Enter the name of the U-23 club : ");
            String clubName = USER_INPUT.nextLine().toLowerCase();
            clubName += USER_INPUT.nextLine().toLowerCase();
            System.out.print("Enter the Registration No. of the club : ");
            int regNo = USER_INPUT.nextInt();

            U23Manager.displayStatsOnATeam(clubName, regNo);

        } else {
            System.out.print("Enter the name of the U-18 club : ");
            String clubName = USER_INPUT.nextLine().toLowerCase();
            clubName += USER_INPUT.nextLine().toLowerCase();
            System.out.print("Enter the Registration No. of the club : ");
            int regNo = USER_INPUT.nextInt();

            U23Manager.displayStatsOnATeam(clubName, regNo);
        }
    }

    private static void displayPLTable(int pick) {
        if (pick == 1){
            PLManager.displayPLTable();
        } else if (pick == 2){
            U23Manager.displayPLTable();
        } else {
            U18Manager.displayPLTable();
        }
    }

    private static void addAPlayedMatch(int pick) throws ParseException, InputMismatchException {
        System.out.print("Enter the team 1 name : ");
        String team1 = USER_INPUT.nextLine().toLowerCase();
        team1 += USER_INPUT.nextLine().toLowerCase();
        System.out.print("Enter the team 2 name : ");
        String team2 = USER_INPUT.nextLine().toLowerCase();
        team2 +=  USER_INPUT.nextLine().toLowerCase();
        while (true) {
            if (team1.equals(team2)){
                System.out.println("Team 1 and Team 2 can not be the same! try again.");
                System.out.print("Enter the team 2 name : ");
                team2 = USER_INPUT.nextLine().toLowerCase();
                team2 += USER_INPUT.nextLine().toLowerCase();
            } else {
                break;
            }
        }

        System.out.print("Enter team 1 score    : ");
        int team1Score = USER_INPUT.nextInt();
        while (true){
            if (team1Score < 0){
                System.out.println("Invalid Score!");
                System.out.print("Enter team 1 score    : ");
                team1Score = USER_INPUT.nextInt();
            } else {
                break;
            }
        }

        System.out.print("Enter team 2 score    : ");
        int team2Score = USER_INPUT.nextInt();
        while (true){
            if (team2Score < 0){
                System.out.println("Invalid Score!");
                System.out.print("Enter team 1 score    : ");
                team2Score = USER_INPUT.nextInt();
            } else {
                break;
            }
        }

        while (true) {
            System.out.print("Enter the date of the match played in 'dd-mm-yyyy' format : ");
            String date = USER_INPUT.next();

            if (isValid(date)) {
                String[] dateArr = date.split("-",3);
                LocalDate today = LocalDate.now();
                int day = Integer.parseInt(dateArr[0]);
                int month = Integer.parseInt(dateArr[1]);
                int year = Integer.parseInt(dateArr[2]);

                SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
                Date date1 = dateFormat.parse(date);
                if (LocalDate.of(year, month, day).isBefore(LocalDate.of(1992,8,15))){
                    System.out.println("First Premier league was started on 8th August 1992. Enter a date on or after that.\n");
                } else if (today.isAfter(LocalDate.of(year, month, day)) || today.equals(LocalDate.of(year, month, day))) {
                    Match m = new Match(team1, team2, team1Score, team2Score, date1);
                    if (pick == 1){
                        PLManager.addAPlayedMatch(m);
                        break;
                    } else if (pick == 2){
                        U23Manager.addAPlayedMatch(m);
                        break;
                    } else {
                        U18Manager.addAPlayedMatch(m);
                        break;
                    }
                } else {
                    System.out.println("Invalid date! try again.");
                }
            } else {
                System.out.println("Invalid date! try again.");
            }
        }
    }

    public static void saveData() throws IOException {
        while (true) {
            System.out.println("Select a League,");
            System.out.println("Enter '1' for Premier League");
            System.out.println("Enter '2' for U-23 Premier League");
            System.out.println("Enter '3' for U-18 Premier League");
            System.out.println("Enter '4' to save all data");
            int pick = USER_INPUT.nextInt();

            if (pick == 1) {
                PLManager.saveData(PLFootballClubs, PLMatches);
                System.out.println("Data has been successfully saved!");
                break;
            } else if (pick == 2) {
                U23Manager.saveData(U23FootballClubs, U23Matches);
                System.out.println("Data has been successfully saved!");
                break;
            } else if (pick == 3) {
                U18Manager.saveData(U18FootballClubs, U18Matches);
                System.out.println("Data has been successfully saved!");
                break;
            } else if (pick == 4){
                PLManager.saveData(PLFootballClubs, PLMatches);
                U23Manager.saveData(U23FootballClubs, U23Matches);
                U18Manager.saveData(U18FootballClubs, U18Matches);
                System.out.println("Data has been successfully saved!");
                break;
            } else {
                System.out.println("Invalid Input! try again.");
            }
        }
    }

    public static boolean isValid(String dateStr) {
        DateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
        sdf.setLenient(false);
        try {
            sdf.parse(dateStr);
        } catch (ParseException e) {
            return false;
        }
        return true;
    }

    public static int leagueSelection(String title){
        while (true){
            System.out.println(title);
            System.out.println("Enter '1' for Premier League");
            System.out.println("Enter '2' for U-23 Premier League");
            System.out.println("Enter '3' for U-18 Premier League");
            int pick = USER_INPUT.nextInt();

            if (pick == 1 || pick == 2 || pick == 3){
                return pick;
            } else {
                System.out.println("Invalid Input! try again.");
            }
        }
    }
}
