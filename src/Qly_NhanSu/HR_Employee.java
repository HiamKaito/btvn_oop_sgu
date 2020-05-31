package Qly_NhanSu;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;


public class HR_Employee implements HR_Interface{
    protected List<Employee> list_emp;
    
    private String File_EmpFull ="./src/Qly_NhanSu/Employee/Emp_Full.txt";
    private String File_EmpHafl ="./src/Qly_NhanSu/Employee/Emp_Hafl.txt";
    private String Backup_File_EmpFull ="./src/Qly_NhanSu/Backup/Emp_Full.txt";
    private String Backup_File_EmpHafl ="./src/Qly_NhanSu/Backup/Emp_Hafl.txt";
    private String History_Emp_Full = "./src/Qly_NhanSu/History/History_Emp.txt";
    
    Scanner cin = new Scanner(System.in);
    Scanner gets = new Scanner(System.in);
    
    //bo khoi tao
    public HR_Employee(List<Employee> list_emp) {
        this.list_emp = list_emp;
    }
    
    public HR_Employee() {
        list_emp=new ArrayList<>();
    }
    
    //kiem tra so luong nhan vien
    public int check_in(){
        int i=0;
        for ( Employee a : list_emp ) {
            i++;
        }
        return i;
    }
    
    //kiem tra su ton tai cua id , id la duy nhat
    public boolean check_existId(String id){
        for (Iterator<Employee> it = list_emp.iterator(); it.hasNext();) {
            Employee e = it.next();
            if(e.getId().compareToIgnoreCase(id)==0){
                System.out.println("We already have that id, Pleaze try again");
                return true;
            }
        }
        return false;
    }
    
    //dien thong tin cho nhan vien
    public Employee fillEmployee_Full(){
        Employee newEmp = new Emp_Full();
        while(true){
            System.out.println("Enter the id ");
            newEmp.setId(gets.nextLine());
            if ( check_existId(newEmp.getId()) )
                System.out.println("");
            else
                break;
        }
        newEmp.setInfo();
        return newEmp;
    }
    
    public Employee fillEmployee_Hafl(){
        Employee newEmp = new Emp_Hafl();
        while(true){
            System.out.println("Enter the id ");
            newEmp.setId(gets.nextLine());
            if ( check_existId(newEmp.getId()) )
                System.out.println("");
            else
                break;
        }
        newEmp.setInfo();
        return newEmp;
    }
    
    //them nhan vien
    public boolean addEmployee(Employee e){
        // 1 nhan vien chi co 1 id
        // id la khoa chinh
        if( check_existId(e.getId()) )
            return false;
        list_emp.add(e);
        return true;
    }
    
    //xoa nhan vien
    public boolean deleteEmployee(String id){
        for (Iterator<Employee> it = list_emp.iterator(); it.hasNext();) {
            Employee e = it.next();
            if(e.getId().compareToIgnoreCase(id)==0){
                it.remove();
                return true;
            }
        }
        return false;
    }
    
    //xoa tat ca nhan vien
    public void deleteAll(){
        list_emp.removeAll(list_emp);
    }
    
    //sua thong tin nhan vien
    public boolean editEmployee(String name){
         for (Iterator<Employee> it = list_emp.iterator(); it.hasNext();) {
            Employee emp = it.next();
            if(emp.getName().compareToIgnoreCase(name)==0){
                emp.setInfo();
                return true;
            }
        }
        return false;
    }
    
    //tim nhan vien theo ten
    public boolean findEmployeebyName(String name){
        System.out.println("___________________________________________________________________________________________________________________________________________________________");
        //                         1          2            3           4               5            6           7                 8              9               10         11
        System.out.println("|    ID    |   HO VA TEN   |   TUOI   |   GIOI TINH  | Full Time |  Ma_Phong  |    CHUC VU    |   LUONG   |     PHUONG    |     QUAN     |    THANH_PHO   |");
        System.out.println("|__________|_______________|__________|______________|___________|____________|_______________|___________|_______________|______________|________________|");
        int k=0;
        for (Iterator<Employee> it = list_emp.iterator(); it.hasNext();) {
            Employee e = it.next();
            if(e.getName().compareToIgnoreCase(name)==0){
                System.out.printf( 
                         //   1     2       3     4         5        6      7      8       9    10        11
                        "| %-9s| %-14s|  %-8d|     %-8s |    %-5s  |  %-9d | %-14s|  %-9s| %-14s| %-13s| %-15s| \n"
                        , e.getId(), e.getName() 
                        , e.getAge() , e.getGender()
                        , e.getCategorize() , e.getId_room() 
                        , e.getPosition() , e.getSalary()
                        , e.getAdd().getWard()
                        , e.getAdd().getDistrict()
                        , e.getAdd().getCity()
                );
                k++;
            }
        }
        System.out.println("|__________|_______________|__________|______________|___________|____________|_______________|___________|_______________|______________|________________|");
        System.out.println("");
       
        if (k!=0 ) return true;
        return false;
    }
    
    //tim nhan vien theo gioi tinh
    public boolean findEmployeebyGender(String gender){
        System.out.println("___________________________________________________________________________________________________________________________________________________________");
        //                         1          2            3           4               5            6           7                 8              9               10         11
        System.out.println("|    ID    |   HO VA TEN   |   TUOI   |   GIOI TINH  | Full Time |  Ma_Phong  |    CHUC VU    |   LUONG   |     PHUONG    |     QUAN     |    THANH_PHO   |");
        System.out.println("|__________|_______________|__________|______________|___________|____________|_______________|___________|_______________|______________|________________|");
        int k=0;
        for (Iterator<Employee> it = list_emp.iterator(); it.hasNext();) {
            Employee e = it.next();
            if(e.getGender().compareToIgnoreCase(gender)==0){
                System.out.printf( 
                         //   1     2       3     4         5        6      7      8       9    10        11
                        "| %-9s| %-14s|  %-8d|     %-8s |    %-5s  |  %-9d | %-14s|  %-9s| %-14s| %-13s| %-15s| \n"
                        , e.getId(), e.getName() 
                        , e.getAge() , e.getGender()
                        , e.getCategorize() , e.getId_room() 
                        , e.getPosition() , e.getSalary()
                        , e.getAdd().getWard()
                        , e.getAdd().getDistrict()
                        , e.getAdd().getCity()
                );
                k++;
            }
        }
        System.out.println("|__________|_______________|__________|______________|___________|____________|_______________|___________|_______________|______________|________________|");
        System.out.println("");
       
        if (k!=0 ) return true;
        return false;
    }
    
    //tim nhan vien theo dia chi phong
    public void findEmployeebyIdRoom(int idroom){
        System.out.println("___________________________________________________________________________________________________________________________________________________________");
        //                         1          2            3           4               5            6           7                 8              9               10         11
        System.out.println("|    ID    |   HO VA TEN   |   TUOI   |   GIOI TINH  | Full Time |  Ma_Phong  |    CHUC VU    |   LUONG   |     PHUONG    |     QUAN     |    THANH_PHO   |");
        System.out.println("|__________|_______________|__________|______________|___________|____________|_______________|___________|_______________|______________|________________|");
        for (Iterator<Employee> it = list_emp.iterator(); it.hasNext() ; ) {
            Employee e = it.next();
            //System.out.println(e.toString());
            if(e.getId_room()==idroom){
                System.out.printf( 
                         //   1     2       3     4         5        6      7      8       9    10        11
                        "| %-9s| %-14s|  %-8d|     %-8s |    %-5s  |  %-9d | %-14s|  %-9s| %-14s| %-13s| %-15s| \n"
                        , e.getId(), e.getName() 
                        , e.getAge() , e.getGender()
                        , e.getCategorize() , e.getId_room() 
                        , e.getPosition() , e.getSalary()
                        , e.getAdd().getWard()
                        , e.getAdd().getDistrict()
                        , e.getAdd().getCity()
                );
            }  
        }
        System.out.println("|__________|_______________|__________|______________|___________|____________|_______________|___________|_______________|______________|________________|");
        System.out.println("");
        
    }
    
    //tim nhan vien theo id
    public boolean findEmployeebyId(String id){
        for (Iterator<Employee> it = list_emp.iterator(); it.hasNext();) {
            Employee e = it.next();
            if(e.getId().compareToIgnoreCase(id)==0){
                e.display();
                return true;
            }
        }
        return false;
    }
    
    //chuyen doi nhan vien giua cac FUll time va part time
    public boolean change_Categorize(String id,int k){
        //chuyen tu full sang hafl
        if ( k==0 ){
            for (Iterator<Employee> it = list_emp.iterator(); it.hasNext();) {
                Employee e = it.next();
                if(e.getId().compareToIgnoreCase(id)==0){
                    e.setCategorize(" ");
                    return true;
                }
            }
            return false;
        }
        else{
            for (Iterator<Employee> it = list_emp.iterator(); it.hasNext();) {
                Employee e = it.next();
                if(e.getId().compareToIgnoreCase(id)==0){
                    e.setCategorize("x");
                    return true;
                }
            }
            return false;
        }
    }
    
    public void display(){
        System.out.println("___________________________________________________________________________________________________________________________________________________________");
        //                         1          2            3           4               5            6           7                 8              9               10         11
        System.out.println("|    ID    |   HO VA TEN   |   TUOI   |   GIOI TINH  | Full Time |  Ma_Phong  |    CHUC VU    |   LUONG   |     PHUONG    |     QUAN     |    THANH_PHO   |");
        System.out.println("|__________|_______________|__________|______________|___________|____________|_______________|___________|_______________|______________|________________|");
        for (Iterator<Employee> it = list_emp.iterator(); it.hasNext() ; ) {
            Employee e = it.next();
            //System.out.println(e.toString());
            System.out.printf( 
                     //   1     2       3     4         5        6      7      8       9    10        11
                    "| %-9s| %-14s|  %-8d|     %-8s |    %-5s  |  %-9d | %-14s|  %-9s| %-14s| %-13s| %-15s| \n"
                    , e.getId(), e.getName() 
                    , e.getAge() , e.getGender()
                    , e.getCategorize() , e.getId_room() 
                    , e.getPosition() , e.getSalary()
                    , e.getAdd().getWard()
                    , e.getAdd().getDistrict()
                    , e.getAdd().getCity()
            );
        }
        System.out.println("|__________|_______________|__________|______________|___________|____________|_______________|___________|_______________|______________|________________|");
        System.out.println("");
    }
    
    public void writeFile() throws IOException{
        
        BufferedWriter out_Full = new BufferedWriter(new FileWriter(File_EmpFull));
        for ( Employee a : list_emp ) {
            //viet tung thanh phan cua list
            if ( a.getCategorize().equals("x") )
                a.writeFile(File_EmpFull, out_Full);
        }
        out_Full.close();
        
        
        BufferedWriter out_Hafl = new BufferedWriter(new FileWriter(File_EmpHafl));
        for ( Employee a : list_emp ) {
            //viet tung thanh phan cua list
            if ( !a.getCategorize().equals("x") )
            a.writeFile(File_EmpHafl, out_Hafl);
        }
        out_Hafl.close();
    }
    
    public void readFile() throws IOException{
        
        BufferedReader inp_Full = null;
        try {
            inp_Full = new BufferedReader(new FileReader(File_EmpFull));
            String s = null;
            do {
                //doc tung dong
                s = inp_Full.readLine();
                Employee a = new Emp_Full();
                if ( a.readFile(s) )
                    list_emp.add(a);
            } while ( s!=null);
            
            inp_Full.close();
        } catch (Exception e) {
            System.out.println("Something wrong when reading Emp_Full file");
        }
        
        BufferedReader inp_Hafl = null;
        try {
            inp_Hafl = new BufferedReader(new FileReader(File_EmpHafl));
            String s = null;
            do {
                //doc tung dong
                s = inp_Hafl.readLine();
                Employee a = new Emp_Full();
                if ( a.readFile(s) )
                    list_emp.add(a);
            } while ( s!=null);
            
            inp_Hafl.close();
        } catch (Exception e) {
            System.out.println("Something wrong when reading Emp_Hafl file");
        }
    }
    
    public void readFile_History() throws IOException{
        
        BufferedReader inp_Full = null;
        try {
            inp_Full = new BufferedReader(new FileReader(File_EmpFull));
            String s = null;
            do {
                //doc tung dong
                s = inp_Full.readLine();
                Employee a = new Emp_Full();
                if ( a.readFile(s) )
                    list_emp.add(a);
            } while ( s!=null);
            
            inp_Full.close();
        } catch (Exception e) {
            System.out.println("Something wrong when reading Emp_Full file");
        }
    }
        
    public void setPosition(String id) throws IOException{        
        BufferedWriter out = new BufferedWriter(new FileWriter(History_Emp_Full));
        for ( Employee a : list_emp ) {
            //viet tung thanh phan cua list
            if ( a.getId().compareTo(id)==0 )
                a.setPosition(File_EmpFull, out);
        }
        out.close();
    }
    
    //backup file 
    public void Backup_writeFile() throws IOException{
        
        BufferedWriter out_Full = new BufferedWriter(new FileWriter(Backup_File_EmpFull));
        for ( Employee a : list_emp ) {
            //viet tung thanh phan cua list
            if ( a.getCategorize().equals("x") )
                a.writeFile(File_EmpFull, out_Full);
        }
        out_Full.close();
        
        
        BufferedWriter out_Hafl = new BufferedWriter(new FileWriter(Backup_File_EmpHafl));
        for ( Employee a : list_emp ) {
            //viet tung thanh phan cua list
            if ( !a.getCategorize().equals("x") )
            a.writeFile(File_EmpHafl, out_Hafl);
        }
        out_Hafl.close();
    }
    
    public void Backup_readFile() throws IOException{
        
        BufferedReader inp_Full = null;
        try {
            inp_Full = new BufferedReader(new FileReader(Backup_File_EmpFull));
            String s = null;
            do {
                //doc tung dong
                s = inp_Full.readLine();
                Employee a = new Emp_Full();
                if ( a.readFile(s) )
                    list_emp.add(a);
            } while ( s!=null);
            
            inp_Full.close();
        } catch (Exception e) {
            System.out.println("Something wrong");
        }
        
        BufferedReader inp_Hafl = null;
        try {
            inp_Hafl = new BufferedReader(new FileReader(Backup_File_EmpHafl));
            String s = null;
            do {
                //doc tung dong
                s = inp_Hafl.readLine();
                Employee a = new Emp_Full();
                if ( a.readFile(s) )
                    list_emp.add(a);
            } while ( s!=null);
            
            inp_Hafl.close();
        } catch (Exception e) {
            System.out.println("Something wrong");
        }
    }
    
    
    @Override
    public void sort(){
        System.out.println("Which sort?     \n"
                + "1.Sort by Name           \n"
                + "2.Sort by Age            \n"
                + "3.Sort by Id             \n"
                + "4.Sort by Gender         \n"
                + "5.Sort by Part - Full time     \n"
                + "6.Sort by Salary         \n");
        int k = cin.nextInt();
        switch( k ){
            case 1:
                //sap xep theo ten
                System.out.println("1.Ascending\n"
                        + "2.Decrease\n");
                k = cin.nextInt();
                sortbyName(k);
                break;
            case 2:
                //sap xep theo tuoi
                System.out.println("1.Ascending\n"
                        + "2.Decrease\n");
                k = cin.nextInt();
                sortbyAge(k);
                break;
            case 3:
                //sap xep theo id
                System.out.println("1.Ascending\n"
                        + "2.Decrease\n");
                k = cin.nextInt();
                sortbyId(k);
                break;
            case 4:
                //sap xep theo gioi tinh
                System.out.println("1.Male\n"
                        + "2.FeMale\n");
                k = cin.nextInt();
                sortbyGender(k);
                break;
            case 5:
                //sap xep theo loai nhan vien part full time
                System.out.println("1.Full Time\n"
                        + "2.Part Time\n");
                k = cin.nextInt();
                sortbyCategorize(k);
                break;
            case 6:
                //sap xep theo luong
                System.out.println("1.Ascending\n"
                        + "2.Decrease\n");
                k = cin.nextInt();
                sortbySalary(k);
                break;
        }
        display();
    }
     
    //cac ham sap xep
    public void sortbyName(int k){
        //sap xep theo ten sach tu a-z
        if ( k==1 ){
            Collections.sort(list_emp, Employee::NameTangdan);
        }
        //tu z-a
        else{
            Collections.sort(list_emp, Employee::NameGiamdan);
        }
    }
    public void sortbyId(int k){
        //sap xep theo so tu nho toi lon
        if ( k==1 ){
            Collections.sort(list_emp, Employee::IdTangdan);
        }
        //tu lon toi nho
        else{
            Collections.sort(list_emp, Employee::IdGiamdan);
        }
    }
    public void sortbyAge(int k){
        //sap xep theo so tu nho toi lon
        if ( k==1 ){
            Collections.sort(list_emp, Employee::AgeTangdan);
        }
        //tu lon toi nho
        else{
            Collections.sort(list_emp, Employee::AgeGiamdan);
        }
    }
    public void sortbyIdPhong(int k){
        //sap xep theo so tu nho toi lon
        if ( k==1 ){
            Collections.sort(list_emp, Employee::IdPhongTangdan);
        }
        //tu lon toi nho
        else{
            Collections.sort(list_emp, Employee::IdPhongGiamdan);
        }
    }
    public void sortbyCategorize(int k){
        //full time dung dau
        if ( k==1 ){
            Collections.sort(list_emp, Employee::Full_Hafl);
        }
        else {
            Collections.sort(list_emp, Employee::Hafl_Full);
        }
    } 
    public void sortbyGender(int k){
        //Nam
        if ( k==1 ){
            Collections.sort(list_emp , Employee::Nam);
        }
        else {
            Collections.sort(list_emp , Employee::Nu);
        }
    }
    public void sortbySalary(int k){
        //luong tang dan
        if ( k==1 ){
            Collections.sort(list_emp, Employee::LuongTangdan);
        }
        else {
            Collections.sort(list_emp, Employee::LuongGiamdan);
        }
    }
}
