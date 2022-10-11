package ba.edu.ssst;

public class Square
        extends Rectangle
        implements IAngle {
    public Square(double side) {
        super(side, side);
    }

    public double getSide() {
        return super.getA();
    }

    public void setSide(double side) {
        super.setA(side);
        super.setB(side);
    }

    @Override
    public String toString() {
        return "Square{}";
    }

    @Override
    public double sumAngles() {
        return 360;
    }
}
