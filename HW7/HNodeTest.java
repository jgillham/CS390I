
import java.util.PriorityQueue;
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
            // Test with no arguments and for field initialization.
            HNode instance = new HNode( );
            assertEquals( 0, instance.getFrequency() );
            assertEquals( null, instance.getSymbol() );
            assertEquals( null, instance.getCode() );
            // Test with a symbol and for field initialization.
            instance = new HNode( 'a' );
            assertEquals( 'a', instance.getSymbol().charValue() );
            // Test with a symbol, frequency, and for field initialization.
            instance = new HNode( 'a', 1 );
            assertEquals( 'a', instance.getSymbol().charValue() );
            assertEquals( 1, instance.getFrequency() );
            // Test with a symbol, frequency, code, and for field initialization.
            instance = new HNode( 'a', 1, "101" );
            assertEquals( 'a', instance.getSymbol().charValue() );
            assertEquals( 1, instance.getFrequency() );
            assertEquals( "101", instance.getCode() );
            // Test with all arguments and for field initialization.
            HNode left = new HNode( );
            HNode right = new HNode( );
            instance = new HNode( 'a', 1, "101", left, right );
            assertEquals( 'a', instance.getSymbol().charValue() );
            assertEquals( 1, instance.getFrequency() );
            assertEquals( "101", instance.getCode() );
            assertEquals( "101", instance.getCode() );
            assertTrue( left == instance.getLeftChild() );
            assertTrue( right == instance.getRightChild() );
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
        HNode instance = new HNode( );
        instance.setFrequency( 1 );
        assertEquals( 1, instance.getFrequency() );
        instance.setFrequency( 0 );
        assertEquals( 0, instance.getFrequency() );
        instance.setFrequency( 5 );
        assertEquals( 5, instance.getFrequency() );
    }
    
    /**
     * Proves that set and get binary code have a working relationship.
     */
    @Test
    public void testGetAndSetCode( ) {
        HNode instance = new HNode( );
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
        HNode instance = new HNode( );
        instance.setSymbol( 'a' );
        assertEquals( Character.valueOf( 'a' ), instance.getSymbol() );
        instance.setSymbol( 'b' );
        assertEquals( Character.valueOf( 'b' ), instance.getSymbol() );
        instance.setSymbol( 'c' );
        assertEquals( Character.valueOf( 'c' ), instance.getSymbol() );
    }
    
    /**
     * Proves that compareTo() returns the correct value.
     */
    @Test
    public void testCompareTo( ) {
        HNode instance = new HNode( );
        HNode instance2 = new HNode( );
        assertEquals( 0, instance.compareTo( instance2 ) );
        instance.setSymbol( 'a' );
        instance.setCode( "101" );
        instance.setFrequency( 1 );
        assertEquals( 1, instance.compareTo( instance2 ) );
        instance.setSymbol( 'b' );
        instance.setCode( "100" );
        instance2.setFrequency( 2 );
        assertEquals( -1, instance.compareTo( instance2 ) );
        instance.setSymbol( 'c' );
        instance.setCode( "1" );
        instance.setFrequency( 3 );
        assertEquals( 1, instance.compareTo( instance2 ) );
        instance.setSymbol( 'd' );
        instance.setCode( "1010" );
        instance2.setFrequency( 4 );
        assertEquals( -1, instance.compareTo( instance2 ) );
        instance.setSymbol( 'e' );
        instance.setCode( "1011010" );
        instance.setFrequency( 4 );
        assertEquals( 0, instance.compareTo( instance2 ) );
        
        // Add random elements into a queue.
        PriorityQueue< HNode > naturalOrdered = new PriorityQueue< HNode >();
        naturalOrdered.add( new HNode( 'a', Integer.valueOf( 3 ) ) );
        naturalOrdered.add( new HNode( 'b', Integer.valueOf( 1 ) ) );
        naturalOrdered.add( new HNode( 'c', Integer.valueOf( 2 ) ) );
        naturalOrdered.add( new HNode( 'e', Integer.valueOf( 5 ) ) );
        naturalOrdered.add( new HNode( 'd', Integer.valueOf( 4 ) ) );
        
        // Frequencies hould be in numberical order.
        int f = 1;
        while ( !naturalOrdered.isEmpty() ) {
            HNode first = naturalOrdered.poll();
            assertEquals( f++, first.getFrequency() );
        }
        
    }
    
    /**
     * Proves that equals() returns the true when symbols and
     *  frequencies are the same.
     */
    @Test
    public void testEquals_TrueReturns( ) {
        // Test with no arguments.
        HNode instance = new HNode( );
        HNode instance2 = new HNode( );
        assertTrue( instance.equals( instance2 ) );
        assertTrue( instance2.equals( instance ) );
        // Test with symbol.
        instance = new HNode( 'a' );
        instance2 = new HNode( 'a' );
        assertTrue( instance.equals( instance2 ) );
        assertTrue( instance2.equals( instance ) );
        // Test with symbol and frequency.
        instance = new HNode( 'a', 2 );
        instance2 = new HNode( 'a', 2 );
        assertTrue( instance.equals( instance2 ) );
        assertTrue( instance2.equals( instance ) );
        // Test with symbol and frequency but different codes.
        instance = new HNode( 'a', 2, "101" );
        instance2 = new HNode( 'a', 2, "100" );
        assertTrue( instance.equals( instance2 ) );
        assertTrue( instance2.equals( instance ) );
        // Test with symbol, frequency, and children but different codes.
        instance = new HNode( 'a', 2, "101", new HNode( 't', 2 ), new HNode( 'c', 1 ) );
        instance2 = new HNode( 'a', 2, "100", new HNode( 't', 2 ), new HNode( 'c', 1 ) );
        assertTrue( instance.equals( instance2 ) );
        assertTrue( instance2.equals( instance ) );
        // Test with symbol and frequency but different codes and children.
        instance = new HNode( 'a', 2, "101", new HNode( 't', 2 ), null );
        instance2 = new HNode( 'a', 2, "100", new HNode( 't', 2 ), new HNode( 'c', 1 ) );
        assertTrue( instance.equals( instance2 ) );
        assertTrue( instance2.equals( instance ) );
        // Test with symbol and frequency but different codes and children.
        instance = new HNode( 'a', 2, "101", null, new HNode( 'c', 1 ) );
        instance2 = new HNode( 'a', 2, "100", new HNode( 't', 2 ), new HNode( 'c', 1 ) );
        assertTrue( instance.equals( instance2 ) );
        assertTrue( instance2.equals( instance ) );
    }
    
    /**
     * Proves that equals() returns the true when symbols and
     *  frequencies are the same.
     */
    @Test
    public void testEquals_FalseReturns( ) {
        
        HNode instance = new HNode( 'a' );
        HNode instance2 = new HNode( );
        assertFalse( instance.equals( null ) );
        assertFalse( instance.equals( instance2 ) );
        assertFalse( instance2.equals( instance ) );
        
        instance = new HNode( 'a' );
        instance2 = new HNode( 'b' );
        assertFalse( instance.equals( instance2 ) );
        assertFalse( instance2.equals( instance ) );
        
        instance = new HNode( 'a', 1 );
        instance2 = new HNode( 'a' );
        assertFalse( instance.equals( instance2 ) );
        assertFalse( instance2.equals( instance ) );
        
        instance = new HNode( 'a', 1 );
        instance2 = new HNode( 'a', 2 );
        assertFalse( instance.equals( instance2 ) );
        assertFalse( instance2.equals( instance ) );
        
        instance = new HNode( 'a', 1, "101" );
        instance2 = new HNode( 'a', 2, "100" );
        assertFalse( instance.equals( instance2 ) );
        assertFalse( instance2.equals( instance ) );
        
        instance = new HNode( 'a', 2, "101" );
        instance2 = new HNode( 'b', 2, "100" );
        assertFalse( instance.equals( instance2 ) );
        assertFalse( instance2.equals( instance ) );
        
        instance = new HNode( 'a', 1, "101", new HNode( 't', 2 ), new HNode( 'c', 1 ) );
        instance2 = new HNode( 'a', 2, "100", new HNode( 't', 2 ), new HNode( 'c', 1 ) );
        assertFalse( instance.equals( instance2 ) );
        assertFalse( instance2.equals( instance ) );
        
        instance = new HNode( 'a', 2, "101", new HNode( 't', 2 ), new HNode( 'c', 1 ) );
        instance2 = new HNode( 'b', 2, "100", new HNode( 't', 2 ), new HNode( 'c', 1 ) );
        assertFalse( instance.equals( instance2 ) );
        assertFalse( instance2.equals( instance ) );
        
        instance = new HNode( 'a', 1, "101", new HNode( 't', 2 ), null );
        instance2 = new HNode( 'a', 2, "100", new HNode( 't', 2 ), new HNode( 'c', 1 ) );
        assertFalse( instance.equals( instance2 ) );
        assertFalse( instance2.equals( instance ) );
        
        instance = new HNode( 'b', 2, "101", new HNode( 't', 2 ), null );
        instance2 = new HNode( 'a', 2, "100", new HNode( 't', 2 ), new HNode( 'c', 1 ) );
        assertFalse( instance.equals( instance2 ) );
        assertFalse( instance2.equals( instance ) );
        
        instance = new HNode( 'b', 2, "101", null, new HNode( 'c', 1 ) );
        instance2 = new HNode( 'a', 2, "100", new HNode( 't', 2 ), new HNode( 'c', 1 ) );
        assertFalse( instance.equals( instance2 ) );
        assertFalse( instance2.equals( instance ) );
        
        instance = new HNode( 'a', 1, "101", null, new HNode( 'c', 1 ) );
        instance2 = new HNode( 'a', 2, "100", new HNode( 't', 2 ), new HNode( 'c', 1 ) );
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
        HNode root1 = new HNode( );
        HNode root2 = new HNode( );
        assertEquals( root1.hashCode(), root2.hashCode() );
        // 1 Argument
        root1 = new HNode( sym );
        root2 = new HNode( sym );
        assertEquals( root1.hashCode(), root2.hashCode() );
        // 2 Arguments
        root1 = new HNode( sym, frq );
        root2 = new HNode( sym, frq );
        assertEquals( root1.hashCode(), root2.hashCode() );
        // 3 Arguments
        root1 = new HNode( sym, frq, code );
        root2 = new HNode( sym, frq, code );
        assertEquals( root1.hashCode(), root2.hashCode() );
        
        root1 = new HNode( sym, frq, code );
        root2 = new HNode( sym, frq, null );
        assertEquals( root1.hashCode(), root2.hashCode() );
        
        root1 = new HNode( sym, frq, code );
        root2 = new HNode( sym, frq, "10000" );
        assertEquals( root1.hashCode(), root2.hashCode() );
        
        // All Arguments
        root1 = new HNode( sym, frq, code, new HNode(), new HNode() );
        root2 = new HNode( sym, frq, "1000", new HNode(), new HNode() );
        assertEquals( root1.hashCode(), root2.hashCode() );
        
        root1 = new HNode( sym, frq, code, null, new HNode() );
        root2 = new HNode( sym, frq, "1000", new HNode(), new HNode() );
        assertEquals( root1.hashCode(), root2.hashCode() );
        
        root1 = new HNode( sym, frq, code, new HNode(), new HNode() );
        root2 = new HNode( sym, frq, "1000", null, new HNode() );
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
        
        HNode root1 = new HNode( sym );
        HNode root2 = new HNode( );
        assertFalse( root1.hashCode() == root2.hashCode() );
        
        root1 = new HNode( sym );
        root2 = new HNode( 'g' );
        assertFalse( root1.hashCode() == root2.hashCode() );
        
        root1 = new HNode( sym, frq );
        root2 = new HNode( sym );
        assertFalse( root1.hashCode() == root2.hashCode() );
        
        root1 = new HNode( sym, frq );
        root2 = new HNode( sym, frq + 1 );
        assertFalse( root1.hashCode() == root2.hashCode() );
        
        root1 = new HNode( sym, frq, code );
        root2 = new HNode( sym, frq + 1, "100001" );
        assertFalse( root1.hashCode() == root2.hashCode() );
        
        root1 = new HNode( sym, frq, code );
        root2 = new HNode( 'g', frq, "100001" );
        assertFalse( root1.hashCode() == root2.hashCode() );
        
        root1 = new HNode( sym, frq, code, new HNode(), new HNode() );
        root2 = new HNode( sym, frq + 1, "100001", new HNode(), new HNode() );
        assertFalse( root1.hashCode() == root2.hashCode() );
        
        root1 = new HNode( sym, frq, code, null, new HNode() );
        root2 = new HNode( sym, frq + 1, "100001", new HNode(), new HNode() );
        assertFalse( root1.hashCode() == root2.hashCode() );
        
        root1 = new HNode( sym, frq, code, new HNode(), new HNode() );
        root2 = new HNode( sym, frq + 1, "100001", null, new HNode() );
        assertFalse( root1.hashCode() == root2.hashCode() );
        
        root1 = new HNode( sym, frq, code, new HNode(), new HNode() );
        root2 = new HNode( 'g', frq, "100001", new HNode(), new HNode() );
        assertFalse( root1.hashCode() == root2.hashCode() );
        
        root1 = new HNode( sym, frq, code, null, new HNode() );
        root2 = new HNode( 'g', frq, "100001", new HNode(), new HNode() );
        assertFalse( root1.hashCode() == root2.hashCode() );
        
        root1 = new HNode( sym, frq, code, new HNode(), new HNode() );
        root2 = new HNode( 'g', frq, "100001", null, new HNode() );
        assertFalse( root1.hashCode() == root2.hashCode() );
    }
    
    @Test
    public void testToString() {
        Character sym = Character.valueOf( 'a' );
        int frq = 1;
        String code = "101";
        
        HNode root1 = new HNode( sym );
        HNode root2 = new HNode( );
        assertFalse( root1.toString().equals( root2.toString() ) );
        
        root1 = new HNode( sym );
        root2 = new HNode( 'g' );
        assertFalse( root1.toString().equals( root2.toString() ) );
        
        root1 = new HNode( sym, frq );
        root2 = new HNode( sym );
        assertFalse( root1.toString().equals( root2.toString() ) );
        
        root1 = new HNode( sym, frq );
        root2 = new HNode( sym, frq + 1 );
        assertFalse( root1.toString().equals( root2.toString() ) );
        
        root1 = new HNode( sym, frq, code );
        root2 = new HNode( sym, frq + 1, "100001" );
        assertFalse( root1.toString().equals( root2.toString() ) );
        
        root1 = new HNode( sym, frq, code );
        root2 = new HNode( 'g', frq, "100001" );
        assertFalse( root1.toString().equals( root2.toString() ) );
        
        root1 = new HNode( sym, frq, code, new HNode(), new HNode() );
        root2 = new HNode( sym, frq + 1, "100001", new HNode(), new HNode() );
        assertFalse( root1.toString().equals( root2.toString() ) );
        
        root1 = new HNode( sym, frq, code, null, new HNode() );
        root2 = new HNode( sym, frq + 1, "100001", new HNode(), new HNode() );
        assertFalse( root1.toString().equals( root2.toString() ) );
        
        root1 = new HNode( sym, frq, code, new HNode(), new HNode() );
        root2 = new HNode( sym, frq + 1, "100001", null, new HNode() );
        assertFalse( root1.toString().equals( root2.toString() ) );
        
        root1 = new HNode( sym, frq, code, new HNode(), new HNode() );
        root2 = new HNode( 'g', frq, "100001", new HNode(), new HNode() );
        assertFalse( root1.toString().equals( root2.toString() ) );
        
        root1 = new HNode( sym, frq, code, null, new HNode() );
        root2 = new HNode( 'g', frq, "100001", new HNode(), new HNode() );
        assertFalse( root1.toString().equals( root2.toString() ) );
        
        root1 = new HNode( sym, frq, code, new HNode(), new HNode() );
        root2 = new HNode( 'g', frq, "100001", null, new HNode() );
        assertFalse( root1.toString().equals( root2.toString() ) );
    }
    // END Good Behavor Tests
}