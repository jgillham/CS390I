

import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import java.util.List;
import java.util.LinkedList;

/**
 * This test unit will check the integrity of the Logic class.
 * 
 * TODO:
 *  testGetStatusWord_InGame()
 *  testMakeGuess_InGame()
 *
 * @author  Josh Gillham
 * @version 9-19-12
 */
public class testLogic
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
    
    @Test( expected= NullPointerException.class )
    public void testConstructor_Null(){
        Logic g= new Logic( null, Dictionary.MIN_WORDLENGTH );
    }
    
    @Test( expected= IllegalArgumentException.class )
    public void testConstructor_NoPlayers(){
        Logic g= new Logic( new LinkedList< Manager >(), Dictionary.MIN_WORDLENGTH );
    }
    
    @Test( expected= IllegalArgumentException.class )
    public void testConstructor_WordTooSmall(){
        Logic g= new Logic( teams, Dictionary.MIN_WORDLENGTH - 1 );
    }
    
    @Test( expected= IllegalArgumentException.class )
    public void testConstructor_WordTooLarge(){
        Logic g= new Logic( teams, Dictionary.MAX_WORDLENGTH + 1 );
    }
    
    /**
     * GetStatusWord should return all underscores before the game starts.
     */
    /* @Test
    public void testGetStatusWord_BeforeGame() {
        for( int i= Dictionary.MIN_WORDLENGTH; i <= Dictionary.MAX_WORDLENGTH; ++i ) {
            Logic g= new Logic( teams, i );
            String word= g.getWordStatus();
            for( int k= 0; k <  word.length(); ++k )
                assertEquals( '_', word.charAt( k ) );
        }
    }*/
    
    /**
     * Test makeGuess with a bad argument.
     */
    @Test( expected= NullPointerException.class )
    public void testMakeGuess_NullPlayer() {
        game.makeGuess( null, 'a' );
    }
    
    /**
     * Test makeGuess with a bad argument.
     */
    @Test( expected= java.util.NoSuchElementException.class )
    public void testMakeGuess_BadPlayer() {
        game.makeGuess( new Player( "Name" ), 'a' );
    }
    
    /**
     * Test makeGuess with a bad argument.
     */
    @Test( expected= IllegalArgumentException.class )
    public void testMakeGuess_wDigit() {
        game.makeGuess( player, '9' );
    }
    
    /**
     * Test makeGuess.
     */
    @Test( expected= IllegalArgumentException.class )
    public void testMakeGuess() {
        game.makeGuess( player, 'a' );
    }
    
    /**
     * Test UI event setter.
     * 
     */
    @Test
    public void testSetGameEventsHandler() {
        game.setGameEventsHandler( new GameUI() );
    }
}
