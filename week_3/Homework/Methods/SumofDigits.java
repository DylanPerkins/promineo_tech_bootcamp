package week_3.Homework.Methods;

// Task:

// Write a method call sumOfDigits that takes an integer variable 
// called digits. Then return the sum of all the digits in digits. 
// For example, 245 would be 2 + 4 + 5 = 11.

public class SumofDigits {
    public static void main(String[] args) {

        int digits = 245;
        int sum = sumOfDigits(digits);
        System.out.println("The sum of the digits in " + digits + " is " + sum + ".");
    }

    public static int sumOfDigits(int digits) {
        int sum = 0;
        while (digits > 0) {
            sum += digits % 10;
            digits /= 10;
        }
        return sum;
    }
}
