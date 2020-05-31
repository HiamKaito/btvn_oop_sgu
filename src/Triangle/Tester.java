
package Triangle;

public class Tester {
    private final myTriangle[] arr = new myTriangle[100];
    private final int n;
    
    public Tester(int n) {
        //nhap cac tam giac
        this.n = n;
        for (int i=0 ; i<n ; i++){
            System.out.println("Tam giac thu "+(i+1));
            arr[i] = new myTriangle(null, null, null);
            arr[i].nhap();
        }
    }
    
    public void xuat(){
        for (int i=0 ; i<n ; i++){
            System.out.println( (i+1) +" "+arr[i].toString());
        }
    }
    
}
