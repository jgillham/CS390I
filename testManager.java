

import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.Assert;

/**
 * The test class testManager.
 *
 * @author  (your name)
 * @version (a version number or a date)
 */
public class testManager 
{
    /**
     * This class does not do anything
     */
    private class MockManager implements Manager{
        public MockManager( String name ){ throw new IllegalArgumentException(); }
        
        public int getScore(){ return 5; }
        public Player addPlayer( String name ) { return null; }
        public boolean kickPlayer( Player player ) { return false; }
        public Player getPlayerUp() { return null; }
        public int getRosterSize() { return 0; }
        public void nextPlayer() {}
        public String getName() { return ""; }
        
    }
    /**
     * Default constructor for test class testManager
     */
    public testManager()
    {
    }
    
    /**
     * Tests the constructor behavior.
     *
     * Called before every test case method.
     */
    @Before
    public void setUp(){
        try{
            String teamName= "Test Team";
            Manager m= new MockManager( "Test Team" );
        } catch( Exception e ) {
            fail( "Constructor should not throw error" );
        }
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
    
    /**
     * Test the constructor with bad names. Errors should be thrown.
     */
    @Test
    public void testConstructor_BadTeamNames(){
        // Test null names
        try{
            Manager m= new MockManager( null );
            fail( "Constructor should have thrown an error." );
        }catch( Exception e ){}
        // Test empty names
        try{
            Manager m= new MockManager( "" );
            fail( "Constructor should have thrown an error." );
        }catch( Exception e ){}
    }
    
    /**
     * Tests getScore() to ensure that it is initialized to 0.
     */
    @Test
    public void testGetScore() {
        String teamName= "Test Team";
        Manager m= new MockManager( "Test Team" );
        
        Assert.assertEquals( 0, m.getScore() );
    }
    
    /**
     * Tests getName() to ensure that it is initialized properly.
     */
    @Test
    public void testGetName() {
        String teamName= "Test Team";
        Manager m= new MockManager( "Test Team" );
        
        Assert.assertEquals( teamName, m.getName() );
    }
        
    /**
     * Tests add player. Should return a non-null.
     */
    @Test
    public void testAddPlayer(){
        String teamName= "Test Team";
        Manager m= new MockManager( "Test Team" );
        
        String[] morePlayerNames= { "Susan", "George", "Bob", "Lucas", "Fred" };
        
        for( String name: morePlayerNames )
            Assert.assertNotNull( m.addPlayer( name ) );
    }
    
    /**
     * Test roster size. Should return the number of players.
     */
    @Test
    public void testGetRosterSize() {
        String teamName= "Test Team";
        Manager m= new MockManager( "Test Team" );
        
        for( int i= 0; i < 10; ++i ){
            m.addPlayer( new Integer( i ).toString() );
            Assert.assertEquals( i + 1, m.getRosterSize() );
        }
    }
    
    /**
     * Test getPlayerUp() by adding players and checking that
     *  it always returns the first player.
     */
    @Test
    public void testGetPlayeUp() {
        String teamName= "Test Team";
        Manager m= new MockManager( "Test Team" );
        Player firstPlayer= null;
        for( int i= 0; i < 10; ++i ){
            if( i == 0 )
                firstPlayer= m.addPlayer( new Integer( i ).toString() );
            else
                m.addPlayer( new Integer( i ).toString() );
            Assert.assertEquals( firstPlayer, m.getPlayerUp() );
        }
    }
    
    /**
     * Tests nextPlayer() by first adding each player then
     *  calling next and testing if the next player is up.
     */
    @Test
    public void testNextPlayer(){
        String teamName= "Test Team";
        Manager m= new MockManager( "Test Team" );
        
        for( int i= 0; i < 10; ++i ){
            m.addPlayer( new Integer( i ).toString() );
        }
        
        for( int i= 1; i < 10; ++i ){
            m.nextPlayer();
            Assert.assertEquals( new Integer( i ), m.getPlayerUp() );
        }
        
    }
}
