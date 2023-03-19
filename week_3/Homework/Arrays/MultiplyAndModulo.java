package week_3.Homework.Arrays;

// Task:

// Given 3 already defined variables; num1, num2, and num3.
// - Multiply num1 and num2 together.
// - Find the remainder of that product (num1 * num2) when divided by num3 (Hint: Use %)
// - Do the entire operation in one line and assign the answer to the variable myAnswer.
// - Make sure you use the normal order of operations (PEMDAS).

public class MultiplyAndModulo {
    public static void main(String[] args) {
        
        int num1, num2, num3;
        num1 = 3;
        num2 = 3;
        num3 = 2;

        int myAnswer = (num1 * num2) % num3;
        System.out.println(myAnswer);
    }
}
