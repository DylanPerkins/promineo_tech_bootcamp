package week_1.Notes;

public class math {
    public static void main(String[] args) {
        
        int x = 4;
        int y = 7;
        int z = 2;
        int f = 64;
        double c = -8.3;


        // The Math.max(x,y) method can be used to find the highest value of x and y:
        System.out.println(Math.max(x, y)); // Outputs: 7

        // The Math.min(x,y) method can be used to find the lowest value of y and z:
        System.out.println(Math.min(y, z)); // Outputs: 2

        // The Math.sqrt(x) method returns the square root of f:
        System.out.println(Math.sqrt(f));   // Outputs: 8.0

        // The Math.abs(x) method returns the absolute (positive) value of x:
        System.out.println(Math.abs(c));    // Outputs: 8.3

        // Math.random() returns a random, `double` type, number between 0.0 and 1.0 by default:
        System.out.println(Math.random());

        // You can have greater control over which number comes out too. Such as type and range.
        int randomNumber = (int) (Math.random() * 100); // Converts to an int and is from 0 to 100
        System.out.println(randomNumber); 

    }
}
