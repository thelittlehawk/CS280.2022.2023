package ba.edu.ssst;

public class Square extends Rectangle {
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
}
