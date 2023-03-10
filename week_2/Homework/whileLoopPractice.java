package week_2.Homework;

import java.util.Scanner;

public class whileLoopPractice {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
		int userNumber = 0;
		userNumber = in.nextInt();  

        if (userNumber > 10 && userNumber < 100) {
            while (userNumber >= 10) {
                System.out.println(userNumber);
                userNumber--;
            }
        } else {
            System.out.println("Your number is not between 10 and 100.");
        }
        in.close();
    }
}

// Task: Create an if/else statement that checks to see if userNumber is more than 10 and under 100.
// If YES, execute a while loop that does the following:
// - prints the value of userNumber
// - decrements by 1 until userNumber is less than 10.
// If NOT, print "Your number is not between 10 and 100." to the console.
