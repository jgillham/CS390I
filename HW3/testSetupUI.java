

import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * The test class testSetupUI.
 *
 * @author  (your name)
 * @version (a version number or a date)
 */
public class testSetupUI
{
    /**
     * Default constructor for test class testSetupUI
     */
    public testSetupUI()
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
     * Tests the constructor to ensure that it throws no errors.
     */
    @Test
    public void testConstructor() {
        new SetupUI();
    }
}
