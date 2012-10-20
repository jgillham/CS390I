import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import java.util.List;
import java.util.LinkedList;
import java.util.TreeMap;
import java.util.SortedSet;
import java.util.TreeSet;

/**
 * This test unit will check the integrity of the Logic class.
 *
 * @author  Josh Gillham
 * @version 9-23-12
 */
public class testLogic {
    
    /** Keeps the Test_InstrumentLogic class for other tests. */
    SetupBase wrapLogic;
    /** Keeps a Logic instance for other tests. */
    Logic game;
    
    class GameEventsTester extends GameEventsBaseTester {
        public void makeAssertions(){}
    }
    
    
    /**
     * Test the constructor to make sure it can successfully construct
     */
    @Before
    public void testConstructor() throws Exception {
        wrapLogic= new SetupBase();
        wrapLogic.addManager( "Alpha" );
        wrapLogic.addPlayer( "bob" );
        game= new Logic( wrapLogic.getTeams(), 3 );
    }
    
    @Test( expected= NullPointerException.class )
    public void testConstructor_Null() throws Exception{
        Logic g= new Logic( null, 5 );
    }
    
    /**
     * Tests the constructor to ensure it fails when there are no teams.
     */
    @Test( expected= Logic.NoTeamsException.class )
    public void testConstructor_NoTeams() throws Exception{
        Logic g= new Logic( new LinkedList< Manager >(), 5 );
    }
    
    /**
     * Tests the constructor to ensure it fails when there are no players.
     */
    @Test( expected= Logic.EmptyTeamsException.class )
    public void testConstructor_NoPlayers() throws Exception{
        List< Manager > teams= new LinkedList< Manager >();
        teams.add( new Manager( "Alpha" ) );
        Logic g= new Logic( teams, 5 );
    }
    
    /**
     * Tests the constructor to ensure it fails when there are empty teams.
     */
    @Test( expected= Logic.EmptyTeamsException.class )
    public void testConstructor_NoPlayers2() throws Exception{
        List< Manager > teams= new LinkedList< Manager >();
        Manager man= new Manager( "Alpha" );
        man.addPlayer( "bob" );
        teams.add( new Manager( "Bravo" ) );
        Logic g= new Logic( teams, 5 );
    }
    
    /**
     * Tests the constructor to ensure it fails when the wordLength is smaller than the dictionary limit.
     */
    @Test( expected= IllegalArgumentException.class )
    public void testConstructor_WordTooSmall() throws Exception{
        new Logic( wrapLogic.getTeams(), -2 );
    }
    
    /**
     * Tests the constructor to ensure it fails when the wordLength is larger than the dictionary limit.
     */
    @Test( expected= IllegalArgumentException.class )
    public void testConstructor_WordTooLarge() throws Exception{
        new Logic( wrapLogic.getTeams(), 20 );
    }
    
    /**
     * Tests the constructor to ensure it fails when the gameWord is null.
     */
    @Test( expected= NullPointerException.class )
    public void testConstructor_NullGameWord() throws Exception{
        new Logic( wrapLogic.getTeams(), null );
    }
    
    /**
     * Tests the constructor to ensure it fails when the gameWord is empty.
     */
    @Test( expected= IllegalArgumentException.class )
    public void testConstructor_EmptyGameWord() throws Exception{
        new Logic( wrapLogic.getTeams(), "" );
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
     * Test makeGuess with a bad argument. Error expected.
     */
    @Test( expected= IllegalArgumentException.class )
    public void testMakeGuess_wDigit()throws Exception {
        game.makeGuess( '9' );
    }
    
    /**
     * Test makeGuess. Should not throw an error.
     */
    @Test
    public void testMakeGuess() throws Exception {
        Logic newGame= new Logic( wrapLogic.getTeams(), 5 );
        newGame.makeGuess( 'a' );
    }
    
    /**
     * Test makeGuess. Should throw an error.
     */
    @Test( expected= Logic.PlayerOutOfTurnException.class )
    public void testMakeGuess_NoRotateTurn() throws Exception {
        Logic newGame= new Logic( wrapLogic.getTeams(), 5 );
        newGame.makeGuess( 'a' );
        newGame.makeGuess( 'b' );
    }
    
    /**
     * Test makeGuess. Should not throw an error.
     */
    @Test
    public void testMakeGuess_RotateTurn() throws Exception {
        Logic newGame= new Logic( wrapLogic.getTeams(), 5 );
        newGame.makeGuess( 'a' );
        newGame.rotateTurn();
        newGame.makeGuess( 'b' );
    }
    
    /**
     * Tests makeGuess to make sure good guesses return true.
     */
    @Test
    public void testMakeGuess_GoodGuess() throws Exception{
        {
            Logic newGame= new Logic( wrapLogic.getTeams(), "logic" );
            assertTrue( newGame.makeGuess( 'l' ) );
        }
        
        {
            Logic newGame= new Logic( wrapLogic.getTeams(), "logic" );
            assertTrue( newGame.makeGuess( 'g' ) );
        }
        
        {
            Logic newGame= new Logic( wrapLogic.getTeams(), "logic" );
            assertTrue( newGame.makeGuess( 'c' ) );
        }
    }
    
    /**
     * Tests makeGuess to make sure good guesses return true. Capital letters shouldn't matter.
     */
    @Test
    public void testMakeGuess_GoodGuess_Capital() throws Exception{
        {
            Logic newGame= new Logic( wrapLogic.getTeams(), "logic" );
            assertTrue( newGame.makeGuess( 'L' ) );
        }
        
        {
            Logic newGame= new Logic( wrapLogic.getTeams(), "logic" );
            assertTrue( newGame.makeGuess( 'G' ) );
        }
        
        {
            Logic newGame= new Logic( wrapLogic.getTeams(), "logic" );
            assertTrue( newGame.makeGuess( 'C' ) );
        }
    }
    
    /**
     * Tests makeGuess to make sure bad guesses return false.
     */
    @Test
    public void testMakeGuess_BadGuess() throws Exception{
        Logic newGame= new Logic( wrapLogic.getTeams(), "logic" );
        assertFalse( newGame.makeGuess( 'a' ) );
    }
    
    /**
     * Test makeGuess with a bad argument. Error expected.
     */
    @Test( expected= IllegalArgumentException.class )
    public void testMakeGuess_String_wLength()throws Exception {
        game.makeGuess( "op" );
    }
    
    /**
     * Test makeGuess with a bad argument. Error expected.
     */
    @Test( expected= NullPointerException.class )
    public void testMakeGuess_String_wNull()throws Exception {
        game.makeGuess( null );
    }
    
    /**
     * Test makeGuess with a bad argument. Error expected.
     */
    @Test( expected= Logic.PlayerOutOfTurnException.class )
    public void testMakeGuess_String_NoRotateTurn()throws Exception {
        game.makeGuess( "cat" );
        game.makeGuess( "mouse" );
    }
    
    /**
     * Test makeGuess.
     */
    @Test
    public void testMakeGuess_String_RotateTurn()throws Exception {
        game.makeGuess( "cat" );
        game.rotateTurn();
        game.makeGuess( "rat" );
    }
    
    /**
     * Test makeGuess with a bad argument. Error expected.
     */
    @Test( expected= IllegalArgumentException.class )
    public void testMakeGuess_String_Nonletters()throws Exception {
        game.makeGuess( "ca$t" );
    }
    
    /**
     * Test makeGuess with a bad argument. Error expected.
     */
    @Test( expected= IllegalArgumentException.class )
    public void testMakeGuess_String_WrongLength()throws Exception {
        game.makeGuess( "sound" );
    }
    
    /**
     * Test UI event setter to make sure this doesn't throw an error.
     */
    @Test
    public void testSetGameEventsHandler() {
        game.setGameEventsHandler( new GameEventsTester() );
    }
    
    /**
     * Test UI event setter to make sure null does not throw an error.
     */
    @Test
    public void testSetGameEventsHandler_null() {
        game.setGameEventsHandler( null );
    }
    
    @Test( expected= IllegalArgumentException.class )
    public void testSetMaxAttempts_badArgs() throws Exception {
        Logic newGame= new Logic( wrapLogic.getTeams(), "logic" );
        newGame.setMaxAttempts( Logic.MIN_ATTEMPTS - 1 );
    }
    
    @Test
    public void testSetMaxAttempts() throws Exception {
        Logic newGame= new Logic( wrapLogic.getTeams(), "logic" );
        newGame.setMaxAttempts( 5 );
        assertEquals( 5, newGame.getRemainingGuesses() );
        newGame.setMaxAttempts( 8 );
        assertEquals( 8, newGame.getRemainingGuesses() );
        newGame.setMaxAttempts( 15 );
        assertEquals( 15, newGame.getRemainingGuesses() );
    }
    
    @Test
    public void testRotateTurn() throws Exception {
        Logic newGame= new Logic( wrapLogic.getTeams(), "logic" );
        newGame.rotateTurn();
    }
    
    @Test
    public void testGetGameState() throws Exception {
        Logic newGame= new Logic( wrapLogic.getTeams(), "logic" );
        assertEquals( Logic.Statis.STARTED, newGame.getGameState() );
        newGame.setMaxAttempts( 5 );
        newGame.rotateTurn();
        newGame.makeGuess( 'a' );
        newGame.rotateTurn();
        newGame.makeGuess( 'b' );
        newGame.rotateTurn();
        newGame.makeGuess( 'c' );
        newGame.rotateTurn();
        newGame.makeGuess( 'd' );
        newGame.rotateTurn();
        newGame.makeGuess( 'e' );
        newGame.rotateTurn();
        assertEquals( Logic.Statis.OVER, newGame.getGameState() );
    }
    
    @Test
    public void testGetGameState_GameOver() throws Exception {
        Logic newGame= new Logic( wrapLogic.getTeams(), "logic" );
        assertEquals( Logic.Statis.STARTED, newGame.getGameState() );
    }
    
    @Test
    public void testGetGuesses() throws Exception {
        Logic newGame= new Logic( wrapLogic.getTeams(), "logic" );
        assertEquals( 0, newGame.getGuesses().length );
        newGame.makeGuess( 'j' );
        assertEquals( 1, newGame.getGuesses().length );
    }
    
    @Test
    public void testGetRemainingGuesses() throws Exception {
        Logic newGame= new Logic( wrapLogic.getTeams(), "logic" );
        newGame.setMaxAttempts( 5 );
        newGame.rotateTurn();
        assertEquals( 5, newGame.getRemainingGuesses() );
        newGame.makeGuess( 'j' );
        newGame.rotateTurn();
        assertEquals( 4, newGame.getRemainingGuesses() );
        newGame.makeGuess( 'a' );
        newGame.rotateTurn();
        assertEquals( 3, newGame.getRemainingGuesses() );
        newGame.makeGuess( 'b' );
        newGame.rotateTurn();
        assertEquals( 2, newGame.getRemainingGuesses() );
        newGame.makeGuess( 'c' );
        newGame.rotateTurn();
        assertEquals( 1, newGame.getRemainingGuesses() );
        newGame.makeGuess( 'd' );
        assertEquals( 0, newGame.getRemainingGuesses() );
    }
    
    /**
     * Tests the chooseKey with a null.
     */
    @Test( expected= NullPointerException.class )
    public void testChooseKey_null() throws Exception{
        game.chooseKey( null );
    }
    
    /**
     * Tests chooseKey with an empty map.
     */
    @Test( expected= IllegalArgumentException.class )
    public void testChooseKey_empty() throws Exception{
        game.chooseKey( new TreeMap< String, SortedSet< String > >() );
    }
    
    /**
     * Prove that the logic will always go with the largest list
     */
    @Test
    public void testChooseKey() throws Exception{
        Logic instance= new Logic( wrapLogic.getTeams(), 3 );
        
        java.util.Map< String, SortedSet< String > > input= new java.util.TreeMap< String, SortedSet< String > >();
        SortedSet< String > temp;
        
        temp= new TreeSet< String >();
        temp.add( "casa" );
        input.put( "-a-a", temp );
        
        temp= new TreeSet< String >();
        temp.add( "cant" );
        temp.add( "call" );
        temp.add( "cars" );
        input.put( "-a--", temp );
        
        temp= new TreeSet< String >();
        temp.add( "acer" );
        temp.add( "acts" );
        input.put( "a---", temp );
        
        temp= new TreeSet< String >();
        temp.add( "tens" );
        input.put( "----", temp );
        
        temp= new TreeSet< String >();
        temp.add( "eval" );
        input.put( "--a-", temp );
        
        assertFalse( instance.chooseKey( input ).equalsIgnoreCase( "-a--" ) );
        
    }
    
    /**
     * Tests the chooseWord with a null value.
     */
    @Test( expected= NullPointerException.class )
    public void testChooseWord_null() throws Exception{
        game.chooseWord( null );
    }
    
    /**
     * Tests the chooseWord with an empty word.
     */
    @Test( expected= IllegalArgumentException.class )
    public void testChooseWord_empty() throws Exception{
        game.chooseWord( "" );
    }
    
    /**
     * Prove that the player can never win unless there is one word left.
     */
    @Test
    public void testChooseWord() throws Exception{
        Dictionary.dispose();
        Dictionary dictionary= Dictionary.getInstance();
        dictionary.depositWord( "cat" );
        dictionary.depositWord( "rat" );
        dictionary.depositWord( "mat" );
        EvilLogic instance= new EvilLogic( wrapLogic.getTeams(), 3 );
        java.util.Set< String > words= dictionary.getSet( 3 );
        java.util.Iterator< String > i= words.iterator();
        int c= 0;
        while( i.hasNext() && c++ < words.size() - 1 ) {
            assertFalse( instance.chooseWord( i.next() ) );
        }
        assertTrue( instance.chooseWord( i.next() ) );
        
    }
}
