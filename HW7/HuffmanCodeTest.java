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
 * Tests HuffmanCode.
 *
 * @author  Josh Gillham
 * @version 11-28-12
 */
public class HuffmanCodeTest {
    /**
     * Provides an equals() with more scrutany. Used as a testing instrument.
     */
    class MockHNode extends HNode {
        /** Used as diagnostic tool to trace the problem. */
        class UnequalObjects extends Exception {
            /**
             * Creates a new object.
             * 
             * @param m is the message.
             */
            public UnequalObjects( String m ) {
                super( m );
            }
        }
        
        /**
         * Creates a copy of an HNode.
         * 
         * @param other is the HNode to copy.
         */
        public MockHNode( HNode other ) {
            super( other.getSymbol(), other.getFrequency(), other.getCode(),
                other.getLeftChild(), other.getRightChild() );
        }
        
        /**
         * Constructor for a parent.
         * 
         * @param left is the left child.
         * @param right is the right child.
         */
        public MockHNode( HNode left, HNode right ) {
            super( 
                null, left.getFrequency() + right.getFrequency(),
                null, left, right
            );
        }
        
        /**
         * Constructor for a leaf.
         * 
         * @param s is the symbol.
         * @param frq is the frequency.
         */
        public MockHNode(Character s, double frq ) {
            super( s, frq, null, null, null );
        }
        
        /**
         * Constructor for a leaf.
         * 
         * @param s is the symbol.
         * @param frq is the frequency.
         * @param code is the binary code.
         */
        public MockHNode(Character s, double frq, String code ) {
            super( s, frq, code, null, null );
        }
        
        /**
         * Calls the recursive method.
         * 
         * @param o is the other object to compare.
         * 
         * @return true if the objects are equal or false otherwise.
         */
        @Override
        public boolean equals( Object o ) {
            return equals( this, o );
        }
        
        /**
         * Provides a diagnostic tool for comparing trees. Print statements
         *  help debugging complex tree structures.
         * 
         * @param first the first object.
         * @param o the other object.
         * 
         * @return true if the objects and children have the same data.
         */
        public boolean equals( HNode first, Object o ) {
            try {
                // Nulls or the same objects are always equal.
                if ( first == o )
                    return true;
                // For the case when only one is null.
                if ( o == null || first == null )
                    throw new UnequalObjects( "Rejecting: one is null." );
                // Must be HNode or extend HNode.
                if ( !(o instanceof HNode) )
                    throw new UnequalObjects( "Rejecting: not an HNode." );
                
                HNode other = (HNode)o;
                // Check the data.
                if ( first.getFrequency() != other.getFrequency() ||
                        !equals( first.getSymbol(), other.getSymbol() ) ||
                        !equals( first.getCode(), other.getCode() ) )
                    throw new UnequalObjects(
                        "Rejecting: data not equal."
                    );
                // Check recursively on the left child.
                if ( !equals( first.getLeftChild(), other.getLeftChild() ) )
                    throw new UnequalObjects( 
                        "Rejecting: left child not equal."
                    );
                // Check recursively on the right child.
                if ( !equals( first.getRightChild(), other.getRightChild() ) )
                    throw new UnequalObjects( 
                        "Rejecting: right child not equal."
                    );
            }
            catch ( UnequalObjects ex ) {
                System.out.println( ex.getMessage() );
                System.out.println( "Inspecting first: " + first );
                System.out.println( "Inspecting o: " + o );
                ex.printStackTrace();
                return false;
            }
            // All tests passed.
            return true;
        }
        /**
         * Provides a fool proof way to compare objects an avoid
         *  nulls.
         * 
         * @param a an object.
         * @param b another object.
         * 
         * @return true if they are equal or false otherwise.
         */
        public boolean equals( Object a, Object b ) {
            // Nulls or the same objects are always equal.
            if ( a == b )
                return true;
            // For the case when only one is null.
            if ( a == null || b == null )
                return false;
            
            return a.equals( b );
        }
    }
    
    // BEGIN Good Behavor Tests
    /**
     * Proves that analyse() gives a list of nodes with the correct letters
     *  and frequencies.
     */
    @Test
    public void testAnalyse() {
        // Test with one letter.
        String input = "a";
        Map< Character, Integer > expected =
            new HashMap< Character, Integer >();
        expected.put( Character.valueOf( 'a' ), Integer.valueOf( 1 ) );
        
        Map< Character, Integer > actual = HuffmanCode.analyse( input );
        assertEquals( expected.size(), actual.size() );
        assertEquals( expected, actual );
        
        // Test with only two letters.
        input = "aa";
        expected = new HashMap< Character, Integer >();
        expected.put( Character.valueOf( 'a' ), Integer.valueOf( 2 ) );
        
        actual = HuffmanCode.analyse( input );
        assertEquals( expected.size(), actual.size() );
        assertEquals( expected, actual );
        
        // Test with only two letters.
        input = "aaz";
        expected = new HashMap< Character, Integer >();
        expected.put( Character.valueOf( 'a' ), Integer.valueOf( 2 ) );
        expected.put( Character.valueOf( 'z' ), Integer.valueOf( 1 ) );
        
        actual = HuffmanCode.analyse( input );
        assertEquals( expected.size(), actual.size() );
        assertEquals( expected, actual );
        
        // Here is an easy analysis.
        input = "abcdead";
        expected = new HashMap< Character, Integer >();
        expected.put( Character.valueOf( 'a' ), Integer.valueOf( 2 ) );
        expected.put( Character.valueOf( 'b' ), Integer.valueOf( 1 ) );
        expected.put( Character.valueOf( 'c' ), Integer.valueOf( 1 ) );
        expected.put( Character.valueOf( 'd' ), Integer.valueOf( 2 ) );
        expected.put( Character.valueOf( 'e' ), Integer.valueOf( 1 ) );
        
        actual = HuffmanCode.analyse( input );
        assertEquals( expected.size(), actual.size() );
        assertEquals( expected, actual );
        
        // Here is a harder one.
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
        // Here is one from his presentation.
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
        // Here is another one from his presentation.
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
        // One letter.
        PriorityQueue< HNode > analysis = new PriorityQueue< HNode >();
        analysis.add( new MockHNode( 'c', 1 ) );
        
        MockHNode expected = new MockHNode( 'c', 1 );
        
        MockHNode actual = new MockHNode( HuffmanCode.buildTree( analysis ) );
        assertTrue( expected.equals( actual ) );
        
        // Two letters.
        analysis = new PriorityQueue< HNode >();
        analysis.add( new MockHNode( 'c', 1 ) );
        analysis.add( new MockHNode( 'a', 2 ) );
        
        expected = new MockHNode(
            new MockHNode( 'a', 2 ),
            new MockHNode( 'c', 1 )
        );
        
        actual = new MockHNode( HuffmanCode.buildTree( analysis ) );
        assertTrue( expected.equals( actual ) );
        
        // Easy
        analysis = new PriorityQueue< HNode >();
        analysis.add( new MockHNode( 'c', 1 ) );
        analysis.add( new MockHNode( 'a', 2 ) );
        analysis.add( new MockHNode( 't', 4 ) );
        
        expected = new MockHNode(
            new MockHNode( 't', 4 ),
            new MockHNode(
                new MockHNode( 'a', 2 ),
                new MockHNode( 'c', 1 )
            )
        );
        actual = new MockHNode( HuffmanCode.buildTree( analysis ) );
        assertTrue( expected.equals( actual ) );
        
        // Reversed order.
        analysis = new PriorityQueue< HNode >();
        analysis.add( new MockHNode( 'c', 4 ) );
        analysis.add( new MockHNode( 'a', 2 ) );
        analysis.add( new MockHNode( 't', 1 ) );
        
        expected = new MockHNode(
            new MockHNode( 'c', 4 ),
            new MockHNode(
                new MockHNode( 'a', 2 ),
                new MockHNode( 't', 1 )
            )
        );
        actual = new MockHNode( HuffmanCode.buildTree( analysis ) );
        assertTrue( expected.equals( actual ) );
        
        // From his example.
        analysis = new PriorityQueue< HNode >();
        analysis.add( new MockHNode( 'H', 1 ) );
        analysis.add( new MockHNode( 'P', 16 ) );
        analysis.add( new MockHNode( 'A', 8 ) );
        analysis.add( new MockHNode( '-', 2 ) );
        analysis.add( new MockHNode( 'Y', 4 ) );

        expected = new MockHNode(
            new MockHNode( 'P', 16 ),
            new MockHNode(
                new MockHNode( 'A', 8 ),
                new MockHNode(
                    new MockHNode( 'Y', 4 ),
                    new MockHNode(
                        new MockHNode( '-', 2 ), 
                        new MockHNode( 'H', 1 )
                    )
                )
            )
        );
        
        actual = new MockHNode( HuffmanCode.buildTree( analysis ) );
        assertTrue( expected.equals( actual ) );
    }
    
    /**
     * Prove that we can get the map codes from the tree.
     */
    @Test
    public void testAddMapCodes() {
        // Here is a single node.
        MockHNode input = new MockHNode( 't', 1 );
        Map< Character, String > expected =
            new HashMap< Character, String >();
        expected.put( Character.valueOf( 't' ), null );
        
        Map<Character, String> actual = new HashMap<Character, String>();
        HuffmanCode.addMapCodes( input, actual );
        assertEquals( expected.size(), actual.size() );
        assertTrue( expected.equals( actual ) );
        
        // Here is a two-level tree;
        input = new MockHNode(
            new MockHNode( 't', 1, "0" ),
            new MockHNode( 'c', 1, "1" )
        );
        expected = new HashMap< Character, String >();
        expected.put( Character.valueOf( 't' ), "0" );
        expected.put( Character.valueOf( 'c' ), "1" );
        
        actual = new HashMap<Character, String>();
        HuffmanCode.addMapCodes( input, actual );
        assertEquals( expected.size(), actual.size() );
        assertTrue( expected.equals( actual ) );
        
        // Here is a three-level tree to test.
        input = new MockHNode(
            new MockHNode( 
                new MockHNode( 'c', 1, "00" ), 
                new MockHNode( 'a', 1, "01" )
            ),
            new MockHNode( 't', 1, "1" )
        );
        expected = new HashMap< Character, String >();
        expected.put( Character.valueOf( 'c' ), "00" );
        expected.put( Character.valueOf( 'a' ), "01" );
        expected.put( Character.valueOf( 't' ), "1" );
        
        actual = new HashMap<Character, String>();
        HuffmanCode.addMapCodes( input, actual );
        assertEquals( expected.size(), actual.size() );
        assertTrue( expected.equals( actual ) );
    }
    
    /**
     * Prove setCodes will set each HNode to the correct binary code.
     */
    @Test
    public void testSetCodes() {
        // Test a single node.
        MockHNode actual = new MockHNode( 't', 1 );
        MockHNode expected = new MockHNode( 't', 1, "" );
        HuffmanCode.setCodes( actual, "" );
        assertTrue( expected.equals( actual ) );
        
        // Test two-level tree.
        actual = new MockHNode(
            new MockHNode( 'c', 1 ), 
            new MockHNode( 'a', 1 )
        );
        expected = new MockHNode(
            new MockHNode( 'c', 1, "0" ), 
            new MockHNode( 'a', 1, "1" )
        );
        HuffmanCode.setCodes( actual, "" );
        assertTrue( expected.equals( actual ) );
        
        // Test three-level tree.
        actual = new MockHNode(
            new MockHNode(
                new MockHNode( 'c', 1 ), 
                new MockHNode( 'a', 1 )
            ),
            new MockHNode( 't', 1 )
        );
        expected = new MockHNode(
            new MockHNode(
                new MockHNode( 'c', 1, "00" ), 
                new MockHNode( 'a', 1, "01" )
            ),
            new MockHNode( 't', 1, "1" )
        );
        HuffmanCode.setCodes( actual, "" );
        assertTrue( expected.equals( actual ) );
    }
    
    /**
     * Prove convert will turn a map into a priority queue.
     */
    @Test
    public void testConvert() {
        PriorityQueue< HNode > expected = new PriorityQueue< HNode >();
        expected.add( new MockHNode( 'c', 1 ) );
        expected.add( new MockHNode( 'a', 2 ) );
        expected.add( new MockHNode( 't', 3 ) );
        
        Map< Character, Integer > input =
            new HashMap< Character, Integer >();
        input.put( Character.valueOf( 'c' ), 1 );
        input.put( Character.valueOf( 'a' ), 2 );
        input.put( Character.valueOf( 't' ), 3 );
        
        PriorityQueue<HNode> actual = HuffmanCode.convert( input );
        
        assertEquals( expected.size(), actual.size() );
        while ( !expected.isEmpty() ) {
            MockHNode exp = new MockHNode( expected.poll() );
            MockHNode act = new MockHNode( actual.poll() );
            assertEquals( exp, act );
        }
    }
    
    /**
     * Prove that find can locate the node with the binary code.
     */
    @Test
    public void testFind() {
        // Test with three level tree.
        MockHNode expected = new MockHNode( 'a', 2, "0" );
        MockHNode input = expected;
        MockHNode actual = 
            (MockHNode)HuffmanCode.find( input, expected.getCode() );
        // Compare references.
        assertTrue( expected == actual );
        
        // Test with three level tree.
        expected = new MockHNode( 'a', 2, "01" );
        input = new MockHNode(
            new MockHNode(
                new MockHNode( 'c', 1, "00" ), 
                expected
            ),
            new MockHNode( 't', 3, "1" )
        );
        actual = 
            (MockHNode)HuffmanCode.find( input, expected.getCode() );
        // Compare references.
        assertTrue( expected == actual );
        
        // Test with two-level tree.
        expected = new MockHNode( 'a', 2, "1" );
        input = new MockHNode(
            new MockHNode( 'c', 1, "0" ), 
            expected
        );
        actual = (MockHNode)HuffmanCode.find( input, expected.getCode() );
        // Compare references.
        assertTrue( expected == actual );
        
        // Test with a two-level tree and the target is in the right.
        expected = new MockHNode( 'a', 2, "0" );
        input = new MockHNode(
            expected,
            new MockHNode( 'c', 1, "1" )
            
        );
        actual = (MockHNode)HuffmanCode.find( input, expected.getCode() );
        // Compare references.
        assertTrue( expected == actual );
    }
    
    /**
     * Proves that encode replaces letters with Huffman binary codes correctly.
     */
    @Test
    public void testEncodeAndDecode() {
        // Basic example.
        String expected = "a";
        HuffmanCode instance = new HuffmanCode( expected );
        String actual = instance.decode( instance.encode( expected ) );
        assertEquals( expected, actual );
        // More complicated.
        expected = "aacc";
        instance = new HuffmanCode( expected );
        actual = instance.decode( instance.encode( expected ) );
        assertEquals( expected, actual );
        // Even more complicated
        expected = "aaccddeeefff";
        instance = new HuffmanCode( expected );
        actual = instance.decode( instance.encode( expected ) );
        assertEquals( expected, actual );
        // His example in the presentation.
        expected = "roadrunner";
        instance = new HuffmanCode( expected );
        actual = instance.decode( instance.encode( expected ) );
        assertEquals( expected, actual );
        // His example in the presentation.
        expected = "HAPPY-PAPPY!";
        instance = new HuffmanCode( expected );
        actual = instance.decode( instance.encode( expected ) );
        assertEquals( expected, actual );
    }
    
    /**
     * Proves that encode replaces letters with Huffman binary codes correctly.
     */
    @Test
    public void testEncode() {
        String input = "a";
        HuffmanCode instance = new HuffmanCode( input );
        String actual = instance.encode( input );
        String expected = "0";
        assertEquals( expected, actual );
        
        input = "caa";
        instance = new HuffmanCode( input );
        actual = instance.encode( input );
        expected = "100";
        assertEquals( expected, actual );
        
        input = "caatttt";
        instance = new HuffmanCode( input );
        actual = instance.encode( input );
        expected = "1110100000";
        assertEquals( expected, actual );
    }
    
    /**
     * Proves that decode replaces the binary codes with letters correctly.
     */
    @Test
    public void testDecode() {
        String input = "0";
        String expected = "a";
        HuffmanCode instance = new HuffmanCode( expected );
        String actual = instance.decode( input );
        assertEquals( expected, actual );
        
        input = "100";
        expected = "caa";
        instance = new HuffmanCode( expected );
        actual = instance.decode( input );
        assertEquals( expected, actual );
        
        input = "1110100000";
        expected = "caatttt";
        instance = new HuffmanCode( expected );
        actual = instance.decode( input );
        assertEquals( expected, actual );
    }
    // END Good Behavor Tests
}
