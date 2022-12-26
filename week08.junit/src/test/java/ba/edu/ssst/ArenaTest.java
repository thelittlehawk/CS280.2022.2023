package ba.edu.ssst;

import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.assertEquals;

public class ArenaTest {
    @Test
    public void testArena() {
        Hero hero1 = new Hero("Hero 1", 150, 10);
        Hero hero2 = new Hero("Hero 2", 100, 10);
        ArrayList<Hero> heroes = new ArrayList<>();
        heroes.add(hero1);
        heroes.add(hero2);
        Arena arena = new Arena(heroes);
        arena.start();
        assertEquals(1, arena.remainingHeroes());
//        for (Hero hero : heroes) {
//            assertEquals(0, hero.getHealth());
//        }
    }

    @Test
    public void testArena2() {
        Hero hero1 = new Hero("Hero 1", 50, 10);
        Hero hero2 = new Hero("Hero 2", 100, 10);
        ArrayList<Hero> heroes = new ArrayList<>();
        heroes.add(hero1);
        heroes.add(hero2);
        Arena arena = new Arena(heroes);
        arena.start();
        assertEquals(1, arena.remainingHeroes());
//        for (Hero hero : heroes) {
//            assertEquals(0, hero.getHealth());
//        }
    }

    @Test
    public void testArena3() {
        ArrayList<Hero> heroes = new ArrayList<>();
        heroes.add(new Hero("Hero 5", 1200, 10));
        heroes.add(new Hero("Hero 1", 50, 10));
        heroes.add(new Hero("Hero 2", 100, 10));
        heroes.add(new Hero("Hero 3", 80, 10));
        heroes.add(new Hero("Hero 4", 12, 10));
        Arena arena = new Arena(heroes);
        arena.start();
        assertEquals(1, arena.remainingHeroes());
        assertEquals(arena.getHeroes().get(0).getName(), "Hero 5");
    }
}
