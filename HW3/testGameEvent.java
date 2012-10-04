import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import java.util.List;
import java.util.LinkedList;

/**
 * Ensures the game events are being called by Logic.
 * 
 * TODO:
 * -test playerUp()
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
    class GameEventsTester extends GameEventsBase{
        public int statusWordChanges= 0;
        public void changedStatusWord( String statusWord ) {
            ++statusWordChanges;
        }
    };
    
    /**
     * Test the constructor to make sure it can successfully construct
     */
    @Before
    public void testConstructor() throws java.io.FileNotFoundException {
        SetupBase wrapGame= new SetupBase( );
        Manager firstTeam= wrapGame.addManager( "Default" );
        Player firstPlayer= wrapGame.addPlayer( "Default" );
        
        Logic game= wrapGame.getGame();
        GameEventsBase gameEvents= new GameEventsBase();
        game.setGameEventsHandler( gameEvents );
        assertEquals( firstTeam, gameEvents.teamUp );
        assertEquals( firstPlayer, gameEvents.playerUp );
    }
    
    /**
     * Test gameOver event.
     */
    public void testGameOver() throws java.io.FileNotFoundException {
        SetupBase wrapGame= new SetupBase( );
        GameEventsBase gameEvents= new GameEventsBase();
        Logic game= wrapGame.getGame();
        game.setGameEventsHandler( gameEvents );
        String partialABCs= "abcdefghijklmnopqr";
        for( int i= 0; i < partialABCs.length() && i < game.getAttempts(); ++i ) {
            char c= partialABCs.charAt( i );
            try{
                game.makeGuess( c );
            }catch( Logic.AmbiguousGuessException e ) {}
        }
        assertTrue( gameEvents.gameOver );
        assertNull( gameEvents.gameWinningTeam );
    }
    
    /**
     * Test gameWinningTeam event.
     */
    public void testGameWinner() throws java.io.FileNotFoundException {
        SetupBase wrapGame= new SetupBase();
        Manager firstTeam= wrapGame.addManager( "Default" );
        Player firstPlayer= wrapGame.addPlayer( "Default" );
        GameEventsBase gameEvents= new GameEventsBase();
        Logic game= wrapGame.getGame( savedGameWord );
        game.setGameEventsHandler( gameEvents );
        for( int i= 0; i < savedGameWord.length(); ++i ) {
            char c= savedGameWord.charAt( i );
            try{
                game.makeGuess( c );
            }catch( Logic.AmbiguousGuessException e ) {}
        }
        assertTrue( gameEvents.gameOver );
        assertNotNull( gameEvents.gameWinningTeam );
        assertEquals( firstTeam, gameEvents.gameWinningTeam );
    }
    
    
    
    /**
     * Test updates to the status word
     */
    public void testChangedStatusWord() throws java.io.FileNotFoundException {
        SetupBase wrapGame= new SetupBase( );
        Logic game= wrapGame.getGame( savedGameWord );
        GameEventsTester gameEvents= new GameEventsTester();
        game.setGameEventsHandler( gameEvents );
        for( int i= 0; i < savedGameWord.length(); ++i ) {
            char c= savedGameWord.charAt( i );
            try{
                game.makeGuess( c );
            }catch( Logic.AmbiguousGuessException e ) {}
        }
        assertEquals( savedGameWord.length(), gameEvents.statusWordChanges );
    }
    
    /**
     * Test updates to the status word with bad guesses.
     */
    public void testChangedStatusWord_wBadGuesses() throws java.io.FileNotFoundException {
        SetupBase wrapGame= new SetupBase( );
        Logic game= wrapGame.getGame( savedGameWord );
        GameEventsTester gameEvents= new GameEventsTester();
        game.setGameEventsHandler( gameEvents );
        StringBuilder wrd= new StringBuilder( gameEvents.savedGameWord );
        // Insert crazy letters in between to simulate bad guesses
        wrd.insert( 1, 'u' );
        wrd.insert( 3, 'z' );
        wrd.insert( 5, 'y' );
        for( int i= 0; i < savedGameWord.length(); ++i ) {
            char c= savedGameWord.charAt( i );
            try{ 
                game.makeGuess( c );
            }catch( Logic.AmbiguousGuessException e ) {}
        }
        // The status word changes should be the same
        // Remember it only changes for good guesses
        assertEquals( savedGameWord.length(), gameEvents.statusWordChanges );
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
