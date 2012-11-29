
/**
 * Extends BTNode by adding a frequency field and also methods to help 
 *  priority queue with sorting.
 * 
 * @author Josh Gillham
 * @version 11-28-12
 */
public abstract class HNode extends BTNode< String > {
    private int frequency = 0;
    
    /**
     * Initializes the class. Calls the base class.
     * 
     * @param binaryCode is the sequency of 1's and 0's which corresponds
     *  to this tree.
     * @param left is the left node.
     * @param right is the right node.
     * 
     * @throws NullPointerException if binaryCode is null.
     */
    public HNode( String binaryCode, HNode left, HNode right ) {
        super( binaryCode, left, right );
        throw new UnsupportedOperationException();
    }
    
    /**
     * Accesses the frequency.
     * 
     * @return the frequency.
     */
    public int getFrequency() {
        throw new UnsupportedOperationException();
    }
    
    /**
     * Compares the HNodes by the frequency.
     * 
     * @param other is the other HNode to compare to.
     * 
     * @throws IllegalArgumentException if other is not a HNode.
     * 
     * @return 1 if this HNode has a higher priority 
     *  OR -1 if the this HNode has a lower priority 
     *  OR 0 otherwise.
     */
    public int compareTo( Object other ) {
        throw new UnsupportedOperationException();
    }
    
    /**
     * Tests if frequencies, data, and children are equal.
     * 
     * @param other is the HNode to compare to.
     * 
     * @return true if the other object is a HNode, the data 
     *  matches, and the children are equal.
     *  OR false otherwise.
     */
    @Override
    public boolean equals( Object other ) {
        throw new UnsupportedOperationException( );
    }
}
