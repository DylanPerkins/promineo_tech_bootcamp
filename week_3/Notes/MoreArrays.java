package week_3.Notes;

public class MoreArrays {
    public static void main(String[] args) {
        
        String[] products = new String[5];

        products[0] = "Carrots";
        products[1] = "Ceareal";
        products[2] = "Pineapples";
        products[3] = "Mac and Cheese";
        products[4] = "PopTarts";

        for (String product : products) {
            System.out.println("Product: " + product);
        }


        int[] multiplesOf3 = new int[10];

        System.out.println("Multiples of 3 loop:");
        for (int i = 1; i <= multiplesOf3.length; i++) {
            multiplesOf3[i - 1] = i * 3;
            System.out.println("Number: " + multiplesOf3[i - 1]);
        }

        int[] multiplesOf5 = new int[10];

        System.out.println("Multiples of 5 loop:");
        for (int i = 0; i < multiplesOf5.length; i++) {
            multiplesOf5[i] = (i + 1) * 5;
            System.out.println("Number: " + multiplesOf5[i]);
        }

    }
}
