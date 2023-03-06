package week_2.Notes;

import java.util.Scanner;

public class largerOrSmaller {
    public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int firstNumber = in.nextInt();
		int secondNumber = in.nextInt();        

        if (firstNumber > secondNumber) {
            System.out.println("Larger");
        } else {
            System.out.println("Smaller");
        }        
    }
}
