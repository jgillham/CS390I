

import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * Provides tests for Exercises.
 *
 * @author  Josh Gillham
 * @version 11-28-12
 */
public class ExercisesTest {
    // BEGIN Good Behavior Tests
    /**
     * Proves that strCount() can handle those tricky cases.
     */
    @Test
    public void testStrCount_Tricky() {
        assertEquals(1, (int)Exercises.strCount("aaa", "aa"));
        assertEquals(2, (int)Exercises.strCount("aaaa", "aa"));
        assertEquals(2, (int)Exercises.strCount("aaaaa", "aa"));
        assertEquals(3, (int)Exercises.strCount("aaaaaa", "aa"));
        assertEquals(3, (int)Exercises.strCount("aaaaaaa", "aa"));
    }
    // END Good Behavior Tests
}
