package ba.edu.ssst;

import com.sun.org.apache.xpath.internal.operations.Bool;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws IOException {

        Map<String, ArrayList<OneAd>> ads = new HashMap<>();
        // ads.put("Male", new ArrayList<>());
        // ads.put("Female", new ArrayList<>());

        File f = new File("ads.csv");
        Scanner s = new Scanner(f);

        s.nextLine();
        while(s.hasNextLine()) {
            String line = s.nextLine(); // line = "15624510,Male,19,19000,0"
            String[] lineParts = line.split(","); // ["15624510","Male","19","19000","0"]
            String id = lineParts[0]; // "15624510"
            String gender = lineParts[1]; // "Male"
            Integer age = Integer.parseInt(lineParts[2]); // "19" -> 19
            Double salary = Double.parseDouble(lineParts[3]); // "19000" -> 19000.0
            Boolean purchased = lineParts[4].equals("1") ? true : false;

            OneAd oneAd = new OneAd(id, gender, age, salary, purchased);
            if (!ads.containsKey(gender)) {
                ads.put(gender, new ArrayList<>());
            }
            ads.get(gender).add(oneAd);
        }

        // 1) Percentage of Females and Males that have seen the ad
        report1(ads);
        System.out.println("Report1 - DONE");

        // 2) Percentage of Females and Males that have purchased the product
        report2(ads);
        System.out.println("Report2 - DONE");

        // 3) Average age of users that purchased the product and the average age of users that have not purchased the product
        // 4) Average salary of users that purchased the product and the average age of users that have not purchased the product
        // 5) All users that have not purchased the product but their age and salary are above average age and salary of those that have purchased the product.
    }

    // 1) Percentage of Females and Males that have seen the ad
    private static void report1(Map<String, ArrayList<OneAd>> ads) throws IOException {
        Double totalFemales = Double.valueOf(ads.get("Female").size());
        Double totalMale = Double.valueOf(ads.get("Male").size());
        double percentageFemales = totalFemales / ( totalFemales + totalMale) * 100;
        double percentageMale = totalMale / ( totalFemales + totalMale) * 100;

        FileWriter fw = new FileWriter("report1.csv");
        fw.write("Female -> " + percentageFemales + "%\n");
        fw.write("Male -> " + percentageMale + "%");

        fw.close();
    }

    // 2) Percentage of Females and Males that have purchased the product
    private static void report2(Map<String, ArrayList<OneAd>> ads) throws IOException {
        Double malePurchased = Double.valueOf(countPurchased(ads.get("Male")));
        Double femalePurchased = Double.valueOf(countPurchased(ads.get("Female")));
        Double totalAds = Double.valueOf(ads.get("Male").size() + ads.get("Female").size());

        FileWriter fw = new FileWriter("report2.csv");
        fw.write("Female -> " + femalePurchased/totalAds*100  + "%\n");
        fw.write("Male -> " + malePurchased/totalAds*100 + "%");

        fw.close();
    }

    private static Integer countPurchased(ArrayList<OneAd> adsArray) {
        Integer purchased = 0;
        for (OneAd oneAd : adsArray) {
            if (oneAd.isPurchased()) {
                purchased++;
            }
        }
        return purchased;
    }
}
