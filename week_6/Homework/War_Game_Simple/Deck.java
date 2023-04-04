package week_6.Homework.War_Game_Simple;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Deck {

    // Fields
    List<Card> cards = new ArrayList<Card>();

    // Constructor
    public Deck() {

        String[] suits = { "Clubs", "Diamonds", "Hearts", "Spades" };
        String[] names = { "Two", "Three", "Four", "Five", "Six", "Seven", "Eight",
                "Nine", "Ten", "Jack", "Queen", "King", "Ace" };
        int value = 2;
        // Loop through the suits and names arrays to create the deck adding an "of"
        // between the two
        for (int i = 0; i < suits.length; i++) {
            for (int j = 0; j < names.length; j++) {
                Card card = new Card(value, names[j] + " of " + suits[i]);
                cards.add(card);
                value++;
            }
            value = 2;
        }

    }

    // Methods
    public void shuffleDeck() {
        Collections.shuffle(cards);
    }

    public Card drawFromDeck() {
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
