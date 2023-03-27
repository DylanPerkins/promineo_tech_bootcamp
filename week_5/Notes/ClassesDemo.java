package week_5.Notes;

public class ClassesDemo {
    public static void main(String[] args) {

        Student student1 = new Student();
        student1.setFirstName("Dylan");
        student1.setLastName("Perkins");
        student1.setPhoneNumber("555-555-5555");
        student1.setGradeLevel(12);

        student1.introduction();

        Student student2 = new Student("John", "Doe");
        student2.introduction();

        Student student3 = new Student("Jane", "Doe", "555-555-5555", 12);
        student3.introduction();
    }
}
