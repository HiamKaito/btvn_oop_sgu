
package Human;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Collections;

public class HRManager {
    public List<Employee> list_emp;
    
    public HRManager(List<Employee> list_emp) {
        this.list_emp = list_emp;
    }
    
    public HRManager() {
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
    
    //dien thong tin cho nhan vien
    public Employee fillEmployee(){
        Employee newEmp=new Employee();
        newEmp.setInfo();
        return newEmp;
    }
    
    //them nhan vien
    public boolean addEmployee(Employee e){
        // 1 nhan vien chi co 1 id
        // id la khoa chinh
        Iterator<Employee> it = list_emp.iterator();
        while( it.hasNext() ) {
            Employee temp = it.next();
            if(temp.getId().compareToIgnoreCase(e.getId())==0)
                return false;
        }
        list_emp.add(e);
        return true;
    }
    
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
    
    public void deleteAll(){
        list_emp.removeAll(list_emp);
    }
    
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
    
    public boolean findEmployee(String name){
        for (Iterator<Employee> it = list_emp.iterator(); it.hasNext();) {
            Employee e = it.next();
            if(e.getName().compareToIgnoreCase(name)==0){
                e.display();
                return true;
            }
        }
        return false;
    }
    public void display(){
        System.out.println("_____________________________________________________________________________________________________________________________");
        System.out.println("|    ID    |   HO VA TEN   |   TUOI   |   NAM   |   CONG VIEC   |   LUONG   |   THANH PHO   |     QUAN     |     PHUONG     |");
        System.out.println("|__________|_______________|__________|_________|_______________|___________|_______________|______________|________________|");
        for (Iterator<Employee> it = list_emp.iterator(); it.hasNext() ; ) {
            Employee e = it.next();
            //System.out.println(e.toString());
            System.out.printf( 
                    "| %-9s| %-14s|  %-8d   |  %-7s| %-14s|  %-9d| %-14s| %-13s| %-15s| \n"
                    , e.getId(), e.getName() 
                    , e.getAge() , e.getStartInYear()
                    , e.getPosition() ,e.getSalary() 
                    , e.getAdd().getWard()
                    , e.getAdd().getDistrict()
                    , e.getAdd().getProvince()
            );
        }
        System.out.println("|__________|_______________|__________|_________|_______________|___________|_______________|______________|________________|");
        System.out.println("");
    }
    
    public void writeFile(String fileName) throws IOException{
        BufferedWriter out = new BufferedWriter(new FileWriter(fileName));    
        for ( Employee a : list_emp ) {
            //viet tung thanh phan cua list
            a.writeFile(fileName,out);
        }
        out.close();
    }
    
    public void readFile(String fileName) throws IOException{
        BufferedReader inp = null;
        //chay sai: BufferedReader inp =new BufferedReader(new FileReader(fileName));
        try {
            inp = new BufferedReader(new FileReader(fileName));
            String s = null;
            do {
                //doc tung dong
                s = inp.readLine();
                Employee a = new Employee();
                if ( a.readFile(s) )
                    list_emp.add(a);
            } while ( s!=null);
            
            inp.close();
        } catch (Exception e) {
            System.out.println("Something wrong");
        }
        // chay sai: inp.close();
    }
    
    public void sortbyName(int k){
        //sap xep theo ten sach tu a-z
        if ( k==0 ){
            Collections.sort(list_emp, Employee::NameTangdan);
        }
        //tu z-a
        else{
            Collections.sort(list_emp, Employee::NameGiamdan);
        }
    }
    public void sortbyId(int k){
        //sap xep theo so tu nho toi lon
        if ( k==0 ){
            Collections.sort(list_emp, Employee::IdTangdan);
        }
        //tu lon toi nho
        else{
            Collections.sort(list_emp, Employee::IdGiamdan);
        }
    }
}
