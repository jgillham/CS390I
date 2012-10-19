

import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import java.util.LinkedList;
import java.util.List;
import java.util.TreeMap;
import java.util.SortedSet;
import java.util.TreeSet;

/**
 * The test class testEvilLogic.
 *
 * @author  Josh Gillham
 * @version 10-19-12
 */
public class testEvilLogic {
    /** Keeps the Test_InstrumentLogic class for other tests. */
    SetupBase wrapLogic;
    /** Keeps a Logic instance for other tests. */
    EvilLogic game;
    
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
        game= new EvilLogic( wrapLogic.getTeams(), 3 );
    }
    
    @Test( expected= NullPointerException.class )
    public void testConstructor_Null() throws Exception{
        EvilLogic g= new EvilLogic( null, 5 );
    }
    
    /**
     * Tests the constructor to ensure it fails when there are no teams.
     */
    @Test( expected= EvilLogic.NoTeamsException.class )
    public void testConstructor_NoTeams() throws Exception{
        EvilLogic g= new EvilLogic( new LinkedList< Manager >(), 5 );
    }
    
    /**
     * Tests the constructor to ensure it fails when there are no players.
     */
    @Test( expected= EvilLogic.EmptyTeamsException.class )
    public void testConstructor_NoPlayers() throws Exception{
        List< Manager > teams= new LinkedList< Manager >();
        teams.add( new Manager( "Alpha" ) );
        EvilLogic g= new EvilLogic( teams, 5 );
    }
    
    /**
     * Tests the constructor to ensure it fails when there are empty teams.
     */
    @Test( expected= EvilLogic.EmptyTeamsException.class )
    public void testConstructor_NoPlayers2() throws Exception{
        List< Manager > teams= new LinkedList< Manager >();
        Manager man= new Manager( "Alpha" );
        man.addPlayer( "bob" );
        teams.add( new Manager( "Bravo" ) );
        EvilLogic g= new EvilLogic( teams, 5 );
    }
    
    /**
     * Tests the constructor to ensure it fails when the wordLength is smaller than the dictionary limit.
     */
    @Test( expected= IllegalArgumentException.class )
    public void testConstructor_WordTooSmall() throws Exception{
        new EvilLogic( wrapLogic.getTeams(), -2 );
    }
    
    /**
     * Tests the constructor to ensure it fails when the wordLength is larger than the dictionary limit.
     */
    @Test( expected= IllegalArgumentException.class )
    public void testConstructor_WordTooLarge() throws Exception{
        new EvilLogic( wrapLogic.getTeams(), 20 );
    }
    
    /**
     * Tests the constructor to ensure it fails when the gameWord is null.
     */
    @Test( expected= NullPointerException.class )
    public void testConstructor_NullGameWord() throws Exception{
        new EvilLogic( wrapLogic.getTeams(), null );
    }
    
    /**
     * Tests the constructor to ensure it fails when the gameWord is empty.
     */
    @Test( expected= IllegalArgumentException.class )
    public void testConstructor_EmptyGameWord() throws Exception{
        new EvilLogic( wrapLogic.getTeams(), "" );
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
        EvilLogic instance= new EvilLogic( wrapLogic.getTeams(), 3 );
        
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
        
        assertEquals( "-a--", instance.chooseKey( input ) );
        
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
