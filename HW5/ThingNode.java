
/**
 * Represents the specific end object in the Decision tree. Forms the end of the tree. Has no
 *  children.
 * 
 * @author Josh Gillham
 * @version 10-16-12
 */
public class ThingNode extends DecisionTreeNode {
    /**
     * Constructs the class.
     * 
     * @param thing is the end object.
     */
    public ThingNode( String thing ) {
        super( );
        super.setValue( thing );
    }
    
    /**
     * Accesses the object.
     * 
     * @return the object.
     */
    public String getThing( ) {
        return super.getValue();
    }
    
    /** To be implemented later. */
    public String toString( ) {
        return super.toString();
    }
}
