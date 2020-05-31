
package Manager_Secretary;

import Human.Employee;
import Human.Address;

public class Manager extends Employee{
    
    public Manager(String id, int salary, int startInYear, String position, String name,int age, Address add) {
        super(id, salary, startInYear, position, name, age, add);
    }
    
    public Manager(){
        
    }
    
    @Override
    public double calWages(){
        return super.getSalary()+ super.getSalary()*1.8;
    }
    
    public double calWages_M(){
        return super.getSalary()+ super.getSalary()*1.8;
    }
}
