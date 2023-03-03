package promineo_tech_bootcamp.week_2.Notes;

import java.util.Scanner;

public class powerLooping {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int base = in.nextInt();
        int power = in.nextInt();
        int result = 1;

        // In this example, we initialize the `result` variable to 1, 
        // and then use a `for` loop to multiply `result` by `base` a 
        // total of `power` times.
        
        for (int i = 1; i <= power; i++) {
            result *= base;
        }
        
        
        // Do not change this code
        System.out.println("Result: "+ result);
    }
    
}
