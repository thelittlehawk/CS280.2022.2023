package ba.edu.ssst;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
//        basicFileReading();
        try {
            File file = new File("files/students.csv");
            Scanner scanner = new Scanner(file);
            ArrayList<Student> students = new ArrayList<>();

            if(scanner.hasNextLine()) scanner.nextLine();
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                String[] elements = line.split(",");

                // Process student information
                String id = elements[0];
                String firstName = elements[1];
                String lastName = elements[2];
                Integer midtermPoints = Integer.parseInt(elements[3]);
                Integer finalPoints = Integer.parseInt(elements[4]);
                Double assignment1Points = Double.parseDouble(elements[5]);
                Double assignment2Points = Double.parseDouble(elements[6]);
                Double assignment3Points = Double.parseDouble(elements[7]);

                Student s = new Student(
                    id,
                    firstName,
                    lastName,
                    midtermPoints,
                    finalPoints,
                    assignment1Points,
                    assignment2Points,
                    assignment3Points
                );
                students.add(s);
            }

            FileWriter fw = new FileWriter("files/output.txt");
            Collections.sort(students);
            for (Student s:students) {
                if (s.pass()) {
                    fw.write(s.getName() + " " + s.getPoints());
                    fw.write('\n');
                }
            }
            fw.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (Exception e) {
            System.out.println("BAD");
        }
    }

    private static void basicFileReading() {
        // pathname: C:\\Users\\name\\Desktop\\file.txt
        // pathname: ../name/../file.txt
        // pathname: file.txt
        try {
//            differentFileInstances();
            File file = new File("files/input.csv");
            Scanner s = new Scanner(file);
            ArrayList<String[]> lines = new ArrayList<>();

            // while(true) {
            if(s.hasNextLine()) s.nextLine();
            while(s.hasNextLine()) {
                String line = s.nextLine();
                String[] elements = line.split(",");
                lines.add(elements);
            }
            System.out.println("END OF READING");

//            System.out.println("PRINT FILE CONTENT, WITHOUT COMMA");
//            for (String[] line:lines) {
//                for (int i = 0; i < line.length; i++) {
//                    System.out.print(line[i]);
//                }
//                System.out.println();
//            }

            ArrayList<Student> students = new ArrayList<>();
            for (String[] line:lines) {
                String firstName = line[0].trim();
                String lastName = line[1].trim();
                String courseId = line[2].trim();
//                Student newStudent = new Student(firstName, lastName, courseId, midtermPoints, finalPoints, assignment1Points, assignment2Points, assignment3Points);
                Student newStudent = new Student(firstName, lastName, courseId);
                students.add(newStudent);
            }
            System.out.println(students);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    private static void differentFileInstances() throws FileNotFoundException {
        File file = new File("random_bla_bla.txt");
        Scanner scanner = new Scanner(file);

        File file2 = new File("files/new_file.txt");
        Scanner s2 = new Scanner(file2);

        File file3 = new File("src/in_src.txt");
        File file4 = new File("/Users/faik/IdeaProjects/week03.files/files_new_file.txt");
    }
}
