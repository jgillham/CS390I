
/**
 * Extends BTNode by adding a frequency field and also methods to help 
 *  priority queue with sorting.
 * 
 * @author Josh Gillham
 * @version 11-28-12
 */
public class HNode extends BTNode< HuffmanData > {
    /**
     * Simple constructor - set all fields to null or 0.
     */
    public HNode() {
        super( null, null, null );
        throw new UnsupportedOperationException();
    }
    
    /**
     * Constructor that sets the symbol only.
     * 
     * @param symbol the symbol.
     */
    public HNode(Character symbol) {
        super( new HuffmanData( symbol ), null, null );
        throw new UnsupportedOperationException();
    }
    
    /**
     * Constructor that sets the symbol and frequency. 
     * 
     * @param symbol the symbol.
     * @param frequency the frequency of occurrence for the symbol.
     */
    public HNode(Character symbol, double frequency) {
        super( new HuffmanData( symbol, frequency ), null, null );
        throw new UnsupportedOperationException();
    }
    
    /**
     * Constructor that sets symbol, frequency, and code. 
     * 
     * @param symbol the symbol.
     * @param frequency the frequency of occurrence for the symbol.
     * @param code the code for the symbol.
     */
    public HNode(Character symbol, double frequency, String code) {
        super( new HuffmanData( symbol, frequency, code ), null, null );
        throw new UnsupportedOperationException();
    }
    
    /**
     * Fully parameterized constructor. 
     * 
     * @param symbol the symbol.
     * @param frequency the frequency of occurrence for the symbol.
     * @param code the code for the symbol.
     * @param left link to the left child.
     * @param right link to the right child
     */
    public HNode(Character symbol, double frequency, String code,
            HNode left, HNode right) {
        super( new HuffmanData( symbol, frequency, code ), left, right );
        throw new UnsupportedOperationException();
    }
    
    /**
     * Compares the HNodes by the frequency.
     * 
     * @param n object to be compared with this.
     * 
     * @return a negative integer, zero, or a positive integer as this 
     *  object is less than, equal to, or greater than the specified object. 
     * 
     * @throws NullPointerException if the specified object is null.
     */
    public int compareTo(HNode n) {
        throw new UnsupportedOperationException();
    }
    
    /**
     * Equals predicate considers the symbol and frequency only. 
     * 
     * @param o the object to check for equality.
     * 
     * @return true if both the symbol and the frequency agree;
     *  false otherwise
     */
    @Override
    public boolean equals( Object o ) {
        throw new UnsupportedOperationException( );
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
     * Sets the binary code.
     * 
     * @param code the new code.
     * 
     * @throws NullPointerException when binaryCode is null.
     */
    public void setCode( String code ) {
        throw new UnsupportedOperationException();
    }
    
    /**
     * Modify the symbol.
     * 
     * @param symbol the new symbol.
     */
    public void setSymbol(Character symbol) {
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
     * Accesses the binary code.
     * 
     * @return the binary code.
     */
    public String getCode( ) {
        throw new UnsupportedOperationException();
    }
    
    /**
     * Access the symbol.
     * 
     * @return the symbol.
     */
    public Character getSymbol() {
        throw new UnsupportedOperationException();
    }
    
    /**
     * Access the left child.
     * 
     * @return the left child of this node.
     */
    public HNode getLeftChild() {
        throw new UnsupportedOperationException();
    }
    
    /**
     * Access the right child.
     * 
     * @return the right child of this node.
     */
    public HNode getRightChild() {
        throw new UnsupportedOperationException();
    }
    
    /**
     * Define hashcode for HNode.
     * 
     * If two objects are equal according to the equals(Object)
     *  method, then calling the hashCode method on each of the 
     *  two objects produces the same integer result.
     * 
     * @return a hash code value for this object.
     */
    public int hashCode() {
        throw new UnsupportedOperationException();
    }
}
