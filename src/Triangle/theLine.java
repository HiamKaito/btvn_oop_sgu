
package Triangle;

    public class theLine {
    private myPoint2D pBegin;
    private myPoint2D pEnd;

    public theLine(myPoint2D pBegin, myPoint2D pEnd) {
        this.pBegin = pBegin;
        this.pEnd = pEnd;
    }

    public myPoint2D getpBegin() {
        return pBegin;
    }

    public void setpBegin(myPoint2D pBegin) {
        this.pBegin = pBegin;
    }

    public myPoint2D getpEnd() {
        return pEnd;
    }

    public void setpEnd(myPoint2D pEnd) {
        this.pEnd = pEnd;
    }
    
    @Override
    public String toString() {
        return "theLine{" + "pBegin=" + pBegin + ", pEnd=" + pEnd + '}';
    }
    
}
