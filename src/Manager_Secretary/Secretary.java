
package Manager_Secretary;

import Human.Employee;
import Human.Address;

public class Secretary extends Employee{

    public Secretary(String id, int salary, int startInYear, String position, String name, int age, Address add) {
        super(id, salary, startInYear, position, name, age, add);
    }
    
    public Secretary(){
        
    }
    
    @Override
    public double calWages(){
        return super.getSalary()+ super.getSalary()*1.2;
    }
    
    public double calWages_S(){
        return super.getSalary()+ super.getSalary()*1.2;
    }
}