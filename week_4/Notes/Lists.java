package week_4.Notes;

import java.util.ArrayList;
import java.util.List;

public class Lists {
    public static void main(String[] args) {

        // String[] cars = new String[4];
        // Arrays are fixed in size, so you must specify the size when you create it
        // and you cannot change the size later, and must be explicitly initialized
        String[] cars = {"Volvo", "BMW", "Ford", "Mazda"};
        System.out.println(cars[0]); // Volvo

        // ArrayLists are dynamic in size, so you do not need to specify the size when
        // you create it, and you can add or remove elements later
        List<String> sports = new ArrayList<>(); 
        sports.add("Soccer");       // add an element to the end of the list [0]
        sports.add("Basketball");   // add an element to the end of the list [1]
        sports.add("Baseball");     // add an element to the end of the list [2]
        sports.add("Football");     // add an element to the end of the list [3]
        // sports.remove(0)           // remove the element at index 0    

        // Basic for loop
        for (int i = 0; i < sports.size(); i++) { // sports.size() = 4 , so i < 4
            System.out.println(sports.get(i)); // Soccer, Basketball, Baseball, Football
        }

        // Enhanced for loop
        for (String sport : sports) {
            System.out.println(sport); // Soccer, Basketball, Baseball, Football
        }

        // List of integers
        List<Integer> numbers = new ArrayList<>();
        numbers.add(1);
        numbers.add(2);
        numbers.add(3);
        numbers.add(4);

        // .isEmpty() returns true if the list is empty, false otherwise
        if (numbers.isEmpty()) {
            System.out.println("The list is empty");
        } else {
            System.out.println("The list is not empty");
        }

        // Enhanced for loop
        for (int number : numbers) {
            System.out.println(number); // 1, 2, 3, 4
        }

    }
}
