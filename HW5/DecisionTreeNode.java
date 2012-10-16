
/**
 * 
 * @author Josh Gillham
 * @version 10-16-12
 */
public abstract class DecisionTreeNode extends BTNode< String > {
    /** To be implemented later. */
    public DecisionTreeNode() { throw new UnsupportedOperationException(); }
    /** To be implemented later. */
    public DecisionTreeNode( String value, DecisionTreeNode no, DecisionTreeNode yes )
    {throw new UnsupportedOperationException(); }
    
    /** To be implemented later. */
    public DecisionTreeNode getNoLink() { throw new UnsupportedOperationException(); }
    /** To be implemented later. */
    public String getString() { throw new UnsupportedOperationException(); }
    /** To be implemented later. */
    public DecisionTreeNode getYesLink() { throw new UnsupportedOperationException(); }
    
    /** To be implemented later. */
    public void setYesLink( DecisionTreeNode link ) { throw new UnsupportedOperationException(); }
    /** To be implemented later. */
    public void setNoLink( DecisionTreeNode link ) { throw new UnsupportedOperationException(); }
}
