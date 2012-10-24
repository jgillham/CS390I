

import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import java.util.Queue;
import java.util.LinkedList;

/**
 *
 * @author  Josh Gillham
 * @version 10-21-12
 */
public class LogicTest {
    class InstrumentationUI extends UI {
        public Queue< YNAnswer > answersYN = new LinkedList< YNAnswer >();
        public Queue< String > answers = new LinkedList< String >();
        public InstrumentationUI( YNAnswer nextYN, String nextQuestion ) {
            this.answersYN.add( nextYN );
            this.answers.add( nextQuestion );
        }
        public YNAnswer inputYNQuestion( String message ) {
            return this.answersYN.poll();
        }
        public String inputQuestion( String message ) { 
            return this.answers.poll();
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
        InstrumentationUI ui= new InstrumentationUI( null, null );
        Logic instance= new Logic( ui, root );
        Logic.Lineage result = instance.inputFindClosestAnswer();
        assertEquals( root,  result.child );
        assertNull( result.parent );
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
        InstrumentationUI ui= new InstrumentationUI( UI.YNAnswer.Yes, "dog" );
        Logic instance= new Logic( ui, root );
        Logic.Lineage result = instance.inputFindClosestAnswer();
        assertEquals( yesChild, result.child );
        assertEquals( root, result.parent );
    }
    
    /**
     * Proves that the program can correct verify the unsure answer.
     */
    @Test
    public void testInputVerifyAnswer() {
        ThingNode yesChild= new ThingNode( "rose" );
        ThingNode noChild= new ThingNode( "cat" );
        DecisionTreeNode root= new QuestionNode( "", noChild, yesChild );
        Logic instance= new Logic( new InstrumentationUI( UI.YNAnswer.No, "" ), root );
        assertFalse( instance.inputVerifyAnswer( yesChild ) );
        
        instance= new Logic( new InstrumentationUI( UI.YNAnswer.Yes, "" ), root );
        assertTrue( instance.inputVerifyAnswer( yesChild ) );
    }
    
    /**
     * Proves that the decision tree is being correctly built.
     */
    @Test
    public void testInputExpandIntelligence() {
        ThingNode yesChild= new ThingNode( "rose" );
        ThingNode noChild= new ThingNode( "cat" );
        QuestionNode root= new QuestionNode( "Is it a plant?", noChild, yesChild );
        String question =  "Does it say \"MEOW?\"";
        String newThing = "Dog";
        InstrumentationUI ui = new InstrumentationUI( UI.YNAnswer.No, newThing );
        Logic instance= new Logic( ui, root );
        ui.answers.add( question );
        QuestionNode result = instance.inputExpandIntelligence( root, noChild );
        QuestionNode expected = new QuestionNode( question, noChild, new ThingNode( newThing )  );
        assertEquals( expected.getNoLink(), result.getNoLink() );
        assertEquals( expected.getYesLink().getValue(), result.getYesLink().getValue() );
        assertEquals( expected.getValue(), result.getValue() );
        assertTrue( result == root.getNoLink() );
    }
}
