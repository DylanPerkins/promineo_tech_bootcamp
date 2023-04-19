package week_6.Homework.War_Game_Full;

import java.util.ArrayList;
import java.util.List;

public class App {
    public static void main(String[] args) {

        // Create a new deck
        Deck deck = new Deck();

        // Shuffle the deck
        deck.shuffleDeck();

        // create hands for each player
        List<Card> player1Hand = new ArrayList<Card>();
        List<Card> player2Hand = new ArrayList<Card>();
        
        // Deal the cards
        for (int i = 0; i < 26; i++) {
            player1Hand.add(deck.drawFromDeck());
            player2Hand.add(deck.drawFromDeck());
        }

        // Add two players
        Player player1 = new Player("Player 1", player1Hand);
        Player player2 = new Player("Player 2", player2Hand);

        // Initalize the round
        int round = 1;

        // Play the game
        while (!player1.getHand().isEmpty() && !player1.getHand().isEmpty()) {

            System.out.println("               | Round " + round + " |               \n");
            round++;

            // Flip a card
            Card player1Card = player1.flipCard();
            Card player2Card = player2.flipCard();

            // Describe the cards
            System.out.println(player1.getName() + " flips: ");
            player1Card.describeCard(player1Card.getValue(), player1Card.getNameOfCard());
            System.out.println(player2.getName() + " flips: ");
            player2Card.describeCard(player2Card.getValue(), player2Card.getNameOfCard());
            System.out.println(" ");

            // Compare the cards
            compareCards(player1, player2, player1Card, player2Card);
        }
        // End the game
        endGame(player1, player2);
    }

    public static String compareCards(Player player1, Player player2, Card player1Card, Card player2Card) {
        String divider = "\n+------------------------------------+\n";
        String winner = "";
        Boolean war = false;

        if (player1Card.getValue() > player2Card.getValue()) {
            // Player 1 wins the round
            System.out.println(player1.getName() + "'s " + player1Card.getNameOfCard() + " beats " + player2.getName()
                    + "'s " + player2Card.getNameOfCard());
            System.out.println("So, " + player1.getName() + " wins the round!");
            System.out.println(divider);

            // Set the winner as Player 1
            winner = player1.getName();

            // If there is a war, do not award cards
            if (war != true) {
                player1.rewardCards(player1, player2, player1Card, player2Card, winner);
            }

        } else if (player1Card.getValue() < player2Card.getValue()) {
            // Player 2 wins the round
            System.out.println(player2.getName() + "'s " + player2Card.getNameOfCard() + " beats " + player1.getName()
                    + "'s " + player1Card.getNameOfCard());
            System.out.println("So, " + player2.getName() + " wins the round!");
            System.out.println(divider);

            // Set the winner as Player 2
            winner = player2.getName();

            // If there is a war, do not award cards
            if (war != true) {
                player2.rewardCards(player1, player2, player1Card, player2Card, winner);
            }

        } else {
            System.out.println("It's a tie! This means WAR!");
            System.out.println(divider);
            war = true;
            war(player1, player2, player1Card, player2Card);
        }

        return winner;

    }

    public static void war(Player player1, Player player2, Card player1Card, Card player2Card) {
        // Check if either player has enough cards to play war
        if (player1.getHand().size() < 4 || player2.getHand().size() < 4) {
            // End the game
            endGame(player1, player2);
        } else {
            // Flip three cards face down (don't care about values)
            Card player1Card1 = player1.flipCard();
            Card player1Card2 = player1.flipCard();
            Card player1Card3 = player1.flipCard();
            Card player2Card1 = player2.flipCard();
            Card player2Card2 = player2.flipCard();
            Card player2Card3 = player2.flipCard();

            // Flip a fourth card face up (we care about these values)
            Card player1Card4 = player1.flipCard();
            Card player2Card4 = player2.flipCard();

            // Describe the cards
            // System.out.println(player1.getName() + " flips: ");
            // player1Card4.describeCard(player1Card4.getValue(), player1Card4.getNameOfCard());
            // System.out.println(player2.getName() + " flips: ");
            // player2Card4.describeCard(player2Card4.getValue(), player2Card4.getNameOfCard());

            // Compare the cards
            String winner = compareCards(player1, player2, player1Card4, player2Card4);

            if (winner.equals(player1.getName())) {
                // Player 1 wins the war
                // System.out.println(player1.getName() + " wins the war!");
                // System.out.println("So, " + player1.getName() + " wins the round!");

                // Add the inital cards to the winner's hand
                player1.getHand().add(player1Card);
                player1.getHand().add(player2Card);

                // Add the war cards to the winner's hand
                player1.getHand().add(player1Card1);
                player1.getHand().add(player1Card2);
                player1.getHand().add(player1Card3);
                player1.getHand().add(player1Card4);
                player1.getHand().add(player2Card1);
                player1.getHand().add(player2Card2);
                player1.getHand().add(player2Card3);
                player1.getHand().add(player2Card4);

            } else if (winner.equals(player2.getName())) {
                // Add the inital cards to the winner's hand
                player2.getHand().add(player1Card);
                player2.getHand().add(player2Card);

                // Add the war cards to the winner's hand
                player2.getHand().add(player1Card1);
                player2.getHand().add(player1Card2);
                player2.getHand().add(player1Card3);
                player2.getHand().add(player1Card4);
                player2.getHand().add(player2Card1);
                player2.getHand().add(player2Card2);
                player2.getHand().add(player2Card3);
                player2.getHand().add(player2Card4);
            }
        }
    }

    public static void endGame(Player player1, Player player2) {
        String divider = "\n+------------------------------------+\n";
        System.out.println(divider);
        System.out.println("             | Game Over |             ");
        System.out.println(divider);

        if (player1.getHand().size() > player2.getHand().size()) {
            System.out.println(player1.getName() + " wins the game!");
        } else if (player2.getHand().size() > player1.getHand().size()) {
            System.out.println(player2.getName() + " wins the game!");
        }
    }
}
