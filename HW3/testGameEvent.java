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
public class testGameEvent{
    
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
    public void testConstructor() throws Exception {
        SetupBase wrapGame= new SetupBase( );
        Manager firstTeam= wrapGame.addManager( "Default" );
        Player firstPlayer= wrapGame.addPlayer( "Default" );
        
        Logic game= wrapGame.getGame();
        GameEventsBase gameEvents= new GameEventsBase();
        game.setGameEventsHandler( gameEvents );
        //assertEquals( firstTeam, gameEvents.teamUp );
        assertEquals( firstPlayer, gameEvents.playerUp );
    }
    
    /**
     * Test gameOver event.
     */
    @Test
    public void testGameOver() throws Exception {
        SetupBase wrapGame= new SetupBase( );
        GameEventsBase gameEvents= new GameEventsBase();
        wrapGame.addManager( "D" );
        wrapGame.addPlayer( "D" );
        Logic game= wrapGame.getGame();
        game.setGameEventsHandler( gameEvents );
        String partialABCs= "abcdefghijklmnopqr";
        for( int i= 0; i < partialABCs.length() && i < game.getAttempts(); ++i ) {
            char c= partialABCs.charAt( i );
            try{
                game.makeGuess( c );
            System.out.println( "Guesses Remaining: ");
            }catch( Logic.AmbiguousGuessException e ) {}
            game.rotateTurn();

        }
        assertTrue( gameEvents.gameOver );
        assertNull( gameEvents.gameWinningTeam );
    }
    
    /**
     * Test gameWinningTeam event.
     */
    @Test
    public void testGameWinner() throws Exception {
        SetupBase wrapGame= new SetupBase();
        Manager firstTeam= wrapGame.addManager( "Default" );
        Player firstPlayer= wrapGame.addPlayer( "Default" );
        GameEventsBase gameEvents= new GameEventsBase();
        Logic game= wrapGame.getGame( savedGameWord );
        game.setGameEventsHandler( gameEvents );
        int i= 0;
        while( game.getGameState() == Logic.Statis.STARTED && i < savedGameWord.length() ){
            char c= savedGameWord.charAt( i++ );
            try{
                game.makeGuess( c );
            }catch( Logic.AmbiguousGuessException e ) {}
            game.rotateTurn();
        }
        
        assertFalse( gameEvents.gameOver );
        assertNotNull( gameEvents.gameWinningTeam );
        assertEquals( firstTeam, gameEvents.gameWinningTeam );
    }
    
    
    
    /**
     * Test updates to the status word
     */
    @Test
    public void testChangedStatusWord() throws Exception {
        SetupBase wrapGame= new SetupBase( );
        wrapGame.addManager( "D" );
        wrapGame.addPlayer( "D" );
        Logic game= wrapGame.getGame( savedGameWord );
        GameEventsTester gameEvents= new GameEventsTester();
        game.setGameEventsHandler( gameEvents );
        int i= 0;
        while( game.getGameState() == Logic.Statis.STARTED && i < savedGameWord.length() - 1 ){
            char c= savedGameWord.charAt( i++ );
            try{
                game.makeGuess( c );
            }catch( Logic.AmbiguousGuessException e ) {}
            game.rotateTurn();
        }
        assertFalse( gameEvents.gameOver );
        assertNull( gameEvents.gameWinningTeam );
        assertEquals( Logic.Statis.STARTED, game.getGameState() );
        assertEquals( savedGameWord.length(), gameEvents.statusWordChanges );
    }
    
    /**
     * Test updates to the status word with bad guesses.
     */
    @Test
    public void testChangedStatusWord_wBadGuesses() throws Exception {
        SetupBase wrapGame= new SetupBase( );
        wrapGame.addManager( "D" );
        wrapGame.addPlayer( "D" );
        Logic game= wrapGame.getGame( savedGameWord );
        GameEventsTester gameEvents= new GameEventsTester();
        game.setGameEventsHandler( gameEvents );
        StringBuilder wrd= new StringBuilder( savedGameWord );
        // Insert crazy letters in between to simulate bad guesses
        wrd.insert( 1, 'u' );
        wrd.insert( 3, 'z' );
        wrd.insert( 5, 'y' );
        int i= 0;
        while( game.getGameState() == Logic.Statis.STARTED && i < savedGameWord.length() ){
            char c= savedGameWord.charAt( i++ );
            try{ 
                game.makeGuess( c );
            }catch( Logic.AmbiguousGuessException e ) {}
            game.rotateTurn();
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
