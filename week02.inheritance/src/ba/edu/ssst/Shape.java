package ba.edu.ssst;

public class Shape extends Object {

    public Shape() {
        super();
    }

    public double area() {
        return 0.;
    }

    public double circumference() {
        return 0.;
    }

    public void scale(int scale) throws Exception {
        if(scale <= 0) throw new Exception("Scale must be non-zero value!");
    }

    @Override
    public String toString() {
        return super.toString();
    }
}
