

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
    /**
     * Proves the constructors can initialize the object with the
     *  fields correctly.
     */
    @Test
    public void testConstructor() {
        try {
            // Test with no arguments.
            HuffmanData instance = new HuffmanData( );
            // Test with 1 argument and for the initialization of the field.
            instance = new HuffmanData( 'a' );
            assertEquals( 'a', instance.getSymbol().charValue() );
            // Test with 2 arguments and for the initialization of the fields.
            instance = new HuffmanData( 'a', 1 );
            assertEquals( 'a', instance.getSymbol().charValue() );
            assertEquals( 1, instance.getFrequency(), 0.001 );
            // Test with 3 argument and for the initialization of the fields.
            instance = new HuffmanData( 'a', 1, "101" );
            assertEquals( 'a', instance.getSymbol().charValue() );
            assertEquals( 1, instance.getFrequency(), 0.001 );
            assertEquals( "101", instance.getCode() );
        }
        catch ( Throwable e ) {
            e.printStackTrace();
        }
    }
    
    /**
     * Proves that compareTo responds to the frequency.
     */
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
     * Proves that equals() returns the true when symbols and
     *  frequencies are the same.
     */
    @Test
    public void testEquals_TrueReturns( ) {
        // Test with no arguments.
        HuffmanData instance = new HuffmanData( );
        HuffmanData instance2 = new HuffmanData( );
        assertTrue( instance.equals( instance2 ) );
        assertTrue( instance2.equals( instance ) );
        // Test with symbol.
        instance = new HuffmanData( 'a' );
        instance2 = new HuffmanData( 'a' );
        assertTrue( instance.equals( instance2 ) );
        assertTrue( instance2.equals( instance ) );
        // Test with symbol and frequency.
        instance = new HuffmanData( 'a', 2 );
        instance2 = new HuffmanData( 'a', 2 );
        assertTrue( instance.equals( instance2 ) );
        assertTrue( instance2.equals( instance ) );
        // Test with symbol and frequency but different codes.
        instance = new HuffmanData( 'a', 2, "101" );
        instance2 = new HuffmanData( 'a', 2, "100" );
        assertTrue( instance.equals( instance2 ) );
        assertTrue( instance2.equals( instance ) );
    }
    
    /**
     * Proves that equals() returns the true when symbols and
     *  frequencies are the same.
     */
    @Test
    public void testEquals_FalseReturns( ) {
        
        HuffmanData instance = new HuffmanData( 'a' );
        HuffmanData instance2 = new HuffmanData( );
        assertFalse( instance.equals( null ) );
        assertFalse( instance.equals( instance2 ) );
        assertFalse( instance2.equals( instance ) );
        
        instance = new HuffmanData( 'a' );
        instance2 = new HuffmanData( 'b' );
        assertFalse( instance.equals( instance2 ) );
        assertFalse( instance2.equals( instance ) );
        
        instance = new HuffmanData( 'a', 1 );
        instance2 = new HuffmanData( 'a' );
        assertFalse( instance.equals( instance2 ) );
        assertFalse( instance2.equals( instance ) );
        
        instance = new HuffmanData( 'a', 1 );
        instance2 = new HuffmanData( 'a', 2 );
        assertFalse( instance.equals( instance2 ) );
        assertFalse( instance2.equals( instance ) );
        
        instance = new HuffmanData( 'a', 1, "101" );
        instance2 = new HuffmanData( 'a', 2, "100" );
        assertFalse( instance.equals( instance2 ) );
        assertFalse( instance2.equals( instance ) );
        
        instance = new HuffmanData( 'a', 2, "101" );
        instance2 = new HuffmanData( 'b', 2, "100" );
        assertFalse( instance.equals( instance2 ) );
        assertFalse( instance2.equals( instance ) );
    }
    
    /**
     * Proves hashCode() returns the same values in all cases.
     */
    @Test
    public void testHashCode_SameReturns() {
        Character sym = Character.valueOf( 'a' );
        int frq = 1;
        String code = "101";
        // No Arguments
        HuffmanData root1 = new HuffmanData( );
        HuffmanData root2 = new HuffmanData( );
        assertEquals( root1.hashCode(), root2.hashCode() );
        // 1 Argument
        root1 = new HuffmanData( sym );
        root2 = new HuffmanData( sym );
        assertEquals( root1.hashCode(), root2.hashCode() );
        // 2 Arguments
        root1 = new HuffmanData( sym, frq );
        root2 = new HuffmanData( sym, frq );
        assertEquals( root1.hashCode(), root2.hashCode() );
        // 3 Arguments
        root1 = new HuffmanData( sym, frq, code );
        root2 = new HuffmanData( sym, frq, code );
        assertEquals( root1.hashCode(), root2.hashCode() );
        
        root1 = new HuffmanData( sym, frq, code );
        root2 = new HuffmanData( sym, frq, null );
        assertEquals( root1.hashCode(), root2.hashCode() );
        
        root1 = new HuffmanData( sym, frq, code );
        root2 = new HuffmanData( sym, frq, "10000" );
        assertEquals( root1.hashCode(), root2.hashCode() );
    }
    
    /**
     * Proves hashCode() returns the different values in all cases.
     */
    @Test
    public void testHashCode_DifferentReturns() {
        Character sym = Character.valueOf( 'a' );
        int frq = 1;
        String code = "101";
        
        HuffmanData root1 = new HuffmanData( sym );
        HuffmanData root2 = new HuffmanData( );
        assertFalse( root1.hashCode() == root2.hashCode() );
        
        root1 = new HuffmanData( sym );
        root2 = new HuffmanData( 'g' );
        assertFalse( root1.hashCode() == root2.hashCode() );
        
        root1 = new HuffmanData( sym, frq );
        root2 = new HuffmanData( sym );
        assertFalse( root1.hashCode() == root2.hashCode() );
        
        root1 = new HuffmanData( sym, frq );
        root2 = new HuffmanData( sym, frq + 1 );
        assertFalse( root1.hashCode() == root2.hashCode() );
        
        root1 = new HuffmanData( sym, frq, code );
        root2 = new HuffmanData( sym, frq + 1, "100001" );
        assertFalse( root1.hashCode() == root2.hashCode() );
        
        root1 = new HuffmanData( sym, frq, code );
        root2 = new HuffmanData( 'g', frq, "100001" );
        assertFalse( root1.hashCode() == root2.hashCode() );
    }
    /**
     * Proves that toString() produces unique strings depending
     *  on the data.
     */
    @Test
    public void testToString() {
        Character sym = Character.valueOf( 'a' );
        int frq = 1;
        String code = "101";
        
        HuffmanData root1 = new HuffmanData( sym );
        HuffmanData root2 = new HuffmanData( );
        assertFalse( root1.toString().equals( root2.toString() ) );
        
        root1 = new HuffmanData( sym );
        root2 = new HuffmanData( 'g' );
        assertFalse( root1.toString().equals( root2.toString() ) );
        
        root1 = new HuffmanData( sym, frq );
        root2 = new HuffmanData( sym );
        assertFalse( root1.toString().equals( root2.toString() ) );
        
        root1 = new HuffmanData( sym, frq );
        root2 = new HuffmanData( sym, frq + 1 );
        assertFalse( root1.toString().equals( root2.toString() ) );
        
        root1 = new HuffmanData( sym, frq );
        root2 = new HuffmanData( 'g', frq );
        assertFalse( root1.toString().equals( root2.toString() ) );
        
        root1 = new HuffmanData( sym, frq, code );
        root2 = new HuffmanData( sym, frq + 1, code );
        assertFalse( root1.toString().equals( root2.toString() ) );
        
        root1 = new HuffmanData( sym, frq, code );
        root2 = new HuffmanData( 'g', frq, code );
        assertFalse( root1.toString().equals( root2.toString() ) );
        
        root1 = new HuffmanData( sym, frq, code );
        root2 = new HuffmanData( sym, frq, "100001" );
        assertFalse( root1.toString().equals( root2.toString() ) );
    }
}
