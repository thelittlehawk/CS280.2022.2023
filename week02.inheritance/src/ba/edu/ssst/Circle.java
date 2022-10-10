package ba.edu.ssst;

public class Circle extends Shape {
    private double diameter;

    public double getDiameter() {
        return diameter;
    }

    public void setDiameter(double diameter) {
        this.diameter = diameter;
    }

    public Circle(double diameter) {
        super();
        this.diameter = diameter;
    }

    @Override
    public double area() {
        return diameter * diameter * Math.PI;
    }

    public void scale(int scale) {
        setDiameter(scale * diameter);
    }

    public double circumference() {
        return 2 * Math.PI * diameter;
    }
}
