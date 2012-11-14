

import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * Test the Characteristic class.
 *
 * @author Josh Gillham
 * @version 10-2-12
 */
public class CharacteristicTest {
    // BEGIN Good Behavioral Tests
    /**
     * Prove the constructor runs without errors and full fills
     *  the post conditions.
     */
    @Test
    public void testConstructor() {
        try {
            String expected = "Test";
            Characteristic instance = new Characteristic( expected );
            assertEquals( expected, instance.getName() );
            assertEquals( Characteristic.DEFAULT_RANK, instance.getRank() );
        }
        catch ( Exception e ) {
            fail( "Should not throw error." );
        }
    }
    
    /**
     * Prove the get and set rank behave as expected.
     */
    @Test
    public void testGetAndSetRank() {
        String name = "Test";
        Characteristic instance = new Characteristic( name );
        int expectedRank = 60;
        instance.setRank( expectedRank );
        assertEquals( expectedRank, instance.getRank() );
        expectedRank = 601;
        instance.setRank( expectedRank );
        assertEquals( expectedRank, instance.getRank() );
    }
    // END Good Behavioral Tests
    // BEGIN Destructive Tests
    /**
     * Prove the constructor rejects null values.
     */
    @Test( expected = NullPointerException.class )
    public void testConstructor_wNull() {
        new Characteristic( null );
    }
    // END Destructive Tests
}
