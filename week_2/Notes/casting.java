package week_2.Notes;

public class casting {
    public static void main(String[] args) {
        
        int myInt = 9;
        double myDouble = myInt;        // Automatic casting: int to double

        System.out.println(myInt);      // Outputs 9
        System.out.println(myDouble);   // Outputs 9.0

    }

    public static void main2(String[] args) {
        
        double myDouble = 9.78d;
        int myInt = (int) myDouble;     // Manual casting: double to int

        System.out.println(myDouble);   // Outputs 9.78
        System.out.println(myInt);      // Outputs 9



    }
}


// Type casting is when you assign a value of one primitive data type to another type.

// In Java, there are two types of casting:

// Widening Casting (automatically) - converting a smaller type to a larger type size
// byte -> short -> char -> int -> long -> float -> double

// Narrowing Casting (manually) - converting a larger type to a smaller size type
// double -> float -> long -> int -> char -> short -> byte