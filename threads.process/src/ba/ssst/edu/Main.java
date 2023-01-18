package ba.ssst.edu;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        System.out.println("Thread example");
        System.out.println("==================");

        long start = System.currentTimeMillis();

        // Threads basic example
        // basicExample();

        ArrayList<Employee> employees = getEmployeesFromFile();

        Integer numberOfElements = employees.size() / 2;
        ArrayList<EmployeeWorker> employeeWorkers = new ArrayList<>();
        employeeWorkers.add(new EmployeeWorker(new ArrayList(employees.subList(0, numberOfElements))));
        employeeWorkers.add(new EmployeeWorker(new ArrayList(employees.subList(numberOfElements, numberOfElements * 2))));

        ArrayList<Thread> threads = new ArrayList<>();
        for (EmployeeWorker ew: employeeWorkers) {
            threads.add(new Thread(ew));
        }
        for (Thread t:threads) { t.start(); }
        for (Thread t:threads) { t.join(); }

        ArrayList<Employee> candidates = new ArrayList<>();
        for (EmployeeWorker ew:employeeWorkers) {
            candidates.add(ew.getMinSalaryEmployee());
        }

        System.out.println("Employee with min salary is: " + Collections.min(candidates));

        long end = System.currentTimeMillis();
        System.out.println("Execution time: " + (end - start));
    }

    private static ArrayList<Employee> getEmployeesFromFile() {
        ArrayList<Employee> employees = new ArrayList<>();
        File f = new File("employees.csv");
        try {
            Scanner s = new Scanner(f);
            s.nextLine();
            while (s.hasNextLine()) {
                String[] parts = s.nextLine().split(",");
                employees.add(new Employee(parts[1], parts[2]));
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
        return employees;
    }

    private static void basicExample() throws InterruptedException {
        Worker w1 = new Worker(1);
        Worker w2 = new Worker(2);
        Worker w3 = new Worker(3);

        Thread t1 = new Thread(w1);
        Thread t2 = new Thread(w2);
        Thread t3 = new Thread(w3);

        t1.start();
        t2.start();
        t3.start();
        // System.out.println("Thread 1 status: " + w1.isCompleted()); -> false

        t1.join();
        t2.join();
        t3.join();

        System.out.println("Thread 1 status: " + w1.isCompleted()); // -> true
        System.out.println("Thread 2 status: " + w2.isCompleted());
        System.out.println("Thread 3 status: " + w3.isCompleted());

        System.out.println("Thread end of example!");
    }
}