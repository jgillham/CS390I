

import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * Tests the HNode class.
 *
 * @author  Josh Gillham
 * @version 11-28-12
 */
public class HNodeTest {
    // BEGIN Good Behavor Tests
    /**
     * Proves that the constructor will produce the object without errors
     *  given the correct parameters.
     */
    @Test
    public void testConstructor( ) {
        try {
            new HNode( 1, null, null );
        }
        catch ( Throwable e ) {
            e.printStackTrace();
            fail( "Constructor should not through an error." );
        }
    }
    
    /**
     * Proves that set and get frequency have a working relationship.
     */
    @Test
    public void testGetAndSetFrequency( ) {
        HNode instance = new HNode( 2, null, null );
        instance.setFrequency( 1 );
        assertEquals( 1, instance.getFrequency() );
        instance.setFrequency( 0 );
        assertEquals( 0, instance.getFrequency() );
        instance.setFrequency( 5 );
        assertEquals( 5, instance.getFrequency() );
    }
    
    /**
     * Proves that compareTo() returns the correct value.
     */
    @Test
    public void testCompareTo( ) {
        HNode instance = new HNode( 0, null, null );
        HNode instance2 = new HNode( 0, null, null );
        assertEquals( 0, instance.compareTo( instance2 ) );
        instance.setFrequency( 1 );
        assertEquals( 1, instance.compareTo( instance2 ) );
        instance2.setFrequency( 2 );
        assertEquals( -1, instance.compareTo( instance2 ) );
        instance.setFrequency( 3 );
        assertEquals( 1, instance.compareTo( instance2 ) );
        instance2.setFrequency( 4 );
        assertEquals( -1, instance.compareTo( instance2 ) );
        instance.setFrequency( 4 );
        assertEquals( 0, instance.compareTo( instance2 ) );
    }
    /**
     * Proves that equals() returns the true when the data, frequencies,
     *  and children are all the same.
     */
    @Test
    public void testEquals( ) {
        HNode instance = new HNode( 0, null, null );
        HNode instance2 = new HNode( 0, null, null );
        assertTrue( instance.equals( instance2 ) );
        instance.setFrequency( 1 );
        instance2.setFrequency( 1 );
        assertTrue( instance.equals( instance2 ) );
        instance = new HNode( 1, new HNode( 2, null, null ), null );
        instance2 = new HNode( 1, new HNode( 2, null, null ), null );
        instance.setFrequency( 2 );
        instance2.setFrequency( 2 );
        assertTrue( instance.equals( instance2 ) );
        instance = new HNode( 3, null, new HNode( 4, null, null ) );
        instance2 = new HNode( 3, null, new HNode( 4, null, null ) );
        instance.setFrequency( 3 );
        instance2.setFrequency( 3 );
        assertTrue( instance.equals( instance2 ) );
        instance = new HNode( 5, new HNode( 6, null, null ),
            new HNode( 7, null, null ) );
        instance2 = new HNode( 5, new HNode( 6, null, null ),
            new HNode( 7, null, null ) );
        instance.setFrequency( 4 );
        instance2.setFrequency( 4 );
        assertTrue( instance.equals( instance2 ) );
    }
    // END Good Behavor Tests
}