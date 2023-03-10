package week_2.Homework;

import java.util.Scanner;

public class multiplecationTable {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int num = in.nextInt();

        System.out.println("Multiplication Table of " + num);

        for (int i = 1; i <= 10; i++) {
            System.out.println(num + " x " + i + " = " + num * i);
        }

        in.close();
    }
}
