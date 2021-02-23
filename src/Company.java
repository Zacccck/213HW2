/**
 * Company Class,store all the employees and number of employees
 *
 * @author Yuan zhao,Alexander Galvan
 */
public class Company {
    private Employee[] emplist;
    private int numEmployee;
    private static final int BUFFER_SIZE = 4;

    public Company() {
        numEmployee = 0;
        this.emplist = new Employee[BUFFER_SIZE];
    }

    /**
     * Find the position of given employee
     *
     * @param employee given employee
     * @return index in emplist,-1 if not find
     */
    private int find(Employee employee) {
        if (employee.getProfile() == null) {
            return -1;
        }
        for (int i = 0; i < numEmployee; i++) {
            if (emplist[i].equals(employee)) {
                return i;
            }
        }
        return -1;
    }

    /**
     * Grow the capacity by 4 if the array is full
     */
    private void grow() {
        int newSize = emplist.length + BUFFER_SIZE;
        Employee[] newEmployeeList = new Employee[newSize];
        for (int i = 0; i < emplist.length; i++) {
            newEmployeeList[i] = emplist[i];
        }
        this.emplist = newEmployeeList;
    }

    /**
     * Add one employee.
     * Check the profile before adding.
     *
     * @param employee should be a new employee
     * @return true if add succeed,false if add before
     */
    public boolean add(Employee employee) {
        if (find(employee) >= 0) {
            return false;
        }
        if (emplist.length == numEmployee) {
            grow();
        }
        emplist[numEmployee] = employee;
        numEmployee++;
        return true;
    }


    /**
     * maintain the original sequence
     *
     * @param employee
     * @return
     */
    public boolean remove(Employee employee) {
        int pos = find(employee);
        if (pos >= 0) {
            for (int i = pos; i < numEmployee - 1; i++) {
                emplist[i] = emplist[i + 1];
            }
            numEmployee -= 1;
            emplist[numEmployee] = null;
            return true;
        }
        return false;
    }


    /**
     * set working hours for a part time
     *
     * @param employee parttime employee
     * @return true if set succeed
     */
    public boolean setHours(Employee employee) {
        if (employee instanceof Parttime) {
            Parttime parttime = (Parttime) employee;
            int hoursWorked = parttime.getHoursWorked();
            if (hoursWorked > 100 || hoursWorked < 0) {
                return false;
            }
            int pos = find(employee);
            if (pos < 0) {
                return false;
            }
            Employee e = emplist[pos];
            //checking if the old employee is a part time employee
            if (e instanceof Parttime) {
                ((Parttime) e).setHoursWorked(hoursWorked);
                return true;
            } else {
                return false;
            }
        }

        return false;
    }

    /**
     * process payments for all employees
     */
    public void processPayments() {
        for (int i = 0; i < numEmployee; i++) {
            emplist[i].updatePayment();
        }
    }

    /**
     * print earning statements for all employees
     */
    public void print() {
        for (int i = 0; i < numEmployee; i++) {
            System.out.println(emplist[i].toString());
        }
    }

    /**
     * Print earning statements by department
     */
    public void printByDepartment() {
        //sort by department first
        for (int i = 0; i < numEmployee; i++) {
            for (int j = 1; j < numEmployee - i; j++) {
                String d1 = emplist[j - 1].getProfile().getDepartment();
                String d2 = emplist[j].getProfile().getDepartment();
                if (d1.compareTo(d2) >= 0) {
                    Employee temp = emplist[j - 1];
                    emplist[j - 1] = emplist[j];
                    emplist[j] = temp;
                }
            }
        }
        for (int i = 0, step = 0; i < numEmployee; i += step) {
            step = 1;
            String dept = emplist[i].getProfile().getDepartment();
            int pos = step + i;
            while (pos < numEmployee && emplist[pos].getProfile().getDepartment().equals(dept)) {
                step++;
                pos = step + i;
            }
            //sort by name
            for (int l = i; l < i + step; l++) {
                for (int j = i + 1; j < i + step - 1; j++) {
                    String name1 = emplist[j - 1].getProfile().getName();
                    String name2 = emplist[j].getProfile().getName();
                    if (name1.compareTo(name2) >= 0) {
                        Employee temp = emplist[j - 1];
                        emplist[j - 1] = emplist[j];
                        emplist[j] = temp;
                    }
                }
            }
        }
        print();
    }

    /**
     * Print earning statements by date hired
     */
    public void printByDate() {
        //sort by hired date
        for (int i = 0; i < numEmployee; i++) {
            for (int j = 1; j < numEmployee - i; j++) {
                Date d1 = emplist[j - 1].getProfile().getDateHired();
                Date d2 = emplist[j].getProfile().getDateHired();
                if (d1.compareTo(d2) >= 0) {
                    Employee temp = emplist[j - 1];
                    emplist[j - 1] = emplist[j];
                    emplist[j] = temp;
                }
            }
        }
        print();
    }

    /**
     * Get number of employees
     *
     * @return number
     */
    public int getNumEmployee() {
        return numEmployee;
    }

    /**
     * Checkout if company has no employee
     *
     * @return true is empty
     */
    public boolean isEmpty() {
        return getNumEmployee() == 0;
    }
}
