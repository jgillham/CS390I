

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
    /**
     * Test default constructor. All private fields should be null.
     * 
     * Proves the constructor is setting private fields properly.
     */
    @Test
    public void testConstructor(){
        BTNode instance= new BTNode();
        assertNull( instance.getLeftChild() );
        assertNull( instance.getRightChild() );
        assertNull( instance.getValue() );
    }
    
    /**
     * Test constructor with 1 parameter. getValue() should be the same as the parameter.
     *  Other fields will be null.
     *  
     * Proves the constructor is setting private fields properly.
     */
    @Test
    public void testConstructor_1param(){
        String expectedValue= "test";
        BTNode< String > instance= new BTNode< String >( expectedValue);
        assertNull( instance.getLeftChild() );
        assertNull( instance.getRightChild() );
        assertEquals( expectedValue, instance.getValue() );
    }
    
    /**
     * Test constructor with 3 parameter. Get methods should return the parameters.
     * 
     * Proves the constructor is setting private fields properly.
     */
    @Test
    public void testConstructor_3param(){
        String expectedValue= "test";
        BTNode< String > expectedRightNode= new BTNode< String >();
        BTNode< String > expectedLeftNode= new BTNode< String >();
        BTNode< String > instance= new BTNode< String >( 
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
        String expected= "test";
        BTNode< String > instance= new BTNode< String >();
        instance.setValue( expected );
        assertEquals( expected, instance.getValue() );
        expected= "apple";
        instance.setValue( expected );
        assertEquals( expected, instance.getValue() );
        expected= "orange";
        instance.setValue( expected );
        assertEquals( expected, instance.getValue() );
    }
    
    /**
     * Proves set function affects what the get function returns.
     */
    @Test
    public void testSetAndGetLeftChild() {
        BTNode< String > expected= new BTNode< String >();
        BTNode< String > instance= new BTNode< String >();
        instance.setLeftChild( expected );
        assertEquals( expected, instance.getLeftChild() );
        expected= new BTNode< String >();
        instance.setLeftChild( expected );
        assertEquals( expected, instance.getLeftChild() );
        expected= new BTNode< String >();
        instance.setLeftChild( expected );
        assertEquals( expected, instance.getLeftChild() );
    }
    
    /**
     * Proves set function affects what the get function returns.
     */
    @Test
    public void testSetAndGetRightChild() {
        BTNode< String > expected= new BTNode< String >();
        BTNode< String > instance= new BTNode< String >();
        instance.setRightChild( expected );
        assertEquals( expected, instance.getRightChild() );
        expected= new BTNode< String >();
        instance.setRightChild( expected );
        assertEquals( expected, instance.getRightChild() );
        expected= new BTNode< String >();
        instance.setRightChild( expected );
        assertEquals( expected, instance.getRightChild() );
    }
    
    /**
     * Proves toString produces a non-null without an error.
     */
    @Test
    public void testToString() {
        try {
            BTNode< String > instance= new BTNode< String >();
            assertNotNull( instance.toString() );
        } catch( Exception e ) {
            fail( "Should not throw an error." );
        }
    }
}
