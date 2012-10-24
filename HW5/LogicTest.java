

import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 *
 * @author  Josh Gillham
 * @version 10-21-12
 */
public class LogicTest {
    class InstrumentationUI extends UI {
        YNAnswer nextYN;
        String nextQuestion;
        public InstrumentationUI( YNAnswer nextYN, String nextQuestion ) {
            this.nextYN= nextYN;
            this.nextQuestion= nextQuestion;
        }
        public YNAnswer inputYNQuestion( String message ) {
            return nextYN;
        }
        public String inputQuestion( String message ) { 
            return this.nextQuestion;
        }
        
    }
    DecisionTreeNode root;
    public LogicTest() {
        root= new ThingNode( "rose" );
    }
    
    /**
     * Proves the constructor can create an instance without an error.
     */
    @Test
    public void testConstructor() {
        new Logic( new InstrumentationUI( null, "" ), root );
    }
    
    /**
     * Proves that a decision tree with one ThingNode produces the same
     *  ThingNode.
     */
    @Test
    public void testInputFindClosestAnswer() {
        Logic instance= new Logic( new InstrumentationUI( null, null ), root );
        assertEquals( root, instance.inputFindClosestAnswer() );
    }
    
    /**
     * Proves that a decision tree with multiple children produces the correct
     *  ThingNode.
     */
    @Test
    public void testInputFindClosestAnswer_multi() {
        ThingNode yesChild= new ThingNode( "rose" );
        ThingNode noChild= new ThingNode( "cat" );
        DecisionTreeNode root= new QuestionNode( "", noChild, yesChild );
        Logic instance= new Logic( new InstrumentationUI( UI.YNAnswer.Yes, "" ), root );
        assertEquals( yesChild, instance.inputFindClosestAnswer() );
    }
}
