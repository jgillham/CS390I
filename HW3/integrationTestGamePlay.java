

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

    
    
    
    @Test
    public void testPlayerWins(){
        GameEventsBaseTester tester= new GameEventsBaseTester(){
            int i= 0;
            public void playerUp( Player player ){
                game.makeGuess( gameWord.charAt( i++ ) );
            }
            public void makeAssertions(){
                assertNotNull( gameWinningTeam );
            }
        };
        game.setGameEventsHandler( tester );
        
        while( game.getGameState() == Logic.Statis.STARTED ) {
            game.rotateTurn();
        }
        tester.makeAssertions();
        
        
        
    }
}
