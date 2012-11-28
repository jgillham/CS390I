import java.lang.Character;
import java.util.PriorityQueue;
import java.util.Iterator;
/**
 * Provides methods for encoding/decoding data in Huffman codes.
 * 
 * @author  Josh Gillham
 * @version 11-18-12
 */
public class HuffmanCode {
    static public void test() {
        String input = "The cat jumped over the moon.";
        PriorityQueue< PriorityPair< Character >  > analysis =
            new PriorityQueue< PriorityPair< Character > >();
        
        // Goes through each character and the resulting data will have letters and corresponding frequencies.
        for( int i = 0; i < input.length(); ++i ) {
            Character chr = new java.lang.Character( input.charAt( i ) );
            Iterator< PriorityPair< Character > > iter = analysis.iterator();
            boolean found = false;
            while( iter.hasNext() ) {
                PriorityPair< Character > current = iter.next();
                if( current.equals( chr ) ) {
                    current.setPriority( current.getPriority() + 1 );
                    found = true;
                }
            }
            if( !found ) {
                PriorityPair< Character > nw = new PriorityPair< Character >( 1, chr );
                analysis.add( nw );
            }
        }
        
        
         
    }
    static public void main( String args ) {
        throw new UnsupportedOperationException();
    }
    
    public String encode( String text ) {
        throw new UnsupportedOperationException();
    }
    
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
