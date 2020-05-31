
package Triangle;

import java.util.Scanner;

public class myTriangle extends theLine{
    private myPoint2D a;
    Scanner cin = new Scanner(System.in);
    
    public myTriangle(myPoint2D a, myPoint2D pBegin, myPoint2D pEnd) {
        super(pBegin, pEnd);
        this.a = a;
    }

    public void nhap() {
        System.out.println("Nhap x:");
        myPoint2D x = new myPoint2D(cin.nextInt(), cin.nextInt());
        System.out.println("Nhap y:");
        myPoint2D y = new myPoint2D(cin.nextInt(), cin.nextInt());
        System.out.println("Nhap z:");
        myPoint2D z = new myPoint2D(cin.nextInt(), cin.nextInt());
        this.a = x; 
        setpBegin(y);
        setpEnd(z);
    }
    
    public myPoint2D getA() {
        return a;
    }

    public void setA(myPoint2D a) {
        this.a = a;
    }   
    
    public void setALL(myPoint2D x, myPoint2D y , myPoint2D z ){
        setA(x);
        setpBegin(y);
        setpEnd(z);
    }
    
    public double dientich(){
        double p = chuvi();
        double a = this.a.distanceEuclid(getpBegin());
        double b = this.a.distanceEuclid(getpBegin());
        double c = this.a.distanceEuclid(getpBegin());
        //s = sqrt( p*(p-a)*(p-b)*p-c) )
        return Math.sqrt( p*(p-a)*(p-b)*(p-c) );
    }
    public double chuvi(){
        //p = a+b+c
        return a.distanceEuclid(super.getpBegin())+a.distanceEuclid(super.getpEnd())+super.getpBegin().distanceEuclid(super.getpEnd());
    }
    
    public void swap(myTriangle a){
        myTriangle temp = new myTriangle(null, null, null);
        temp.setALL(a.getA(), a.getpBegin(), a.getpEnd());
        a.setALL(this.a, this.getpBegin(), this.getpEnd());
        this.setALL(temp.getA(), temp.getpBegin(), temp.getpEnd());
    }
    
    @Override
    public String toString() {
        return "myTriangle{" + "a=" + a + " b="+getpBegin()+" c="+getpEnd()+"}";
    }
    
}
