package Qly_NhanSu;

import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        HR_Employee list = new HR_Employee();
        list.readFile();
        list.display();
        list.sortbyId(1);
        list.display();
        list.writeFile();
        
        //sap xep bang 2 thuoc tinh thi ta phai lam sao
    }
}
