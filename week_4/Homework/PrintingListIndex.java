package week_4.Homework;

import java.util.ArrayList;
import java.util.List;

/*
 * Task: 
 * 
 * Given a List of Character called alphabet;
 * - search the list for the Character stored in userLetter
 * - print to the console the index value of that Character.
 * 
 */

public class PrintingListIndex {
    public static void main(String[] args) {
        char userLetter = 'n';
		
		List<Character> alphabet = new ArrayList<>();
		for (int i = 97; i < (97+26); i++) {
		    alphabet.add((char) i);
		}
		
		findLetter(alphabet, userLetter);
    }

    static void findLetter(List<Character> alphabet, char userLetter) {
        int index = alphabet.indexOf(userLetter);

        System.out.println(index);
    }
}
