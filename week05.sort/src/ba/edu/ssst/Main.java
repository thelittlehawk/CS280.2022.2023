package ba.edu.ssst;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        File file = new File("in.csv");
        Scanner s = new Scanner(file);

        ArrayList<OneJobSalary> salaries = new ArrayList<>();
        Map<String, ArrayList<OneJobSalary>> salariesByJob = new HashMap<>();

        s.nextLine();
        while(s.hasNextLine()) {
            String line = s.nextLine();
            String[] elements = line.split(",");
            // id,
            String id = elements[0].trim();
            // work_year,
            // experience_level,
            // employment_type,
            // job_title,
            String jobTitle = elements[4].trim();
            // salary,
            Double salary = Double.parseDouble(elements[5].trim());
            // salary_currency,
            String currency = elements[6].trim();
            // salary_in_usd,
            Double salaryInUSD = Double.parseDouble(elements[7].trim());
            // employee_residence,
            // remote_ratio,
            // company_location,
            // company_size

            // Add element to the array list
            salaries.add(new OneJobSalary(id, jobTitle, salary, salaryInUSD, currency));

            // Add element to the map
            if (!salariesByJob.containsKey(jobTitle)) {
                salariesByJob.put(jobTitle, new ArrayList<>());
            }
            OneJobSalary ojs = new OneJobSalary(id, jobTitle, salary, salaryInUSD, currency);
            salariesByJob.get(jobTitle).add(ojs);
        }

//        Comparable<OneJobSalary> c = new OneJobSalary("1", "2", 3.0, 4.0);

//        sortArray(salaries);

        for (Map.Entry<String, ArrayList<OneJobSalary>> entry : salariesByJob.entrySet()) {
            System.out.println(entry.getValue().size() + " - " + entry.getKey());
            Collections.sort(entry.getValue());
            Collections.reverse(entry.getValue());

//            System.out.println(entry.getValue().get(0));
            FileWriter fw = new FileWriter("outfiles/" +entry.getKey() + ".csv");
            fw.write("id,job_title,salary,salary_in_usd\n");
            for (OneJobSalary ojs :
                    entry.getValue().size() > 5 ?
                            entry.getValue().subList(0, 5) :
                            entry.getValue()) {
                fw.write(ojs.fileString());
                fw.write("\n");
            }
            fw.close();
        }
    }

    private static void sortArray(ArrayList<OneJobSalary> salaries) throws IOException {
        Collections.sort(salaries);
        Collections.reverse(salaries);

        FileWriter fw = new FileWriter("out.csv");
        fw.write("id,job_title,salary,salary_in_usd\n");
        for (OneJobSalary ojs : salaries) {
            fw.write(ojs.fileString());
            fw.write("\n");
        }
        fw.close();

        OneJobSalary o1 = new OneJobSalary("1", "2", 50.0, 100.0, "USD");
        OneJobSalary o2 = new OneJobSalary("1", "2", 50.0, 100.0, "USD");
        System.out.println(o1.compareTo(o2));
    }
}
