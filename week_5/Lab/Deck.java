package week_5.Lab;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Deck {
    // Fields
    List<Card> cards = new ArrayList<Card>();

    // Constructor
    Deck() {
        String[] suits = { "Clubs", "Diamonds", "Hearts", "Spades" };
        String[] names = { "Two", "Three", "Four", "Five", "Six", "Seven", "Eight", 
                            "Nine", "Ten", "Jack", "Queen", "King", "Ace" };

        for (String suit : suits) {
            int value = 2;
            for (String name : names) {
                Card card = new Card(name, suit, value);
                cards.add(card);
                value++;
            }
        }
    }

    // Methods

    // Describe the deck
    public void describeDeck() {
        for (Card card : cards) {
            card.describeCard();
        }
    }

    // Shuffle the deck
    public void shuffle() {
        Collections.shuffle(cards);
    }

    // Draw a card
    public Card draw() {
        return cards.remove(0);
    }

    // Getters and Setters
    public List<Card> getCards() {
        return cards;
    }

    public void setCards(List<Card> cards) {
        this.cards = cards;
    }


}
