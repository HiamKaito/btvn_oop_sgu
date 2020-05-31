
package Human;

import java.util.Scanner;

public class Person {
    private String name; //ho va ten
    private int age;     //tuoi
    private Address new_Address; //dia chi
    
    Scanner cin = new Scanner(System.in);
    Scanner gets = new Scanner(System.in);
    
    //Bo khoi tao
    public Person() {
        
    }
    
    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public Person(String name, int age, Address add) {
        this.name = name;
        this.age = age;
        this.new_Address = add;
    }
    
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    
    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
    
    public Address getAdd() {
        return new_Address;
    }

    public void setAdd(Address new_Address) {
        this.new_Address = new_Address;
    }    
    
    //Lay thong tin con nguoi
    public void setInfo(){
        System.out.println("Enter the name ");
        this.setName(gets.nextLine());
        System.out.println("Enter the age ");
        this.setAge(cin.nextInt());
        //tao 1 bien nhap thong tin
        Address add = new Address();
        add.setInfo(); // nhap thong tin dia chi
        this.setAdd(add); // lay thong tin dia chi
    }
    
    @Override
    public String toString(){
	return "Name: " + name + " Age " + age + " " + this.getAdd();
    }
}
