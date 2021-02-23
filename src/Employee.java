/**
 * Employee class,store profile information and payment of one employee
 *
 * @author Yuan zhao,Alexander Galvan
 */
public class Employee {
    private Profile profile; // profile representing employee
    private double payment; // compensation

    /**
     * Employee constructor
     *
     * @param profile hold infomation about employee
     */
    public Employee(Profile profile) {
        this.profile = profile;
    }

    /**
     * Calculate total payment,subclass should override this method
     */
    public void updatePayment() {
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof Employee) {
            Employee e = (Employee) obj;
            if (e.profile.equals(this.profile)) {
                return true;
            }
        }

        return false;
    }

    @Override
    public String toString() {
        String payment = String.format("%,.2f", this.getPayment());
        return profile.toString() + "::Payment $" + payment + "::";
    }

    /**
     * Get total payment
     *
     * @return payment
     */
    public double getPayment() {
        return payment;
    }

    /**
     * Set total payment
     *
     * @param payment new payment
     */
    public void setPayment(double payment) {
        this.payment = payment;
    }

    /**
     * Get profile of the employee
     *
     * @return Profile
     */
    public Profile getProfile() {
        return profile;
    }

}