package week_4.Notes;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class DifferentCollections {
    public static void main(String[] args) {
        
        /*
         * Lists
         * 
         * List<E> where E is the element type
         * 
         * Allows for duplicate elements
         * Keeps the order of the elements
         * Allows for null values
         * 
         * Common implementations:
         * - ArrayList
         * - LinkedList
         * - Vector
         * - Stack
         * 
         */

        System.out.println("\nStarting lists:");
        
        List<String> students = new ArrayList<>();
        students.add("John");
        students.add("Jeff");
        students.add("John");
        students.add("John");

        for (String student : students) {
            System.out.println(student);
        }

        System.out.println(students.get(0)); // John
        System.out.println(students.get(1)); // Jeff


        /*
         * Sets
         * 
         * Set<E> where E is the element type
         * 
         * Does not allow duplicate elements, only one null as well
         * Does not keep the order of the elements
         * Allows for null values
         * 
         * Common implementations:
         * - HashSet
         * - LinkedHashSet
         * - TreeSet
         * 
         */

        System.out.println("\nStarting sets:");
        
        Set<String> states = new HashSet<>();
        states.add("California");
        states.add("Texas");
        states.add("California");
        states.add("Massachusetts");
        states.add(null);

        System.out.println(states.size()); // 4
        System.out.println(states.contains("California")); // true
        System.out.println(states.contains("New York")); // false
        states.remove("California");

        if (states.contains("California")) {
            System.out.println("California is in the set");
        } else {
            System.out.println("California is not in the set");
        }

        for (String state : states) {
            System.out.println(state);
        }

        /*
         * Maps
         * 
         * Map<K, V> where K is the key and V is the value
         * 
         * Stores key-value pairs (like a dictionary)
         * Does not allow duplicate keys, only one null as well
         * Allows for duplicate values
         * Does not keep the order of the elements
         * Allows for null values
         * 
         * Common implementations:
         * - HashMap
         * - LinkedHashMap
         * - TreeMap
         * - Hashtable
         * - Properties
         * 
         */

        System.out.println("\nStarting maps:");

        Map<Integer, String> racerPlacements = new HashMap<>();
        racerPlacements.put(1, "John");
        racerPlacements.put(2, "Jeff");
        racerPlacements.put(3, "Joseph");

        System.out.println(racerPlacements.get(1)); // John

        // Key-Set method
        Set<Integer> racerKeys = racerPlacements.keySet(); // [1, 2, 3] 
        for (Integer key : racerKeys) {
            System.out.println(key + " - " + racerPlacements.get(key)); 
        }

        Collection<String> racerValues = racerPlacements.values(); // [John, Jeff, Joseph]
        for (String value : racerValues) {
            System.out.println(value);
        }


        Map<String, String> dictionary = new HashMap<>();
        dictionary.put("August", "The eighth month of the year");
        dictionary.put("Augment", "To make something greater");
        dictionary.put("Devastating", "Causing great damage");

        System.out.println(dictionary.get("August"));

    }
}
