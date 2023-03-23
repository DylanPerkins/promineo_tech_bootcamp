//
// Copyright (c) 2023 Promineo Tech
// Author:  Promineo Tech Academic Team
// Subject:  StringBuilders, Lists, Sets, & Maps
// Java Week 04 Lab  
//
package week_4.Lab;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class Week04StringBuilderListSetMapLab {

	public static void main(String[] args) {

		// 1. Why would we use a StringBuilder instead of a String?
		// a. Instantiate a new StringBuilder
		// b. Append the characters 0 through 9 to it separated by dashes
		// Note: make sure no dash appears at the end of the StringBuilder

		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < 10; i++) {
			sb.append(i);
			if (i < 9) {
				sb.append("-");
			}
		}
		System.out.println(sb.toString());

		// 2. List of String:
		// a. Create a list of Strings
		// b. Add 5 Strings to it, each with a different length

		List<String> stringList = new ArrayList<>();
		stringList.add("Dylan");
		stringList.add("Perkins");
		stringList.add("is");
		stringList.add("an");
		stringList.add("engineer");
		stringList.add("and");
		stringList.add("a");
		stringList.add("programmer");

		// 3. Write and test a method that takes a list of strings
		// and returns the shortest string

		System.out.println("The shortest string is: " + getShortestString(stringList));

		// 4. Write and test a method that takes a list of strings
		// and returns the list with the first and last element switched

		System.out.println("The list with the first and last elements switched is: " + switchFirstAndLast(stringList));

		// 5. Write and test a method that takes a list of strings
		// and returns a string with all the list elements concatenated to each other,
		// separated by a comma

		System.out.println("The plus plus String List is: " + concatenateWithPlus(stringList));

		// 6. Write and test a method that takes a list of strings and a string
		// and returns a new list with all strings from the original list
		// containing the second string parameter (i.e. like a search method)

		System.out.println(
				"The list with all strings containing the second string parameter is: " + searchList(stringList, "an"));

		// 7. Write and test a method that takes a list of integers
		// and returns a List<List<Integer>> with the following conditions specified
		// for the return value:
		// a. The first List in the returned value contains any number from the input
		// list
		// that is divisible by 2
		// b. The second List contains values from the input list that are divisible by
		// 3
		// c. The third containing values divisible by 5, and
		// d. The fourth all numbers from the input List not divisible by 2, 3, or 5

		List<Integer> intList = new ArrayList<>();
		intList.add(91);
		intList.add(82);
		intList.add(73);
		intList.add(64);
		intList.add(55);
		intList.add(46);
		intList.add(37);
		intList.add(28);
		intList.add(19);
		intList.add(10);
		System.out.println("The list of lists is: " + getDivisibleLists(intList));

		// 8. Write and test a method that takes a list of strings
		// and returns a list of integers that contains the length of each string

		System.out
				.println("The list of integers that contains the length of each string is: " + getLengths(stringList));

		// 9. Create a set of strings and add 5 values

		Set<String> stringSetCars = new HashSet<>();
		stringSetCars.add("Lexus");
		stringSetCars.add("Mercedes");
		stringSetCars.add("BMW");
		stringSetCars.add("Toyota");
		stringSetCars.add("Honda");

		// 10. Write and test a method that takes a set of strings and a character
		// and returns a set of strings consisting of all the strings in the
		// input set that start with the character parameter.

		System.out.println(
				"The set of strings consisting of all the strings in the input set that start with the character parameter is: "
						+ getStringsThatStartWith(stringSetCars, 'T'));

		// 11. Write and test a method that takes a set of strings
		// and returns a list of the same strings

		System.out.println("The list of the same strings is: " + getListOfStrings(stringSetCars));

		// 12. Write and test a method that takes a set of integers
		// and returns a new set of integers containing only even numbers
		// from the original set

		Set<Integer> intSet = new HashSet<>();
		intSet.add(91);
		intSet.add(82);
		intSet.add(73);
		intSet.add(64);
		intSet.add(55);
		intSet.add(46);
		intSet.add(37);
		intSet.add(28);
		intSet.add(19);
		intSet.add(10);
		System.out.println("The set of integers containing only even numbers from the original set is: " + getEvenNumbers(intSet));

		// 13. Create a map of string and string and add 3 items to it where the key of
		// each
		// is a word and the value is the definition of the word

		Map<String, String> stringMap = new HashMap<>();
		stringMap.put("Dylan", "A person");
		stringMap.put("Honda", "A car");
		stringMap.put("Hospital", "A place");

		// 14. Write and test a method that takes a Map<String, String> and a string
		// and returns the value for a key in the map that matches the
		// string parameter (i.e. like a language dictionary lookup)

		System.out.println("The value for a key in the map that matches the string parameter is: "
				+ getDefinition(stringMap, "Dylan"));

		// 15. Write and test a method that takes a List<String>
		// and returns a Map<Character, Integer> containing a count of
		// all the strings that start with a given character

		System.out.println("The map containing a count of all the strings that start with a given character is: "
				+ getCharacterCount(stringList));

	}

	// Method 15:

	public static Map<Character, Integer> getCharacterCount(List<String> stringList) {
		Map<Character, Integer> charMap = new HashMap<>();
		for (String s : stringList) {
			char c = s.charAt(0);
			if (charMap.containsKey(c)) {
				charMap.put(c, charMap.get(c) + 1);
			} else {
				charMap.put(c, 1);
			}
		}
		return charMap;
	}

	// Method 14:

	public static String getDefinition(Map<String, String> stringMap, String s) {
		return stringMap.get(s);
	}

	// Method 12:

	public static Set<Integer> getEvenNumbers(Set<Integer> intSet) {
		Set<Integer> intSet2 = new HashSet<>();
		for (Integer i : intSet) {
			if (i % 2 == 0) {
				intSet2.add(i);
			}
		}
		return intSet2;
	}

	// Method 11:

	public static List<String> getListOfStrings(Set<String> stringSet) {
		List<String> stringList = new ArrayList<>();
		for (String s : stringSet) {
			stringList.add(s);
		}
		return stringList;
	}

	// Method 10:

	public static Set<String> getStringsThatStartWith(Set<String> stringSet, char c) {
		Set<String> stringSet2 = new HashSet<>();
		for (String s : stringSet) {
			if (s.charAt(0) == c) {
				stringSet2.add(s);
			}
		}
		return stringSet2;
	}

	// Method 8:

	public static List<Integer> getLengths(List<String> stringList) {

		List<Integer> intList = new ArrayList<>();
		for (String s : stringList) {
			intList.add(s.length());
		}
		return intList;
	}

	// Method 7:
	public static List<List<Integer>> getDivisibleLists(List<Integer> intList) {
		List<Integer> divByTwo = new ArrayList<>();
		List<Integer> divByThree = new ArrayList<>();
		List<Integer> divByFive = new ArrayList<>();
		List<Integer> divByNoneAbove = new ArrayList<>();

		for (Integer i : intList) {
			if (i % 5 == 0) {
				divByFive.add(i);
			}
			if (i % 3 == 0) {
				divByThree.add(i);
			}
			if (i % 2 == 0) {
				divByTwo.add(i);
			}
			if (i % 2 != 0 && i % 3 != 0 && i % 5 != 0) {
				divByNoneAbove.add(i);
			}
		}

		return Arrays.asList(divByTwo, divByThree, divByFive, divByNoneAbove);
	}

	// Method 6:
	public static String searchList(List<String> stringList, String searchString) {
		List<String> newList = new ArrayList<>();
		for (String string : stringList) {
			if (string.contains(searchString)) {
				newList.add(string);
			}
		}
		return newList.toString();
	}

	// Method 5:
	public static String concatenateWithPlus(List<String> stringList) {
		String fullString = "";
		for (String string : stringList) {
			fullString += string + "+";
		}

		// Removes the last plus sign
		fullString = fullString.substring(0, fullString.length() - 1);
		return fullString;
	}

	// Method 4:
	public static String switchFirstAndLast(List<String> stringList) {
		String firstString = stringList.get(0);
		String lastString = stringList.get(stringList.size() - 1);
		stringList.set(0, lastString);
		stringList.set(stringList.size() - 1, firstString);
		return stringList.toString();
	}

	// Method 3:
	public static String getShortestString(List<String> stringList) {
		String shortestString = stringList.get(0);
		for (String string : stringList) {
			if (string.length() < shortestString.length()) {
				shortestString = string;
			}
		}

		return shortestString;
	}

}
