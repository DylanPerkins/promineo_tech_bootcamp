package week_3.Homework.Arrays;

// Task:

//Given an array of words, do the following:
// - Create a new array that is big enough to hold all of the 
// words from the original array, as well as the three new words.
// - Write a loop to get the words from the original array, and put
//  them into the new array.
// - Add the new words into the new array.
// - When the new array is complete, Loop through the new array 
// and print each element to the console.


public class BuildANewArray {
    public static void main(String[] args) {
        String[] arr = {"Astros", "Reds", "Phillies", "Dodgers", "Angels"};
        String word1 = "Yankees";
        String word2 = "Orioles";
        String word3 = "Mariners";

        String[] newArr = new String[arr.length + 3];
        for (int i = 0; i < arr.length; i++) {
            newArr[i] = arr[i];
        }
        newArr[arr.length] = word1;
        newArr[arr.length + 1] = word2;
        newArr[arr.length + 2] = word3;

        for (int i = 0; i < newArr.length; i++) {
            System.out.println(newArr[i]);
        }
    }
}
