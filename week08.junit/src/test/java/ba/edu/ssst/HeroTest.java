package ba.edu.ssst;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class HeroTest {

    @Test
    public void createHeroContructor() {
        Hero h = new Hero("Yellow bat", 100, 6);
        assertEquals("Yellow bat", h.getName());
        assertEquals(100, h.getHealth());
        assertEquals(6, h.getDamage());
    }

    @Test
    public void createHeroTakeDamage() {
        Hero h = new Hero("Red dragon", 100, 6);
        h.takeDamage(10);
        assertEquals(90, h.getHealth());
        h.takeDamage(10);
        assertEquals(80, h.getHealth());
    }
}
