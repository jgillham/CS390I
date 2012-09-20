

import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * This unit test will check the integrity of the Player class.
 *
 * @author  Josh Gillham
 * @version 9-19-12
 */
public class testPlayer
{
    /**
     * Default constructor for test class testPlayer
     */
    public testPlayer()
    {
    }

    /**
     * Sets up the test fixture.
     *
     * Called before every test case method.
     */
    @Before
    public void setUp()
    {
    }

    /**
     * Tears down the test fixture.
     *
     * Called after every test case method.
     */
    @After
    public void tearDown()
    {
    }
    
    /**
     * Test the constructor with null argument. The result should be an error.
     */
    @Test( expected= NullPointerException.class )
    public void testConstructor_Null() {
        PlayerInterface d= new Player( null );
    }
    
    /**
     * Test the constructor with empty string arguments. The result should be an error
     */
    @Test( expected= IllegalArgumentException.class )
    public void testConstructor_Empty() {
        PlayerInterface d= new Player( "" );
    }
}
