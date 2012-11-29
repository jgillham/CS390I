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
    }
    // END Good Behavor Tests
}
