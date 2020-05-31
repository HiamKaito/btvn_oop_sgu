package T.Huy;

import java.util.*;

public class MyDate {
    private int year;
    private int month;
    private int day;
    private String[] strMonths = {"Jan","Feb","Mar","Apr","May","Jun",
                                  "Jul","Aug","Sep","Oct","Nov","Dec"};
    private String[] strDays = {"Sunday","Monday","Tuesday","Wednesday",
                                "Thursday","Friday","Saturday"};
    private int[] daysInMonths = {31,28,31,30,31,30,31,31,30,31,30,31};

    public MyDate() {
    }

    public MyDate(int year, int month, int day) {
        this.year = year;
        this.month = month;
        this.day = day;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public int getMonth() {
        return month;
    }

    public void setMonth(int month) {
        this.month = month;
    }

    public int getDay() {
        return day;
    }

    public void setDay(int day) {
        this.day = day;
    }

    @Override
    public String toString() {
        String s = this.strMonths[this.month - 1];
        String ss = strDays[getDayofWeek(this.year, this.month, this.day)];
        return ss+" " + this.day + " " + s + " " +this.year;
    }
    
    public boolean IsLeapYear(int year){
        if ( year%400==0 || (year%4==0 && year%100!=0) )
            return true;
        return false;
    }
    
    public boolean IsvalidDate(int year,int month,int day){
        if ( year<0 || year>9999)
            return false;
        if ( month > 0 && month < 13 ){
            if ( day<=0 || day>31)
                return false;
            if ( IsLeapYear(year) )
                if ( day <=29 && month==2 )
                    return true;
            if ( day <=28 && month==2 )
                return true;
            if ( day <=this.daysInMonths[month-1])
                return true;
        }
            
        return false;
    }
    
    public int getDayofWeek(int year,int month,int day){
        year -= (month<3) ? 1:0;
        int[] t= {0,3,2,5,0,3,5,1,3,6,2,4};
        return (year+year/4-year/100+year/400+t[month-1]+day)%7;
    }
    
}
