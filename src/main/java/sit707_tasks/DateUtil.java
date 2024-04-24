package sit707_tasks;

public class DateUtil {

    private static final String[] MONTHS = {
            "January", "February", "March", "April", "May", "June",
            "July", "August", "September", "October", "November", "December"
    };

    private int day, month, year;

    public DateUtil(int day, int month, int year) {
        if (!isValidDate(day, month, year)) {
            throw new IllegalArgumentException("Invalid date: " + day + "/" + month + "/" + year);
        }
        this.day = day;
        this.month = month;
        this.year = year;
    }

    public int getDay() {
        return day;
    }

    public int getMonth() {
        return month;
    }

    public int getYear() {
        return year;
    }

    public void increment() {
        if (day < monthDuration(month, year)) {
      
            day++;
        } else if (month < 12) {
            day = 1;
            month++;
        } else {
            day = 1;
            month = 1;
            year++;
        }
    }


    public void decrement() {
        if (day > 1) {
            day--;
        } else {
            if (month > 1) {
                month--;
                day = monthDuration(month, year);
            } else {
                month = 12;
                year--;
                day = monthDuration(month, year);
            }
        }
    }

    public static int monthDuration(int month, int year) {
        if (month == 2 && isLeapYear(year)) {
            return 29;
        } else if (month == 2) {
            return 28;
        } else if (month == 4 || month == 6 || month == 9 || month == 11) {
            return 30;
        }
        return 31;
    }

    public static boolean isLeapYear(int year) {
        return (year % 4 == 0 && year % 100 != 0) || (year % 400 == 0);
    }



    private boolean isValidDate(int day, int month, int year) {
        return isValidDay(day, month, year) && isValidMonth(month) && isValidYear(year);
    }

    private boolean isValidDay(int day, int month, int year) {
        int maxDay = monthDuration(month, year);
        return day >= 1 && day <= maxDay;
    }

    private boolean isValidMonth(int month) {
        return month >= 1 && month <= 12;
    }

    private boolean isValidYear(int year) {
        return year >= 1700 && year <= 2024;
    }

    @Override
    public String toString() {
        return day + " " + MONTHS[month - 1] + " " + year;
    }
}
