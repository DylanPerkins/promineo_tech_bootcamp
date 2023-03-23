package week_4.Homework;

import java.util.ArrayList;
import java.util.List;

/*
 * Task:
 * 
 * - Create a List of integers that contains the numbers from 1 to the variable endNum.
 * - Print the first element from the List using "The first number in the List is "
 * - Print the last element of the List (without using a hard-coded index), to the console 
 *   using "The last number in the List is: "
 * - Check if endNum is greater than zero (0), otherwise print "Your List cannot be created with a number less than one."
 * 
 */

public class ListOfIntegers {
    public static void main(String[] args) {
        
        int endNum = 10;
        List<Integer> intList = new ArrayList<>();

        // Create a List of integers that contains the numbers from 1 to the variable endNum.
        if (endNum <= 0) {
            System.out.println("Your List cannot be created with a number less than one.");
        } else {
            for (int i = 1; i <= endNum; i++) {
                intList.add(i);
            }

            // Print the first element from the List using "The first number in the List is "
            System.out.println("The first number in the List is: " + intList.get(0));

            // Print the last element of the List (without using a hard-coded index), to the console
            // using "The last number in the List is: "
            System.out.println("The last number in the List is: " + intList.get(intList.size() - 1));

        }

    }
}
