package ba.ssst.edu;

public class Employee implements Comparable<Employee> {
    private String name;
    private Double salary;

    public Employee(String name, String salary) {
        this.name = name;
        this.salary = Double.parseDouble(salary);
    }

    @Override
    public int compareTo(Employee o) {
        return this.salary.compareTo(o.salary);
    }

    @Override
    public String toString() {
        return this.name + " (" + this.salary + ")";
    }
}
