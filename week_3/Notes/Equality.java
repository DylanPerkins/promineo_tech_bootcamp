package week_3.Notes;

public class Equality {
    public static void main(String[] args) {
        
        String a = new String("Hello");
        String b = new String("Hello");

        System.out.println("a equals: " + a);
        System.out.println("b equals: " + b);
        System.out.println("a == b: " + (a == b));
        System.out.println("equals() method: " + a.equals(b));

        int x = 5;
        int y = 5;

        System.out.println("x equals: " + x);
        System.out.println("y equals: " + y);
        System.out.println("x == y: " + (x == y));
    }
}
