
package Human;

import java.io.IOException;
import java.util.Scanner;

public class Menu {
    public static int k;
    public static String s;    
    public static String exit="khong";
    public static String filename = null;
    static Scanner cin = new Scanner(System.in);
    static Scanner gets = new Scanner(System.in); 
    public static HRManager list_emp = new HRManager();
    //thong tin ve nhan vien
    public static Address address = new Address("HCM_city", "TAN PHU", "Phuong_nay");
    public static Employee a = new Employee("3121", 100, 2, "Ban hang", "Jonh", 22, address);
    public static Employee b = new Employee("1235", 20, 1, "Rua bat", "Cena", 19, address);
    public static Employee c = new Employee("3213", 300, 5, "Nau an", "Jonh_Cena", 41, address);
    public static Employee d = new Employee("3215", 900, 20, "Giam Doc", "WWR", 30, address);
    public static Employee e = new Employee("3215", 900000, 2000, "Hacker", "Anonymous", 30, address);
    
    public static void defaul_emp(){
        list_emp.addEmployee(a);
        list_emp.addEmployee(b);
        list_emp.addEmployee(c);
        list_emp.addEmployee(d);
        list_emp.addEmployee(e);
    }
    
    public static void Process(int k) throws IOException{
        switch( k ){
            case 1:
                //Hien thi danh sach nhan vien
                if ( list_emp.check_in()==0 )
                    System.out.println("We have no employee");
                else
                    list_emp.display();
                break;
            case 2:
                //them nhan vien
                if ( list_emp.addEmployee( list_emp.fillEmployee()) )
                    System.out.println("Success");
                else
                    System.out.println("We already have that ID");
                break;
            case 3:
                //tim nhan vien
                System.out.println("Enter name employee:");
                s = gets.nextLine();
                if ( list_emp.findEmployee(s) ) 
                    System.out.println("Founded");
                else 
                    System.out.println("We don't have that employee");
                break;
            case 4:
                //sua thong tin 1 nhan vien
                list_emp.display();
                System.out.println("Enter name employee:");
                s=gets.nextLine();
                if ( list_emp.editEmployee(s) ) 
                    System.out.println("Success");
                else 
                    System.out.println("We don't have that employee");              
                break;    
            case 5:
                //Xoa
                list_emp.display();
                System.out.println("Enter id employee:");
                s=gets.nextLine();
                if ( list_emp.deleteEmployee(s) ) 
                    System.out.println("Success");
                else 
                    System.out.println("We don't have that employee");              
                break;
            case 6:
                //Xoa tat ca 
                list_emp.deleteAll();
                System.out.println("Success");
                break;
            case 7:
                //sap xep theo ten
                System.out.println("Sort Name employees :");
                System.out.println("0.Increase");
                System.out.println("1.Decrease");
                k = cin.nextInt();
                list_emp.sortbyName(k);
                System.out.println("Success");
                break;
            case 8:
                //sap xep theo id
                System.out.println("Sort Id employees :");
                System.out.println("0.Increase");
                System.out.println("1.Decrease");
                k = cin.nextInt();
                list_emp.sortbyId(k);
                System.out.println("Success");
                break;
            case 9:
                //ghi vao file
                System.out.println("Enter the file name");
                filename = gets.nextLine();
                list_emp.writeFile(filename);
                System.out.println("Success");
                break;
            case 10:
                //lay du lieu tu file
                System.out.println("Enter the file name");
                filename = gets.nextLine();
                list_emp.deleteAll();
                list_emp.readFile(filename);
                System.out.println("Success");
                break;   
            case 11:
                //thu vien mac dinh
                list_emp.deleteAll();
                defaul_emp();
                System.out.println("Success");
                break;
            case 0:
                //thoat
                System.out.println("Thanks for using my application");
                exit = "co";
                break;
        }
    }
    
    public static void Form(){  
        System.out.printf(
                "1. Display a list of employees         \n"
                +"2. Create a new employee              \n"
                +"3. Find an employee                   \n"
                +"4. Edit information an employee       \n"
                +"5. Delete an employee                 \n"
                +"6. Delete all                         \n"
                +"7. Sort by Name                       \n"
                +"8. Sort by ID                         \n"
                +"9. Write list of employees to file    \n"
                +"10.Read  list of employees from file  \n"
                +"11.Rollback data                      \n"
                +"0. EXI                                \n"
                +"Select the number:");
    }
    
    public static void Menu() throws IOException{  
        
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
