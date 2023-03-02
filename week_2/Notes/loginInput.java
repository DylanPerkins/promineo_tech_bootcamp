package promineo_tech_bootcamp.week_2.Notes;

import java.util.Scanner;

public class loginInput {
    public static void main(String[] args) {

        boolean loggedIn = false;
        Scanner sc = new Scanner(System.in);
        int failedLogin = 0;

        while (!loggedIn) {
            System.out.println("Enter username: ");
            String username = sc.nextLine();

            System.out.println("Enter password: ");
            String password = sc.nextLine();

            if (username.equals("samy123") && password.equals("12345")) {
                System.out.println("Welcome back " + username);
                loggedIn = true;
            } else if (failedLogin == 3) {
                System.out.println("Login failed, try again later");
                return;
            } else {
                failedLogin ++;
                System.out.println("Inaccurate credentials. Please try again");
            }
        }
    }
}
