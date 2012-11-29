import java.lang.Character;
import java.util.PriorityQueue;
import java.util.Iterator;
import java.util.Map;

/**
 * Provides methods for encoding/decoding data in Huffman codes.
 * 
 * @author  Josh Gillham
 * @version 11-18-12
 */
public class HuffmanCode {
    /** Only an experiment. */
    static public void test() {
        String input = "The cat jumped over the moon.";
        PriorityQueue< PriorityPair< Character >  > analysis =
            new PriorityQueue< PriorityPair< Character > >();
        
        // Goes through each character and the resulting data will have 
        //  letters and corresponding frequencies.
        for ( int i = 0; i < input.length(); ++i ) {
            Character chr = new java.lang.Character( input.charAt( i ) );
            Iterator< PriorityPair< Character > > iter = analysis.iterator();
            boolean found = false;
            while ( iter.hasNext() ) {
                PriorityPair< Character > current = iter.next();
                if ( current.equals( chr ) ) {
                    current.setPriority( current.getPriority() + 1 );
                    found = true;
                }
            }
            if ( !found ) {
                PriorityPair< Character > nw =
                    new PriorityPair< Character >( 1, chr );
                analysis.add( nw );
            }
        }
    }
    
    /**
     * Analyses the text to create a priority queue of nodes showing each 
     *  letter and the frequency which the symbol occured in the text.
     * 
     * @param text the string to analyse.
     * 
     * @return the queue of letters with frequencies.
     */
    static public Map< Character, Integer > analyse( String text ) {
        throw new UnsupportedOperationException( );
    }
    
    /**
     * Creates a Huffman code tree with the analysis queue containing letters
     *  and what frequency they occured in a text.
     * 
     * @param analysis is the queue with letters and their frequencies.
     * 
     * @return the Huffman code tree.
     */
    static public HNode generateHTree( PriorityQueue< HCode > analysis ) {
        throw new UnsupportedOperationException( );
    }
    
    /**
     * Starts the program.
     * 
     * @param args is unused.
     */
    static public void main( String args ) {
        throw new UnsupportedOperationException();
    }
    
    /**
     * Takes the text and replaces each letter with a sequence of ones and
     *  zeros.
     * 
     * @param text the text to encode with ones and zeros.
     * 
     * @return the encoded text.
     * 
     * @throws NullPointerException when text is null.
     */
    public String encode( String text ) {
        throw new UnsupportedOperationException();
    }
    
    /**
     * Takes the encoded Huffman text and replaces it with the letters.
     * 
     * @param text is the encoded text.
     * 
     * @return the decoded text.
     */
    public String decode( String text ) {
        throw new UnsupportedOperationException();
    }
    
    public String getCode( String symbol ) {
        throw new UnsupportedOperationException();
    }
    public String getCode( ) {
        throw new UnsupportedOperationException();
    }
}
