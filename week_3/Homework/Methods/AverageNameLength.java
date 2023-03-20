package week_3.Homework.Methods;

// Task:

// Write a method call avgNameLength that takes in an array of Strings 
// stored in names. The names array will hold 5 names that are entered by 
// the user. The method avgNameLength will traverse the array and find 
// the average length of all the names that are part of names


public class AverageNameLength {
    public static void main(String[] args) {
        
        String[] names = {"Joey", "James", "Robert", "Theodore", "Fred"};

        double sum = 0;
        for (int i = 0; i < names.length; i++) {
            sum += names[i].length();
        }
        double avgLength = sum / names.length;
        System.out.println("The average name length is " + avgLength + ".");
    }
}


