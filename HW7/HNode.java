
/**
 * Extends BTNode by adding a frequency field and also methods to help 
 *  priority queue with sorting.
 * 
 * @author Josh Gillham
 * @version 11-28-12
 */
public class HNode extends BTNode< Integer > {
    private String binaryCode = null;
    
    /**
     * Initializes the class. Calls the base class.
     * 
     * @param frequency is the new frequency.
     * @param left is the left node.
     * @param right is the right node.
     * 
     * @throws NullPointerException if binaryCode is null.
     * @throws IllegalArgumentException if frequency is less than 0.
     */
    public HNode( int frequency, HNode left, HNode right ) {
        super( Integer.valueOf( frequency ), left, right );
        throw new UnsupportedOperationException();
    }
    
    /**
     * Sets the frequency.
     * 
     * @param frequency the new frequency.
     * 
     * @throws IllegalArgumentException if frequency is less than 0.
     */
    public void setFrequency( int frequency ) {
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
     * Sets the binary code.
     * 
     * @param binaryCode the new code.
     * 
     * @throws NullPointerException when binaryCode is null.
     */
    public void setBinaryCode( String binaryCode ) {
        throw new UnsupportedOperationException();
    }
    
    /**
     * Accesses the binary code.
     * 
     * @return the binary code.
     */
    public String getBinaryCode( ) {
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
