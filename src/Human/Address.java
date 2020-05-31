
package Human;

import java.util.Scanner;

public class Address {
    ////aaaaaaaaaaaaaaaaaaaaaaaaaa
    private String ward;
    private String district;
    private String province; 
    
    Scanner scan=new Scanner(System.in);
    
    public Address() {
    }

    public Address(String ward, String district, String province) {
        this.ward = ward;
        this.district = district;
        this.province = province;
    }

    public String getWard() {
        return ward;
    }

    public void setWard(String ward) {
        this.ward = ward;
    }

    public String getDistrict() {
        return district;
    }

    public void setDistrict(String district) {
        this.district = district;
    }

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province;
    }
    
    
    public void setInfo(){
        System.out.println("Enter the ward ");
        this.setWard(scan.nextLine());
        System.out.println("Enter the district ");
        this.setDistrict(scan.nextLine());
        System.out.println("Enter the province ");
        this.setProvince(scan.nextLine());
    }
    
    @Override
    public String toString(){
        return "Addess is ward "+this.getWard() + " district " + this.getDistrict() +" province " +this.getProvince();
    }
}
