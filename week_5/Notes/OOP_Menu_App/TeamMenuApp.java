package week_5.Notes.OOP_Menu_App;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class TeamMenuApp {

    static Scanner sc = new Scanner(System.in);
    static List<Team> teams = new ArrayList<>();

    public static void main(String[] args) {

        int choice = 0;
        boolean flag = true;

        while (flag) {
            printOptions();
            choice = sc.nextInt();
            if (choice == 1) {
                teams.add(createNewTeam());
            }  else if (choice == 2) {
                addPlayerToTeam();
            } else if (choice == 3) {
                removePlayerFromTeam();
            } else if (choice == 4) {
                printTeamInfo();
            } else if (choice == 5) {
                break;
            } else {
                System.out.println("Invalid Choice");
            }

        }
    }

    private static void printOptions() {
        System.out.println("1. Create Team");
        System.out.println("2. Add a Player to a Team");
        System.out.println("3. Remove a Player from a Team");
        System.out.println("4. Print Team Info");
        System.out.println("5. Exit");
        System.out.print("Enter Choice: ");
    }

    private static void printTeamInfo() {
        printTeamNames();
        System.out.println("Enter Team Name: ");
        String teamName = sc.next();
        try {
            Team foundTeam = findTeamByName(teamName);
            foundTeam.printTeam();
        } catch (RuntimeException e) {
            System.out.println(e.toString());
        }
    }

    private static Team createNewTeam() {
        System.out.println("Enter Team Name: ");
        String teamName = sc.next();
        return new Team(teamName);        
    }

    public static void addPlayerToTeam() {
        printTeamNames();
        System.out.println("Enter Team Name: ");
        String teamName = sc.next();
        try {
            Team foundTeam = findTeamByName(teamName);
            foundTeam.addPlayer(createPlayer());
        } catch (RuntimeException e) {
            System.out.println(e.toString());
        }
    }

    private static void removePlayerFromTeam() {
        printTeamNames();
        System.out.println("Enter Team Name: ");
        String teamName = sc.next();
        try {
            Team foundTeam = findTeamByName(teamName);
            foundTeam.printTeam();
            System.out.println("Enter Player Name: ");
            String playerName = sc.next();
            foundTeam.removePlayer(playerName);
        } catch (RuntimeException e) {
            System.out.println(e.toString());
        }
    }

    private static Player createPlayer() {
        System.out.println("Enter Player Name: ");
        String playerName = sc.next();
        System.out.println("Enter Player's Position: ");
        String playerPosition = sc.next();
        System.out.println("Enter Player's Speciality: ");
        String playerSpeciality = sc.next();
        return new Player(playerName, playerPosition, playerSpeciality);
    }

    public static void printTeamNames() {
        for (Team team : teams) {
            System.out.println(team.getName());
        }
    }

    public static Team findTeamByName(String teamName) throws RuntimeException{
        for (Team team : teams) {
            if (team.getName().equals(teamName)) {
                return team;
            }
        }
        throw new RuntimeException("Team not found: " + teamName);
    }

}
