package week_3.Homework.Methods;

// Task:

// Create a program called fizzBuzz that accepts the integer value 
// stored in num1. If the value is divisible by 3, print "Fizz" to the 
// console. If the value is divisible by 5 print "Buzz" to the console. 
// If the value is divisible by both 3 and 5 print "FizzBuzz" to the 
// console. If the number is not divisible by either 3 or 5, 
// print "Hello world!" to the console.


public class FizzBuzz {
    public static void main(String[] args) {
        int number = 35;

        if (number % 3 == 0 && number % 5 == 0) {
            System.out.println("FizzBuzz");
        } else if (number % 3 == 0) {
            System.out.println("Fizz");
        } else if (number % 5 == 0) {
            System.out.println("Buzz");
        } else {
            System.out.println("Hello world!");
        }
    }
}
