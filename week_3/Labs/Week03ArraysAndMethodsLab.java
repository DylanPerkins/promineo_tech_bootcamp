package week_3.Labs;

import java.util.Arrays;

public class Week03ArraysAndMethodsLab {
	public static void main(String[] args) {

		//
		// Arrays:
		//

		// 1. Create an array with the following values 1, 5, 2, 8, 13, 6

		int[] arrayQuestionOne = new int[6];
		arrayQuestionOne[0] = 1;
		arrayQuestionOne[1] = 5;
		arrayQuestionOne[2] = 2;
		arrayQuestionOne[3] = 8;
		arrayQuestionOne[4] = 13;
		arrayQuestionOne[5] = 6;

		// 2. Print out the first element in the array

		System.out.println(arrayQuestionOne[0]);

		// 3. Print out the last element in the array without using the number 5

		System.out.println(arrayQuestionOne[arrayQuestionOne.length - 1]);

		// 4. Print out the element in the array at position 6, what happens?

		// An exception error occurs stating that the indexed position is out of bounds

		// 5. Print out the element in the array at position -1, what happens?

		// An exception error occurs stating that the indexed position is out of bounds

		// 6. Write a traditional for loop that prints out each element in the array

		for (int i = 0; i < arrayQuestionOne.length; i++) {
			System.out.println("Position " + i + " in array: " + arrayQuestionOne[i]);
		}

		// 7. Write an enhanced for loop that prints out each element in the array

		for (int num : arrayQuestionOne) {
			System.out.println(num);
		}

		// 8. Create a new variable called sum, write a loop that adds
		// each element in the array to the sum

		double sum = 0;
		for (int i : arrayQuestionOne) {
			sum += i;
		}
		System.out.println("The sum is: " + sum);

		// 9. Create a new variable called average and assign the average value of the
		// array to it

		double average = sum / arrayQuestionOne.length;
		System.out.println("The array's average is: " + average);

		// 10. Write an enhanced for loop that prints out each number in the array
		// only if the number is odd

		for (int i : arrayQuestionOne) {
			if (i % 2 != 0) {
				System.out.println(i);
			}
		}

		// 11. Create an array that contains the values "Sam", "Sally", "Thomas", and
		// "Robert"

		String[] names = new String[4];
		names[0] = "Sam";
		names[1] = "Sally";
		names[2] = "Thomas";
		names[3] = "Robert";

		// 12. Calculate the sum of all the letters in the new array

		int namesSum = 0;

		for (String name : names) {
			namesSum += name.length();
		}

		System.out.println("Sum of letters in the 'names' array: " + namesSum);

		//
		// Methods:
		//

		// 13. Write and test a method that takes a String name and prints out a
		// greeting.
		// This method returns nothing.

		String personsName = "Dylan";
		greetingString(personsName);

		// 14. Write and test a method that takes a String name and
		// returns a greeting. Do not print in the method.

		greetingStringReturn(personsName);

		// Compare method 13 and method 14:
		// a. Analyze the difference between these two methods.
		// b. What do you find?
		// c. How are they different?

		/*
		 * The method from q13 actually prints out the output of the instructions,
		 * while the method from q14 simply stores the output for later use.
		 */

		// 15. Write and test a method that takes a String and an int and
		// returns true if the number of letters in the string is greater than the int

		System.out.println(numOfCharInStringVS("Dylan", 5));

		// 16. Write and test a method that takes an array of string and a string and
		// returns true if the string passed in exists in the array

		String[] array16 = { "apple", "banana", "cherry", "date" };
		String str1 = "banana";

		System.out.println(method16(array16, str1));

		// 17. Write and test a method that takes an array of int and
		// returns the smallest number in the array

		int[] numbers = { 7, 18, 2, 13, 5, -1, 19, -50, 0 };
		int smallest = method17(numbers);
		System.out.println("The smallest number in the array is: " + smallest);

		// 18. Write and test a method that takes an array of double and
		// returns the average

		double[] numbers2 = { 2.87, 7.95, 18.11, 45.00, 1.95, 4.28 };
		System.out.println(averageDouble(numbers2));

		// 19. Write and test a method that takes an array of Strings and
		// returns an array of int where each element
		// matches the length of the string at that position

		String[] array19 = { "hello", "world", "java" };
		System.out.println(Arrays.toString(stringAndIntArray(array19)));

		// 20. Write and test a method that takes an array of strings and
		// returns true if the sum of letters for all strings with an even amount of
		// letters
		// is greater than the sum of those with an odd amount of letters.

		String[] array20 = { "Hello", "Goodbye", "Heyo", "Good", "Test", "Word" };
		System.out.println(evenSumVersusOddSum(array20));

		// 21. Write and test a method that takes a string and
		// returns true if the string is a palindrome

		String question21 = "RaCEcAr";
		System.out.println(isPalindrome(question21));

	}

	// Method 13:
	public static void greetingString(String x) {
		System.out.println("Hello, " + x + "! How are you?");
	}

	// Method 14:

	public static String greetingStringReturn(String x) {
		return "Hello, " + x + "! How are you today?";
	}

	// Method 15:

	private static boolean numOfCharInStringVS(String x, int y) {
		int stringSum = 0;
		stringSum = x.length();
		if (stringSum > y) {
			return true;
		} else {
			return false;
		}
	}

	// Method 16:

	public static boolean method16(String[] array, String y) {
		for (String s : array) {
			if (s.equals(y)) {
				return true;
			}
		}
		return false;
	}

	// Method 17:

	public static int method17(int[] array) {
		int smallestNum = array[0];
		for (int i : array) {
			if (i < smallestNum) {
				smallestNum = i;
			}
		}

		return smallestNum;
	}

	// Method 18:

	public static double averageDouble(double[] array) {
		double sum = 0;
		double average = 0;
		for (double d : array) {
			sum += d;
		}
		average = sum / array.length;
		return average;
	}

	// Method 19:

	public static int[] stringAndIntArray(String[] array) {
		int[] intArray = new int[array.length];

		for (int index = 0; index < array.length; index++) {
			intArray[index] = array[index].length();
		}
		return intArray;
	}

	// Method 20:

	public static boolean evenSumVersusOddSum(String[] strArray) {
		int sumOfEven = 0;
		int sumOfOdd = 0;

		for (String s : strArray) {
			if (s.length() % 2 == 0) {
				sumOfEven += s.length();
			} else {
				sumOfOdd += s.length();
			}
		}

		if (sumOfEven > sumOfOdd) {
			return true;
		} else {
			return false;
		}
	}

	// Method 21:

	public static boolean isPalindrome(String str) {
		String word1 = str;
		String word2 = "";
		for (int index = str.length() - 1; index >= 0; index--) {
			word2 += str.charAt(index);
		}

		System.out.println(word1);
		System.out.println(word2);
		
		if (word1.equalsIgnoreCase(word2)) {
			return true;
		} else {
			return false;
		}

	}

}
