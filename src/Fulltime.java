/**
 * Fulltime class,driver from Employee.
 * This class store profile information and payment of one employee
 *
 * @author Yuan zhao,Alexander Galvan
 */
public class Fulltime extends Employee {
    private double salary;
    private double overTimePay;

    /*
     * Fulltime Constructor
     * @param profile information about fulltime employee
     * @param salary for employee
     */
    public Fulltime(Profile profile, double salary) {
        super(profile);
        this.salary = salary;
        this.overTimePay = 0;
    }

    /**
     * Calculate total payment of full time employee
     */
    @Override
    public void updatePayment() {
        double payment = (salary + overTimePay) / 26;
        super.setPayment(payment);
    }

    @Override
    public boolean equals(Object obj) {
        return super.equals(obj);
    }

    @Override
    public String toString() {
        return super.toString() + "FULL TIME" + "::" + "Annual Salary $" + String.format("%,.2f", this.salary);
    }

    /**
     * Set the over time payment in a period of time
     *
     * @param overTimePay total annual payment
     */
    public void setOverTimePay(double overTimePay) {
        this.overTimePay = overTimePay;
    }

    /**
     * Get the overtime payment in a pay period.
     *
     * @return overtime payment
     */
    public double getPeriodicCompensation() {
        return this.overTimePay / 26;
    }
}