package ba.edu.ssst;

import org.w3c.dom.css.Rect;

import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {
        ArrayList<Shape> shapes = new ArrayList();
        shapes.add(new Circle(5));
        shapes.add(new Square(10));
        shapes.add(new Square(15));
        shapes.add(new Rectangle(10, 20));

        ArrayList<IAngle> shapes2 = new ArrayList<>();
        shapes2.add(new Square(10));
        shapes2.add(new Rectangle(10, 20));
        shapes2.add(new Circle(10));

        Computer c = new Computer("My super computer");
        c.plugInUSB(new AppleData());
        c.plugInUSB(new Toshiba());

        for (int i = 0; i < shapes.size(); i++) {
            try {
                Shape s = shapes.get(i);
                System.out.println(s);
                System.out.println("Area: " + s.area() + ", Circumference: " + s.circumference());
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public static void BaseExample() {
        // Inheritance
        try {
            Square s = new Square(10);
            double sArea = s.area();
            double sCircumference = s.circumference();
            s.scale(10);
            System.out.println(s);
            System.out.println("Area: " + sArea + ", Circumference: " + sCircumference);
            // Test exception handling
            // s.scale(-12);
        } catch (Exception e) {
            e.printStackTrace();
        }

        Circle c = new Circle(5);
        double cArea = c.area();
        c.scale(2);
        double cCircumference = c.circumference();
        System.out.println(c);
        System.out.println("Area: " + cArea + ", Circumference: " + cCircumference);
    }
}
