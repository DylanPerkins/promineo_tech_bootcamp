package week_2.Homework;

import java.util.Scanner;

public class concatenateNumOfTimes {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String userWord = in.next();
        String longString = "";


        for (int i = 0; i < userWord.length(); i++) {
            longString += userWord;
        }
 
        System.out.println(longString);

        in.close();
    }
}


// Task: Write a for loop that starts at zero and loops the length of a user-entered String saved in userWord. Every time the loop runs, the userWord is added to the variable longString to make a repeating string. 
// For example, if the userWord was = "Hello", the loop would run 5 times and concatenate the word "Hello" to longString 5 times. The String printed to the console would be "HelloHelloHelloHelloHello"