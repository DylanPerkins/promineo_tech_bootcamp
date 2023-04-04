package week_6.Lab;

import java.util.Scanner;

public class TicTacToe {
	public static void main(String[] args) {

		String[][] gameboard = new String[3][3];
		String player1 = "X";
		String player2 = "O";
		String currentPlayer = player1;
		String winner = null;
		int row = 0;
		int column = 0;
		int turn = 0;
		Scanner input = new Scanner(System.in);

		for (int i = 0; i < gameboard.length; i++) {
			for (int j = 0; j < gameboard[i].length; j++) {
				gameboard[i][j] = " ";
			}
		}

		// Initialize the gameboard
		displayGameboard(gameboard);

		// While loop to keep the game going until there is a winner
		while (winner == null) {

			// Grab the row and column from the user
			System.out.println("Player " + currentPlayer + ", please enter a row: ");
			row = input.nextInt() - 1;
			System.out.println("Player " + currentPlayer + ", please enter a column: ");
			column = input.nextInt() - 1;

			// Check to see if the row and column are valid
			if (row < 0 || row > 2 || column < 0 || column > 2) {
				System.out.println("Invalid row or column. Please try again.");
				continue;
			}

			// Check to see if the row and column are already taken
			if (gameboard[row][column].equals("X") || gameboard[row][column].equals("O")) {
				System.out.println("That row and column is already taken. Please try again.");
				continue;
			}

			// Increment the turn
			turn++;

			// Place the player's mark on the board
			gameboard[row][column] = currentPlayer;

			// Update the gameboard
			displayGameboard(gameboard);

			// Check to see if the player has won
			if (checkWinStatus(gameboard, currentPlayer)) {
				winner = currentPlayer;
			}

			// Check to see if the game is a tie
			if (turn == 9 && winner == null) {
				winner = "tie";
			}

			// Switch players
			if (currentPlayer.equals(player1)) {
				currentPlayer = player2;
			} else {
				currentPlayer = player1;
			}
		}

		// Display the winner
		if (winner.equals("tie")) {
			System.out.println("The game is a tie!");
		} else {
			System.out.println("Player " + winner + " wins!");
		}

		input.close();
	}

	public static void displayGameboard(String[][] gameboard) {
		System.out.println("+---+---+---+");
		for (int i = 0; i < gameboard.length; i++) {
			System.out.print("| ");
			for (int j = 0; j < gameboard[i].length; j++) {
				System.out.print(gameboard[i][j] + " | ");
			}
			System.out.println();
			System.out.println("+---+---+---+");
		}
	}

	public static boolean checkWinStatus(String[][] gameboard, String currentPlayer) {
		// Check to see if the player has won
		String winner = null;
		if (gameboard[0][0].equals(currentPlayer) && gameboard[0][1].equals(currentPlayer)
				&& gameboard[0][2].equals(currentPlayer)) {
			winner = currentPlayer;
		} else if (gameboard[1][0].equals(currentPlayer) && gameboard[1][1].equals(currentPlayer)
				&& gameboard[1][2].equals(currentPlayer)) {
			winner = currentPlayer;
		} else if (gameboard[2][0].equals(currentPlayer) && gameboard[2][1].equals(currentPlayer)
				&& gameboard[2][2].equals(currentPlayer)) {
			winner = currentPlayer;
		} else if (gameboard[0][0].equals(currentPlayer) && gameboard[1][0].equals(currentPlayer)
				&& gameboard[2][0].equals(currentPlayer)) {
			winner = currentPlayer;
		} else if (gameboard[0][1].equals(currentPlayer) && gameboard[1][1].equals(currentPlayer)
				&& gameboard[2][1].equals(currentPlayer)) {
			winner = currentPlayer;
		} else if (gameboard[0][2].equals(currentPlayer) && gameboard[1][2].equals(currentPlayer)
				&& gameboard[2][2].equals(currentPlayer)) {
			winner = currentPlayer;
		} else if (gameboard[0][0].equals(currentPlayer) && gameboard[1][1].equals(currentPlayer)
				&& gameboard[2][2].equals(currentPlayer)) {
			winner = currentPlayer;
		} else if (gameboard[0][2].equals(currentPlayer) && gameboard[1][1].equals(currentPlayer)
				&& gameboard[2][0].equals(currentPlayer)) {
			winner = currentPlayer;
		} else {
			winner = null;
		}
		if (winner != null) {
			return true;
		} else {
			return false;
		}

	}
}
