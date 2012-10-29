import javax.swing.JOptionPane;
import java.io.File;
import java.io.OutputStream;
import java.io.FileOutputStream;
import java.io.BufferedOutputStream;
import java.io.ObjectOutputStream;
import java.io.ObjectOutput;
import java.io.IOException;
import java.io.InputStream;
import java.io.FileInputStream;
import java.io.BufferedInputStream;
import java.io.ObjectInput;
import java.io.ObjectInputStream;

/**
 * Features
 * -Starts the program.
 * -Deducts the closest answer.
 * -Improves decision tree.
 * 
 * @author Josh Gillham
 * @version 10-18-12
 */
public class Logic {
    /**
     * For experimental purposes. Soon to be deleted.
     * 
     * @param args not used
     */
    static public void experiment( String[] args ) {
        int result = JOptionPane.showConfirmDialog( null, 
            "Pick a object. I bet I can guess what you're thinking...",
            "Continue?", JOptionPane.YES_NO_OPTION );
        if ( result == 1 ) // No
            JOptionPane.showMessageDialog( null, 
                "NO! Why you sir are no fun!" );
        else // Yes
            JOptionPane.showMessageDialog( null, 
                "Get ready to be amazed!" );
    }
    
    /** Holds the message which asks the player if they want to play. */
    static private final String WANT_TO_PLAY_MESSAGE = 
        "Pick a object. I bet I can guess what you're thinking...";
    
    /** Provides a return type for inputFindClosestAnswer. */
    static public class Lineage {
        /** Holds a reference to the parent node. */
        public QuestionNode parent;
        /** Holds a reference to the child node. */
        public ThingNode child;
        /**
         * Initializes the class.
         * 
         * @param parent is the parent node.
         * @param child is the child node.
         */
        public Lineage( QuestionNode parent, ThingNode child ) {
            this.parent = parent;
            this.child = child;
        }
    }
    
    static File defaultFile = new File( "data.ser" );
    
    /**
     * Starts up the program.
     * 
     * @param args not used.
     */
    static public void main( String[] args ) {
        UI ui = new UI();
        DecisionTreeNode root = Logic.readDecisionTree( defaultFile );
        if( root == null )
            root = new ThingNode( "rose" );
        Logic instance = new Logic( ui, root );
        while ( ui.inputYNQuestion( WANT_TO_PLAY_MESSAGE ) 
          == UI.YNAnswer.Yes ) {
            ui.showMessage( "Get ready to be amazed!" );
            
            
            Lineage unsureAnswer;
            do {
                unsureAnswer = instance.inputFindClosestAnswer();
            }
            while( unsureAnswer == null &&
            // The user clicked the X or cancel so maybe they want to quit.
              ui.inputYNQuestion( "Do you want to quit the game?" )  == UI.YNAnswer.No );
            // Exit the game early
            if( unsureAnswer == null )
                break;
            
            UI.YNAnswer response;
            do {
                response = instance.inputVerifyAnswer( unsureAnswer.child );
            }
            while( response == null &&
            // The user clicked the X or cancel so maybe they want to quit.
              ui.inputYNQuestion( "Do you want to quit the game?" )  == UI.YNAnswer.No );
            // Exit the game early
            if( response == null )
                break;
            // The game wins.
            if ( response == UI.YNAnswer.Yes ) {
                ui.showMessage( "See? I am so smart!" );
            }
            // The game was wrong.
            else {
                QuestionNode result;
                do {
                    result = instance.inputExpandIntelligence( 
                    unsureAnswer.parent, unsureAnswer.child );
                } 
                while( result == null && 
                // The user clicked the X or cancel so maybe they want to quit.
                  ui.inputYNQuestion( "Do you want to quit the game?" )  == UI.YNAnswer.No );
                // Exit the game early
                if( result == null )
                    break;
            }
        }
        instance.writeDecisionTree( defaultFile );
        ui.showMessage( "Why you sir are no fun!" );
    }
    
    /** Holds a reference to the base of the decision tree. */
    private DecisionTreeNode root;
    /** Holds a reference to the user interface. */
    private UI ui;
    
    /**
     * Initializes the class.
     * 
     * Post Conditions:
     *  -ensures root and ui are set.
     * 
     * @param ui is the user interface that handles interaction with the user.
     * @param root is the root of the decision tree.
     * 
     * @throws NullPointerException when root or ui is null.
     */
    public Logic( UI ui, DecisionTreeNode root ) {
        if ( ui == null || root == null )
            throw new NullPointerException();
        
        this.ui = ui;
        this.root = root;
    }
    
    /**
     * Provides a shortcut.
     * 
     * @return the parent and child of the closest node.
     */
    public Lineage inputFindClosestAnswer( ) {
        return inputFindClosestAnswer( null, root );
    }
    
    /**
     * Repeates a series of questions until the decision tree points 
     *  to a specific thing.
     *  
     * Post Conditions:
     *  -lastParent references the parent of the last node specified 
     *   by the user's answers OR null when the last node is the root.
     * 
     * @param parent is the parent node.
     * @param child is the child node.
     * 
     * @return The last node specified by the user's answers.
     * 
     * @throws NullPointerException when start is null.
     */
    public Lineage inputFindClosestAnswer( QuestionNode parent, 
        DecisionTreeNode child ) {
        if ( child == null )
            throw new NullPointerException();
            
        if ( child.getClass() == ThingNode.class ) {
            return new Lineage( parent, (ThingNode)child );
        }
        else if ( child.getClass() == QuestionNode.class ) {
            QuestionNode question = (QuestionNode)child;
            UI.YNAnswer response = ui.inputYNQuestion( question.getQuestion() );
            if( response == null )
                return null;
            switch( response  ) {
                case Yes:
                    return inputFindClosestAnswer( question, 
                        child.getYesLink() );
                case No:
                    return inputFindClosestAnswer( question,
                        child.getNoLink() );
                default:
                    throw new UnsupportedOperationException();
            }
        }
        else
            throw new UnsupportedOperationException();
    }
            
    
    /**
     * Asks the user if the guess was correct.
     * 
     * @param unsureAnswer the answer that we are verifying with the user.
     * 
     * @return true if the answer was correct OR false if it wasn't correct.
     * 
     * @throws NullPointerException when unsureAnswer is null.
     */
    public UI.YNAnswer inputVerifyAnswer( ThingNode unsureAnswer ) {
        if ( unsureAnswer == null )
            throw new NullPointerException();
        return ui.inputYNQuestion( "Were you thinking of " + 
            unsureAnswer.getValue() + "?" ); 
    }
    
    /**
     * Asks the user for the correct answer and a question to differentiate
     *  the two.
     * 
     * Post Conditions:
     * -The decision tree will be modified when the answer is incorrect. The 
     *  result will have the ThingNode in the tree replaced with a question 
     *  node where the question differentiates between the right and wrong 
     *  answer and yes and no child point to the correct answer.
     * 
     * @param parent the parent node of incorrectAnswer.
     * @param incorrectAnswer the node that needs to be replaced.
     * 
     * @return the question node that replaced the incorrectAnswer in the tree OR return null if
     *  the user cancels any dialog box.
     * 
     * @throws NullPointerException when incorrectAnswer is null.
     */
    public QuestionNode inputExpandIntelligence( QuestionNode parent, 
            ThingNode incorrectAnswer ) {
        if ( incorrectAnswer == null )
            throw new NullPointerException();
        ThingNode correctAnswer = new ThingNode( ui.inputQuestion( "What were you thinking of?" ) );
        if( correctAnswer.getValue() == null )
            return null;
        String question = ui.inputQuestion( 
            "Please enter a Yes/No question to differentiate between " 
            + correctAnswer.getValue() + " and " +
            incorrectAnswer.getValue() + "." );
        if( question == null )
            return null;
            
        QuestionNode replacement;
        UI.YNAnswer response = ui.inputYNQuestion( "Whats the answer for " + 
            incorrectAnswer.getValue() + "." );
        if ( response == UI.YNAnswer.Yes )
            replacement = new QuestionNode( question, correctAnswer, 
                incorrectAnswer );
        else if ( response == UI.YNAnswer.No )
            replacement = new QuestionNode( question, incorrectAnswer, 
                correctAnswer );
        else
            return null;
            
        if ( parent == null )
            root = replacement;
        else {
            if ( parent.getNoLink() == incorrectAnswer )
                parent.setNoLink( replacement );
            else
                parent.setYesLink( replacement );
        }
        return replacement;
    }
    
    /**
     * Writes the data tree to a file.
     * 
     * @arg outFile the file to write to.
     */
    public void writeDecisionTree( File outFile ) {
        try {
            OutputStream out = new FileOutputStream( outFile );
            OutputStream buffer = new BufferedOutputStream( out );
            ObjectOutput oOutPut = new ObjectOutputStream( buffer );
            try {
                oOutPut.writeObject( this.root );
            } finally {
                oOutPut.close();
            }
            
        } catch( IOException e ) {
            e.printStackTrace();
        }
    }
    /**
     * Reads the data tree from the file.
     * 
     * @arg inFile is the file to read from.
     * 
     * @return the tree root.
     */
    static public DecisionTreeNode readDecisionTree( File inFile ) {
        try {
            ObjectInput input = new ObjectInputStream( new BufferedInputStream( new FileInputStream( inFile ) ) );
            try {
                @SuppressWarnings( "unchecked" )
                DecisionTreeNode root = (DecisionTreeNode)input.readObject();
                return root;
            }finally {
                input.close();
            }
        }catch (ClassNotFoundException ex) {
            System.err.println(
                "Unsuccessful deserialization: Class not found. " + ex);
        }
        catch (IOException ex) {
            System.err.println("Unsuccessful deserialization: " + ex);
        }
        return null;
    }
}
