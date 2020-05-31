package Time;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        Time a = new Time(12,54,0);
        while (true){
        a = a.NextSecondTime();
        //a = a.PreviousSecondTime();
        System.out.println(a.toString());
        Thread.sleep(1000);
        }
    }
}
