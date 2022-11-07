package ba.edu.ssst;

public class OneJobSalary implements Comparable<OneJobSalary> {
    private final String id;

    private final String jobTitle;

    private final Double salary;

    private final Double salaryInUSD;
    private String currency;

    public OneJobSalary(String id, String jobTitle, Double salary, Double salaryInUSD, String currency) {
        this.id = id;
        this.jobTitle = jobTitle;
        this.salary = salary;
        this.salaryInUSD = salaryInUSD;
        this.currency = currency;
    }

    @Override
    public String toString() {
        return "OneJobSalary{" +
                "id='" + id + '\'' +
                ", jobTitle='" + jobTitle + '\'' +
                ", salary=" + salary +
                ", salaryInUSD=" + salaryInUSD +
                ", currency=" + currency +
                '}';
    }

    @Override
    public int compareTo(OneJobSalary o) {
        return this.salaryInUSD.compareTo(o.salaryInUSD);
    }

//    @Override
//    public int compareTo(OneJobSalary o) {
//        if(this.salaryInUSD > o.salaryInUSD) {
//            return -1;
//        } else if(this.salaryInUSD < o.salaryInUSD) {
//            return 1;
//        } else {
//            return 0;
//        }
//    }

    public String fileString() {
        return id + "," + jobTitle + "," + salary + "," + salaryInUSD;
    }
}
