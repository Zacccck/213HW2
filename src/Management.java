/**
 * Management class,driver from Fulltime.
 * This class store profile information and payment of a full-time employee with a management role
 *
 * @author Yuan zhao,Alexander Galvan
 */
public class Management extends Fulltime {
    private String title;

    /**
     * @param profile        information about fulltime employee
     * @param salary         salary for employee
     * @param managementCode management role code 1=Manager;2=DepartmentHead;3=Director
     */
    public Management(Profile profile, double salary, int managementCode) {
        super(profile, salary);
        double overTimePay = 0;
        if (managementCode == 1) {
            overTimePay = 5000;
            this.title = "Manager";
        } else if (managementCode == 2) {
            overTimePay = 9500;
            this.title = "DepartmentHead";
        } else if (managementCode == 3) {
            overTimePay = 12000;
            this.title = "Director";
        }
        super.setOverTimePay(overTimePay);
    }

    /**
     * Calculate total payment of manager employee.
     */
    @Override
    public void updatePayment() {
        super.updatePayment();
    }

    @Override
    public boolean equals(Object obj) {
        return super.equals(obj);
    }

    @Override
    public String toString() {
        return super.toString() + "::" + title + " Compensation $" + String.format("%,.2f", super.getPeriodicCompensation());
    }
}