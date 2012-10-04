import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * Tests the class GameUI.
 *
 * @author  Josh Gillham
 * @version 9-23-12
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
    public void testConstructor() throws java.io.FileNotFoundException {
        SetupBase wrapGame= new SetupBase();
        wrapGame.addManager( "Default" );
        wrapGame.addPlayer( "Default" );
        Logic game= wrapGame.getGame();
        new GameUI( game );
    }
}
