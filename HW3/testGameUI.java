

import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * The test class testGameUI.
 *
 * @author  (your name)
 * @version (a version number or a date)
 */
public class testGameUI
{
    /**
     * Default constructor for test class testGameUI
     */
    public testGameUI()
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
     * Tests the constructor to make sure there are no errors.
     */
    @Test
    public void testConstructor() {
        Test_InstrumentLogic wrapGame= new Test_InstrumentLogic();
        Logic game= wrapGame.getInstance();
        new GameUI( game );
    }
}
