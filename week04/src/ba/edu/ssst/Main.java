package ba.edu.ssst;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.management.ManagementFactory;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        System.out.println("Week 04 - Maps");

        // Naive approach
//        ArrayList<String> blueAnimals = new ArrayList<>();
//        ArrayList<String> redAnimals = new ArrayList<>();
//        ArrayList<String> yellowAnimals = new ArrayList<>();
//        ArrayList<String> purpleAnimals= new ArrayList<>();

        // Base example of Maps
        // LinkedList, [14, 16, 27, 123, 231]
        // Tree, [123, 123, 12312]
        // Hash, [14, 16, 123, 12312]

        Map<String, ArrayList<Animal>> coloredAnimals = new LinkedHashMap<>();
//        Map<String, ArrayList<String>> coloredAnimals = new TreeMap<>();
//        Map<String, ArrayList<String>> coloredAnimals = new HashMap<>();
        // blue, [ant, cat, tiger]
        // Entry => {blue, [ant, cat, tiger]}
        // Key => blue
        // Value => [ant, cat, tiger]
        // for (Animal a : tmpAnimals ) {
        // prolaz 1. ant
        // prolaz 2. cat
        // prolaz 3. tiger
        // }
        // red, [dog, bear]
        // yellow, [lizard, shark]
        // purple, [lion]

//        Map<String, Map<String, ArrayList<Integer>>> multiDim = new LinkedHashMap<>();
        // blue | height | [10, 20, 30]
        //      | weight | [2, 3, 4]
//        multiDim.put("blue", new LinkedHashMap<>());
//        multiDim.get("blue").put("height", new ArrayList<>());
//        multiDim.get("blue").get("height").add(10);
//        multiDim.get("blue").get("height").add(20);
//        multiDim.get("blue").get("height").add(30);
//        System.out.println(multiDim);

        File file = new File("in.txt");
        Scanner s = new Scanner(file);

        s.nextLine();
        while(s.hasNextLine()) {
            String line = s.nextLine();
            String[] elements = line.split(",");
            String color = elements[0].trim();
            String animal = elements[1].trim();
            Integer weight = Integer.parseInt(elements[2].trim());

//            if (coloredAnimals.containsKey(color)) {
//                coloredAnimals.get(color).add(animal);
//            } else {
//                coloredAnimals.put(color, new ArrayList<>());
//                coloredAnimals.get(color).add(animal);
//            }

            if (!coloredAnimals.containsKey(color)) {
                coloredAnimals.put(color, new ArrayList<>());
            }
            Animal a = new Animal(animal, weight);
            coloredAnimals.get(color).add(a);
        }

        for (Map.Entry<String, ArrayList<Animal>> entry: coloredAnimals.entrySet()) {
            System.out.println("Key: " + entry.getKey());

            FileWriter fw = new FileWriter(entry.getKey());

            ArrayList<Animal> tmpAnimals = entry.getValue();
            for (Animal animal:tmpAnimals) {
                fw.write(String.valueOf(animal));
                fw.write("\n");
            }
            System.out.println(entry.getKey() + " file created!");
            fw.close();
        }

//        for (String k : coloredAnimals.keySet()) { }

//        System.out.println(coloredAnimals);
    }
}
