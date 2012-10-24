

import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * Tests the functionality.
 *
 * @author  Josh Gillham
 * @version 10-23-12
 */
public class DecisionTreeNodeTest {
    /**
     * Provides an instrument to test DecisionTreeNode. 
     */
    class InstrumentDecisionTreeNode extends DecisionTreeNode {
        public InstrumentDecisionTreeNode() { 
            super();
        }
        public InstrumentDecisionTreeNode( String value, DecisionTreeNode no, DecisionTreeNode yes ) {
            super( value, no, yes );
        }
    }
    
    /**
     * Test default constructor. Should produce no errors.
     */
    @Test
    public void testConstructor(){
        new InstrumentDecisionTreeNode(); 
    }
    
    /**
     * Test the 3 param constructor. Should produce no errors.
     */
    @Test
    public void testConstructor_3param(){
        new InstrumentDecisionTreeNode( "", new InstrumentDecisionTreeNode(), new InstrumentDecisionTreeNode() ); 
    }
    
    /**
     * Tests the getYesLink and setYesLink together.
     */
    @Test
    public void testGetAndSetYesLink() {
        InstrumentDecisionTreeNode expectedYesLink= new InstrumentDecisionTreeNode();
        InstrumentDecisionTreeNode instance=
            new InstrumentDecisionTreeNode( "", new InstrumentDecisionTreeNode(), expectedYesLink ); 
        assertEquals( expectedYesLink, instance.getYesLink() );
        
        expectedYesLink= new InstrumentDecisionTreeNode();
        instance.setYesLink( expectedYesLink );
        assertEquals( expectedYesLink, instance.getYesLink() );
        
        expectedYesLink= new InstrumentDecisionTreeNode();
        instance.setYesLink( expectedYesLink );
        assertEquals( expectedYesLink, instance.getYesLink() );
    }
    
    /**
     * Tests the getNoLink and setNoLink together.
     */
    @Test
    public void testGetAndSetNoLink() {
        InstrumentDecisionTreeNode expectedNoLink= new InstrumentDecisionTreeNode();
        InstrumentDecisionTreeNode instance=
            new InstrumentDecisionTreeNode( "", new InstrumentDecisionTreeNode(), expectedNoLink ); 
        assertEquals( expectedNoLink, instance.getNoLink() );
        
        expectedNoLink= new InstrumentDecisionTreeNode();
        instance.setNoLink( expectedNoLink );
        assertEquals( expectedNoLink, instance.getNoLink() );
        
        expectedNoLink= new InstrumentDecisionTreeNode();
        instance.setNoLink( expectedNoLink );
        assertEquals( expectedNoLink, instance.getNoLink() );
    }
}
