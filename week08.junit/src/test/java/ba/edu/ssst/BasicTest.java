package ba.edu.ssst;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

public class BasicTest {
    @Test
    public void TestThatPass() {
        String text = "First, Last";
        assertEquals("First, Last", text);
    }

    @Test
    public void TestThatPassToo() {
        String text = "First is not Last";
        assertNotEquals("First, Last", text);
    }
}
