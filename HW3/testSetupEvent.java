

import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * The test class testFormGameSetup.
 *
 * @author  (your name)
 * @version (a version number or a date)
 */
public class testFormGameSetup
{
    /**
     * Default constructor for test class testFormGameSetup
     */
    public testFormGameSetup()
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
    FormGameSetup form;
    /**
     * Tests the constructor to see if it won't throw an error.
     */
    @Before
    public void testConstructor() {
        form= new FormGameSetup( new SetupEvent() {
            public void completedSetup( int maxAttempts, int wordLen ) throws IllegalArgumentException
            { throw new UnsupportedOperationException(); }
        } );
    }
    
    
}
