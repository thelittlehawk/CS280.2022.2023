package ba.edu.ssst;

import java.util.ArrayList;

public class Student {
    private String ime;
    private String prezime;
    private String index;
    private ArrayList<Integer> grades;

    public Student(String ime, String prezime, String index) {
        this.ime = ime;
        this.prezime = prezime;
        this.index = index;
        this.grades = new ArrayList<>();
    }

    public void addGrade(int grade) {
        grades.add(grade);
    }

    public boolean pass() {
        for (Integer g:this.grades) {
            if(g < 6) return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Student{" +
                "ime='" + ime + '\'' +
                ", prezime='" + prezime + '\'' +
                ", index='" + index + '\'' +
                '}';
    }
}
