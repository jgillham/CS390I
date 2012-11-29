

import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * Tests the HCode class.
 *
 * @author  Josh Gillham
 * @version 11-28-12
 */
public class HCodeTest {
    // BEGIN Good Behavor Tests
    /**
     * Proves that the constructor produces an object given good parameters.
     */
    @Test
    public void testConstructor( ) {
        try {
            new HCode( "10", 'l' );
        }
        catch ( Throwable e ) {
            fail ( "Constructor should not throw an error." );
        }
    }
    
    /**
     * Proves that getSymbol() returns the letter passed into the constructor.
     */
    @Test
    public void testGetSymbol() {
        HCode instance = new HCode( "10", 'l' );
        assertEquals( 'l', instance.getSymbol() );
        instance = new HCode( "10", 'a' );
        assertEquals( 'a', instance.getSymbol() );
    }
    
    /**
     * Proves that equals() returns true when all the fields are equal 
     *  including fields in the parent.
     */
    @Test
    public void testEquals() {
        HCode instance1 = new HCode( "10", 'l' );
        HCode instance2 = new HCode( "10", 'l' );
        assertTrue( instance1.equals( instance2 ) );
        instance1.setFrequency( 1 );
        instance2.setFrequency( 1 );
        assertTrue( instance1.equals( instance2 ) );
        instance1 = new HCode( "1", 'a' );
        instance2 = new HCode( "1", 'a' );
        instance1.setFrequency( 2 );
        instance2.setFrequency( 2 );
        assertTrue( instance1.equals( instance2 ) );
        instance1.setFrequency( 3 );
        instance2.setFrequency( 3 );
        assertTrue( instance1.equals( instance2 ) );
    }
    // END Good Behavor Tests
}