

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
    
    /**
     * Test the constructor to make sure it can successfully construct
     */
    @Before
    public void testConstructor() {
        
        teams= new LinkedList< Manager >();
        Manager man= new Manager( "Alpha" );
        teams.add( man );
        man.addPlayer( "Bob" );
        
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
    /* @Test( expected= NullPointerException.class )
    public void testMakeGuess_NullPlayer() {
        Logic g= new Logic( Logic.MIN_ATTEMPTS, Dictionary.MAX_WORDLENGTH );
        PlayerInterface player= g.addTeam().addPlayer( "Bob" );
        g.startGame();
        g.makeGuess( null, 'a' );
    }*/
    
    /**
     * Test makeGuess with a bad argument.
     */
    /* @Test( expected= java.util.NoSuchElementException.class )
    public void testMakeGuess_BadPlayer() {
        Logic g= new Logic( Logic.MIN_ATTEMPTS, Dictionary.MAX_WORDLENGTH );
        PlayerInterface player= g.addTeam().addPlayer( "Bob" );
        g.startGame();
        g.makeGuess( new Player( "Name" ), 'a' );
    } */
    
    /**
     * Test makeGuess with a bad argument.
     */
    /* @Test( expected= IllegalArgumentException.class )
    public void testMakeGuess_WithoutStart() {
        Logic g= new Logic( Logic.MIN_ATTEMPTS, Dictionary.MAX_WORDLENGTH );
        PlayerInterface player= g.addTeam().addPlayer( "Bob" );
        g.makeGuess( player, '9' );
    } */
    
    /**
     * Test makeGuess with a bad argument.
     */
   /* @Test( expected= IllegalArgumentException.class )
    public void testMakeGuess() {
        Logic g= new Logic( Logic.MIN_ATTEMPTS, Dictionary.MAX_WORDLENGTH );
        PlayerInterface player= g.addTeam().addPlayer( "Bob" );
        g.startGame();
        g.makeGuess( player, '9' );
    }*/
    
    /**
     * Tests addTeam after a call with startGame(). The result should be an error.
     */
    /*@Test( expected= Exception.class )
    public void testAddTeam_afterStartGame() {
        Logic g= new Logic( Logic.MIN_ATTEMPTS, Dictionary.MAX_WORDLENGTH );
        g.startGame();
        g.addTeam();
    }*/
    
    /**
     * Tests addteam.
     * 
     */
    /*@Test
    public void testAddTeam() {
        Logic g= new Logic( Logic.MIN_ATTEMPTS, Dictionary.MAX_WORDLENGTH );
        assertNotNull( g.addTeam() );
    }*/
    
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
    
    /**
     * Tests startGame before there is one team in the game. Expected to fail.
     */
    /*@Test( expected= Exception.class )
    public void testStartGame_wOneTeam() {
        Logic g= new Logic( Logic.MIN_ATTEMPTS, Dictionary.MAX_WORDLENGTH );
        g.startGame();
    } */
    
    /**
     * Tests startGame before there is one player in the game. Expected to fail.
     */
    /*@Test( expected= Exception.class )
    public void testStartGame_wOnePlayer() {
        Logic g= new Logic( Logic.MIN_ATTEMPTS, Dictionary.MAX_WORDLENGTH );
        g.addTeam();
        g.startGame();
    }*/
    
    /**
     * Tests startGame before there is one player in the game.
     */
    /* @Test
    public void testStartGame() {
        Logic g= new Logic( Logic.MIN_ATTEMPTS, Dictionary.MAX_WORDLENGTH );
        g.addTeam().addPlayer( "Name" );
        g.startGame();
    } */
}
