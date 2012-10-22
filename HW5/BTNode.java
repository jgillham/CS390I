
/**
 * Provides the base node structure.
 * 
 * @author Josh Gillham
 * @version 10-16-12
 */
public class BTNode< T > {
    /** Holds a reference of the left child. */
    private BTNode< T > left;
    /** Holds a reference of the right child. */
    private BTNode< T > right;
    /** Holds a reference to the data. */
    private T value;
    
    /**
     * Constructs a blank instance.
     */
    public BTNode( ) { throw new UnsupportedOperationException(); }
    
    /**
     * Constructs an end node.
     * 
     * @param value is the data.
     */
    public BTNode( T value ) { throw new UnsupportedOperationException(); }
    /**
     * Constructs a parent node.
     * 
     * @param value is the data.
     * @param left is a reference to the left node.
     * @param right is a reference to the right node.
     */
    public BTNode( T value,  BTNode< T > left, BTNode< T > right ) { throw new UnsupportedOperationException(); }
    
    /**
     * Accesses the left node.
     * 
     * @return a reference to the left node.
     */
    public BTNode< T > getLeftChild(){ throw new UnsupportedOperationException(); }
    
    /**
     * Accesses the right node.
     * 
     * @return a reference to the right node.
     */
    public BTNode< T > getRightChild(){ throw new UnsupportedOperationException(); }
    
    /**
     * Accesses the data.
     * 
     * @return a reference to the data.
     */
    public T getValue( ){ throw new UnsupportedOperationException(); }
    
    /**
     * Sets the left child.
     * 
     * Post Conditions:
     * -the left child is set.
     * 
     * @param left is the new left node.
     */
    public void setLeftChild( BTNode< T > left ){ throw new UnsupportedOperationException(); }
    
    /**
     * Sets the right child.
     * 
     * Post Conditions:
     * -the right child is set.
     * 
     * @param right is the new right node.
     */
    public void setRightChild( BTNode< T > right ){ throw new UnsupportedOperationException(); }
    
    /**
     * Sets the data.
     * 
     * Post Conditions:
     * -the data is set.
     * 
     * @param value is the new data.
     */
    public void setValue( T value ){ throw new UnsupportedOperationException(); }
    
    /** To be implemented later. */
    public String toString( ){ throw new UnsupportedOperationException(); }
}
