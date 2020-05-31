
package Triangle;

import java.util.Scanner;


public class qlyTamgiac {
    private myTriangle[] arr = new myTriangle[100];
    private int n;
    Scanner cin = new Scanner(System.in);
    
    public qlyTamgiac(int n) {
        //nhap cac tam giac
        this.n = n;
        for (int i=0 ; i<arr.length ; i++){
            System.out.println("Traingle "+(i+1));
            System.out.println("Point x:");
            myPoint2D x = new myPoint2D(cin.nextInt(), cin.nextInt());
            System.out.println("Point y:");
            myPoint2D y = new myPoint2D(cin.nextInt(), cin.nextInt());
            System.out.println("Point z:");
            myPoint2D z = new myPoint2D(cin.nextInt(), cin.nextInt());
            arr[i] = new myTriangle(x, y, z);
        }
    }
    
    //them xoa sua
    public void them_tamgiac(){
        System.out.println("Nhap so luong tam giac can them vao:");
        int k = cin.nextInt();
        for(int i=n ; i<n+k ; i++){
            System.out.println("Tam giac thu "+(i+1));
            System.out.println("Nhap x:");
            myPoint2D x = new myPoint2D(cin.nextInt(), cin.nextInt());
            System.out.println("Nhap y:");
            myPoint2D y = new myPoint2D(cin.nextInt(), cin.nextInt());
            System.out.println("Nhap z:");
            myPoint2D z = new myPoint2D(cin.nextInt(), cin.nextInt());
            arr[i] = new myTriangle(x, y, z);
        }
        this.n = n+k;
        xuat();
    }
    
    public void xoa_tamgiac(){
        System.out.println("Ban muon xoa bao nhieu tam giac:");
        int count = cin.nextInt();
        while ( count!=0 ){
            System.out.println("Nhap so thu tu tam giac can xoa:");
            xuat();
            int pos = cin.nextInt();
            pos-=1;
            int temp=0;
            for(int i=0 ; i<n ; i++){
                if( i==pos ){
                    temp=i;
                    break;
                }
            }
            for(int i=temp ; i<n-1 ; i++)
                arr[i]=arr[i+1];
            n--;
            count--;
        }    
        xuat();
    }
    
    public void sua_tamgiac(){
        System.out.println("Nhap so thu tu tam giac can sua:");
        xuat();
        int pos = cin.nextInt();
        pos-=1;
        for(int i=0 ; i<n ; i++){
            if( i==pos ){
                System.out.println("Nhap x:");
                myPoint2D x = new myPoint2D(cin.nextInt(), cin.nextInt());
                System.out.println("Nhap y:");
                myPoint2D y = new myPoint2D(cin.nextInt(), cin.nextInt());
                System.out.println("Nhap z:");
                myPoint2D z = new myPoint2D(cin.nextInt(), cin.nextInt());
                arr[i].setALL(x, y, z);
                break;
            }
        }
        xuat();
    }
    
    public void sapxep_S(int k){
        //tang dan
        if ( k==0 ){
            for (int i=0 ; i<n-1 ; i++){
                for (int j=0; j < n-i-1; j++){
                    if (arr[j].dientich() > arr[j+1].dientich()){
                        arr[j+1].swap(arr[j]);
                    }
                }
            }
        }
        else {
            for (int i=0 ; i<n-1 ; i++){
                for (int j = 0; j < n-i-1; j++){
                    if (arr[j].dientich() < arr[j+1].dientich()){
                        arr[j+1].swap(arr[j]);
                    }
                }
            }
        }
    }
    
    public void sapxep_P(int k){
        //tang dan
        if ( k==0 ){
            for (int i=0 ; i<n-1 ; i++){
                for (int j = 0; j < n-i-1; j++){
                    if (arr[j].chuvi() > arr[j+1].chuvi()){
                        arr[j+1].swap(arr[j]);
                    }
                }
            }
        }
        else {
            for (int i=0 ; i<n-1 ; i++){
                for (int j = 0; j < n-i-1; j++){
                    if (arr[j].chuvi() < arr[j+1].chuvi()){
                        arr[j+1].swap(arr[j]);
                    }
                }
            }
        }
    }
    
    public void xuat(){
        for (int i=0 ; i<n ; i++){
            System.out.println( (i+1)+" "+arr[i].toString());
        }
    }
    
    public void xuat_PvaS(){
        for (int i=0 ; i<n ; i++){
            System.out.println( "Tam giac thu "+(i+1)+" co chu vi:"+arr[i].chuvi()+" va dien tich:"+" "+arr[i].dientich() );
        }
    }
    
}
