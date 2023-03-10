package week_2.Notes;

public class loops {
    public static void main(String[] args) {
        // 'for' loops are good when you know how many times you want to 
        // iterate. Or when you have a defined set of data

        // ++ is the same as + 1 to a variable
        for (int i = 0; i < 10; i ++) { 
            System.out.println(i);
        }

        for (int i = 1; i <= 10 ; i++) {
            System.out.println(i);
        }

        // +=x where 'x' is a defined int, will increment the variable 'i' by x
        for (int i = 0; i < 100; i += 5) {
            if (i % 2 == 0) { // You can use this to print out only the even numbers in a set, no matter what
                System.out.println(i);
            }
        }


        // 'while' a condition is true, its function will execute 
        int x = 0; // Will loop if x is less than 10 without an exit (x++ in this case)
        while (x < 10) {
            System.out.println(x);
            x++;
        }


        // has the possibility of never running if its Boolean expression 
        // evaluates to false the first time
        // And, a 'do while' loop will always execute at least once since the expression is at the end.
        do {
            System.out.println(x);
            x++;
        } while (x < 2);


    }
}
