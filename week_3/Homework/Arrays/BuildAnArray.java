package week_3.Homework.Arrays;

import java.util.Arrays;

// Task: 

// In the method buildArray you will take the integer value stored in 
// the variable num and build an array of that size called numArray. 
// To fill the array, you will write a for loop that starts with an 
// iterator of zero (0) and checks to see if the iterator is less 
// than num and add the value of that iterator to one of the slots 
// in numArray indexed by the iterator. Return the variable numArray.

public class BuildAnArray {
    public static void main(String[] args) {

        int num = 8;

        System.out.println("Your array is: ");
        System.out.println(Arrays.toString(buildArray(num)));
        // Output: [0, 1, 2, 3, 4, 5, 6, 7]
    }

    public static int[] buildArray(int num) {
        int[] array = new int[num];

        for (int i = 0; i < array.length; i++) {
            array[i] = i;
        }
        return array;
    }

}
