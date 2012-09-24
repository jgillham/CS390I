

import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * This unit test will check the integrity of the Player class.
 * 
 * TODO:
 *  testGetScore_InGame() - ensure the score gets incremented when the player guesses correctly
 *  testGetHistory_InGame() - ensure that correct guess get added to the list
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
    Player player;
    
    /**
     * Tests the constructor with good arguments. No errors should occur.
     */
    @Before
    public void testConstructor() {
        player= new Player( "Bob" );
    }
    
    /**
     * Test the constructor with null argument. The result should be an error.
     */
    @Test( expected= NullPointerException.class )
    public void testConstructor_Null() {
        Player d= new Player( null );
    }
    
    /**
     * Test the constructor with empty string arguments. The result should be an error
     */
    @Test( expected= IllegalArgumentException.class )
    public void testConstructor_Empty() {
        Player d= new Player( "" );
    }
    
    /**
     * Ensure that the initial score is 0.
     */
    /* @Test
    public void testGetScore_Beginning() {
        assertEquals( 0, player.getScore() );
    } */
    
    /**
     * Ensure that the initial history is "".
     */
    /* @Test
    public void testGetHistory_Beginning() {
        assertEquals( "", player.getHistory() );
    } */
}
