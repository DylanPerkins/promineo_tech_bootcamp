package week_2.Homework;

import java.util.Scanner;

public class forLoopPractice {
    public static void main(String[] args) {
        
		Scanner in = new Scanner(System.in);
		int userValue;
		userValue = in.nextInt();

        if (userValue > 0) {
            for (int i = 1; i <= 100; i += userValue) {
                System.out.println(i);
            }
        } else {
            System.out.println("Your number needs to be greater than 0.");
        }
        in.close();
    }
}


// Task: Create a for loop that starts at 1 and goes to 100, but increments by the value of userValue and prints the value of the counter to the console each time the loop processes.

// Also, check to make sure that userValue is greater than 0. 
// If userValue is not greater than 0, print "Your number needs to be greater than 0."