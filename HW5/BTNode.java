import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.ObjectInputStream;

/**
 * Provides the base node structure.
 * 
 * @author Josh Gillham
 * @version 10-16-12
 */
public class BTNode< T > implements java.io.Serializable {
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
    public String toString( ) {
        StringBuilder retValue = new StringBuilder();
        retValue.append( '{' );
        retValue.append( this.getValue() );
        retValue.append( ", " );
        retValue.append( this.getLeftChild().toString() );
        retValue.append( ", " );
        retValue.append( this.getRightChild().toString() );
        retValue.append( '}' );
        return retValue.toString();
    }
    
    /**
     * Write the non serializable fields.
     * 
     * @arg out is the output stream.
     * 
     * @throws IOException should never be thrown.
     */
    private void writeObject( ObjectOutputStream out) throws IOException{
        out.writeObject( this.getValue() );
        out.writeObject( this.getLeftChild() );
        out.writeObject( this.getRightChild() );
    }
    
    /**
     * Sets the refences to the objects of non serializable fields as they are read.
     * 
     * @param in is the input stream.
     * 
     * @throws IOException should never be thrown.
     * @throws ClassNotFoundException should never be thrown.
     */
    @SuppressWarnings( "unchecked" ) // For the cast of type T
    private void readObject( ObjectInputStream in ) throws IOException, ClassNotFoundException {
        this.setValue( (T)in.readObject() );
        this.setLeftChild( (BTNode< T >)in.readObject() );
        this.setRightChild( (BTNode< T >)in.readObject() );
    }
}
