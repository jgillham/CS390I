

import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * The test class testFormGamePlay.
 *
 * @author  (your name)
 * @version (a version number or a date)
 */
public class testGameEvent
{
    /**
     * Default constructor for test class testGame
     */
    public testLogic()
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
    Logic game;
    List< Manager > teams;
    PlayerInterface player;
    
    /**
     * Test the constructor to make sure it can successfully construct
     */
    @Before
    public void testConstructor() {
        
        teams= new LinkedList< Manager >();
        Manager man= new Manager( "Alpha" );
        teams.add( man );
        player= man.addPlayer( "Bob" );
        
        game= new Logic( teams, Dictionary.MIN_WORDLENGTH );
    }
    
    /**
     * Tests getActiveTeam();
     * 
     */
    /* @Test
    public void testGetActiveTeam() {
        Logic g= new Logic( Logic.MIN_ATTEMPTS, Dictionary.MAX_WORDLENGTH );
        ManagerInterface firstTeam= null;
        for( int i= 0; i < 10; ++i ){
            if( i == 0 )
                firstTeam= g.addTeam();
            else
                g.addTeam();
            assertEquals( firstTeam, g.getActiveTeam() );
        }
    }*/
}
