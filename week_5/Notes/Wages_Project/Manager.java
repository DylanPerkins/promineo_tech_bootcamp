package week_5.Notes.Wages_Project;

public class Manager extends Employee {

    private double bonusPercentage;

    public Manager(String firstName, String lastName, double pay, double bonusPercentage) {
        super(firstName, lastName, pay);
        this.bonusPercentage = bonusPercentage;
    }

    @Override
    public double calculatePay() {
        return getPay() * 80 + (getPay() * 80 * bonusPercentage);
    }

}
