package week_3.Homework.Arrays;

// Task:
// Write a loop (any type of loop will work) that does a countdown from the variable countDown.

// Implement the following:
// - countDown is an already declared variable representing a user entered number.
// - Check to make sure the number is not larger than 10, but greater than or equal to 3.
// - Each time the loop runs, print the value of the counter followed by three periods (…)
// - Once out of the loop, print "We have lift off!".
// - Use System.out.println() to print everything to the console.
// Note: If the user entered number is less than 3 or greater than 10, 
// then the only message printed to the console is "We have lift off!"

public class CountDown {
    public static void main(String[] args) {
        int countDown = -2;
        boolean mainCondition = countDown <= 10 && countDown >= 3;

        if (mainCondition) {
            for (int i = countDown; i > 0; i--) {
                System.out.println(i + "...");
            }
        } 
        System.out.println("We have lift off!");
    }
}
