
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
            HNode instance = new HNode( );
            assertEquals( 0, instance.getFrequency() );
            assertEquals( null, instance.getSymbol() );
            assertEquals( null, instance.getCode() );
            instance = new HNode( 'a' );
            assertEquals( 'a', instance.getSymbol().charValue() );
            instance = new HNode( 'a', 1 );
            assertEquals( 'a', instance.getSymbol().charValue() );
            assertEquals( 1, instance.getFrequency() );
            instance = new HNode( 'a', 1, "101" );
            assertEquals( 'a', instance.getSymbol().charValue() );
            assertEquals( 1, instance.getFrequency() );
            assertEquals( "101", instance.getCode() );
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
     * Proves that equals() returns the true when the data, frequencies,
     *  and children are all the same.
     */
    @Test
    public void testEquals( ) {
        HNode instance = new HNode( 'a', 1 );
        HNode instance2 = new HNode( 'a', 2 );
        assertTrue( instance.equals( instance2 ) );
        instance.setFrequency( 1 );
        instance2.setFrequency( 1 );
        assertTrue( instance.equals( instance2 ) );
        instance = new HNode( ' ', 2, "", new HNode( 't', 2), null );
        instance2 = new HNode( ' ', 2, "", new HNode( 'c', 3 ), null );
        instance.setFrequency( 2 );
        instance2.setFrequency( 2 );
        assertTrue( instance.equals( instance2 ) );
        instance = new HNode( ' ', 6, "", null, new HNode( 'v', 6 ) );
        instance2 = new HNode( ' ', 7, "", null, new HNode( 'g', 6 ) );
        instance.setFrequency( 3 );
        instance2.setFrequency( 3 );
        assertTrue( instance.equals( instance2 ) );
        instance = new HNode( ' ', 9, "", new HNode( 'r', 3 ),
            new HNode( 'h', 6 ) );
        instance2 = new HNode( ' ', 9, "", new HNode( 'r', 3 ),
            new HNode( 'h', 6 ) );
        instance.setFrequency( 4 );
        instance2.setFrequency( 4 );
        assertTrue( instance.equals( instance2 ) );
    }
    
    /**
     * Proves hashCode() works.
     */
    @Test
    public void testHashCode() {
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
        // All Arguments
        root1 = new HNode( sym, frq, code, new HNode(), new HNode() );
        root2 = new HNode( sym, frq, code, new HNode(), new HNode() );
        assertEquals( root1.hashCode(), root2.hashCode() );
    }
    // END Good Behavor Tests
}