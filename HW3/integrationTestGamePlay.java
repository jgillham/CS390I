

import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * This class will test the total experience of game focussing on the interaction between
 *  the UI and the Logic.
 *
 * @author  Josh Gillham
 * @version 10-4-12
 */
public class integrationTestGamePlay {
    SetupBase logicWrapper;
    Logic game;
    String gameWord= "Fuel";
    /**
     * Default constructor for test class integrationTestGamePlay
     */
    public integrationTestGamePlay()
    {
    }

    /**
     * Sets up the test fixture.
     *
     * Called before every test case method.
     */
    @Before
    public void setUp() throws java.io.FileNotFoundException {
        logicWrapper= new SetupBase();
        logicWrapper.addManager( "Default" );
        logicWrapper.addPlayer( "Bob" );
        game= logicWrapper.getGame( gameWord );
        
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
    abstract class GameEventsBaseTester extends GameEventsBase {
        public abstract void makeAssertions();
    }

    
    
    final int MAX_TURNS= 20;
    @Test
    public void testPlayerWins(){
        final int maxGuesses= gameWord.length();
        GameEventsBaseTester tester= new GameEventsBaseTester(){
            int badGuesses= 0;
            int errorGuesses= 0;
            int i= 0;
            public void playerUp( Player player ){
                if( i < maxGuesses )try {
                    if( !game.makeGuess( gameWord.charAt( i++ ) ) )
                        ++badGuesses;
                } catch( Exception e ) {
                    ++errorGuesses;
                }
            }
            public void makeAssertions(){
                assertFalse( gameOver );
                assertNotNull( gameWinningTeam );
                assertEquals( 0, badGuesses );
                assertEquals( 0, errorGuesses );
            }
        };
        game.setMaxAttempts( maxGuesses );
        game.setGameEventsHandler( tester );
        
        int counter= 0;
        while( counter++ < MAX_TURNS && game.getGameState() == Logic.Statis.STARTED ) {
            game.rotateTurn();
        }
        tester.makeAssertions();
    }
    
    @Test
    public void testPlayerLooses(){
        final String guesses= "abcdefghijkl";
        final int maxGuesses= gameWord.length();
        GameEventsBaseTester tester= new GameEventsBaseTester(){
            int badGuesses= 0;
            int errorGuesses= 0;
            
            int i= 0;
            public void playerUp( Player player ){
                if( i < maxGuesses )try {
                    if( !game.makeGuess( guesses.charAt( i++ ) ) )
                        ++badGuesses;
                } catch( Exception e ) {
                    ++errorGuesses;
                }
            }
            public void makeAssertions(){
                assertTrue( gameOver );
                assertNull( gameWinningTeam );
                assertEquals( maxGuesses, badGuesses );
                assertEquals( 0, errorGuesses );
            }
        };
        game.setMaxAttempts( maxGuesses );
        game.setGameEventsHandler( tester );
        int counter= 0;
        while( counter++ < MAX_TURNS && game.getGameState() == Logic.Statis.STARTED ) {
            game.rotateTurn();
        }
        assertTrue( counter < MAX_TURNS );
        tester.makeAssertions();
    }
    @Test
    public void testPlayerHasAFewBadGuessesButWins(){
        final String guesses= "fyu.eyl";
        final int maxGuesses= gameWord.length() + 3;
        GameEventsBaseTester tester= new GameEventsBaseTester(){
            int badGuesses= 0;
            int errorGuesses= 0;
            
            int i= 0;
            public void playerUp( Player player ){
                if( i < maxGuesses ) try {
                    if( !game.makeGuess( guesses.charAt( i++ ) ) )
                        ++badGuesses;
                } catch( Exception e ) {
                    ++errorGuesses;
                }
            }
            public void makeAssertions(){
                assertFalse( gameOver );
                assertNotNull( gameWinningTeam );
                assertEquals( 1, badGuesses );
                assertEquals( 2, errorGuesses );
            }
        };
        game.setMaxAttempts( maxGuesses );
        game.setGameEventsHandler( tester );
        int counter= 0;
        while( counter++ < MAX_TURNS && game.getGameState() == Logic.Statis.STARTED ) {
            game.rotateTurn();
        }
        assertTrue( counter < MAX_TURNS );
        tester.makeAssertions();
    }
    @Test
    public void testPlayerHasAFewBadGuessesButLooses(){
        final String guesses= "fyu.eyl";
        final int maxGuesses= gameWord.length() + 2;
        GameEventsBaseTester tester= new GameEventsBaseTester(){
            int badGuesses= 0;
            int errorGuesses= 0;
            
            int i= 0;
            public void playerUp( Player player ){
                if( i < maxGuesses ) try {
                    if( !game.makeGuess( guesses.charAt( i++ ) ) )
                        ++badGuesses;
                } catch( Exception e ) {
                    ++errorGuesses;
                }
            }
            public void makeAssertions(){
                assertFalse( gameOver );
                assertNotNull( gameWinningTeam );
                assertEquals( 1, badGuesses );
                assertEquals( 2, errorGuesses );
            }
        };
        game.setMaxAttempts( maxGuesses );
        game.setGameEventsHandler( tester );
        int counter= 0;
        while( counter++ < MAX_TURNS && game.getGameState() == Logic.Statis.STARTED ) {
            game.rotateTurn();
        }
        assertTrue( counter < MAX_TURNS );
        tester.makeAssertions();
    }
}
