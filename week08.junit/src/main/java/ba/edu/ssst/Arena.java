package ba.edu.ssst;

import java.util.ArrayList;
import java.util.Map;

public class Arena {
    private final ArrayList<Hero> heroes;

    public Arena(ArrayList<Hero> heroes) {
        this.heroes = heroes;
    }

    public void start() {
        while(heroes.size() > 1) {
            heroes.get(1).takeDamage(heroes.get(0).getDamage());
            heroes.get(0).takeDamage(heroes.get(1).getDamage());

            if (heroes.get(0).getHealth() <= 0) {
                heroes.remove(0);
            }
            if (heroes.size() > 1 && heroes.get(1).getHealth() <= 0) {
                heroes.remove(1);
            }
        }
    }

    public int remainingHeroes() {
        return heroes.size();
    }

    public ArrayList<Hero> getHeroes() {
        return this.heroes;
    }
}
