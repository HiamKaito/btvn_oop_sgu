
package Human;

import java.io.BufferedWriter;
import java.io.IOException;

public class Employee extends Person{
    /////
    private String id;
    private int salary;
    private int startInYear;
    private String position;
    
    //bo khoi tao
    public Employee(String id, int salary, int startInYear, String position, String name, int age) {
        super(name, age);
        this.id = id;
        this.salary = salary;
        this.startInYear = startInYear;
        this.position = position;
    }

    public Employee(String id, int salary, int startInYear, String position, String name, int age, Address add) {
        super(name, age, add);
        this.id = id;
        this.salary = salary;
        this.startInYear = startInYear;
        this.position = position;
    }
    
    public Employee(){
        
    }
    
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    public int getStartInYear() {
        return startInYear;
    }

    public void setStartInYear(int startInYear) {
        this.startInYear = startInYear;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }
    
    public double calWages (){
        return (salary + salary*0.1);
    }
            
    //Lay thong tin nguoi di lam
    @Override
    public void setInfo(){
        //nhap thong tin ve nguoi
        //goi ham nhap tu superclass (Person)
        super.setInfo();
        //nhap thong tin cua nguoi di lam
        System.out.println("Enter the id ");
        this.setId(gets.nextLine());
        System.out.println("Enter the salary ");
        this.setSalary(cin.nextInt());
        System.out.println("Enter the startInYear ");
        this.setStartInYear(cin.nextInt());
        System.out.println("Enter the position ");
        this.setPosition(gets.nextLine());
    }
    
    public void writeFile(String fileName,BufferedWriter out) throws IOException{
        try {
            // khi viet file viet them dau | vao giua
            out.write(super.getName() + "|");
            out.write(String.valueOf(super.getAge()) + "|");
            out.write(super.getAdd().getWard() + "|");
            out.write(super.getAdd().getDistrict() + "|");
            out.write(super.getAdd().getProvince() + "|");
            out.write(this.getId() + "|");
            out.write(this.getPosition() + "|");
            out.write(String.valueOf(this.getSalary()) + "|");
            out.write(String.valueOf(this.getStartInYear()) + "|");
            out.newLine();
        } catch (Exception e) {
            System.out.println("Error in writing ");
        }
    }
    
    public boolean readFile(String s){ 
        if (s!=null){
            // khi doc file doc toi dau |
            String[] inp = s.split("\\|");
            super.setName(inp[0]);
            super.setAge( Integer.parseInt( inp[1] ) );
            super.setAdd(new Address(inp[2],inp[3],inp[4]));
            this.setId(inp[5]);
            this.setPosition(inp[6]);
            this.setSalary(Integer.parseInt( inp[7] ) );
            this.setStartInYear(Integer.parseInt( inp[8] ) );
            return true;
        }
        return false;
    }
  
    @Override
    public String toString(){
        return getId()+" "+super.getName()+" "+super.getAge()+ " "+ super.getAdd()+ " "+getPosition()+ " " +getSalary() + " "+getStartInYear();
    }
    
    public void display(){
        System.out.println("_____________________________________________________________________________________________________________________________");
        System.out.println("|    ID    |   HO VA TEN   |   TUOI   |   NAM   |   CONG VIEC   |   LUONG   |   THANH PHO   |     QUAN     |     PHUONG     |");
        System.out.println("|__________|_______________|__________|_________|_______________|___________|_______________|______________|________________|");
        System.out.printf( 
            "| %-9s| %-14s|  %-8d|  %-7s| %-14s|  %-9d| %-14s| %-13s| %-15s| \n"
            , this.getId(), super.getName() 
            , super.getAge() , this.getStartInYear()
            , this.getPosition() ,this.getSalary() 
            , super.getAdd().getWard()
            , super.getAdd().getDistrict()
            , super.getAdd().getProvince()
        );
        System.out.println("|__________|_______________|__________|_________|_______________|___________|_______________|______________|________________|");
    }
    
    //cac ham so sanh
    public static int NameTangdan(Employee a, Employee b){
        return a.getName().compareTo(b.getName());
    }
    
    public static int NameGiamdan(Employee a, Employee b){
        return b.getName().compareTo(a.getName());
    }
    
    public static int IdTangdan(Employee a, Employee b){
        return a.getId().compareTo(b.getId());
    }
    public static int IdGiamdan(Employee a, Employee b){
        return b.getId().compareTo(a.getId());
    }
}
