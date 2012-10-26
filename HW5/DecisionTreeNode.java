
/**
 * Provides the basic structure for the decision tree.
 * 
 * @author Josh Gillham
 * @version 10-16-12
 */
public abstract class DecisionTreeNode extends BTNode< String > implements java.io.Serializable {
    /**
     * Creates a blank instance.
     */
    public DecisionTreeNode() { 
        super();
    }
    
    /**
     * Creates a parent decision node.
     */
    public DecisionTreeNode( String value, DecisionTreeNode no, DecisionTreeNode yes ) {
        super( value, no, yes );
    }
    
    /**
     * Gets a reference to the no node.
     * 
     * @return the "no" node.
     */
    public DecisionTreeNode getNoLink() {
        return (DecisionTreeNode)super.getLeftChild(); //TODO forced cast
    }
    
    /**
     * Gets a reference to the yes node.
     * 
     * @return the "yes" node.
     */
    public DecisionTreeNode getYesLink() {
        return (DecisionTreeNode)super.getRightChild();
    }
    
    /** To be implemented later. */
    public String toString() { 
        return super.toString();
    }
    
    
    /**
     * Sets a new yes node.
     * 
     * @param link is the new "yes" node.
     */
    public void setYesLink( DecisionTreeNode link ) {
        super.setRightChild( link );
    }
    
    /**
     * Sets a new no node
     * 
     * @param link is the new "no" node.
     */
    public void setNoLink( DecisionTreeNode link ) {
        super.setLeftChild( link );
    }
}
