package ba.edu.ssst;

public class Animal {
    private String animal;
    private Integer weight;

    public Animal(String animal, Integer weight) {
        this.animal = animal;
        this.weight = weight;
    }

    @Override
    public String toString() {
        return "Animal {" + animal + " (" + weight + ")}";
    }
}
