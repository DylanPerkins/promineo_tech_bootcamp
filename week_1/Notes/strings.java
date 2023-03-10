package week_1.Notes;

public class strings {
    public static void main(String[] args) {
        
        String greeting = "hElLo WoRlD";

        System.out.println(greeting); // Outputs: hElLo WoRlD

        System.out.println(greeting.length()); // Outputs: 11

        System.out.println(greeting.toUpperCase()); // Outputs: HELLO WORLD
        System.out.println(greeting.toLowerCase()); // Outputs: hello world


        
        String text = "This is a sample sentence that I can index.";
        
        // The indexOf() method returns the index (the position) of the first 
        // occurrence of a specified text in a string (including whitespace)
        // Note that Java counts positions from zero. 
        // 0 is the first position in a string, 1 is the second, 2 is the third and so on
        
        System.out.println(text.indexOf("sample")); // Outputs: 10



    }
}
