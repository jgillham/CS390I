
/**
 * Represents a Huffman code which corresponds to the sequence of 
 *  1's and 0's. Extends HNode with a field for symbol.
 * 
 * @author Josh Gillham
 * @version 11-28-12
 */
public class HCode extends HNode {
    /** Holds the letter for the code. */
    private char symbol;
    
    /**
     * Initializes the class. Calls the super constructor.
     * 
     * @param binaryCode is the sequence of 1's and 0's that
     *  corresponds to the sequence.
     * @param symbol is the letter which corresponds to the 
     *  binary code.
     * 
     * @throws NullPointerException if binaryCode is null.
     */
    public HCode( String binaryCode, char symbol ) {
        super( binaryCode, null, null );
        throw new UnsupportedOperationException();
    }
    
    /**
     * Accesses the symbol.
     * 
     * @return the symbol.
     */
    public char getSymbol() {
        throw new UnsupportedOperationException();
    }
    
    /**
     * Tests if the symbols are the same and also checks with the base class.
     * 
     * @param other is the HNode to compare to.
     * 
     * @return true if the other object is a HNode, the data matches, and the 
     *  children are equal.
     *  OR false otherwise.
     */
    @Override
    public boolean equals( Object other ) {
        super.equals( other );
        throw new UnsupportedOperationException( );
    }
}