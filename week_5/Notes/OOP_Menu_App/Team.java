package week_5.Notes.OOP_Menu_App;

import java.util.ArrayList;
import java.util.List;

public class Team {

    // Instance Variables
    private List<Player> players = new ArrayList<>();
    private String name;

    // Constructor
    public Team(String name) {
        this.setName(name);
    }

    // Add Player to Team
    public void addPlayer(Player player) {
        players.add(player);
    }

    // Remove Player from Team
    public void removePlayer(String player) {
        for (Player p : players) {
            if (p.getName().equals(player)) {
                players.remove(p);
                break;
            }
        }
    }

    // Print Team's Info and Players
    public void printTeam() {
        System.out.println("Team: " + name);
        System.out.println("---------------------------");
        for (Player player : players) {
            player.printPlayer();
        }
    }

    // Getters and Setters

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    
}
