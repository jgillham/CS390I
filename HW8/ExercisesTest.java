

import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import java.util.List;
import java.util.LinkedList;

/**
 * Provides tests for Exercises.
 *
 * @author  Josh Gillham
 * @version 11-28-12
 */
public class ExercisesTest {
    // BEGIN Good Behavior Tests
    /**
     * Proves that sum() can handle most cases.
     */
    @Test
    public void testSum() {
        List< Integer > series = new LinkedList< Integer >();
        int sum = 0;
        for( int i = -50; i <= 50; ++i ) {
            sum += i;
            series.add( Integer.valueOf( i ) );
            assertEquals( Integer.valueOf( sum ), Exercises.sum( series ) );
        }
        // Should be associative.
        sum = 0;
        series = new LinkedList< Integer >();
        for( int i = 50; i >= -50; --i ) {
            sum += i;
            series.add( Integer.valueOf( i ) );
            assertEquals( Integer.valueOf( sum ), Exercises.sum( series ) );
        }
    }
    
    /**
     * Proves that product() can handle most cases.
     */
    @Test
    public void testProduct() {
        List< Integer > series = new LinkedList< Integer >();
        int product = 1;
        for( int i = -50; i < 50; ++i ) {
            if ( i != 0 ) {
                product *= i;
                series.add( Integer.valueOf( i ) );
                assertEquals( Integer.valueOf( product ), Exercises.product( series ) );
            }
        }
        // Should be communitive.
        product = 1;
        series = new LinkedList< Integer >();
        for( int i = 50; i >= -50; --i ) {
            if ( i != 0 ) {
                product *= i;
                series.add( Integer.valueOf( i ) );
                assertEquals( Integer.valueOf( product ), Exercises.product( series ) );
            }
        }
        
        series.add( Integer.valueOf( 0 ) );
        assertEquals( Integer.valueOf( 0 ), Exercises.sum( series ) );
    }
    
    /**
     * Proves that strCount() can handle those tricky cases.
     */
    @Test
    public void testStrCount() {
        assertEquals(0, (int)Exercises.strCount("a", "c"));
        assertEquals(0, (int)Exercises.strCount("a", "ca"));
        assertEquals(1, (int)Exercises.strCount("acatyr", "cat"));
        assertEquals(2, (int)Exercises.strCount("acatycatr", "cat"));
        assertEquals(0, (int)Exercises.strCount("acatycatr", "woodcutters"));
        
    }
    
    /**
     * Proves that strCount() can handle those tricky cases.
     */
    @Test
    public void testStrCount_Tricky() {
        assertEquals(1, (int)Exercises.strCount("a", "a"));
        assertEquals(2, (int)Exercises.strCount("aa", "a"));
        assertEquals(1, (int)Exercises.strCount("aa", "aa"));
        assertEquals(1, (int)Exercises.strCount("aaa", "aa"));
        assertEquals(2, (int)Exercises.strCount("aaaa", "aa"));
        assertEquals(2, (int)Exercises.strCount("aaaaa", "aa"));
        assertEquals(3, (int)Exercises.strCount("aaaaaa", "aa"));
        assertEquals(3, (int)Exercises.strCount("aaaaaaa", "aa"));
    }
    
    /**
     * Check of every existing sum to ensure the return is true.
     */
    @Test
    public void testGroupExists_TrueReturn() {
        List< Integer > numbers = new LinkedList< Integer >();
        assertTrue( Exercises.groupExists( numbers, 0 ) );
        numbers.add( 1 );
        numbers.add( 3 );
        numbers.add( 5 );
        numbers.add( 12 );
        assertTrue( Exercises.groupExists( numbers, 0 ) );
            // Find the number of combinations.
        int combinationCount = (int)Math.pow( 2D, numbers.size() );
            // Iterate through each combination.
        for ( int i = 0; i < combinationCount; ++i ) {
            int bits = i;
            int index = numbers.size() - 1;
            int num = 0;
                // Start at the highest possible bit and count down.
            for ( int c = combinationCount / 2; c > 0; c /= 2) {
                    // Check for the bit.
                if ( bits / c == 1 ) {
                        // Add selected number.
                    num += numbers.get( index );
                }
                    // Discard bit.
                bits%=c;
                --index;
            }
            System.out.println( "numbers: " + numbers );
            System.out.println( "num: " + num );
            
                // "num" should be a combination of "numbers."
            assertTrue( Exercises.groupExists( numbers, num ) );
        }
    }
    
    /**
     * Check of every existing sum to ensure the return is true.
     */
    @Test
    public void testGroupExists_FalseReturn() {
        List< Integer > numbers = new LinkedList< Integer >();
        assertFalse( Exercises.groupExists( numbers, 1 ) );
        assertFalse( Exercises.groupExists( numbers, 2 ) );
        assertFalse( Exercises.groupExists( numbers, 3 ) );
        numbers.add( 1 );
        numbers.add( 3 );
        numbers.add( 5 );
        numbers.add( 12 );
        assertFalse( Exercises.groupExists( numbers, 2 ) );
        assertFalse( Exercises.groupExists( numbers, 7 ) );
        assertFalse( Exercises.groupExists( numbers, 10 ) );
        assertFalse( Exercises.groupExists( numbers, 11 ) );
        assertFalse( Exercises.groupExists( numbers, 14 ) );
        assertFalse( Exercises.groupExists( numbers, 19 ) );
        assertFalse( Exercises.groupExists( numbers, 22 ) );
    }
    // END Good Behavior Tests
    // BEGIN Destructive Tests
    /**
     * Prove that sum() throws an exception for null paramters.
     */
    @Test( expected = NullPointerException.class )
    public void testSum_Null() {
        Exercises.sum( null );
    }
    
    /**
     * Prove that sum() throws an exception for empty lists.
     */
    @Test( expected = IllegalArgumentException.class )
    public void testSum_Empty() {
        Exercises.sum( new LinkedList< Integer >() );
    }
    
    /**
     * Prove that product() throws an exception for null paramters.
     */
    @Test( expected = NullPointerException.class )
    public void testProduct_Null() {
        Exercises.product( null );
    }
    
    /**
     * Prove that product() throws an exception for empty lists.
     */
    @Test( expected = IllegalArgumentException.class )
    public void testProduct_Empty() {
        Exercises.product( new LinkedList< Integer >() );
    }
    
    /**
     * Prove that strCount() throws an exception for null paramters.
     */
    @Test( expected = NullPointerException.class )
    public void testStrCount_Null() {
        Exercises.strCount( null, "test" );
    }
    
    /**
     * Prove that strCount() throws an exception for null paramters.
     */
    @Test( expected = NullPointerException.class )
    public void testStrCount_Null2() {
        Exercises.strCount( "test", null );
    }
    
    /**
     * Prove that strCount() throws an exception for empty lists.
     */
    @Test( expected = IllegalArgumentException.class )
    public void testStrCount_Empty() {
        Exercises.strCount( "test", "" );
    }
    
    /**
     * Prove that strCount() throws an exception for empty lists.
     */
    @Test( expected = IllegalArgumentException.class )
    public void testStrCount_Empty2() {
        Exercises.strCount( "", "test" );
    }
    
    /**
     * Prove that groupExists() throws an exception for null paramters.
     */
    @Test( expected = NullPointerException.class )
    public void testGroupExists_Null() {
        Exercises.groupExists( null, 0 );
    }
    // BEGIN Destructive Tests
}
