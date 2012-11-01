import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.ObjectInputStream;
import java.io.Serializable;

/**
 * Provides the base node structure.
 * 
 * @author Josh Gillham
 * @version 10-16-12
 * 
 * @param <T> will be the data type.
 */
public class BTNode< T > implements Serializable {
    /** Holds a reference of the left child. */
    private BTNode< T > left = null;
    /** Holds a reference of the right child. */
    private BTNode< T > right = null;
    /** Holds a reference to the data. */
    private T value = null;
    
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
        this.value = value;
    }
    
    /**
     * Constructs a parent node.
     * 
     * @param value is the data.
     * @param left is a reference to the left node.
     * @param right is a reference to the right node.
     */
    public BTNode( T value,  BTNode< T > left, BTNode< T > right ) {
        this.value = value;
        this.left = left;
        this.right = right;
    }
    
    /**
     * Accesses the left node.
     * 
     * @return a reference to the left node.
     */
    public BTNode< T > getLeftChild( ) {
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
     * <br>
     * Post Conditions:
     * <br>
     * -the left child is set.
     * 
     * @param newLeft is the new left node.
     */
    public void setLeftChild( BTNode< T > newLeft ) {
        this.left = newLeft;
    }
    
    /**
     * Sets the right child.
     * <br>
     * Post Conditions:
     * <br>
     * -the right child is set.
     * 
     * @param newRight is the new right node.
     */
    public void setRightChild( BTNode< T > newRight ) {
        this.right = newRight;
    }
    
    /**
     * Sets the data.
     * <br>
     * Post Conditions:
     * <br>
     * -the data is set.
     * 
     * @param value is the new data.
     */
    public void setValue( T value ) {
        this.value = value;
    }
    
    /**
     * Gives a representation of this node along with the child nodes and
     *  their children.
     *  
     * @return a string representation.
     */
    public String toString( ) {
        StringBuilder retValue = new StringBuilder();
        retValue.append( '{' );
        retValue.append( this.getValue() );
        retValue.append( ", " );
        retValue.append( this.getLeftChild() );
        retValue.append( ", " );
        retValue.append( this.getRightChild() );
        retValue.append( '}' );
        return retValue.toString();
    }
}
