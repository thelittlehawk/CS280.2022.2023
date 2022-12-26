package ba.edu.ssst;

public class Hero {
    private String name;
    private int hp;
    private int damage;

    public Hero(String name, int hp, int damage) {
        this.name = name;
        this.hp = hp;
        this.damage = damage;
    }

    public String getName() {
        return this.name;
    }

    public int getHealth() {
        return this.hp;
    }

    public int getDamage() {
        return this.damage;
    }

    public void takeDamage(int i) {
        this.hp -= i;
    }
}
