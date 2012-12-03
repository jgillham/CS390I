
/**
 * Data for Huffman code tree nodes.
 * 
 * @author Josh Gillham
 * @version 12-3-12
 */
public class HuffmanData {
    /** The Huffman code for this node; null if none. */
    private String code;
    /** Maximum difference to accept two double values as equal. */
    public static final double EPSILON = 0.001;
    /** The frequency stored at this node. */
    private double frq;
    /** The symbol stored at this node; null if none. */
    private Character sym;
    
    /**
     * Simple constructor - set all fields to null or 0.
     */
    public HuffmanData() {
        throw new UnsupportedOperationException();
    }
    
    /**
     * Constructor that sets the symbol only.
     * 
     * @param symbol the symbol.
     */
    public HuffmanData( Character symbol ) {
        throw new UnsupportedOperationException();
    }
    
    /**
     * Constructor that sets the symbol and frequency.
     * 
     * @param symbol the symbol.
     * @param frequency the frequency.
     */
    public HuffmanData( Character symbol, double frequency ) {
        throw new UnsupportedOperationException();
    }
    
    /**
     * Constructor that sets the symbol and frequency.
     * 
     * @param symbol the symbol.
     * @param frequency the frequency.
     * @param code the binary code.
     */
    public HuffmanData( Character symbol, double frequency, String code ) {
        throw new UnsupportedOperationException();
    }
    
    /**
     * Comparison method considers frequency only.
     * 
     * @param n another instance.
     * 
     * @return a negative integer, zero, or a positive integer as 
     *  this object is less than, equal to, or greater than the 
     *  specified object.
     */
    public int compareTo( HuffmanData n ) {
        throw new UnsupportedOperationException();
    }
    
    /**
     * Equals predicate considers the symbol and frequency only.
     * 
     * @param o another object.
     * 
     * @return true if both the symbol and the frequency agree; false otherwise.
     */
    public boolean equals( Object o ) {
        throw new UnsupportedOperationException();
    }
    
    /**
     * Access the code.
     * 
     * @return the code associated with the symbol.
     */
    public String getCode() {
        throw new UnsupportedOperationException();
    }
    
    /**
     * Access the frequency.
     * 
     * @return the frequency of occurrence.
     */
    public double getFrequency() {
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
     * Define hashcode for HuffmanData.
     * 
     * @return the hash code.
     */
    public int hashCode() {
        throw new UnsupportedOperationException();
    }
    
    /**
     * Modify the code.
     */
    public void setFrequency() {
        throw new UnsupportedOperationException();
    }
    
    /**
     * Modify the symbol.
     */
    public void setSymbol() {
        throw new UnsupportedOperationException();
    }
    
    /**
     * String representation of this object.
     * 
     * @return the string representing the object.
     */
    public String toString() {
        throw new UnsupportedOperationException();
    }
}
