
/**
 * Provides the base node structure.
 * 
 * @author Josh Gillham
 * @version 10-16-12
 */
public class BTNode< T > {
    /** Holds a reference of the left child. */
    private BTNode< T > left= null;
    /** Holds a reference of the right child. */
    private BTNode< T > right= null;
    /** Holds a reference to the data. */
    private T value= null;
    
    /**
     * Constructs a blank instance.
     */
    public BTNode( ) { }
    
    /**
     * Constructs an end node.
     * 
     * @param value is the data.
     */
    public BTNode( T value ) { 
        this.value= value;
    }
    
    /**
     * Constructs a parent node.
     * 
     * @param value is the data.
     * @param left is a reference to the left node.
     * @param right is a reference to the right node.
     */
    public BTNode( T value,  BTNode< T > left, BTNode< T > right ) {
        this.value= value;
        this.left= left;
        this.right= right;
    }
    
    /**
     * Accesses the left node.
     * 
     * @return a reference to the left node.
     */
    public BTNode< T > getLeftChild(){
        return left;
    }
    
    /**
     * Accesses the right node.
     * 
     * @return a reference to the right node.
     */
    public BTNode< T > getRightChild() {
        return right;
    }
    
    /**
     * Accesses the data.
     * 
     * @return a reference to the data.
     */
    public T getValue( ) {
        return value;
    }
    
    /**
     * Sets the left child.
     * 
     * Post Conditions:
     * -the left child is set.
     * 
     * @param left is the new left node.
     */
    public void setLeftChild( BTNode< T > left ) {
        this.left= left;
    }
    
    /**
     * Sets the right child.
     * 
     * Post Conditions:
     * -the right child is set.
     * 
     * @param right is the new right node.
     */
    public void setRightChild( BTNode< T > right ) {
        this.right= right;
    }
    
    /**
     * Sets the data.
     * 
     * Post Conditions:
     * -the data is set.
     * 
     * @param value is the new data.
     */
    public void setValue( T value ) {
        this.value= value;
    }
    
    /** To be implemented later. */
    public String toString( ){ throw new UnsupportedOperationException(); }
}
