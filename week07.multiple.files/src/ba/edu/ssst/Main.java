package ba.edu.ssst;

import com.sun.org.apache.xpath.internal.operations.Bool;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws FileNotFoundException {
        Map<Course, ArrayList<Student>> courses = new HashMap<>();

        File coursesFile = new File("courses.csv");
        Scanner coursesScanner = new Scanner(coursesFile);

        coursesScanner.nextLine();
        while(coursesScanner.hasNextLine()) {
            String line = coursesScanner.nextLine();
            String[] parts = line.split(",");
            String courseName = parts[0].trim();
            String courseECTS = parts[1].trim();
            String courseId = parts[2].trim();
            String studentId = parts[3].trim();
            String studentGrade = parts[4].trim();
            Course c = new Course(courseName, courseECTS, courseId);

            if(!courses.containsKey(c)) {
                courses.put(c, new ArrayList<>());
            }
             courses.get(c).add(new Student(studentId, studentGrade));
        }

        File studentsFile = new File("students.csv");
        Scanner studentsScanner = new Scanner(studentsFile);
        studentsScanner.nextLine();
        while(studentsScanner.hasNextLine()) {
            String line = studentsScanner.nextLine();
            String[] parts = line.split(",");
            String studentId = parts[0].trim();
            String studentName = parts[1].trim();
//            System.out.println(studentId + " " + studentName);
            Boolean found = false;
            for(Map.Entry<Course, ArrayList<Student>> e: courses.entrySet()) {
                for(Student s: e.getValue()) {
//                    if(s.getId().equals(studentId))
//                    System.out.println(e.getKey().toString() + " => " + s);
                    if(s.equals(new Student(studentId, studentName))) {
                        s.setName(studentName);
                        found = true;
                    }
                    if(found) break;
                }
                if(found) break;
            }
        }

        for (Map.Entry<Course, ArrayList<Student>> entry : courses.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }
        // Object-Oriented Programming (6 ECTS): [M, A, B, C]
        // Algorithms (8 ECTS): [M, A, B, C]
    }
}
