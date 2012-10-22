import javax.swing.JOptionPane;
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
    static public void experiment( String[] args ) {
        int result= JOptionPane.showConfirmDialog( null, "Pick a object. I bet I can guess what you're thinking...",
        "Continue?", JOptionPane.YES_NO_OPTION );
        if( result == 1 ) // No
            JOptionPane.showMessageDialog( null, "NO! Why you sir are no fun!" );
        else // Yes
            JOptionPane.showMessageDialog( null, "Get ready to be amazed!" );
    }
    
    /**
     * Logices the program.
     * 
     * @arg args not used.
     */
    static public void main( String[] args ) {
        DecisionTreeNode root= new ThingNode( "rose" );
        
        Logic instance= new Logic( new UI(), root );
        
        ThingNode unsureAnswer= instance.inputFindClosestAnswer();
        if( instance.inputVerifyAnswer( unsureAnswer ) ) {
            //TODO what to do when the game wins.
        }
    }
    
    /** Holds a reference to the base of the decision tree. */
    private DecisionTreeNode root;
    /** Holds a reference to the user interface. */
    private UI ui;
    /** Holds a copy to the parent of the last node specified by the user's answers. */
    private DecisionTreeNode lastParent= null;
    
    /**
     * Initializes the class.
     * 
     * Post Conditions:
     *  -ensures root is set.
     * 
     * @arg ui is the user interface that handles interaction with the user.
     * @arg root is the root of the decision tree.
     * 
     * @throws NullPointerException when root is null.
     */
    public Logic( UI ui, DecisionTreeNode root ) { throw new UnsupportedOperationException(); }
    
    /**
     * Repeates a series of questions until the decision tree points to a specific thing.
     *  
     * Post Conditions:
     *  -lastParent references the parent of the last node specified by the user's answers OR null when
     *   the last node is the root.
     * 
     * 
     * @returns The last node specified by the user's answers.
     */
    public ThingNode inputFindClosestAnswer( ) { throw new UnsupportedOperationException(); }
    
    /**
     * Asks the user if the guess was correct. If correct, returns. If not, asks the user 
     *  for the correct answer and a question to differentiate the two.
     *  
     * Post Conditions:
     * -The decision tree will be modified when the answer is incorrect. The result will have the ThingNode
     *  in the tree replaced with a question node where the question differentiates between the right and
     *  wrong answer and yes and no child point to the correct answer.
     * 
     * @arg unsureAnswer the answer that we are verifying with the user.
     * 
     * @return true if the answer was correct OR false if it wasn't correct.
     * 
     * @throws NullPointerException when unsureAnswer is null.
     */
    public boolean inputVerifyAnswer( ThingNode unsureAnswer ) { throw new UnsupportedOperationException(); }
}
