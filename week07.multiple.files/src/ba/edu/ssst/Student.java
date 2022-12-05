package ba.edu.ssst;

import java.util.Objects;

public class Student {
    private String id;
    private String grade;
    private String name;

    public Student(String id, String grade) {
        this.id = id;
        this.grade = grade;
        this.name = "Unknown";
    }

    public Student(String id, String grade, String name) {
        this.id = id;
        this.name = name;
        this.grade = grade;
    }

    @Override
    public String toString() {
        return name + "(" + id + ") (" + grade + ")";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Student student = (Student) o;
        return Objects.equals(id, student.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    public void setName(String studentName) {
        this.name = studentName;
    }
}
