import java.util.Objects;

/**
 * Profile class,store information about a employee,including name, department,hired date.
 *
 * @author Yuan zhao,Alexander Galvan
 */
public class Profile {
    private String name; //employee’s name in the form “lastname,firstname”
    private String department; //department code: CS, ECE, IT
    private Date dateHired;

    /**
     * Profile constructor
     *
     * @param name       of the employee
     * @param department of the employee
     * @param dateHired  hired date of the employee
     */
    public Profile(String name, String department, Date dateHired) {
        this.name = name;
        this.department = department;
        this.dateHired = dateHired;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof Profile) {
            Profile p = (Profile) obj;
            return this.name.equals(p.name) &&
                    this.department.equals(p.department) &&
                    this.dateHired.compareTo(p.dateHired) == 0;
        }
        return false;
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, department, dateHired);
    }

    @Override
    public String toString() {
        return name + "::" + department + "::" + dateHired.toString();
    }

    /**
     * Get name of the employee
     * @return  name
     */
    public String getName() {
        return name;
    }

    /**
     * Department of the employee
     * @return department
     */
    public String getDepartment() {
        return department;
    }

    /**
     * Get hired date of the employee
     * @return hired date
     */
    public Date getDateHired() {
        return dateHired;
    }
}
