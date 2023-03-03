package promineo_tech_bootcamp.week_2.Notes;

import java.util.Scanner;

public class nestedIf {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int num1 = in.nextInt();
        int num2 = in.nextInt();
        int num3 = in.nextInt();
        int num4 = in.nextInt();

        if (num1 >= num2) {
            if (num3 >= num4) {
                System.out.println("both statements are true");
            }
        }

        System.out.println("program ended");
    }
}
