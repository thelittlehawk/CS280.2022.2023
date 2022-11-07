package ba.edu.ssst;

public class OneAd {
    private String id;
    private String gender;
    private Integer age;
    private Double salary;
    private Boolean purchased;

    public OneAd(String id, String gender, Integer age, Double salary, Boolean purchased) {
        this.id = id;
        this.gender = gender;
        this.age = age;
        this.salary = salary;
        this.purchased = purchased;
    }

    public boolean isPurchased() {
        return this.purchased;
    }
}
