package week_2.Homework;

import java.util.Scanner;

public class between1and100 {
    public static void main(String[] args) {
        
        Scanner in = new Scanner(System.in);
        int userNumber = in.nextInt();
        int counter = 0;

        do {
            if (userNumber >= 1 && userNumber <= 100) {
                for (int i = userNumber; i <= 100; i++) {
                    counter = i;
                    System.out.println(i);
                }
            } else {
                System.out.println("Your number was not between 1 and 100.");
                break;
            }
        } while (counter < 100);
        in.close();
    }
}

// Task: If a number is between 1 and 100, print that number and each int up to and including 100. Else, print that the number isnt between 1 and 100
// For Example: If number is 95, program will print 95, 96, 97, 98, 99, 100