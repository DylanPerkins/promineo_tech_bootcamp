package week_2.Notes;

public class conditionals {
    public static void main(String[] args) {
        
        String name = "Mike";

        // Will only run if the condition is 'true'
        if (name == "Sam") {
            System.out.println("Hello Sam!");            
        } 
        
        // Will only run if the if condition is false
        else {
            System.out.println("You are not Sam, " + name);
        }


        int age = 15;

        if (age >= 16) {
            System.out.println("You can get your driver's permit!");
        } else {
            System.out.println("You are not old enough! Please wait " + (16 - age) + " year(s) to get your permit.");
        }


        // will skip a block until true, if none true then 'else' gets ran
        double costOfMilk = 2.01;
        int numOfMilkToBuy = 0;

        if (costOfMilk <= 2) {
            numOfMilkToBuy = 3;            
        } else if (costOfMilk <= 3) {
            numOfMilkToBuy = 2;
        } else {
            System.out.println("I'm not buying any milk.");
        }
        System.out.println("I'm buying " + numOfMilkToBuy + " gallons of milk.");



        // 'switch' is a programming construct.
        // it creates logical paths with the possibility of multiple options
        char grade = 'D';

        switch (grade) {
            case 'A':
                System.out.println("90%");
                break;
        
            case 'B':
                System.out.println("80%");
                break;
            
            case 'C':
                System.out.println("70%");
                break;
            default:
                System.out.println("0%");
        }
        // You can ommit a break to have a single true statement do two things 



        // You can flatten with an && statment when there's only 'ifs' nested
        if (5 == 5) {
            if (4 == 4) {
                System.out.println("Yes");
            }
        }

        // Nested statement from above
        if (5 == 5 && 4 == 4) {
            System.out.println("Yes Yes");
        }
    }
}
