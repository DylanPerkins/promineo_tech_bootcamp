package week_3.Homework.Arrays;

// Task:
// Create an array using five (5) integers provided by the user. 
// Once the array is created, create a new array that is the reverse 
// of the original array. Loop through each array and print each element 
// in the console.


public class ReverseAnArray {
    public static void main(String[] args) {
        int a,b,c,d,e;
        a = 50;
        b = 25;
        c = 0;
        d = 25;
        e = 50;
        reverseArray(a, b, c, d, e);
    }

    public static void reverseArray(int a, int b, int c, int d, int e) {
        int[] arrayOne = {a, b, c, d, e};
        int[] arrayTwo = {e, d, c, b, a};

        for (int i : arrayOne) {
            System.out.println(i);
        }
        for (int i : arrayTwo) {
            System.out.println(i);
        }
    }
}
