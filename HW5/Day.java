import java.util.Scanner;

public class Day {
    
    public static void main (String[] args){

        //ask user to enter their birthday
        Scanner scan = new Scanner(System.in);
        System.out.println("Enter the numerical year you were born: ");
        int year = scan.nextInt();
        System.out.println("Enter the numerical month you were born: ");
        int month = scan.nextInt();
        System.out.println("Enter the numerical day you were born: ");
        int day = scan.nextInt();
        Day birthday = new Day(year, month, day);

        //ask user to enter the current date
        System.out.println("Enter the current numerical year: ");
        int currentYear = scan.nextInt();
        System.out.println("Enter the current numerical month: ");
        int currentMonth = scan.nextInt();
        System.out.println("Enter the current numerical day: ");
        int currentDate = scan.nextInt();
        Day currentDay = new Day(currentYear, currentMonth, currentDate);

        scan.close();


        //use user inputted values to calculate the number of days elapsed since they were born
        int daysElapsed = currentDay.daysFrom(birthday);
        System.out.println("You have been alive for " + daysElapsed + " days.");
    }

    public Day(int aYear, int aMonth, int aDate) {
        year = aYear;
        month = aMonth;
        date = aDate;
    }

    public int getYear() {
        return year;
    }

    public int getMonth() {
        return month;
    }

    public int getDate() {
        return date;
    }

    public Day addDays( int n){
        Day result = this;
        while (n > 0) {
            result = result.nextDay();
            n--;
        }
        while(n<0){
            result = result.previousDay();
            n++;
        }
        return result;
    }

    public int daysFrom(Day other){
        int n=0;
        Day d = this;
        while(d.compareTo(other)>0){
            d = d.previousDay();
            n++;
        }
        while(d.compareTo(other)<0){
            d = d.nextDay();
            n--;
        }
        return n;
    }

    private int compareTo(Day other){
        if(year>other.year) return 1;
        if(year<other.year) return -1;
        if(month>other.month) return 1;
        if(month<other.month) return -1;
        return date-other.date;
    }

    private Day nextDay(){
        int y = year;
        int m = month;
        int d = date;
        if(y == GREGIORIAN_START_YEAR && m == GREGORIAN_START_MONTH && d == JULIAN_END_DAY)
            d = GREGORIAN_START_DAY;
        else if(d<daysPerMonth(y,m))
            d++;
        else{
            d = 1;
            m++;
            if(m>DECEMBER){
                m = JANUARY;
                y++;
                if (y==0) y++;
            }
        }
        return new Day(y,m,d);
    }

    private Day previousDay(){
        int y = year;
        int m = month;
        int d = date;
        if(y == GREGIORIAN_START_YEAR && m == GREGORIAN_START_MONTH && d == GREGORIAN_START_DAY)
            d = JULIAN_END_DAY;
        else if(d>1)
            d--;
        else{
            m--;
            if(m<JANUARY){
                m = DECEMBER;
                y--;
                if(y==0) y--;
            }
            d = daysPerMonth(y,m);
        }
        return new Day(y,m,d);
    }

    private static int daysPerMonth(int y, int m){
        int days = DAYS_PER_MONTH[m-1];
        if(m == FEBRUARY && isLeapYear(y)) days++;
        return days;
    }

    private static boolean isLeapYear(int y){
        if(y%4 != 0) return false;
        if(y<GREGIORIAN_START_YEAR) return true;
        return (y%100 != 0) || (y%400 == 0);
    }

    private int year;
    private int month;
    private int date;

    private static final int[] DAYS_PER_MONTH = {31,28,31,30,31,30,31,31,30,31,30,31};

    private static final int GREGIORIAN_START_YEAR = 1582;
    private static final int GREGORIAN_START_MONTH = 10;
    private static final int GREGORIAN_START_DAY = 15;
    private static final int JULIAN_END_DAY = 4;

    private static final int JANUARY = 1;
    private static final int FEBRUARY = 2;
    private static final int DECEMBER = 12;
}
