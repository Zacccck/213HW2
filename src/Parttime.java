/**
 * Parttime class,driver from Employee.
 * This class store profile information and payment of one employee
 *
 * @author Yuan zhao,Alexander Galvan
 */
public class Parttime extends Employee {
    private double hourlyRate;
    private int hoursWorked;

    public Parttime(Profile profile) {
        super(profile);
    }

    public Parttime(Profile profile, double hourlyRate) {
        super(profile);
        this.hourlyRate = hourlyRate;
    }

    /**
     * Calculate total payment of part time employee
     */
    @Override
    public void updatePayment() {
        double payment = this.hourlyRate * this.hoursWorked;
        int overtimeHours = 0;
        int normalHoursPerWeek = 80;
        double overtimeTimes = 1.5;
        if (this.hoursWorked > normalHoursPerWeek) {
            payment = this.hourlyRate * normalHoursPerWeek;
            overtimeHours = this.hoursWorked - normalHoursPerWeek;
        }
        payment += overtimeHours * overtimeTimes * this.hourlyRate;
        super.setPayment(payment);
    }


    @Override
    public boolean equals(Object obj) {
        return super.equals(obj);
    }


    @Override
    public String toString() {
        return super.toString() + "PART TIME" + "::" + "Hourly Rate $"
                + String.format("%,.2f", this.hourlyRate) + "::"
                + "Hours worked this period: " + this.hoursWorked;
    }

    /**
     * Set the hours of worked
     *
     * @param hoursWorked of one payment period
     */
    public void setHoursWorked(int hoursWorked) {
        this.hoursWorked = hoursWorked;
    }

    /**
     * Set the hours of worked
     *
     * @return hours of a payment period
     */
    public int getHoursWorked() {
        return hoursWorked;
    }
}