package week_3.Homework.Coding_Assignment;

import java.util.*;

public class HomeworkOne {
    public static void main(String[] args) {

        // Question 1:
        System.out.println("Question 1's answer begins:");
        int[] arrayIntOne = { 3, 9, 23, 64, 2, 8, 28, 93 };
        calculateRangeAndAverage(arrayIntOne);

        // Question 2:
        System.out.println("\nQuestion 2's answer begins:");
        String[] arrayStringOne = { "Sam", "Tommy", "Tim", "Sally", "Buck", "Bob" };
        calculateStringAverageAndConcatenate(arrayStringOne);

        // Question 3
        System.out.println("\nQuestion 3's answer begins:");
        System.out.println(
                "You can access the last element of an array by using the following method "
                        + "on an array, `.length` and substracting 1 from that value, and "
                        + "then using that value as your index position. You'd use it like so, "
                        + "`arrayX[arrayX.length - 1]`");

        // Question 4
        System.out.println("\nQuestion 4's answer begins:");
        System.out.println("You can always access the first element of an array by "
                + "indexing the 0th position, like so, array[0].");

        // Question 5
        System.out.println("\nQuestion 5's answer begins:");
        int stringLength = 0;
        int[] nameLengths = new int[arrayStringOne.length];
        for (int i = 0; i <= (arrayStringOne.length - 1); i++) {
            stringLength = arrayStringOne[i].length();
            nameLengths[i] = stringLength;
        }
        System.out.println(Arrays.toString(nameLengths));

        // Question 6
        System.out.println("\nQuestion 6's answer begins:");
        int question6Sum = 0;
        for (int x : nameLengths) {
            question6Sum += x;
        }
        System.out.println("The sum of the lengths of the strings in the array is: " + question6Sum);

        // Question 7
        System.out.println("\nQuestion 7's answer begins:");
        methodSevenQuestion("Hello", 5);

        // Question 8
        System.out.println("\nQuestion 8's answer begins:");
        methodEightQuestion("John", "Smith");

        // Question 9
        System.out.println("\nQuestion 9's answer begins:");
        int[] arrayIntTwo = { 3, 9, 23, 64, 2, 8, 28, 93};
        boolean question9Answer = methodNineQuestion(arrayIntTwo);
        System.out.println("The answer to question 9 is: " + question9Answer);

        // Question 10
        System.out.println("\nQuestion 10's answer begins:");
        double[] arrayDoubleOne = { 3.0, 9.0, 23.0, 64.0, 2.0, 8.0, 28.0, 93.0 };
        methodTenQuestion(arrayDoubleOne);

        // Question 11
        System.out.println("\nQuestion 11's answer begins:");
        double[] arrayDoubleTwo = { 3.0, 9.0, 23.0, 64.0, 2.0, 8.0, 28.0, 93.0 };
        double[] arrayDoubleThree = { 4.9, 9.29, 4.82, 20.11, 30.0, 15.11, 28.0, 93.0 };
        boolean question11Answer = methodElevenQuestion(arrayDoubleTwo, arrayDoubleThree);
        System.out.println("The answer to question 11 is: " + question11Answer);

        // Question 12
        System.out.println("\nQuestion 12's answer begins:");
        boolean question12Answer = willBuyDrink(false, 12.0);
        System.out.println("The answer to question 12 is: " + question12Answer);

        // Question 13
        System.out.println("\nQuestion 13's answer begins:");
        int[] arrayIntThree = { 82, 44, 67, 52, 120 };
        calculateStandardDeviation(arrayIntThree);
        // The method I created takes a data set of type int and returns the standard deviation of that data set.
        // I created this method as a fun little challenge for myself since I'm in love with math!


    }

    public static void calculateRangeAndAverage(int[] arrayIntX) {
        // Range
        int range = 0;
        int lastNumber = 0;
        lastNumber = arrayIntX[arrayIntX.length - 1];
        range = lastNumber - arrayIntX[0];
        System.out.println("The range of this array is: " + range);

        // Average
        double sum = 0;
        double average = 0;
        for (int x : arrayIntX) {
            sum += x;
        }
        average = (sum / arrayIntX.length);
        System.out.println("The average of this array is: " + average);
    }

    public static void calculateStringAverageAndConcatenate(String[] arrayStringX) {
        // Average
        double sum = 0;
        double average = 0;
        for (String x : arrayStringX) {
            sum += x.length();
        }
        average = sum / arrayStringX.length;
        System.out.printf("The average string length of this array is: %.2f", average);

        // Concatenate
        String fullStringList = "";
        for (String y : arrayStringX) {
            fullStringList += " " + y + " ";
        }
        System.out.println("\nThe full list of items in this list is:" + fullStringList);
    }

    public static void methodSevenQuestion(String stringX, int intX) {
        for (int i = 1; i <= intX; i++) {
            System.out.println(stringX);
        }
    }

    public static void methodEightQuestion(String firstName, String lastName) {
        String fullName = firstName + " " + lastName;
        System.out.println(fullName);
    }

    public static boolean methodNineQuestion(int[] arrayIntX) {
        int sum = 0;
        for (int x : arrayIntX) {
            sum += x;
        }
        if (sum > 100) {
            return true;
        } 
        return false;
    }

    public static void methodTenQuestion(double[] arrayDoubleX) {
        double sum = 0;
        double average = 0;
        for (double x : arrayDoubleX) {
            sum += x;
        }
        average = sum / arrayDoubleX.length;
        System.out.println("The average of this array is: " + average);
    } 

    public static boolean methodElevenQuestion(double[] arrayDoubleX, double[] arrayDoubleY) {
        double sumX = 0;
        double sumY = 0;
        double averageX = 0;
        double averageY = 0;
        for (double x : arrayDoubleX) {
            sumX += x;
        }
        for (double y : arrayDoubleY) {
            sumY += y;
        }
        averageX = sumX / arrayDoubleX.length;
        averageY = sumY / arrayDoubleY.length;
        if (averageX > averageY) {
            return true;
        } 
        return false;
    }

    public static boolean willBuyDrink(boolean isHotOutside, double moneyInPocket) {
        if (isHotOutside && moneyInPocket > 10.50) {
            return true;
        } 
        return false;
    }

    public static void calculateStandardDeviation(int[] arrayIntX) {
        double sum = 0;
        double average = 0;
        double sumOfSquares = 0;
        double standardDeviation = 0;
        for (int x : arrayIntX) {
            sum += x;
        }
        average = sum / arrayIntX.length;
        for (int y : arrayIntX) {
            sumOfSquares += Math.pow((y - average), 2);
        }
        standardDeviation = Math.sqrt(sumOfSquares / arrayIntX.length);
        System.out.println("The standard deviation of this array is: " + standardDeviation);
    }
        











}
