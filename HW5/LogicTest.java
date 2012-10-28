

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
        
        assertTrue( root.getLeftChild() == result );
        assertEquals( "rose", root.getYesLink().getValue() );
        assertEquals( question, root.getNoLink().getValue() );
        assertEquals( "cat", root.getNoLink().getYesLink().getValue() );
        assertEquals( newThing, root.getNoLink().getNoLink().getValue() );
    }
    
    /**
     * Proves that the decision tree is being correctly built.
     */
    @Test
    public void testInputExpandIntelligence2() {
        String question = "Is it a plant?";
        String newThing = "cat";
        String oldThing = "rose";
        DecisionTreeNode root = new ThingNode( oldThing );
        InstrumentationUI ui = new InstrumentationUI( UI.YNAnswer.No, newThing );
        ui.answers.add( question );
        ui.answersYN.add( UI.YNAnswer.Yes );
        
        Logic instance= new Logic( ui, root );
        root = instance.inputExpandIntelligence( null, (ThingNode)root );
        assertEquals( question, root.getValue() );
        assertNotNull( root.getLeftChild() );
        assertEquals( newThing, root.getLeftChild().getValue() );
        assertNotNull( root.getRightChild() );
        assertEquals( oldThing, root.getRightChild().getValue() );
    }
    
    /**
     * Proves the readDecisionTree can be used to recover the same object written with writeDecisionTree.
     */
    @Test
    public void testReadAndWriteDecisionTree_OnlyRoot() {
        DecisionTreeNode root= new ThingNode( "cat" );
        InstrumentationUI ui = new InstrumentationUI( UI.YNAnswer.No, null );
        Logic instance= new Logic( ui, root );
        instance.writeDecisionTree( new java.io.File( "temp" ) );
        DecisionTreeNode actual = instance.readDecisionTree( new java.io.File( "temp" ) );
        assertEquals( root.getValue(), actual.getValue() );
        assertEquals( ThingNode.class, actual.getClass() );
        assertNull( actual.getLeftChild() );
        assertNull( actual.getRightChild() );
    }
    
    /**
     * Proves the readDecisionTree can be used to recover the same object written with writeDecisionTree.
     *  This time with two levels.
     */
    @Test
    public void testReadAndWriteDecisionTree_TwoLevels() {
        DecisionTreeNode left = new ThingNode( "cat" );
        DecisionTreeNode right = new ThingNode( "dog" );
        DecisionTreeNode expected = new QuestionNode( "question", left, right );
        InstrumentationUI ui = new InstrumentationUI( UI.YNAnswer.No, null );
        Logic instance = new Logic( ui, expected );
        instance.writeDecisionTree( new java.io.File( "temp" ) );
        DecisionTreeNode actual = instance.readDecisionTree( new java.io.File( "temp" ) );
        assertNotNull( actual );
        assertEquals( QuestionNode.class, actual.getClass() );
        assertEquals( expected.getValue(), actual.getValue() );

        assertNotNull( actual.getLeftChild() );
        assertEquals( ThingNode.class, actual.getLeftChild().getClass() );        
        assertEquals( expected.getLeftChild().getValue(), actual.getLeftChild().getValue() );
        assertNull( actual.getLeftChild().getLeftChild() );
        assertNull( actual.getLeftChild().getRightChild() );
        
        assertNotNull( actual.getRightChild() );
        assertEquals( ThingNode.class, actual.getRightChild().getClass() );        
        assertEquals( expected.getRightChild().getValue(), actual.getRightChild().getValue() );
        assertNull( actual.getRightChild().getLeftChild() );
        assertNull( actual.getRightChild().getRightChild() );
    }
}
