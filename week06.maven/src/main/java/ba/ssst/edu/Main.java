package ba.ssst.edu;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;

import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {
//        Reader in = new FileReader("airbnb.txt");
//        Iterable<CSVRecord> records = CSVFormat.EXCEL.parse(in);
//        for (CSVRecord record : records) {
//            try{
//                System.out.println(record.get(0));
//            } catch (Exception e) {
//                System.out.println("Error");
//            }
//        }
        ArrayList<String> loseLinije = new ArrayList<>();
        ArrayList<Airbnb> airbnbs = new ArrayList<>();
        File file = new File("airbnb.txt");
        Scanner s = new Scanner(file);
        s.nextLine();
        while (s.hasNextLine()) {
            String line = s.nextLine();
            try {
                String[] parts = line.split("\t");
                String id = parts[0];
                String text = parts[1];
//                System.out.println(parts[1]);
                airbnbs.add(new Airbnb(id, text));
            } catch (Exception e) {
                loseLinije.add(line);
            }
        }
//        System.out.println(airbnbs.size());
//        System.out.println(loseLinije);

//        for (Airbnb a: airbnbs) {
//            a.getLocations();
//        }

        String text = "This is a sentence, written by Mike in Paris.";
        for(String s1 : text.split("[ .|, ]")) {
            System.out.println(s1);
        }
    }
}
