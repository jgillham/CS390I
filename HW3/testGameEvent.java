

import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import java.util.List;
import java.util.LinkedList;

/**
 * Ensures the game events are being called by Logic.
 *
 * @author  Josh Gillham
 * @version 9-23-12
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
    
    public String savedGameWord= "flamingo";
    
    /**
     * Test the constructor to make sure it can successfully construct
     */
    @Before
    public void testConstructor() {
        Test_InstrumentLogic wrapGame= new Test_InstrumentLogic( );
        
        Logic game= wrapGame.getInstance();
        assertEquals( wrapGame.firstTeam, wrapGame.teamUp );
        assertEquals( wrapGame.firstPlayer, wrapGame.playerUp );
    }
    
    /**
     * Test gameOver event.
     */
    public void testGameOver(){
        Test_InstrumentLogic wrapGame= new Test_InstrumentLogic( );
        Logic game= wrapGame.getInstance();
        String partialABCs= "abcdefghijklmnopqr";
        for( int i= 0; i < partialABCs.length() && i < game.getAttempts(); ++i ) {
            char c= partialABCs.charAt( i );
            game.makeGuess( wrapGame.playerUp, c );
        }
        assertTrue( wrapGame.gameOver );
        assertNull( wrapGame.gameWinningTeam );
    }
    
    /**
     * Test gameWinningTeam event.
     */
    public void testGameWinner(){
        Test_InstrumentLogic wrapGame= new Test_InstrumentLogic();
        Logic game= wrapGame.getInstance( savedGameWord );
        for( int i= 0; i < savedGameWord.length(); ++i ) {
            char c= savedGameWord.charAt( i );
            game.makeGuess( wrapGame.playerUp, c );
        }
        assertTrue( wrapGame.gameOver );
        assertNotNull( wrapGame.gameWinningTeam );
        assertEquals( wrapGame.firstTeam, wrapGame.gameWinningTeam );
    }
    
    /**
     * Test updates to the status word
     */
    public void testChangedStatusWord(){
        Test_InstrumentLogic wrapGame= new Test_InstrumentLogic( );
        Logic game= wrapGame.getInstance( savedGameWord );
        for( int i= 0; i < savedGameWord.length(); ++i ) {
            char c= savedGameWord.charAt( i );
            game.makeGuess( wrapGame.playerUp, c );
        }
        assertEquals( savedGameWord.length(), wrapGame.statusWordChanges );
    }
    
    /**
     * Test updates to the status word with bad guesses.
     */
    public void testChangedStatusWord_wBadGuesses(){
        Test_InstrumentLogic wrapGame= new Test_InstrumentLogic( );
        Logic game= wrapGame.getInstance( savedGameWord );
        StringBuilder wrd= new StringBuilder( wrapGame.savedGameWord );
        // Insert crazy letters in between to simulate bad guesses
        wrd.insert( 1, 'u' );
        wrd.insert( 3, 'z' );
        wrd.insert( 5, 'y' );
        for( int i= 0; i < savedGameWord.length(); ++i ) {
            char c= savedGameWord.charAt( i );
            game.makeGuess( wrapGame.playerUp, c );
        }
        // The status word changes should be the same
        // Remember it only changes for good guesses
        assertEquals( savedGameWord.length(), wrapGame.statusWordChanges );
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
