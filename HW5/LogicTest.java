

import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import java.util.Queue;
import java.util.LinkedList;
import java.io.File;

/**
 * Tests Logic.
 *
 * @author  Josh Gillham
 * @version 10-21-12
 */
public class LogicTest {
    /** Provides mock input instrumentation for UI. */
    class InstrumentationUI extends UI {
        /** Holds a list of yes or no answers. */
        public Queue< YNAnswer > answersYN = new LinkedList< YNAnswer >();
        /** Holds a list of text answers. */
        public Queue< String > answers = new LinkedList< String >();
        /**
         * Constructs a new class with the first inputs.
         * 
         * @param nextYN is the first Yes or no answer.
         * @param nextQuestion is the first text answer.
         */
        public InstrumentationUI( YNAnswer nextYN, String nextQuestion ) {
            this.answersYN.add( nextYN );
            this.answers.add( nextQuestion );
        }
        
        /**
         * Provides the first answer in the queue.
         * 
         * @param message is not used.
         * 
         * @return the next answer in the queue.
         */
        public YNAnswer inputYNQuestion( String message ) {
            return this.answersYN.poll();
        }
        
        /**
         * Provides the first text answer in the queue.
         * 
         * @param message is not used.
         * 
         * @return the next answer in the queue.
         */
        public String inputQuestion( String message ) { 
            return this.answers.poll();
        }
        
    }
    
    /**
     * Proves the constructor can create an instance without an error.
     */
    @Test
    public void testConstructor() {
        new Logic( new InstrumentationUI( null, "" ), new ThingNode( "rose" ) );
    }
    
    /**
     * Proves that a decision tree with one ThingNode produces the same
     *  ThingNode.
     */
    @Test
    public void testInputFindClosestAnswer() {
        InstrumentationUI ui = new InstrumentationUI( null, null );
        ThingNode root = new ThingNode( "rose" );
        Logic instance = new Logic( ui, root );
        Logic.Lineage result = instance.inputFindClosestAnswer();
        assertNotNull( result );
        assertEquals( root,  result.child );
        assertNull( result.parent );
    }
    
    /**
     * Proves that a decision tree with multiple children produces the correct
     *  ThingNode.
     */
    @Test
    public void testInputFindClosestAnswer_multi() {
        ThingNode yesChild = new ThingNode( "rose" );
        ThingNode noChild = new ThingNode( "cat" );
        DecisionTreeNode root = new QuestionNode( "", noChild, yesChild );
        InstrumentationUI ui = new InstrumentationUI( UI.YNAnswer.Yes, "dog" );
        Logic instance = new Logic( ui, root );
        Logic.Lineage result = instance.inputFindClosestAnswer();
        assertNotNull( result );
        assertEquals( yesChild, result.child );
        assertEquals( root, result.parent );
    }
    
    /**
     * Proves that a decision tree with multiple children produces the correct
     *  ThingNode.
     */
    @Test
    public void testInputFindClosestAnswer_userCancels2ndLevel() {
        ThingNode yesChild = new ThingNode( "rose" );
        ThingNode noChild = new ThingNode( "cat" );
        DecisionTreeNode root = new QuestionNode( "", noChild, yesChild );
        InstrumentationUI ui = new InstrumentationUI( null, null );
        ui.answersYN.add( UI.YNAnswer.No );
        Logic instance = new Logic( ui, root );
        Logic.Lineage result = instance.inputFindClosestAnswer();
        assertNull( result );
    }
    
    /**
     * Proves that the user can cancel the process.
     */
    @Test
    public void testInputVerifyAnswer_userCancels() {
        ThingNode yesChild = new ThingNode( "rose" );
        ThingNode noChild = new ThingNode( "cat" );
        DecisionTreeNode root = new QuestionNode( "", noChild, yesChild );
        Logic instance = new Logic( new InstrumentationUI( null, null ), root );
        assertNull( instance.inputVerifyAnswer( yesChild ) );
    }
    
    /**
     * Proves that the program can correct verify the unsure answer.
     */
    @Test
    public void testInputVerifyAnswer() {
        ThingNode yesChild = new ThingNode( "rose" );
        ThingNode noChild = new ThingNode( "cat" );
        DecisionTreeNode root = new QuestionNode( "", noChild, yesChild );
        Logic instance = new Logic( 
            new InstrumentationUI( UI.YNAnswer.No, "" ), root
        );
        assertEquals( UI.YNAnswer.No, instance.inputVerifyAnswer( yesChild ) );
        
        instance = new Logic( 
            new InstrumentationUI( UI.YNAnswer.Yes, "" ), root
        );
        assertEquals( UI.YNAnswer.Yes, instance.inputVerifyAnswer( yesChild ) );
    }
    
    /**
     * Proves that the user can cancel the process.
     */
    @Test
    public void testInputExpandIntelligence_userCancels1st() {
        InstrumentationUI ui = new InstrumentationUI( UI.YNAnswer.Yes, null );
        ui.answers.add( "test3" );
        DecisionTreeNode root = new ThingNode( "test" );
        Logic instance = new Logic( ui, root );
        QuestionNode result = instance.inputExpandIntelligence( 
            null, (ThingNode)root
        );
        assertNull( result );
    }
    
    /**
     * Proves that the user can cancel the process.
     */
    @Test
    public void testInputExpandIntelligence_userCancels2nd() {
        InstrumentationUI ui = new InstrumentationUI( 
            UI.YNAnswer.Yes, "test2"
        );
        DecisionTreeNode root = new ThingNode( "test" );
        Logic instance = new Logic( ui, root );
        QuestionNode result = instance.inputExpandIntelligence( 
            null, (ThingNode)root
        );
        assertNull( result );
    }
    
    /**
     * Proves that the user can cancel the process.
     */
    @Test
    public void testInputExpandIntelligence_userCancels3rd() {
        InstrumentationUI ui = new InstrumentationUI( null, "test2" );
        DecisionTreeNode root = new ThingNode( "test" );
        ui.answers.add( "test3" );
        Logic instance = new Logic( ui, root );
        QuestionNode result = instance.inputExpandIntelligence( 
            null, (ThingNode)root
        );
        assertNull( result );
    }
    
    /**
     * Proves that the decision tree is being correctly built.
     */
    @Test
    public void testInputExpandIntelligence_1level() {
        String question = "Is it a plant?";
        String newThing = "cat";
        String oldThing = "rose";
        DecisionTreeNode root = new ThingNode( oldThing );
        InstrumentationUI ui = new InstrumentationUI( 
            UI.YNAnswer.Yes, newThing
        );
        ui.answers.add( question );
        
        Logic instance = new Logic( ui, root );
        root = instance.inputExpandIntelligence( null, (ThingNode)root );
        assertNotNull( root );
        assertEquals( question, root.getValue() );
        assertNotNull( root.getLeftChild() );
        assertEquals( newThing, root.getLeftChild().getValue() );
        assertNotNull( root.getRightChild() );
        assertEquals( oldThing, root.getRightChild().getValue() );
    }
    
    /**
     * Proves that the decision tree is being correctly built.
     */
    @Test
    public void testInputExpandIntelligence_2levels() {
        ThingNode yesChild = new ThingNode( "rose" );
        ThingNode noChild = new ThingNode( "cat" );
        QuestionNode root = new QuestionNode( 
            "Is it a plant?", noChild, yesChild
        );
        String question =  "Does it say \"MEOW?\"";
        String newThing = "dog";
        InstrumentationUI ui = new InstrumentationUI( 
            UI.YNAnswer.Yes, newThing
        );
        Logic instance = new Logic( ui, root );
        ui.answers.add( question );
        QuestionNode result = instance.inputExpandIntelligence( root, noChild );
        assertNotNull( result );
        
        assertTrue( root.getLeftChild() == result );
        assertEquals( "rose", root.getYesLink().getValue() );
        assertEquals( question, root.getNoLink().getValue() );
        assertEquals( "cat", root.getNoLink().getYesLink().getValue() );
        assertEquals( newThing, root.getNoLink().getNoLink().getValue() );
    }
    
    
    /**
     * Proves the readDecisionTree can be used to recover the same 
     *  object written with writeDecisionTree.
     */
    @Test
    public void testReadAndWriteDecisionTree_OnlyRoot() {
        File tempFile = new File( "temp" );
        DecisionTreeNode root = new ThingNode( "cat" );
        InstrumentationUI ui = new InstrumentationUI( UI.YNAnswer.No, null );
        Logic instance = new Logic( ui, root );
        instance.writeDecisionTree( tempFile );
        DecisionTreeNode actual = instance.readDecisionTree( tempFile );
        assertEquals( root.getValue(), actual.getValue() );
        assertEquals( ThingNode.class, actual.getClass() );
        assertNull( actual.getLeftChild() );
        assertNull( actual.getRightChild() );
        tempFile.delete(); // Remove file as a curtisee
    }
    
    /**
     * Proves the readDecisionTree can be used to recover the same 
     *  object written with writeDecisionTree. This time with two levels.
     */
    @Test
    public void testReadAndWriteDecisionTree_TwoLevels() {
        File tempFile = new File( "temp" );
        DecisionTreeNode left = new ThingNode( "cat" );
        DecisionTreeNode right = new ThingNode( "dog" );
        DecisionTreeNode expected = new QuestionNode( "question", left, right );
        InstrumentationUI ui = new InstrumentationUI( UI.YNAnswer.No, null );
        Logic instance = new Logic( ui, expected );
        instance.writeDecisionTree( tempFile );
        DecisionTreeNode actual = instance.readDecisionTree( tempFile );
        assertNotNull( actual );
        assertEquals( QuestionNode.class, actual.getClass() );
        assertEquals( expected.getValue(), actual.getValue() );

        assertNotNull( actual.getLeftChild() );
        assertEquals( 
            ThingNode.class, 
            actual.getLeftChild().getClass()
        );        
        assertEquals( 
            expected.getLeftChild().getValue(), 
            actual.getLeftChild().getValue()
        );
        assertNull( actual.getLeftChild().getLeftChild() );
        assertNull( actual.getLeftChild().getRightChild() );
        
        assertNotNull( actual.getRightChild() );
        assertEquals( 
            ThingNode.class,
            actual.getRightChild().getClass()
        );        
        assertEquals( 
            expected.getRightChild().getValue(), 
            actual.getRightChild().getValue()
        );
        assertNull( actual.getRightChild().getLeftChild() );
        assertNull( actual.getRightChild().getRightChild() );
        tempFile.delete(); // Remove file as a curtisee
    }
}
