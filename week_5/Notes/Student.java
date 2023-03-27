package week_5.Notes;

public class Student {
    
    static int numberOfStudents;

    // Properties
    private String firstName;
    private String lastName;
    private String phoneNumber;
    private int gradeLevel;

    // Constructors
    public Student() {
    }

    public Student(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public Student(String firstName, String lastName, String phoneNumber, int gradeLevel) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.phoneNumber = phoneNumber;
        this.gradeLevel = gradeLevel;
    }

    // Methods
    // Can be used to print out the student's information in other classes
    public void introduction() {
        System.out.println("Hello, my name is " + firstName + " " + lastName);
        System.out.println("My phone number is " + phoneNumber);
        System.out.println("I am in grade " + gradeLevel);
    }

    // Can be used to check if the string length is valid, and cannot be used outside of this class
    private Boolean isStringLengthValid(String str, int length) {
        return str.length() > length;
    }

    // Getters and Setters

    // Setter
    public void setFirstName(String firstName) {
        if (isStringLengthValid(firstName, 1)) {
            this.firstName = firstName;
        }
    }

    // Getter
    public String getFirstName() {
        return firstName;
    }

    // Setter
    public void setLastName(String lastName) {
        if (isStringLengthValid(lastName, 0)) {
            this.lastName = lastName;
        }
    }

    // Getter
    public String getLastName() {
        return lastName;
    }

    // Setter
    public void setPhoneNumber(String phoneNumber) {
        if (isStringLengthValid(phoneNumber, 9)) {
            this.phoneNumber = phoneNumber;
        }
    }

    // Getter
    public String getPhoneNumber() {
        return phoneNumber;
    }

    // Setter
    public void setGradeLevel(int gradeLevel) {
        if (gradeLevel > 0 && gradeLevel < 13) {
            this.gradeLevel = gradeLevel;
        }
    }

    // Getter
    public int getGradeLevel() {
        return gradeLevel;
    }

}
