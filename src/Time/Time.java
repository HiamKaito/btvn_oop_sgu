package Time;

import java.util.*;

public class Time {
    private int hour;
    private int minute;
    private int second;

    public Time(){
        Random rand = new Random();
        this.hour = rand.nextInt(24);
        this.minute = rand.nextInt(60);
        this.second = rand.nextInt(60);
    }
    
    public Time(int hour, int minute, int second) {
        if ( hour >23 || minute >60 || second >60 ){
            System.out.println("Input error");
        }
        else {
            this.hour = hour;
            this.minute = minute;
            this.second = second;
        }
    }

    public int getHour() {
        return hour;
    }

    public void setHour(int hour) {
        this.hour = hour;
    }

    public int getMinute() {
        return minute;
    }

    public void setMinute(int minute) {
        this.minute = minute;
    }

    public int getSecond() {
        return second;
    }

    public void setSecond(int second) {
        this.second = second;
    }

    public void setTime(int hour, int minute , int second){
        this.hour = hour;
        this.minute = minute;
        this.second = second;
    }
    
    @Override
    public String toString() {
        String hour,min,sec;
        hour = ""+this.hour;
        min = ""+this.minute;
        sec = ""+this.second;
        
        if ( this.hour <10 )
            hour = "0"+this.hour;
        if ( this.minute <10 )
            min = "0"+this.minute;
        if ( this.second <10 )
            sec = "0"+this.second;
        return "Time{" + "hour=" + hour + ", minute=" + min + ", second=" + sec + '}';
    }
    
    public Time NextSecondTime(){
        int hour = this.hour;
        int min = this.minute;
        int sec = this.second;
        sec ++;
        if (sec == 60){
            sec = 0;
            min ++;
        }
        if (min == 60){
            min = 0;
            hour++;
        }
        if (hour == 24){
            hour = 0;
        }
        Time temp = new Time(hour,min,sec);
        return temp;
    }
    
    public Time PreviousSecondTime(){
        int hour = this.hour;
        int min = this.minute;
        int sec = this.second;
        sec --;
        if (sec == -1){
            sec = 59;
            min --;
        }
        if (min == -1){
            min = 59;
            hour--;
        }
        if (hour == -1){
            hour = 24;
        }
        Time temp = new Time(hour,min,sec);
        return temp;
    }
}
