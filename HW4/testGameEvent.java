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
    
    class GameEventsTester extends GameEventsBaseTester {
        public void makeAssertions(){}
    }
    
    
    /**
     * Test the constructor to make sure it can successfully construct
     */
    @Before
    public void testConstructor() throws Exception {
        SetupBase wrapGame= new SetupBase( );
        Manager firstTeam= wrapGame.addManager( "Default" );
        Player firstPlayer= wrapGame.addPlayer( "Default" );
        
        Logic game= new Logic( wrapGame.getTeams(), 5 );
        GameEventsTester gameEvents= new GameEventsTester();
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
        GameEventsTester gameEvents= new GameEventsTester();
        wrapGame.addManager( "D" );
        wrapGame.addPlayer( "D" );
        String partialABCs= "abcdefghijklmnopqr";
        Logic game= new Logic( wrapGame.getTeams(), 5 );
        game.setGameEventsHandler( gameEvents );
        game.setMaxAttempts( 5 );
        System.out.println( "Hello");
        int i= 0;
        while( game.getGameState() == Logic.Statis.STARTED && i < partialABCs.length() ){
            System.out.println( "Round  "+i);
            char c= partialABCs.charAt( i++ );
            try{
                game.makeGuess( c );
            System.out.println( "Guess accepted");
            }catch( Logic.AmbiguousGuessException e ) {}
            game.rotateTurn();

        }
        System.out.println( "Goodby");
        assertTrue( gameEvents.gameOver );
        assertNull( gameEvents.gameWinningTeam );
        assertEquals( Logic.Statis.OVER, game.getGameState() );
    }
    
    /**
     * Test gameWinningTeam event.
     */
    @Test
    public void testGameWinner() throws Exception {
        SetupBase wrapGame= new SetupBase();
        Manager firstTeam= wrapGame.addManager( "Default" );
        Player firstPlayer= wrapGame.addPlayer( "Default" );
        GameEventsTester gameEvents= new GameEventsTester();
        Logic game= new Logic( wrapGame.getTeams(), savedGameWord );
        game.setGameEventsHandler( gameEvents );
        game.setMaxAttempts( savedGameWord.length() );
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
        assertEquals( Logic.Statis.WINNER, game.getGameState() );
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
        Logic game= new Logic( wrapGame.getTeams(), savedGameWord );
        GameEventsTester gameEvents= new GameEventsTester();
        game.setGameEventsHandler( gameEvents );
        game.setMaxAttempts( savedGameWord.length() );
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
        char c= savedGameWord.charAt( i++ );
        try{
            game.makeGuess( c );
        }catch( Logic.AmbiguousGuessException e ) {}
        game.rotateTurn();
        assertFalse( gameEvents.gameOver );
        assertNotNull( gameEvents.gameWinningTeam );
        assertEquals( Logic.Statis.WINNER, game.getGameState() );
        assertEquals( savedGameWord.length() + 1, gameEvents.statusWordChanges );
    }
    
    /**
     * Test updates to the status word with bad guesses.
     */
    @Test
    public void testChangedStatusWord_wBadGuesses() throws Exception {
        SetupBase wrapGame= new SetupBase( );
        wrapGame.addManager( "D" );
        wrapGame.addPlayer( "D" );
        Logic game= new Logic( wrapGame.getTeams(), savedGameWord );
        GameEventsTester gameEvents= new GameEventsTester();
        game.setGameEventsHandler( gameEvents );
        StringBuilder wrd= new StringBuilder( savedGameWord );
        // Insert crazy letters in between to simulate bad guesses
        wrd.insert( 1, 'u' );
        wrd.insert( 3, 'z' );
        wrd.insert( 5, 'y' );
        game.setMaxAttempts( wrd.length() );
        int i= 0;
        System.out.println( "helo 111");
        while( game.getGameState() == Logic.Statis.STARTED && i < wrd.length() ){
            char c= savedGameWord.charAt( i++ );
            try{ 
                game.makeGuess( c );
            }catch( Logic.AmbiguousGuessException e ) {}
            game.rotateTurn();
        }
        System.out.println( "gb 111");
        assertFalse( gameEvents.gameOver );
        assertNotNull( gameEvents.gameWinningTeam );
        assertEquals( Logic.Statis.WINNER, game.getGameState() );
        // The status word changes should be the same
        // Remember it only changes for good guesses
        assertEquals( savedGameWord.length() + 1, gameEvents.statusWordChanges );
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
