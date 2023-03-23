package week_4.Homework;

import java.util.ArrayList;
import java.util.List;

/*
 * Task:
 * 
 * Given the numbers stored in the variables; num1, num2, num3, num4, and num5
 * - create a List called squaredNums that takes the values of num1, num2, num3, num4, and num5
 *   and squares each number and adds the squared value into the list. 
 * 
 * 
 * 
 */

public class ListOfSquares {
    public static void main(String[] args) {
        
        int num1 = 1;
        int num2 = 2;
        int num3 = 3;
        int num4 = 4;
        int num5 = 5;

        List<Integer> squaredNums = new ArrayList<>();
        squaredNums.add(num1 * num1);
        squaredNums.add(num2 * num2);
        squaredNums.add(num3 * num3);
        squaredNums.add(num4 * num4);
        squaredNums.add(num5 * num5);
        
    }
}
