package week_3.Homework.Arrays;

public class HottestDay {
    public static void main(String[] args) {
        double sundayTemp = 79.88;
        double mondayTemp = 80.11;
        double tuesdayTemp = 82.11;

        if (sundayTemp > mondayTemp && sundayTemp > tuesdayTemp) {
            System.out.println("Sunday was the hottest day.");
        } else if (mondayTemp > sundayTemp && mondayTemp > tuesdayTemp) {
            System.out.println("Monday was the hottest day.");
        } else if (tuesdayTemp > sundayTemp && tuesdayTemp > mondayTemp) {
            System.out.println("Tuesday was the hottest day.");
        } else {
            System.out.println("There was a tie.");
        }
    }
}
