package week_2.Notes;

import java.util.Scanner;

public class whoIsOlder {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
		int personOneAge,personTwoAge, personThreeAge;
		personOneAge = in.nextInt();
		personTwoAge = in.nextInt();
		personThreeAge = in.nextInt();

        if (personOneAge > personTwoAge && personOneAge > personThreeAge) {
            System.out.println("Person one is older.");
        } else if (personTwoAge > personOneAge && personTwoAge > personThreeAge){
            System.out.println("Person two is older.");
        } else {
            System.out.println("Person three is older.");
        }
    }
}
