package week_3.Notes;

public class Objects {
    public static void main(String[] args) {

        String name = "Dylan Perkins";

        System.out.println("The length of your name is " + name.length() + " characters.");
        System.out.println(name.charAt(0)); // Prints char at the x index
        System.out.println(name.indexOf('k')); // Prints the index of the first instance of char 'k'

        int [] numbers= new int[3];
        System.out.println(numbers.length); // Even though it's empty, it still has a defined length
    }
}