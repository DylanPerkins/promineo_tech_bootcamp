package promineo_tech_bootcamp.week_1;

public class operations {
    public static void main(String[] args) {
        int age = 34;
        System.out.println(age);
        boolean isAge30 = age == 30; // Equality
        System.out.println(isAge30);

        System.out.println(age == 34);

        age = age + 1; // Addition
        System.out.println(age);

        age = age * 2; // Multiplication
        System.out.println(age);

        String firstName = "Dylan";
        String lastName = "Perkins";
        String fullName = firstName + " " + lastName; // Concatenation
        System.out.println(fullName);

    }
    
}

// An operator performs actions on operands
// An operand is a piece of data
// Most operations take TWO operands
// + - * /