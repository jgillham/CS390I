import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * Sample tests for the functional programming exercises.
 * Full credit for the assignment requires providing a
 * more extensive set of tests.
 * @author Dr. Jody Paul
 * @version Intermediate Programming 1.0
 */
public class ExercisesTestByProfessor {
    java.util.List li;
    /**
     * Sets up the test fixture.
     * Called before every test case method.
     */
    @Before
    public void setUp() {
        li = java.util.Arrays.asList(2, 7, 13, 9, 11);
    }

    @Test
    public void testSum() {
        assertEquals(42, (int)Exercises.sum(this.li));
    }

    @Test
    public void testProduct() {
        assertEquals(18018, (int)Exercises.product(this.li));
    }

    @Test
    public void testStrCount() {
        assertEquals(2, (int)Exercises.strCount("catdogcat", "cat"));
        assertEquals(0, (int)Exercises.strCount("x", "foo"));
        assertEquals(2, (int)Exercises.strCount("ccccc", "cc"));
    }

    @Test
    public void testGroupExists() {
        assertTrue(Exercises.groupExists(this.li, 0));
        assertTrue(Exercises.groupExists(this.li, 2));
        assertTrue(Exercises.groupExists(this.li, 7));
        assertTrue(Exercises.groupExists(this.li, 9));
        assertTrue(Exercises.groupExists(this.li, 31));
        assertTrue(Exercises.groupExists(this.li, 42));
        assertFalse(Exercises.groupExists(this.li, 1));
        assertFalse(Exercises.groupExists(this.li, 3));
        assertFalse(Exercises.groupExists(this.li, 12));
        assertFalse(Exercises.groupExists(this.li, 4));
        li = java.util.Arrays.asList(2, 7, 13, 9, 11, 2);
        assertTrue(Exercises.groupExists(this.li, 4));
    }
}