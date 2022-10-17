package ba.edu.ssst;

public class Student implements Comparable<Student> {
    private String id;
    private String firstName;
    private String lastName;
    private Integer midtermPoints;
    private Integer finalPoints;
    private Double assignment1Points;
    private Double assignment2Points;
    private Double assignment3Points;
    private String courseId;

    public Student(String firstName, String lastName, String courseId) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.courseId = courseId;
    }

    public Student(String id, String firstName, String lastName, Integer midtermPoints, Integer finalPoints, Double assignment1Points, Double assignment2Points, Double assignment3Points) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.midtermPoints = midtermPoints;
        this.finalPoints = finalPoints;
        this.assignment1Points = assignment1Points;
        this.assignment2Points = assignment2Points;
        this.assignment3Points = assignment3Points;
    }

    public String getId() {
        return id;
    }

    @Override
    public String toString() {
        return "Student{" +
                firstName + ", " +
                lastName + ", "  +
                courseId + '}';
    }

    public boolean pass() {
        return finalPoints > 25 && midtermPoints > 10;
    }

    public String getName() {
        return this.firstName + " " + this.lastName;
    }

    public Double getPoints() {
        return
                finalPoints +
                midtermPoints +
                assignment1Points * 10 +
                assignment2Points * 10 +
                assignment3Points * 10;
    }

    @Override
    public int compareTo(Student o) {
        return this.getPoints().compareTo(o.getPoints());
    }
}
