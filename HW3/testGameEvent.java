

import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import java.util.List;
import java.util.LinkedList;

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
    public testGameEvent()
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
    Player player;
    Manager man;
    
    Player playerUp= null;
    Manager teamUp= null;
    String savedGameWord= null;
    
    Manager gameWinningTeam= null;
    
    boolean gameOver= false;
    
    GameUI gameUI= new GameUI() {
        public void teamUp( Manager team ){
            teamUp= team;
        }
        public void playerUp( Player player ){
            playerUp= player;
        }
        public void gameWinner( Manager team ){
            gameWinningTeam= team;
        }
        public void gameOver() {
            gameOver= true;
        }
    };
    
    class LogicMock extends Logic {
            public LogicMock( java.util.List< Manager > teams, int gameWordLength ) 
             throws IllegalArgumentException {
                 super( teams, gameWordLength );
                  savedGameWord= "Schoter"; //gameWord=
            }
        }
    
    
    
    /**
     * Test the constructor to make sure it can successfully construct
     */
    @Before
    public void testConstructor() {
        
        teams= new LinkedList< Manager >();
        man= new Manager( "Alpha" );
        teams.add( man );
        player= man.addPlayer( "Bob" );
        
        game= new LogicMock( teams, Dictionary.MIN_WORDLENGTH );
        // Set events should shoot off playerUp and teamUp events as soon as it is set
        game.setGameEventsHandler( gameUI );
        assertEquals( man, teamUp );
        assertEquals( player, playerUp );
    }
    
    /**
     * Test loosing the game.
     */
    public void testGameOver(){
        String partialABCs= "abcdefghijklmnopqr";
        for( int i= 0; i < partialABCs.length() && i < LogicMock.DEFAULT_ATTEMPTS; ++i ) {
            char c= partialABCs.charAt( i );
            game.makeGuess( player, c );
        }
        assertTrue( gameOver );
        assertNull( gameWinningTeam );
    }
    
    /**
     * Test winning the game.
     */
    public void testGameWinner(){
        for( int i= 0; i < savedGameWord.length(); ++i ) {
            char c= savedGameWord.charAt( i );
            game.makeGuess( player, c );
        }
        assertNotNull( gameWinningTeam );
        assertEquals( man, gameWinningTeam );
        
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
