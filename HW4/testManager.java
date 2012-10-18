import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.Assert;

/**
 * The test class testManager.
 *
 * @author  Josh Gillham
 * @version 9-23-12
 */
public class testManager {
    
    /**
     * Test the constructor with a null. Errors are expected
     */
    @Test( expected= NullPointerException.class )
    public void testConstructor_NullName(){
        Manager m= new Manager( null );
    }
    
    /**
     * Test the constructor with an empty name. Errors are expected
     */
    @Test( expected= IllegalArgumentException.class )
    public void testConstructor_BadTeamNames(){
        Manager m= new Manager( "" );
    }
    
    /**
     * Test constructor to ensure no errors.
     */
    @Before
    public void testConstructor() {
        Manager m= new Manager( "Alpha" );
    }
        
    /**
     * Tests add player. Should return a non-null.
     */
    @Test
    public void testAddPlayer(){
        String teamName= "Test Team";
        Manager m= new Manager( "Test Team" );
        
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
        Manager m= new Manager( "Test Team" );
        
        Assert.assertEquals( 0, m.getRosterSize() );
        
        for( int i= 0; i < 10; ++i ){
            m.addPlayer( new Integer( i ).toString() );
            Assert.assertEquals( i + 1, m.getRosterSize() );
        }
    }
    
    /**
     * Test getPlayerUp() with no players. Errors are expected.
     */
    @Test( expected= java.util.NoSuchElementException.class )
    public void testGetPlayerUp_NoPlayers() {
        String teamName= "Test Team";
        Manager m= new Manager( "Test Team" );
        m.getPlayerUp();
    }
    
    /**
     * Test getPlayerUp() by adding players and checking that
     *  it always returns the first player.
     */
    @Test
    public void testGetPlayerUp() {
        String teamName= "Test Team";
        Manager m= new Manager( "Test Team" );
        Player firstPlayer= null;
        for( int i= 0; i < 10; ++i ){
            if( i == 0 )
                firstPlayer= m.addPlayer( new Integer( i ).toString() );
            else
                m.addPlayer( new Integer( i ).toString() );
            Assert.assertEquals( firstPlayer, m.getPlayerUp() );
        }
    }
}
