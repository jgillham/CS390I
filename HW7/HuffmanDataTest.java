

import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * Tests HuffmanData
 *
 * @author  Josh Gillham
 * @version 12-2-12
 */
public class HuffmanDataTest {
    @Test
    public void testConstructor() {
        try {
            new HuffmanData();
            new HuffmanData( 'a' );
            new HuffmanData( 'a', 1 );
            new HuffmanData( 'a', 1, "101" );
            
        }
        catch ( Throwable e ) {
            e.printStackTrace();
        }
    }
    
    @Test
    public void testCompareTo() {
        HuffmanData instance = new HuffmanData( );
        HuffmanData instance2 = new HuffmanData( );
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
     * Proves that set and get frequency have a working relationship.
     */
    @Test
    public void testGetAndSetFrequency( ) {
        HuffmanData instance = new HuffmanData( );
        instance.setFrequency( 1 );
        assertEquals( 1, instance.getFrequency(), 0.001 );
        instance.setFrequency( 0 );
        assertEquals( 0, instance.getFrequency(), 0.001 );
        instance.setFrequency( 5 );
        assertEquals( 5, instance.getFrequency(), 0.001 );
    }
    
    /**
     * Proves that set and get binary code have a working relationship.
     */
    @Test
    public void testGetAndSetCode( ) {
        HuffmanData instance = new HuffmanData( );
        instance.setCode( "101" );
        assertEquals( "101", instance.getCode() );
        instance.setCode( "11" );
        assertEquals( "11", instance.getCode() );
        instance.setCode( "1011" );
        assertEquals( "1011", instance.getCode() );
    }
    
    /**
     * Proves that set and get symbol have a working relationship.
     */
    @Test
    public void testGetAndSetSymbol( ) {
        HuffmanData instance = new HuffmanData( );
        instance.setSymbol( 'a' );
        assertEquals( Character.valueOf( 'a' ), instance.getSymbol() );
        instance.setSymbol( 'b' );
        assertEquals( Character.valueOf( 'b' ), instance.getSymbol() );
        instance.setSymbol( 'c' );
        assertEquals( Character.valueOf( 'c' ), instance.getSymbol() );
    }
    
    /**
     * Proves that equals() returns the true when frequencies and symbol
     *  are the same.
     */
    @Test
    public void testEquals( ) {
        HuffmanData instance = new HuffmanData( 'a', 1 );
        HuffmanData instance2 = new HuffmanData( 'a', 1 );
        assertTrue( instance.equals( instance2 ) );
        instance.setFrequency( 2 );
        instance2.setFrequency( 2 );
        assertTrue( instance.equals( instance2 ) );
    }
    
    @Test
    public void testHashCode() {
        fail( "Test not implemented." );
    }
    
    @Test
    public void testToString() {
        fail( "Test not implemented." );
    }
}
