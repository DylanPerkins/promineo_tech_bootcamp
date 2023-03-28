package week_5.Notes.Folder;

public class SalariedEmployee extends Employee {

    // super is used to call the constructor of the parent class
    public SalariedEmployee(String firstName, String lastName, double pay) {
        super(firstName, lastName, pay);
    }

    @Override
    public double calculatePay() {
        return this.getPay() * 80;
    }

}
