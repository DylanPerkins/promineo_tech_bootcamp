package week_5.Notes.Wages_Project;

public class InherAbstractPolymorphism {
    public static void main(String[] args) {
        
        Employee salary = new SalariedEmployee("Dylan", "Perkins", 2500.00);
        Employee hourly = new HourlyEmployee("John", "Doe", 15.00, 40);
        Employee manager = new Manager("Jeff", "Doe", 5000.00, .15);

        System.out.println(salary.calculatePay());
        System.out.println(hourly.calculatePay());
        System.out.println(manager.calculatePay());
    }
}
