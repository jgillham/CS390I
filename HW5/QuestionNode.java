
/**
 * The question node is the parent node in the decision tree.
 * 
 * @author Josh Gillham
 * @version 10-16-12
 */
public class QuestionNode/** To be implemented later. */ extends DecisionTreeNode {
    /**
     * Constructs a new question node.
     * 
     * @param question is the question.
     * @param noAnswer is a reference to the no child.
     * @param yesAnswer is a reference to the yes child.
     */
    public QuestionNode( String question, DecisionTreeNode noAnswer, DecisionTreeNode yesAnswer)
    { throw new UnsupportedOperationException(); }
    
    /**
     * Accesses the question.
     * 
     * @return the question.
     */
    public String getQuestion( ) { throw new UnsupportedOperationException(); }

    /** To be implemented later. */
    public String toString( ) { throw new UnsupportedOperationException(); }
}
