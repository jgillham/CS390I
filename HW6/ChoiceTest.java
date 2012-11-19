

import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * Tests Choice.
 *
 * @author  Josh Gillham
 * @version 10-2-12
 */
public class ChoiceTest {
    // BEGIN Good Behavioral Tests
    /**
     * Proves that the constructor runs without errors and
     *  full fills the post conditions.
     */
    @Test
    public void testConstructor() {
        try {
            String expected = "Test";
            Choice instance = new Choice( expected );
            assertEquals( expected, instance.getName() );
            assertEquals( Choice.DEFAULT_SCORE, instance.getFinalScore() );
        }
        catch ( Exception e ) {
            fail( "Should not throw an error." );
        }
    }
    
    /**
     * Proves the get and set for finalScore behave correctly.
     */
    @Test
    public void testGetAndSetFinalScore() {
        Choice instance = new Choice( "Test" );
        int expected = 1001;
        instance.setFinalScore( expected );
        assertEquals( expected, instance.getFinalScore() );
        expected = 1002;
        instance.setFinalScore( expected );
        assertEquals( expected, instance.getFinalScore() );
    }
    // END Good Behavioral Tests
    // BEGIN Destructive Tests
    /**
     * Proves the constructor rejects null values.
     */
    @Test( expected = NullPointerException.class )
    public void testConstructorNull() {
        new Choice( null );
    }
    // END Destructive Tests
}
