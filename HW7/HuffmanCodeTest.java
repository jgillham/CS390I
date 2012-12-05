import java.util.PriorityQueue;
import java.util.Iterator;
import java.util.Map;
import java.util.HashMap;

import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.lang.reflect.Method;

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
        
        input = "HAPPY-PAPPY";
        expected = new HashMap< Character, Integer >();
        expected.put( Character.valueOf( 'H' ), Integer.valueOf( 1 ) );
        expected.put( Character.valueOf( 'A' ), Integer.valueOf( 2 ) );
        expected.put( Character.valueOf( 'P' ), Integer.valueOf( 5 ) );
        expected.put( Character.valueOf( 'Y' ), Integer.valueOf( 2 ) );
        expected.put( Character.valueOf( '-' ), Integer.valueOf( 1 ) );
        
        actual = HuffmanCode.analyse( input );
        assertEquals( expected.size(), actual.size() );
        for ( Character key : expected.keySet() ) {
            assertEquals( expected.get( key ), actual.get( key ) );
        }
        
        input = "roadrunner";
        expected = new HashMap< Character, Integer >();
        expected.put( Character.valueOf( 'r' ), Integer.valueOf( 3 ) );
        expected.put( Character.valueOf( 'o' ), Integer.valueOf( 1 ) );
        expected.put( Character.valueOf( 'a' ), Integer.valueOf( 1 ) );
        expected.put( Character.valueOf( 'd' ), Integer.valueOf( 1 ) );
        expected.put( Character.valueOf( 'u' ), Integer.valueOf( 1 ) );
        expected.put( Character.valueOf( 'n' ), Integer.valueOf( 2 ) );
        expected.put( Character.valueOf( 'e' ), Integer.valueOf( 1 ) );
        
        actual = HuffmanCode.analyse( input );
        assertEquals( expected.size(), actual.size() );
        for ( Character key : expected.keySet() ) {
            assertEquals( expected.get( key ), actual.get( key ) );
        }
    }
    
    /**
     * Prove that we can build a tree correctly
     */
    @Test
    public void testBuildTree() {
        // Easy
        PriorityQueue< HNode > analysis = new PriorityQueue< HNode >();
        analysis.add( new HNode( 'c', 1 ) );
        analysis.add( new HNode( 'a', 2 ) );
        analysis.add( new HNode( 't', 4 ) );
        
        HNode expected = new HNode( ' ', 7, "",
            new HNode( 't', 4 ),
            new HNode( ' ', 3, "", 
                new HNode( 'a', 2 ),
                new HNode( 'c', 1 )
            )
        );
        HNode actual = HuffmanCode.buildTree( analysis );
        assertEquals( expected, actual );
        
        // Reversed order.
        analysis = new PriorityQueue< HNode >();
        analysis.add( new HNode( 'c', 4 ) );
        analysis.add( new HNode( 'a', 2 ) );
        analysis.add( new HNode( 't', 1 ) );
        
        expected = new HNode( ' ', 7, "", 
            new HNode( 'c', 4 ),
            new HNode( ' ', 3, "", 
                new HNode( 'a', 2 ),
                new HNode( 't', 1 )
            )
        );
        actual = HuffmanCode.buildTree( analysis );
        assertEquals( expected, actual );
        
        // From his example.
        analysis = new PriorityQueue< HNode >();
        analysis.add( new HNode( 'H', 1 ) );
        analysis.add( new HNode( 'P', 16 ) );
        analysis.add( new HNode( 'A', 8 ) );
        analysis.add( new HNode( '-', 2 ) );
        analysis.add( new HNode( 'Y', 4 ) );

        expected = new HNode( ' ', 11, "",
            new HNode( 'P', 16 ),
            new HNode( ' ', 15, "",
                new HNode( 'A', 8 ),
                new HNode( ' ', 7, "",
                    new HNode( 'Y', 4 ),
                    new HNode( ' ', 3, "", 
                        new HNode( '-', 2 ), 
                        new HNode( 'H', 1 )
                    )
                )
            )
        );
        
        actual = HuffmanCode.buildTree( analysis );
        assertEquals( expected, actual );
    }
    
    /**
     * Prove that we can get the map codes from the tree.
     */
    @Test
    public void testAddMapCodes() {
        HNode input = new HNode( ' ', 3, "",
            new HNode( ' ', 2, "", 
                new HNode( 'c', 1, "00" ), 
                new HNode( 'a', 1, "01" )
            ),
            new HNode( 't', 1, "1" )
        );
        Map< Character, String > expected =
            new HashMap< Character, String >();
        expected.put( Character.valueOf( 'c' ), "00" );
        expected.put( Character.valueOf( 'a' ), "01" );
        expected.put( Character.valueOf( 't' ), "1" );
        
        Map<Character, String> actual = new HashMap<Character, String>();
        HuffmanCode.addMapCodes( input, actual );
        assertEquals( expected.size(), actual.size() );
        assertEquals( expected, actual );
    }
    
    /**
     * Prove setCodes will set each HNode to the correct binary code.
     */
    @Test
    public void testSetCodes() {
        HNode actual = new HNode( ' ', 3, "",
            new HNode( ' ', 2, "", 
                new HNode( 'c', 1 ), 
                new HNode( 'a', 1 )
            ),
            new HNode( 't', 1 )
        );
        HNode expected = new HNode( ' ', 3, "",
            new HNode( ' ', 2, "", 
                new HNode( 'c', 1, "00" ), 
                new HNode( 'a', 1, "01" )
            ),
            new HNode( 't', 1, "1" )
        );
        HuffmanCode.setCodes( actual, "" );
        assertEquals( expected.getLeftChild().getLeftChild().getCode(), 
                      actual.getLeftChild().getLeftChild().getCode()
        );
        assertEquals( expected.getLeftChild().getRightChild().getCode(), 
                      actual.getLeftChild().getRightChild().getCode()
        );
        assertEquals( expected.getRightChild().getCode(), 
                      actual.getRightChild().getCode()
        );
    }
    
    /**
     * Prove convert will turn a map into a priority queue.
     */
    @Test
    public void testConvert() {
        PriorityQueue< HNode > expected = new PriorityQueue< HNode >();
        expected.add( new HNode( 'c', 1 ) );
        expected.add( new HNode( 'a', 2 ) );
        expected.add( new HNode( 't', 3 ) );
        
        Map< Character, Integer > input =
            new HashMap< Character, Integer >();
        input.put( Character.valueOf( 'c' ), 1 );
        input.put( Character.valueOf( 'a' ), 2 );
        input.put( Character.valueOf( 't' ), 3 );
        
        PriorityQueue<HNode> actual = HuffmanCode.convert( input );
        
        assertEquals( expected.size(), actual.size() );
        while ( !expected.isEmpty() ) {
            HNode exp = expected.poll();
            HNode act = actual.poll();
            assertEquals( exp, act );
        }
    }
    
    /**
     * The same as testConvert.
     */
    @Test
    public void createPriorityQueue( ) {
        testConvert();
    }
    
    /**
     * Prove that find can locate the node with the binary code.
     */
    @Test
    public void testFind() {
        HNode expected = new HNode( 'a', 2, "01" );
        HNode input = new HNode( ' ', 3, "",
            new HNode( ' ', 2, "", 
                new HNode( 'c', 1, "00" ), 
                expected
            ),
            new HNode( 't', 3, "1" )
        );
        HNode actual = HuffmanCode.find( input, expected.getCode() );
        assertTrue( expected == actual );
        
        expected = new HNode( 'a', 2, "1" );
        input = new HNode( ' ', 3, "",
            new HNode( 'c', 1, "0" ), 
            expected
        );
        actual = HuffmanCode.find( input, expected.getCode() );
        assertTrue( expected == actual );
        
        expected = new HNode( 'a', 2, "0" );
        input = new HNode( ' ', 3, "",
            expected,
            new HNode( 'c', 1, "1" )
            
        );
        actual = HuffmanCode.find( input, expected.getCode() );
        assertTrue( expected == actual );
    }
    
    /**
     * Proves that encode replaces letters with Huffman binary codes correctly.
     */
    @Test
    public void testEncodeAndDecode() {
        String expected = "roadrunner";
        HuffmanCode instance = new HuffmanCode( expected );
        String actual = instance.decode( instance.encode( expected ) );
        assertEquals( expected, actual );
    }
    
    /**
     * Proves that encode replaces letters with Huffman binary codes correctly.
     */
    @Test
    public void testEncode() {
        String input = "caa";
        HuffmanCode instance = new HuffmanCode( input );
        String actual = instance.encode( input );
        String expected = "100";
        assertEquals( expected, actual );
        
        input = "caattt";
        instance = new HuffmanCode( input );
        actual = instance.encode( input );
        expected = "111010000";
        assertEquals( expected, actual );
    }
    
    /**
     * Proves that decode replaces the binary codes with letters correctly.
     */
    @Test
    public void testDecode() {
        String input = "100";
        String expected = "caa";
        HuffmanCode instance = new HuffmanCode( expected );
        String actual = instance.decode( input );
        assertEquals( expected, actual );
        
        input = "111010000";
        expected = "caattt";
        instance = new HuffmanCode( expected );
        actual = instance.decode( input );
        assertEquals( expected, actual );
    }
    // END Good Behavor Tests
}
