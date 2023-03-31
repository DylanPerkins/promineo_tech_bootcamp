package week_5.Lab;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Week05OOPLab {
	public static void main(String[] args) {

		// A standard deck of playing cards has 52 cards as specified below
		// i. There are 4 suits: Clubs, Diamonds, Hearts, & Spades
		//
		// ii. Each suit has 13 cards: Two, Three, Four, Five, Six, Seven,
		// Eight, Nine, Ten, Jack, Queen, King & Ace
		//
		// iii. Comparing Cards: When comparing two cards, Ace is high and Two is low.
		// to make this easy, a Two will have a value of 2, a
		// Three will have a value of 3, ... and an Ace will have
		// a value of 14.
		//



		// 1. Card Class:
		// Create a class called Card to represent a standard playing card.
		// Fields: The Card class should have the following fields:
		// a. name field
		// b. suit field
		// c. value field for comparing against other cards.
		//
		// Methods: This class can have any useful method.
		// a. describe() to display the card information to the Console.
		// b. Getters & Setters
		//
		System.out.println("\nQuestion 1 Start: Card Class");

		Card card1 = new Card("Ace", "Spades", 14); // Defines and instances a new card
		card1.describeCard(); // Calls the describe method on the new card


		// 2. Deck Class:
		// Create a class called Deck.
		// Fields: This class should have a list of Card field called cards
		// that will hold all the cards in the deck.
		// List<Card> cards = new ArrayList<Card>();
		//
		// Constructor: The constructor for the Deck Class should
		// instantiate all 52 standard playing cards and add them to the cards list.
		//
		// Methods:
		// a. describe() to describe the deck to the Console --
		// print out all of the cards in the deck.
		//
		System.out.println("\nQuestion 2: Deck Class");
		// Add your code here to instantiate a Deck

		Deck deck1 = new Deck(); // Defines and instantiates a new deck
		deck1.describeDeck(); // Calls the describe method on the new deck


		// 3. Deck shuffle() Method:
		// Add a shuffle method within the Deck Class
		System.out.println("\nQuestion 3: Deck shuffle() method");
		// Test your method here
		deck1.shuffle();

		// Call the describe method on the newly shuffled deck.
		deck1.describeDeck();


		// 4. Deck draw() Method:
		// Add a draw method within the Deck Class
		System.out.println("\nQuestion 4: Deck draw() method");
		// Test your method here

		// Call the draw method on the deck and print out the card that was drawn.
		Card card2 = deck1.draw();
		card2.describeCard();

		// 5. Create Game Board:
		// Create and test a method that takes an int as a parameter (representing the
		// number of players for a game) and returns a Map<String, List<Card>>
		// that represents each player (i.e. "Player 1", "Player 2", etc..)
		// and their cards.
		//
		// The method should create a new instance of Deck, shuffle it,
		// and deal the cards out to the "players" in the Map.
		System.out.println("\nQuestion 5: Create Game");
		// Call your method here
		int numOfPlayers = 5;
		Map<String, List<Card>> gameBoard = createGame(numOfPlayers);
	
		for (int i = 1; i <= numOfPlayers; i++) {
			System.out.println("-----------------------------------------");
			String player = "Player " + i;
			System.out.println(player + "\n--------");
			List<Card> cards = gameBoard.get(player);
			for (Card card : cards) {
				card.describeCard();
			}
		}

	}

	// Method 5:

	public static Map<String, List<Card>> createGame(int numPlayers) {
		// Create a new instance of Deck
		Deck deck = new Deck();
		// Shuffle the deck
		deck.shuffle();
		// Create a new Map to hold the players and their cards
		Map<String, List<Card>> game = new HashMap<String, List<Card>>();
		// Iteration amount
		int iterations = 52 / numPlayers;

		// Deal the cards to the players
		for (int i = 1; i <= numPlayers; i++) {
			// Create a new player
			String player = "Player " + i;
			// Create a new list of cards for the player
			List<Card> cards = new ArrayList<Card>();
			// Deal 5 cards to the player
			for (int j = 0; j < (iterations); j++) {
				// Draw a card from the deck
				Card card = deck.draw();
				// Add the card to the player's list of cards
				cards.add(card);
			}
			// Add the player and their cards to the game
			game.put(player, cards);
		}
		// Check to see if there are any cards left in the deck
		if (52 % numPlayers != 0) {
			System.out.println("There are " + deck.cards.size() + " cards left in the deck.");
		} else {
			System.out.println("There are no cards left in the deck.");
		}

		// Return the game
		return game;
	}

}
