package ba.edu.ssst;

import java.util.Objects;

public class Course {
    private String courseName;
    private String courseECTS;
    private String courseId;

    public Course(String courseName, String courseECTS, String courseId) {
        this.courseName = courseName;
        this.courseECTS = courseECTS;
        this.courseId = courseId;
    }

    @Override
    public String toString() {
        return this.courseName + " (" + this.courseECTS + " ECTS)";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Course course = (Course) o;
        return Objects.equals(courseName, course.courseName) &&
                Objects.equals(courseId, course.courseId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(courseName, courseId);
    }
}
