package week_5.Notes.Folder;

public class HourlyEmployee extends Employee {

    private double hoursWorked;

    // super is used to call the constructor of the parent class
    public HourlyEmployee(String firstName, String lastName, double pay, double hoursWorked) {
        super(firstName, lastName, pay);
        this.hoursWorked = hoursWorked;
    }

    @Override
    public double calculatePay() {
        return getPay() * hoursWorked;
    }

}
