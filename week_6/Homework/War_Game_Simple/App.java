package week_6.Homework.War_Game_Simple;

public class App {
    public static void main(String[] args) {

        // Create a new deck
        Deck deck = new Deck();

        // Shuffle the deck
        deck.shuffleDeck();

        // Add two players
        Player player1 = new Player();
        Player player2 = new Player();

        // Set the player names
        player1.setName("Player 1");
        player2.setName("Player 2");

        // create a new hand for each player
        player1.setHand(deck.getCards());
        player2.setHand(deck.getCards());

        // Deal the cards
        for (int i = 0; i < 26; i++) {
            player1.draw(deck);
            player2.draw(deck);
        }

        // Initalize the round
        int round = 1;

        // Play the game
        while (!player1.getHand().isEmpty() && !player2.getHand().isEmpty()) {
            
            for (int i = 1; i <= 26; i++) {
                System.out.println("         | Round " + round + " of 26 |         \n");
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

            // Check if the game is over
            if (player1.getScore() > player2.getScore()) {
                System.out.println(player1.getName() + " wins the game!");
                break;
            } else if (player2.getScore() > player1.getScore()) {
                System.out.println(player2.getName() + " wins the game!");
                break;
            } else {
                System.out.println("It's a tie!");
                break;
            }
        }
    }

    public static void compareCards(Player player1, Player player2, Card player1Card, Card player2Card) {
        String divider = "\n+------------------------------------+\n";

        if (player1Card.getValue() > player2Card.getValue()) {
            // Player 1 wins
            player1.incrementScore();
            System.out.println(player1.getName() + "'s " + player1Card.getNameOfCard() + " beats " + player2Card.getNameOfCard());
            System.out.println("So, " + player1.getName() + " wins the round!");
            System.out.println(player1.getName() + " now has " + player1.getScore() + " points.");
            System.out.println(divider);
        } else if (player1Card.getValue() < player2Card.getValue()) {
            // Player 2 wins
            player2.incrementScore();
            System.out.println(player2.getName() + "'s " + player2Card.getNameOfCard() + " beats " + player1Card.getNameOfCard());
            System.out.println("So, " + player2.getName() + " wins the round!");
            System.out.println(player2.getName() + " now has " + player2.getScore() + " points.");
            System.out.println(divider);
        } else {
            System.out.println("It's a tie!");
            System.out.println(divider);
        }

    }
}
