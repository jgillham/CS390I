

import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * This test unit will check the integrity of the Game class.
 *
 * @author  Josh Gillham
 * @version 9-19-12
 */
public class testGame
{
    /**
     * Default constructor for test class testGame
     */
    public testGame()
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
     * Test the constructor to make sure it will throw errors when given bad
     *  arguments
     */
    @Test
    public void testConstructor_BadArgs() {
        try{
            Game g= new Game( Game.MIN_ATTEMPTS - 1, Dictionary.MIN_WORDLENGTH );
            fail( "Constructor should have thrown an error." );
        }catch( Exception e ) {}
        
        try{
            Game g= new Game( Game.MIN_ATTEMPTS, Dictionary.MIN_WORDLENGTH - 1 );
            fail( "Constructor should have thrown an error." );
        }catch( Exception e ) {}
        
        try{
            Game g= new Game( Game.MIN_ATTEMPTS, Dictionary.MAX_WORDLENGTH + 1 );
            fail( "Constructor should have thrown an error." );
        }catch( Exception e ) {}
            
    }
}
