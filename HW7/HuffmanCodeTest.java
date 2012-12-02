import java.util.PriorityQueue;
import java.util.Iterator;
import java.util.Map;
import java.util.HashMap;

import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 *
 * @author  Josh Gillham
 * @version 11-28-12
 */
public class HuffmanCodeTest {
    // BEGIN Good Behavor Tests
    /**
     * Proves that analyse() gives a list of nodes with the correct letters
     *  and frequencies.
     */
    @Test
    public void testAnalyse() {
        String input = "abcdead";
        Map< Character, Integer > expected =
            new HashMap< Character, Integer >();
        expected.put( Character.valueOf( 'a' ), Integer.valueOf( 2 ) );
        expected.put( Character.valueOf( 'b' ), Integer.valueOf( 1 ) );
        expected.put( Character.valueOf( 'c' ), Integer.valueOf( 1 ) );
        expected.put( Character.valueOf( 'd' ), Integer.valueOf( 2 ) );
        expected.put( Character.valueOf( 'e' ), Integer.valueOf( 1 ) );
        
        Map< Character, Integer > actual = HuffmanCode.analyse( input );
        assertEquals( expected.size(), actual.size() );
        assertEquals( expected, actual );
        
        input = "cat fat head hat";
        expected = new HashMap< Character, Integer >();
        expected.put( Character.valueOf( 'c' ), Integer.valueOf( 1 ) );
        expected.put( Character.valueOf( 'a' ), Integer.valueOf( 4 ) );
        expected.put( Character.valueOf( 't' ), Integer.valueOf( 3 ) );
        expected.put( Character.valueOf( ' ' ), Integer.valueOf( 3 ) );
        expected.put( Character.valueOf( 'f' ), Integer.valueOf( 1 ) );
        expected.put( Character.valueOf( 'h' ), Integer.valueOf( 2 ) );
        expected.put( Character.valueOf( 'e' ), Integer.valueOf( 1 ) );
        expected.put( Character.valueOf( 'd' ), Integer.valueOf( 1 ) );
        
        actual = HuffmanCode.analyse( input );
        assertEquals( expected.size(), actual.size() );
        assertEquals( expected, actual );
        
        input = "HAPPY–PAPPY";
        expected = new HashMap< Character, Integer >();
        expected.put( Character.valueOf( 'c' ), Integer.valueOf( 1 ) );
        expected.put( Character.valueOf( 'a' ), Integer.valueOf( 4 ) );
        expected.put( Character.valueOf( 't' ), Integer.valueOf( 3 ) );
        expected.put( Character.valueOf( ' ' ), Integer.valueOf( 3 ) );
        expected.put( Character.valueOf( 'f' ), Integer.valueOf( 1 ) );
        expected.put( Character.valueOf( 'h' ), Integer.valueOf( 2 ) );
        expected.put( Character.valueOf( 'e' ), Integer.valueOf( 1 ) );
        expected.put( Character.valueOf( 'd' ), Integer.valueOf( 1 ) );
        
        actual = HuffmanCode.analyse( input );
        assertEquals( expected.size(), actual.size() );
        assertEquals( expected, actual );
    }
    
    @Test
    public void testGenerateHTree() {
        // Easy
        HashMap< Character, Integer > analysis = new HashMap< Character, Integer >();
        analysis.put( Character.valueOf( 'c' ), Integer.valueOf( 1 ) );
        analysis.put( Character.valueOf( 'a' ), Integer.valueOf( 1 ) );
        analysis.put( Character.valueOf( 't' ), Integer.valueOf( 1 ) );
        
        HNode expected = new HNode( 3, 
            new HNode( 2, 
                new HCode( 1, 'c' ), 
                new HCode( 1, 'a' )
            ), 
            new HCode( 1, 't' )
        );
        HNode actual = HuffmanCode.generateHTree( analysis );
        assertEquals( expected, actual );
        
        // Reversed order.
        analysis = new HashMap< Character, Integer >();
        analysis.put( Character.valueOf( 'c' ), Integer.valueOf( 3 ) );
        analysis.put( Character.valueOf( 'a' ), Integer.valueOf( 2 ) );
        analysis.put( Character.valueOf( 't' ), Integer.valueOf( 1 ) );
        
        expected = new HNode( 6, 
            new HNode( 3, 
                new HCode( 1, 't' ), 
                new HCode( 2, 'a' )
            ), 
            new HCode( 3, 'c' )
        );
        actual = HuffmanCode.generateHTree( analysis );
        assertEquals( expected, actual );
        
        // From his example.
        analysis = new HashMap< Character, Integer >();
        analysis.put( Character.valueOf( 'H' ), Integer.valueOf( 1 ) );
        analysis.put( Character.valueOf( 'P' ), Integer.valueOf( 5 ) );
        analysis.put( Character.valueOf( 'A' ), Integer.valueOf( 2 ) );
        analysis.put( Character.valueOf( '-' ), Integer.valueOf( 1 ) );
        analysis.put( Character.valueOf( 'Y' ), Integer.valueOf( 2 ) );

        expected = new HNode( 11,
            new HNode( 6,
                new HNode( 2, 
                    new HCode( 1, 'H' ), 
                    new HCode( 1, '-' )
                ),
                new HNode( 4, 
                    new HCode( 2, 'A' ), 
                    new HCode( 2, 'Y' )
                ) 
            ),
            new HCode( 5, 'P' )
        );
        
        actual = HuffmanCode.generateHTree( analysis );
        assertEquals( expected, actual );
    }
    
    /**
     * Proves that encode replaces letters with Huffman binary codes correctly.
     */
    @Test
    public void testEncode() {
        String input = "roadrunner";
        HuffmanCode instance = new HuffmanCode( input );
        String actual = instance.encode( input );
        String expected = "111000011011111010010100011";
        assertEquals( expected, actual );
    }
    
    /**
     * Proves that decode replaces the binary codes with letters correctly.
     */
    @Test
    public void testDecode() {
        String input = "111000011011111010010100011";
        String expected = "roadrunner";
        HuffmanCode instance = new HuffmanCode( expected );
        String actual = instance.decode( input );
        assertEquals( expected, actual );
    }
    // END Good Behavor Tests
}
