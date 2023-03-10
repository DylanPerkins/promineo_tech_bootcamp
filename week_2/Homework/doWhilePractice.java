package week_2.Homework;

import java.util.Scanner;

public class doWhilePractice {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
		String userWord = in.nextLine();
		int wordLength = userWord.length();
		int counter = wordLength;

		do {
		    System.out.println(userWord);
		    if ( wordLength < 5 ) {
		        break;
		    } 
		    counter--;
		} while ( counter > 0 );

		in.close();
        /*
         * Check the length of userWord
         * If word is less than 5 char, print userWord
         * 
         * If word is 5 or more char, print word counter times
         */
    }
}
