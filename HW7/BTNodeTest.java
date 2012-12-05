

import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * Tests each method to prove that behavior is consistant throughout the class.
 *
 * @author  Josh Gillham
 * @version 10-21-12
 */
public class BTNodeTest {
    // BEGIN Good Behavior Tests
    /**
     * Test default constructor. All private fields should be null.
     * 
     * Proves the constructor is setting private fields properly.
     */
    @Test
    public void testConstructor() {
        BTNode instance = new BTNode();
        assertNull( instance.getLeftChild() );
        assertNull( instance.getRightChild() );
        assertNull( instance.getValue() );
    }
    
    /**
     * Test constructor with 1 parameter. getValue() should be the
     *  same as the parameter. Other fields will be null.
     *  
     * Proves the constructor is setting private fields properly.
     */
    @Test
    public void testConstructor_1param() {
        String expectedValue = "test";
        BTNode< String > instance = new BTNode< String >( expectedValue);
        assertNull( instance.getLeftChild() );
        assertNull( instance.getRightChild() );
        assertEquals( expectedValue, instance.getValue() );
    }
    
    /**
     * Test constructor with 3 parameter. Get methods should return 
     *  the parameters.
     * 
     * Proves the constructor is setting private fields properly.
     */
    @Test
    public void testConstructor_3param() {
        String expectedValue = "test";
        BTNode< String > expectedRightNode = new BTNode< String >();
        BTNode< String > expectedLeftNode = new BTNode< String >();
        BTNode< String > instance = new BTNode< String >( 
            expectedValue, expectedLeftNode, expectedRightNode
        );
        assertEquals( expectedLeftNode, instance.getLeftChild() );
        assertEquals( expectedRightNode, instance.getRightChild() );
        assertEquals( expectedValue, instance.getValue() );
    }
    
    /**
     * Proves that the set function affects what the get function returns.
     */
    @Test
    public void testSetAndGetValue() {
        String expected = "test";
        BTNode< String > instance = new BTNode< String >();
        instance.setValue( expected );
        assertEquals( expected, instance.getValue() );
        expected = "apple";
        instance.setValue( expected );
        assertEquals( expected, instance.getValue() );
        expected = "orange";
        instance.setValue( expected );
        assertEquals( expected, instance.getValue() );
    }
    
    /**
     * Proves set function affects what the get function returns.
     */
    @Test
    public void testSetAndGetLeftChild() {
        BTNode< String > expected = new BTNode< String >();
        BTNode< String > instance = new BTNode< String >();
        instance.setLeftChild( expected );
        assertEquals( expected, instance.getLeftChild() );
        expected = new BTNode< String >();
        instance.setLeftChild( expected );
        assertEquals( expected, instance.getLeftChild() );
        expected = new BTNode< String >();
        instance.setLeftChild( expected );
        assertEquals( expected, instance.getLeftChild() );
    }
    
    /**
     * Proves set function affects what the get function returns.
     */
    @Test
    public void testSetAndGetRightChild() {
        BTNode< String > expected = new BTNode< String >();
        BTNode< String > instance = new BTNode< String >();
        instance.setRightChild( expected );
        assertEquals( expected, instance.getRightChild() );
        expected = new BTNode< String >();
        instance.setRightChild( expected );
        assertEquals( expected, instance.getRightChild() );
        expected = new BTNode< String >();
        instance.setRightChild( expected );
        assertEquals( expected, instance.getRightChild() );
    }
    
    /**
     * Proves toString produces a non-null without an error.
     */
    @Test
    public void testToString() {
        try {
            BTNode< String > instance = new BTNode< String >();
            assertNotNull( instance.toString() );
        }
        catch ( Exception e ) {
            fail( "Should not throw an error." );
        }
    }
    
    /**
     * Proves hashCode() returns the same values in all cases.
     */
    @Test
    public void testHashCode_SameReturn() {
        String value = "this is a test.";
        BTNode< String > root1 = new BTNode< String >( );
        BTNode< String > root2 = new BTNode< String >( );
        assertEquals( root1.hashCode(), root2.hashCode( ) );
        
        root1 = new BTNode< String >(value );
        root2 = new BTNode< String >(value );
        assertEquals( root1.hashCode(), root2.hashCode( ) );
        
        root1 = new BTNode< String >(value, new BTNode< String >(), new BTNode< String >() );
        root2 = new BTNode< String >(value, new BTNode< String >(), new BTNode< String >() );
        assertEquals( root1.hashCode(), root2.hashCode( ) );
        
        root1 = new BTNode< String >(null, new BTNode< String >(), new BTNode< String >() );
        root2 = new BTNode< String >(null, new BTNode< String >(), new BTNode< String >() );
        assertEquals( root1.hashCode(), root2.hashCode( ) );
    }
    
    /**
     * Proves hashCode() returns different values in all cases.
     */
    @Test
    public void testHashCode_DifferentReturns() {
        String value = "this is a test.";
        
        BTNode< String > root1 = new BTNode< String >( );
        BTNode< String > root2 = new BTNode< String >( value );
        assertFalse( root1.hashCode() == root2.hashCode( ) );
        
        root1 = new BTNode< String >( value );
        root2 = new BTNode< String >( value + "b" );
        assertFalse( root1.hashCode() == root2.hashCode( ) );
        
        root1 = new BTNode< String >(value, null, new BTNode< String >() );
        root2 = new BTNode< String >(value, new BTNode< String >(), new BTNode< String >() );
        assertFalse( root1.hashCode() == root2.hashCode( ) );
        
        root1 = new BTNode< String >(value, new BTNode< String >(), null );
        root2 = new BTNode< String >(value, new BTNode< String >(), new BTNode< String >() );
        assertFalse( root1.hashCode() == root2.hashCode( ) );
        
        root1 = new BTNode< String >(null, new BTNode< String >(), new BTNode< String >() );
        root2 = new BTNode< String >(value, new BTNode< String >(), new BTNode< String >() );
        assertFalse( root1.hashCode() == root2.hashCode( ) );
    }
    
    /**
     * Proves equals() returns true for all possible true conditions.
     */
    @Test
    public void testEquals_TrueReturns() {
        String value = "this is a test.";
        BTNode< String > root1 = new BTNode< String >( );
        BTNode< String > root2 = new BTNode< String >( );
        assertTrue( root1.equals( root2 ) );
        assertTrue( root2.equals( root1 ) );
        
        root1 = new BTNode< String >(value );
        root2 = new BTNode< String >(value );
        assertTrue( root1.equals( root2 ) );
        assertTrue( root2.equals( root1 ) );
        
        root1 = new BTNode< String >(value, new BTNode< String >(), new BTNode< String >() );
        root2 = new BTNode< String >(value, new BTNode< String >(), new BTNode< String >() );
        assertTrue( root1.equals( root2 ) );
        assertTrue( root2.equals( root1 ) );
        
        root1 = new BTNode< String >(null, new BTNode< String >(), new BTNode< String >() );
        root2 = new BTNode< String >(null, new BTNode< String >(), new BTNode< String >() );
        assertTrue( root1.equals( root2 ) );
        assertTrue( root2.equals( root1 ) );
    }
    
    /**
     * Proves equals() returns false for all false cases.
     */
    @Test
    public void testEquals_FalseReturns() {
        String value = "this is a test.";
        
        BTNode< String > root1 = new BTNode< String >( );
        BTNode< String > root2 = new BTNode< String >( value );
        assertFalse( root1.equals( "different object" ) );
        assertFalse( root1.equals( null ) );
        assertFalse( root1.equals( root2 ) );
        assertFalse( root2.equals( root1 ) );
        
        root1 = new BTNode< String >( value );
        root2 = new BTNode< String >( value + "b" );
        assertFalse( root1.equals( root2 ) );
        assertFalse( root2.equals( root1 ) );
        
        root1 = new BTNode< String >(value, null, new BTNode< String >() );
        root2 = new BTNode< String >(value, new BTNode< String >(), new BTNode< String >() );
        assertFalse( root1.equals( root2 ) );
        assertFalse( root2.equals( root1 ) );
        
        root1 = new BTNode< String >(value, new BTNode< String >(), null );
        root2 = new BTNode< String >(value, new BTNode< String >(), new BTNode< String >() );
        assertFalse( root1.equals( root2 ) );
        assertFalse( root2.equals( root1 ) );
        
        root1 = new BTNode< String >(null, new BTNode< String >(), new BTNode< String >() );
        root2 = new BTNode< String >(value, new BTNode< String >(), new BTNode< String >() );
        assertFalse( root1.equals( root2 ) );
        assertFalse( root2.equals( root1 ) );
    }
    // END Good Behavior Tests
    // BEGIN Destructive Tests
    // END Destructive Tests
}
