package week_5.Lab;

public class Card {

    // Fields
    private String name;
    private String suit;
    private int value;

    // Constructor(s)
    public Card(String name, String suit, int value) {
        this.name = name;
        this.suit = suit;
        this.value = value;
    }

    // Method(s)
    public void describeCard() {
        System.out.println("Card: " + name + " of " + suit + " with a value of " + value);
    }

    // Getters and Setters
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSuit() {
        return suit;
    }

    public void setSuit(String suit) {
        this.suit = suit;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

}
