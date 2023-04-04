package week_6.Homework.War_Game_Simple;

import java.util.List;

public class Player {

    // Fields
    private String name;
    private int score = 0;
    private List<Card> hand;

    // Constructor
    public Player() {
    }

    public Player(String name, List<Card> hand) {
        this.name = name;
        this.hand = hand;
    }

    // Methods

    public void describeHand(String name, List<Card> hand) {
        System.out.println("Player: " + name + " has the following cards in their hand: ");
        for (Card card : hand) {
            card.describeCard(card.getValue(), card.getNameOfCard());
        }

    }

    public Card flipCard() {
        return hand.remove(0);
    }

    public void incrementScore() {
        score++;
    }

    public void draw(Deck deck) {
        hand.add(deck.drawFromDeck());
    }

    // Getters and Setters
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public List<Card> getHand() {
        return hand;
    }

    public void setHand(List<Card> hand) {
        this.hand = hand;
    }
}
