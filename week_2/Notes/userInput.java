package week_2.Notes;

import java.util.Scanner;


// This method is NOT recommended for any type of way for production code.
// Debugger gives 'resource leak' error as well for 'sc'

public class userInput {
    public static void main(String[] args) {
        // System.in is a standard input stream.
        // 'sc' is the scanner variable
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter your name: ");
        String name = sc.nextLine(); 

        System.out.println("\nWelcome " + name + "\n");

        int selection = 0;
        double total = 0;

        while (selection != 4) {
        System.out.println("Select an option.");
        System.out.println("1) Add a candybar to the shopping cart: $1.99");
        System.out.println("2) Add a cheese to the shopping cart: $4.99");
        System.out.println("3) Add a eggs to the shopping cart: $8.99");
        System.out.println("4) Check out.");

        selection = sc.nextInt();

        switch (selection) {
            case 1:
                total += 1.99;
                break;
            case 2:
                total += 4.99;
                break;
            case 3:
                total += 8.99;
                break;
            case 4:
                break;
            default:
                System.out.println("Please pick a valid option");        
            }
        }
        System.out.println("Your current total is: " + total);

        sc.close();

    }
}

