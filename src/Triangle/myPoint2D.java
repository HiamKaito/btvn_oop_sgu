
package Triangle;

public class myPoint2D {

    private int x;
    private int y;

    public myPoint2D() {
    }

    public myPoint2D(int x, int y) {
        this.x = x;
        this.y = y;
    }
    
    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }
    
    protected double distanceEuclid(int x, int y){
        return Math.sqrt((this.x-x)*(this.x-x)+(this.y-y)*(this.y-y));
    }
    
    public double distanceEuclid (myPoint2D point){
        return Math.sqrt((this.x-point.x)*(this.x-point.x)+(this.y-point.y)*(this.y-point.y));
    }
    
    //set infor
    
    @Override
    public String toString(){
        return "point has x = " +x+ " y = " +y;
    }
   
}
