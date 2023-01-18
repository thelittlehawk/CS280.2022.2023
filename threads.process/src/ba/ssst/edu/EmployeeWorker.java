package ba.ssst.edu;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Collections;

public class EmployeeWorker implements Runnable {

    private ArrayList<Employee> employees;

    private Employee employeeWithMinSalary;

    public EmployeeWorker(ArrayList<Employee> employees) {
        this.employees = employees;
    }

    @Override
    public void run() {
        this.employeeWithMinSalary = Collections.min(this.employees);
    }

    public Employee getMinSalaryEmployee() {
        return this.employeeWithMinSalary;
    }
}
