package week_4.Homework;

import java.util.ArrayList;
import java.util.List;

/*
 * Task:
 * 
 * - Given the four integer numbers stored in the variables num1, num2, num3, and num4
 * - Create a List of integers that contains all of the numbers from num1 to num4, and then 
 *   stores the sum of the numbers in the last element of the List.
 * 
 * - Print the list to the console. 
 * 
 */

public class NewIntList {
    public static void main(String[] args) {
        int num1 = -1;
        int num2 = -2;
        int num3 = -3;
        int num4 = -4;
        int sum = num1 + num2 + num3 + num4;

        List<Integer> intList = new ArrayList<>();
        intList.add(num1);
        intList.add(num2);
        intList.add(num3);
        intList.add(num4);
        intList.add(sum);

        System.out.println(intList);
    }
}
