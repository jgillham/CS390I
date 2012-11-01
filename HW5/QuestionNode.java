
/**
 * The question node is the parent node in the decision tree.
 * 
 * @author Josh Gillham
 * @version 10-16-12
 */
public class QuestionNode extends DecisionTreeNode {
    /**
     * Constructs a new question node.
     * 
     * @param question is the question.
     * @param noAnswer is a reference to the no child.
     * @param yesAnswer is a reference to the yes child.
     */
    public QuestionNode( String question, DecisionTreeNode noAnswer, 
            DecisionTreeNode yesAnswer) {
        super( question, noAnswer, yesAnswer );
    }
    
    /**
     * Accesses the question.
     * 
     * @return the question.
     */
    public String getQuestion( ) {
        return super.getValue();
    }
    
    /**
     * Accesses the string representation of the tree.
     * 
     * @return the string representation.
     */
    public String toString( ) {
        return super.toString();
    }
}
