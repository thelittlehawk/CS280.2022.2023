package ba.edu.ssst;

public class Rectangle extends Shape {
    private double a;
    private double b;

    public Rectangle(double a, double b) {
        this.a = a;
        this.b = b;
    }

    public double getA() {
        return a;
    }

    public void setA(double a) {
        this.a = a;
    }

    public double getB() {
        return b;
    }

    public void setB(double b) {
        this.b = b;
    }

    @Override
    public double area() {
        return a * b;
    }

    @Override
    public double circumference() {
        return 2 * a + 2 * b;
    }

    @Override
    public void scale(int scale) throws Exception {
        super.scale(scale);
        this.setA(a * scale);
        this.setB(b * scale);
    }

    @Override
    public String toString() {
        return "Rectangle{" +
                "a=" + a +
                ", b=" + b +
                '}';
    }
}
