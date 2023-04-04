package week_6.Homework.War_Game_Simple;

public class Card {
    // Fields
    private int value;
    private String nameOfCard;

    // Constructor
    public Card(int value, String nameOfCard) {
        this.value = value;
        this.nameOfCard = nameOfCard;
    }

    // Methods
    public void describeCard(int value, String nameOfCard) {
        System.out.println("Card: " + nameOfCard + " with a value of " + value);
    }

    // Getters and Setters
    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public String getNameOfCard() {
        return nameOfCard;
    }

    public void setNameOfCard(String nameOfCard) {
        this.nameOfCard = nameOfCard;
    }

}
