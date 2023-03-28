package week_5.Notes.Wages_Project;

// This class can not be instantiated

// It is an abstract class
// It is a template for other classes

public abstract class Employee {

    private String firstName;
    private String lastName;
    private double pay;
    private String address;
    private String reportsTo;

    protected Employee(String firstName, String lastName, double pay) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.pay = pay;
    }

    // Will not be implemented in this class - Polymorphism
    // Will be implemented in the child classes in their own way
    public abstract double calculatePay();

    public String getInformation() {
        return "Name: " + firstName + " " + lastName
                + "\nReports to: " + reportsTo
                + "\nAddress: " + address;
    }

    // Getters and Setters
    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public double getPay() {
        return pay;
    }

    public void setPay(double pay) {
        this.pay = pay;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getReportsTo() {
        return reportsTo;
    }

    public void setReportsTo(String reportsTo) {
        this.reportsTo = reportsTo;
    }

}
