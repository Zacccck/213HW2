import java.util.Calendar;
import java.util.StringTokenizer;

/**
 * Date class,parse format date(mm/dd/yyyy) to get year,month and day.
 *
 * @author Yuan zhao,Alexander Galvan
 */
public class Date implements Comparable<Date> {
    private int year;
    private int month;
    private int day;

    private static final int MIN_YEAR = 1900;

    /**
     * Date constructor
     *
     * @param dateStr string of data, format:01/01/2011
     */
    public Date(String dateStr) {
        StringTokenizer dt = new StringTokenizer(dateStr, "/");
        month = Integer.parseInt(dt.nextToken().trim());
        day = Integer.parseInt(dt.nextToken().trim());
        year = Integer.parseInt(dt.nextToken().trim());
    }

    /**
     * Default Date constructor, return current date
     */
    public Date() {
        Calendar c = Calendar.getInstance();
        year = c.get(Calendar.YEAR);
        day = c.get(Calendar.DATE);
        month = c.get(Calendar.MONTH) + 1;
    }

    /**
     * check whether a date is formatted correctly
     *
     * @return true if the date is valid
     */
    public boolean isValid() {
        if (this.day > 31 || this.day < 1) {
            return false;
        }
        if (this.month > 12 || this.month < 1) {
            return false;
        }
        if (this.year < MIN_YEAR) {
            return false;
        }

        Date currentDate = new Date();
        //check if date <=current date
        if (this.compareTo(currentDate) > 0)
            return false;

        //check if day < days of month
        if (this.day > dayOfMonth()) {
            return false;
        }
        return true;
    }

    /**
     * Get the days of one month
     *
     * @return int days
     */
    int dayOfMonth() {
        if (this.month == 4 || this.month == 6 || this.month == 9 || this.month == 11)
            return 30;

        if (this.month == 2) {
            //leap year checking
            if ((this.year % 4 == 0 && this.year % 100 != 0) || (this.year % 400 == 0))
                return 29;
            else
                return 28;
        }
        return 31;
    }


    /**
     * get year of date
     *
     * @return year
     */
    public int getYear() {
        return year;
    }

    /**
     * get month of date
     *
     * @return month
     */
    public int getMonth() {
        return month;
    }

    /**
     * get day of date
     *
     * @return day
     */
    public int getDay() {
        return day;
    }

    @Override
    public String toString() {
        return getMonth() + "/" + getDay() + "/" + getYear();
    }

    @Override
    public int compareTo(Date o) {
        if (this.year == o.year && this.month == o.month && this.day == o.day)
            return 0;

        if (this.year > o.year) {
            return 1;
        } else if (this.year < o.year) {
            return -1;
        }
        if (this.month > o.month) {
            return 1;
        } else if (this.month < o.month) {
            return -1;
        }

        if (this.day > o.day) {
            return 1;
        }
        return -1;
    }
}
