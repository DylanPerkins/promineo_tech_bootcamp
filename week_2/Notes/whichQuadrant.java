package week_2.Notes;

import java.util.Scanner;

public class whichQuadrant {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int x = in.nextInt();
        int y = in.nextInt();

        int number;

        if ((x == 0 || y == 0)) {
            number = 0;
            System.out.println("You are not in a quadrant!");
        } else if (x > 0 && y > 0) {
            number = 1;
            System.out.println("You are in quadrant " + number + ".");
        } else if (x < 0 && y > 0) {
            number = 2;
            System.out.println("You are in quadrant " + number + ".");            
        } else if (x < 0 && y < 0) {
            number = 3;
            System.out.println("You are in quadrant " + number + ".");            
        } else if (x > 0 && y < 0) {
            number = 4;
            System.out.println("You are in quadrant " + number + ".");            
        }
    }
}
