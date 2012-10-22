

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
public class ThingNodeTest {
    /**
     * Test constructor with 1 parameter. Get methods should return the parameters.
     * 
     * Proves the constructor is setting private fields properly.
     */
    @Test
    public void testConstructor_1param(){
        String expectedValue= "test";
        ThingNode instance= new ThingNode( expectedValue );
        assertNull( instance.getLeftChild() );
        assertNull( instance.getRightChild() );
        assertEquals( expectedValue, instance.getValue() );
    }
    
    /**
     * Proves that the set function affects what the get function returns.
     */
    @Test
    public void testGetThing() {
        String expected= "test";
        ThingNode instance= new ThingNode( expected );
        assertEquals( expected, instance.getThing() );
        instance.setValue( expected );
        assertEquals( expected, instance.getThing() );
        expected= "apple";
        instance.setValue( expected );
        assertEquals( expected, instance.getThing() );
        expected= "orange";
        instance.setValue( expected );
        assertEquals( expected, instance.getThing() );
    }
    
    /**
     * Proves toString ...
     * 
     * TODO
     */
    @Test
    public void testToString() {
        throw new UnsupportedOperationException();
    }
}
