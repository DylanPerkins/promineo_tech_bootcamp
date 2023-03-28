package week_5.Notes.OOP_Menu_App;

public class Player {
    
    // Instance Variables
    private String name;
    private String position;
    private String specialty;

    // Constructor
    public Player(String name, String position, String specialty) {
        this.name = name;
        this.position = position;
        this.specialty = specialty;
    }

    // Print Player's Info
    public void printPlayer() {
        System.out.println("Name: " + name);
        System.out.println("Position: " + position);
        System.out.println("Specialty: " + specialty);
        System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
    }

    // Getters and Setters

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public String getSpecialty() {
        return specialty;
    }

    public void setSpecialty(String specialty) {
        this.specialty = specialty;
    }



}
