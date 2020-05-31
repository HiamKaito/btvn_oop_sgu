
package Triangle;

import java.util.Scanner;

public class Menu {
    
    public static int k;
    public static String s;
    public static String exit="khong";
    static Scanner cin = new Scanner(System.in);
    static Scanner gets = new Scanner(System.in); 
    public static qlyTamgiac a;
    
    public static void Process(int k){
        switch( k ){
            case 1:
                //Hien thi danh sach tam giac
                a.xuat();
                break;
            case 2:
                //xuat chu vi dien tich
                a.xuat_PvaS();
                break;    
            case 3:
                //them 1 tam giac
                a.them_tamgiac();
                break;    
            case 4:
                //Xoa 1 tam giac
                a.xoa_tamgiac();
                break;
            case 5:
                //Sap xep theo dien tich
                System.out.println("0.Increase");
                System.out.println("1.Decrease");
                k = cin.nextInt();
                a.sapxep_S(k);
                break;
            case 6:
                //Sap xep theo chiu vi
                System.out.println("0.Increase");
                System.out.println("1.Decrease");
                k = cin.nextInt();
                a.sapxep_P(k);
                break;
            case 7:
                //sua thong tin 1 tam giac
                a.sua_tamgiac();
                break;
            case 8:
                //thoat
                exit = "co";
                break;
        }
    }
    
    public static void Form(){  
        System.out.println("Select the number:");
        System.out.println("1.Display Traingles");
        System.out.println("2.Display S and P Traingles");
        System.out.println("3.Add new Traingle");
        System.out.println("4.Delete the Traingle");
        System.out.println("5.Sort book by dien tich");
        System.out.println("6.Sort book by chu vi");
        System.out.println("7.Set information for the Triangle");
        System.out.println("8.EXIT");
    }
    
    public static void Menu(){  
        System.out.println("How many Traingles?:");
        a = new qlyTamgiac( cin.nextInt() );
        do{  
            System.out.printf("Display Menu:(yes or no): ");
            s = gets.nextLine();
            s = s.toLowerCase();
            if ( s.equals("yes") ) Form();     
            k = cin.nextInt();
            Process(k);
        }while ( exit.equals("khong") );
      
        
    }
}
