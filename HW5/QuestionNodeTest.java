

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
public class QuestionNodeTest {
    /** Provides a testable implementation of DecisionTreeNode. */
    class InstrumentationDecisionTreeNode extends DecisionTreeNode {
        
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
        DecisionTreeNode expectedRightNode = 
            new InstrumentationDecisionTreeNode();
        DecisionTreeNode expectedLeftNode = 
            new InstrumentationDecisionTreeNode();
        QuestionNode instance = new QuestionNode( 
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
    public void testGetQuestion() {
        String expected = "test";
        DecisionTreeNode expectedRightNode = 
            new InstrumentationDecisionTreeNode();
        DecisionTreeNode expectedLeftNode = 
            new InstrumentationDecisionTreeNode();
        QuestionNode instance = new QuestionNode( 
            expected, expectedLeftNode, expectedRightNode
        );
        assertEquals( expected, instance.getQuestion() );
        instance.setValue( expected );
        assertEquals( expected, instance.getQuestion() );
        expected = "apple";
        instance.setValue( expected );
        assertEquals( expected, instance.getQuestion() );
        expected = "orange";
        instance.setValue( expected );
        assertEquals( expected, instance.getQuestion() );
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
}
