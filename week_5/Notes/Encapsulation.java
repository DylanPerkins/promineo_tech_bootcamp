package week_5.Notes;

public class Encapsulation {
    public static void main(String[] args) {
        
        Student student1 = new Student();
        student1.setFirstName("Dylan");
        student1.setPhoneNumber("1234567890");
        student1.introduction();

        Rectangle rectangle1 = new Rectangle(10, 20);
        rectangle1.setLength(20);
        System.out.println(rectangle1.getArea());

    }
}
