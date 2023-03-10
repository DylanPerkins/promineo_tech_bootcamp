package week_2.Homework;

import java.util.Scanner;

public class printingARangeOfInt {
    public static void main(String[] args) {
        
        Scanner in = new Scanner(System.in);
        int x = in.nextInt();

        if (x > 0) {
            for (int i = 0; i <= x; i++) {
                System.out.println(i);
            }
        } else {
            System.out.println("Please enter a number greater than 0.");
        }
        in.close();
    }
}


// Task: Create a for loop that prints the numbers 0 to x to the console using System.out.println() 
// for each number, where x is a value that is provided
/*
 * Check for the value of x to be greater than zero (0).
 * 
 * Print "Please enter a number greater than 0." if less than 0 
 * 
 */