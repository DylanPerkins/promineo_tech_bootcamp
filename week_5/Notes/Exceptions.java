package week_5.Notes;

public class Exceptions {
    public static void main(String[] args) {

        int[] numbers = {1, 2, 3, 4, 5};

        // Since the array only has 5 elements, the following line will throw an exception.
        // The exception is an ArrayIndexOutOfBoundsException.
        // But since the exception is unchecked, the program will not stop running.
        if (numbers.length > 5) {
            System.out.println(numbers[5]);
        }

        try {
            System.out.println(numbers[5]);
        } catch (Exception e) {
            System.out.println("Exception caught!");
        }

        /*
         * Checked Exceptions
         * - Checked exceptions are exceptions that are checked by the compiler at compile time.
         * - If a method throws a checked exception, the method must either handle the 
         *   exception or declare it using the throws keyword.
         * - If a method handles a checked exception, it must either catch the exception or
         *   declare it using the throws keyword. (Try/Catch)
         * 
         * - Example: Syntax Errors -- a missing semi-colon or closing curly brace, 
         *   incorrect datatype assignment, returning the wrong data type from a method, etc.
         * 
         * 
         * Unchecked Exceptions
         * - Unchecked exceptions are exceptions that are not checked by the compiler at compile time.
         * - If a method throws an unchecked exception, the method does not have to handle the exception.
         * 
         * - Runtime Exception Example: Trying to access a Null Address, Out-of-Bounds Indices
         *      Class: RuntimeException, NullPointerException, ArithmeticException, etc.
         * - Error Exception Example: Serious issues that cause an application to abort, or to stop running, 
         *   including Memory or Stack Overflow Errors
         *      Class: OutOfMemory, StackOverflow, VirtualMachineError, etc.
         * 
         * 
         */

    }
}
