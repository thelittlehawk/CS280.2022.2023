package ba.edu.ssst;

import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {
        // basicExample();

        Student s = new Student("Ime", "Prezime", "SSST#1");
        s.addGrade(10);
        s.addGrade(8);
        s.addGrade(6);
        s.addGrade(5);
        System.out.println(s.pass());
        System.out.println(s);
    }

    private static void basicExample() {
        System.out.println("Testera");
        System.out.print("Testera");
        System.out.print(" ");
        System.out.print("2");
        System.out.println();

        Zbir z = new Zbir(10, 20);
        System.out.println(z.getA());
        System.out.println(z.getB());
        int sum = z.saberi();
        System.out.println(sum);
    }
}