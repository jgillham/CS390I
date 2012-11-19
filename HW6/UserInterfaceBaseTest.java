

import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import java.util.Queue;
import java.util.LinkedList;
import java.util.List;
import java.util.Iterator;

/**
 * The test class UserInterfaceTest.
 *
 * @author  Josh Gillham
 * @version 10-29-12
 */
public class UserInterfaceBaseTest {
    // BEGIN Good Behavior Tests
    /**
     * Proves the user can input the choices.
     */
    @Test
    public void testGetChoices() {
        List< String > expected = new LinkedList< String >();
        expected.add( "hp" );
        expected.add( "dell" );
        expected.add( "sony" );
        InstrumentationUI instance = new InstrumentationUI();
        for ( String choice : expected ) {
            instance.answers.add( choice );
        }
        List< Choice > actualChoices = instance.getChoices();
        Iterator< String > expI = expected.iterator();
        for ( Choice actualChoice : actualChoices ) {
            assertTrue( expI.hasNext() );
            assertEquals( expI.next(), actualChoice.getName() );
        }
    }
    
    /**
     * Proves the user can input the characteristics.
     */
    @Test
    public void testGetCharacteristics() {
        List< String > expected = new LinkedList< String >();
        expected.add( "color" );
        expected.add( "price" );
        expected.add( "speed" );
        InstrumentationUI instance = new InstrumentationUI();
        for ( String choice : expected ) {
            instance.answers.add( choice );
        }
        List< Choice > actualChoices = instance.getChoices();
        Iterator< String > expI = expected.iterator();
        for ( Choice actualChoice : actualChoices ) {
            assertTrue( expI.hasNext() );
            assertEquals( expI.next(), actualChoice.getName() );
        }
    }
    
    
    /**
     * Proves the user can rank each characteristic.
     */
    @Test
    public void testGetCharacteristicRankings() {
        int[] expected = {
            10, 40, 30  
        };
        InstrumentationUI instance = new InstrumentationUI();
        for ( int val : expected ) {
            // Check for the default value.
            if ( val == 10 )
                // Skip the default value.
                continue;
            instance.answers.add( Integer.toString( val ) );
        }
        List< Characteristic > chars = new LinkedList< Characteristic >();
        chars.add( new Characteristic( "color" ) );
        chars.add( new Characteristic( "price" ) );
        chars.add( new Characteristic( "speed" ) );
        assertTrue( instance.getCharacteristicRankings( chars, 10 ) );
        int i = 0;
        for ( Characteristic chr : chars ) {
            assertTrue( i < expected.length );
            assertEquals( expected[ i ], chr.getRank() );
            ++i;
        }
    }
    
    /**
     * Prove that getCrossRankings() calculates the results correctly.
     */
    @Test
    public void testGetCrossRankings() {
        {
            List< Characteristic > chars = new LinkedList< Characteristic >();
            Characteristic chr = new Characteristic( "color" );
            chr.setRank( 10 );
            chars.add( chr );
            chr = new Characteristic( "price" );
            chr.setRank( 20 );
            chars.add( chr );
            chr = new Characteristic( "speed" );
            chr.setRank( 30 );
            chars.add( chr );
            chr = new Characteristic( "appearance" );
            chr.setRank( 40 );
            chars.add( chr );
            List< Choice > choices = new LinkedList< Choice >();
            choices.add( new Choice( "hp" ) );
            choices.add( new Choice( "dell" ) );
            double[][] input = { 
                { 5, 15, 20, 7 }
                //{ 1, 5 },
                //{ 2, 6 },
                //{ 3, 7 },
                //{ 4, 8 }
            };
            InstrumentationUI instance = new InstrumentationUI();
            for ( int r = 0; r < input.length; ++r ) {
                for ( int c = 0; c < input[r].length; ++c ) {
                    instance.answers.add( Double.toString( input[r][c] ) );
                }
            }
            double[][] expected = { 
                { 10D / 15D, 10D / 25D, 10D / 30D, 10D / 17D },
                { 5D / 15D, 15D / 25D, 20D / 30D, 7D / 17D }
                //{ 1D/6D, 5D/6D },
                //{ 2D/8D, 6D/8D },
                //{ 3D/10D, 7D/10D },
                //{ 4D/12D, 8D/12D }
            };
            double[][] actual = instance.getCrossRankings( choices, chars, 10 );
            assertEquals( expected.length, actual.length );
            assertEquals( expected[0].length, actual[0].length );
            for ( int r = 0; r < expected.length; ++r ) {
                for ( int c = 0; c < expected[r].length; ++c ) {
                    assertEquals( expected[r][c], actual[r][c], 0.1 );
                }
            }
        }
        {
            List< Characteristic > chars = new LinkedList< Characteristic >();
            Characteristic chr = new Characteristic( "playfulness" );
            chr.setRank( 10 );
            chars.add( chr );
            chr = new Characteristic( "appearance" );
            chr.setRank( 20 );
            chars.add( chr );
            List< Choice > choices = new LinkedList< Choice >();
            choices.add( new Choice( "dog" ) );
            choices.add( new Choice( "cat" ) );
            choices.add( new Choice( "bird" ) );
            double[][] input = { 
                { 7, 15, },
                { 5, 30 }
            };
            InstrumentationUI instance = new InstrumentationUI();
            for ( int c = 0; c < input[0].length; ++c ) {
                for ( int r = 0; r < input.length; ++r ) {
                    instance.answers.add( Double.toString( input[r][c] ) );
                }
            }
            double[][] expected = { 
                { 0.45D, 0.13D },
                { 0.32D, 0.27D },
                { 0.23D, 0.55D }
            };
            double[][] actual = instance.getCrossRankings( choices, chars, 10 );
            assertEquals( expected.length, actual.length );
            assertEquals( expected[0].length, actual[0].length );
            for ( int r = 0; r < expected.length; ++r ) {
                for ( int c = 0; c < expected[r].length; ++c ) {
                    assertEquals( expected[r][c], actual[r][c], 0.1 );
                }
            }
        }
        {
            List< Characteristic > chars = new LinkedList< Characteristic >();
            Characteristic chr = new Characteristic( "color" );
            chr.setRank( 10 );
            chars.add( chr );
            chr = new Characteristic( "price" );
            chr.setRank( 20 );
            chars.add( chr );
            List< Choice > choices = new LinkedList< Choice >();
            choices.add( new Choice( "hp" ) );
            choices.add( new Choice( "dell" ) );
            double[][] input = { 
                { 5, 15 }
                //{ 1, 5 },
                //{ 2, 6 },
                //{ 3, 7 },
                //{ 4, 8 }
            };
            InstrumentationUI instance = new InstrumentationUI();
            for ( int r = 0; r < input.length; ++r ) {
                for ( int c = 0; c < input[r].length; ++c ) {
                    instance.answers.add( Double.toString( input[r][c] ) );
                }
            }
            double[][] expected = { 
                { 10D / 15D, 10D / 25D },
                { 5D / 15D, 15D / 25D }
                //{ 1D/6D, 5D/6D },
                //{ 2D/8D, 6D/8D },
                //{ 3D/10D, 7D/10D },
                //{ 4D/12D, 8D/12D }
            };
            double[][] actual = instance.getCrossRankings( choices, chars, 10 );
            assertEquals( expected.length, actual.length );
            assertEquals( expected[0].length, actual[0].length );
            for ( int r = 0; r < expected.length; ++r ) {
                for ( int c = 0; c < expected[r].length; ++c ) {
                    assertEquals( expected[r][c], actual[r][c], 0.1 );
                }
            }
        }
    }
    
    /**
     * Proves inputCrossRankings() gets the cross rankings from the
     *  user as expected.
     */
    @Test
    public void inputCrossRankings() {
        {
            List< Characteristic > chars = new LinkedList< Characteristic >();
            Characteristic chr = new Characteristic( "color" );
            chr.setRank( 10 );
            chars.add( chr );
            chr = new Characteristic( "price" );
            chr.setRank( 20 );
            chars.add( chr );
            chr = new Characteristic( "speed" );
            chr.setRank( 30 );
            chars.add( chr );
            chr = new Characteristic( "appearance" );
            chr.setRank( 40 );
            chars.add( chr );
            List< Choice > choices = new LinkedList< Choice >();
            choices.add( new Choice( "hp" ) );
            choices.add( new Choice( "dell" ) );
            double[][] input = { 
                { 5, 15, 20, 7 }
            };
            InstrumentationUI instance = new InstrumentationUI();
            for ( int r = 0; r < input.length; ++r ) {
                for ( int c = 0; c < input[r].length; ++c ) {
                    instance.answers.add( Double.toString( input[r][c] ) );
                }
            }
            double[][] expected = { 
                { 10D, 10D, 10D, 10D},
                { 5D, 15D, 20D, 7D }
            };
            double[][] actual =
                instance.inputCrossRankings( choices, chars, 10 );
            assertEquals( expected.length, actual.length );
            assertEquals( expected[0].length, actual[0].length );
            for ( int r = 0; r < expected.length; ++r ) {
                for ( int c = 0; c < expected[r].length; ++c ) {
                    assertEquals( expected[r][c], actual[r][c], 0.1 );
                }
            }
        }
    }
    
    /**
     * Proves that calculateColumnTotals() gets the total of each column.
     */
    @Test
    public void testCalculateColumnTotals() {
        double[][] input = { 
            { 10, 10 },
            { 5, 15 }
        };
        double[] expected = {
            15, 25
        };
        InstrumentationUI instance = new InstrumentationUI();
        double[] actual = instance.calculateColumnTotals( input );
        assertEquals( expected.length, actual.length );
        for ( int r = 0; r < expected.length; ++r ) {
            assertEquals( expected[r], actual[r], 0.0001D );
        }
    }
    
    /**
     * Proves that normalizeCrossRankings() will normalize (make a 
     *  percent of the column total) each column by the column total.
     */
    @Test
    public void testNormalizeCrossRankings() {
        double[][] actual = { 
            { 10, 5 },
            { 15, 15 }
        };
        double[] columnTotals = {
            25, 20
        };
        double[][] expected = {
            { 0.4D, 0.25D },
            { 0.6D, 0.75D }
        };
        InstrumentationUI instance = new InstrumentationUI();
        instance.normalizeCrossRankings( actual, columnTotals );
        for ( int r = 0; r < expected.length; ++r ) {
            for ( int c = 0; c < expected[0].length; ++c ) {
                assertEquals( expected[r][c], actual[r][c], 0.0001D );
            }
        }
    }
    
    /**
     * Prove that showResults displays one message box.
     */
    @Test
    public void testShowResults() {
        List< Choice > choices = new LinkedList< Choice >();
        choices.add( new Choice( "hp" ) );
        choices.add( new Choice( "dell" ) );
        InstrumentationUI instance = new InstrumentationUI();
        instance.showResults( choices );
        assertEquals( 1, instance.messagesShown );
    }
    // END Good Behavioral Tests
    
    // BEGIN Destructive Tests
    /**
     * Proves that getCharacteristicRankings() will reject
     *  null values.
     */
    @Test( expected = NullPointerException.class )
    public void testGetCharacteristicRankingsNull() {
        InstrumentationUI instance = new InstrumentationUI();
        instance.getCharacteristicRankings( null, 10 );
    }
    
    /**
     * Proves that getCharacteristicRankings() will reject
     *  an empty list.
     */
    @Test( expected = IllegalArgumentException.class )
    public void testgetCharacteristicRankingsEmpty() {
        List< Characteristic > chars = new LinkedList< Characteristic >();
        InstrumentationUI instance = new InstrumentationUI();
        instance.getCharacteristicRankings( chars, 10 );
    }
    
    /**
     * Proves that getCrossRankings() will reject
     *  a null value in the 1st argument.
     */
    @Test( expected = NullPointerException.class )
    public void testGetCrossRankingsFirstNull() {
        List< Characteristic > chars = new LinkedList< Characteristic >();
        Characteristic chr = new Characteristic( "color" );
        chr.setRank( 10 );
        chars.add( chr );
        chr = new Characteristic( "price" );
        chr.setRank( 20 );
        chars.add( chr );
        chr = new Characteristic( "speed" );
        InstrumentationUI instance = new InstrumentationUI();
        instance.getCrossRankings( null, chars , 10 );
    }
    
    /**
     * Proves that getCrossRankings() will reject
     *  a null value in the 2nd argument.
     */
    @Test( expected = NullPointerException.class )
    public void testGetCrossRankingsSecondNull() {
        List< Choice > choices = new LinkedList< Choice >();
        choices.add( new Choice( "hp" ) );
        choices.add( new Choice( "dell" ) );
        InstrumentationUI instance = new InstrumentationUI();
        instance.getCrossRankings( choices, null, 10 );
    }
    
    /**
     * Proves that getCrossRankings() will reject
     *  an empty list for the 1st parameter.
     */
    @Test( expected = IllegalArgumentException.class )
    public void testGetCrossRankingsFirstEmpty() {
        List< Characteristic > chars = new LinkedList< Characteristic >();
        Characteristic chr = new Characteristic( "color" );
        chr.setRank( 10 );
        chars.add( chr );
        chr = new Characteristic( "price" );
        chr.setRank( 20 );
        chars.add( chr );
        chr = new Characteristic( "speed" );
        List< Choice > choices = new LinkedList< Choice >();
        InstrumentationUI instance = new InstrumentationUI();
        instance.getCrossRankings( choices, chars , 10 );
    }
    
    /**
     * Proves that getCrossRankings() will reject
     *  an empty list for the 2nd parameter.
     */
    @Test( expected = IllegalArgumentException.class )
    public void testGetCrossRankingsSecondEmpty() {
        List< Characteristic > chars = new LinkedList< Characteristic >();
        List< Choice > choices = new LinkedList< Choice >();
        choices.add( new Choice( "hp" ) );
        choices.add( new Choice( "dell" ) );
        InstrumentationUI instance = new InstrumentationUI();
        instance.getCrossRankings( choices, chars , 10 );
    }
    
    /**
     * Proves that inputCrossRankings() will reject
     *  a null value in the 2nd argument.
     */
    @Test( expected = NullPointerException.class )
    public void testInputCrossRankingsSecondNull() {
        List< Choice > choices = new LinkedList< Choice >();
        choices.add( new Choice( "hp" ) );
        choices.add( new Choice( "dell" ) );
        InstrumentationUI instance = new InstrumentationUI();
        instance.inputCrossRankings( choices, null, 10 );
    }
    
    /**
     * Proves that inputCrossRankings() will reject
     *  a null value in the 1st argument.
     */
    @Test( expected = NullPointerException.class )
    public void testInputCrossRankingsFirstNull() {
        List< Characteristic > chars = new LinkedList< Characteristic >();
        Characteristic chr = new Characteristic( "color" );
        chr.setRank( 10 );
        chars.add( chr );
        chr = new Characteristic( "price" );
        chr.setRank( 20 );
        chars.add( chr );
        chr = new Characteristic( "speed" );
        InstrumentationUI instance = new InstrumentationUI();
        instance.inputCrossRankings( null, chars , 10 );
    }
    
    /**
     * Proves that inputCrossRankings() will reject
     *  an empty list for the 1st parameter.
     */
    @Test( expected = IllegalArgumentException.class )
    public void testInputCrossRankingsFirstEmpty() {
        List< Characteristic > chars = new LinkedList< Characteristic >();
        Characteristic chr = new Characteristic( "color" );
        chr.setRank( 10 );
        chars.add( chr );
        chr = new Characteristic( "price" );
        chr.setRank( 20 );
        chars.add( chr );
        chr = new Characteristic( "speed" );
        List< Choice > choices = new LinkedList< Choice >();
        InstrumentationUI instance = new InstrumentationUI();
        instance.inputCrossRankings( choices, chars , 10 );
    }
    
    /**
     * Proves that inputCrossRankings() will reject
     *  an empty list for the 2nd parameter.
     */
    @Test( expected = IllegalArgumentException.class )
    public void testInputCrossRankingsSecondEmpty() {
        List< Characteristic > chars = new LinkedList< Characteristic >();
        List< Choice > choices = new LinkedList< Choice >();
        choices.add( new Choice( "hp" ) );
        choices.add( new Choice( "dell" ) );
        InstrumentationUI instance = new InstrumentationUI();
        instance.inputCrossRankings( choices, chars , 10 );
    }
    
    /**
     * Proves that calculateColumnTotals() will reject null
     *  values.
     */
    @Test( expected = NullPointerException.class )
    public void testCalculateColumnTotalsNull() {
        InstrumentationUI instance = new InstrumentationUI();
        instance.calculateColumnTotals( null );
    }
    
    /**
     * Proves that calculateColumnTotals() will reject arrays
     *  that have no columns.
     */
    @Test( expected = IllegalArgumentException.class )
    public void testCalculateColumnTotalsNoColumns() {
        double[][] crossRankings = {
            {},
            {}
        };
        InstrumentationUI instance = new InstrumentationUI();
        instance.calculateColumnTotals( crossRankings );
    }
    
    /**
     * Proves that normalizeCrossRankings() will reject null
     *  for the 1st argument.
     */
    @Test( expected = NullPointerException.class )
    public void testNormalizeCrossRankingsFirstNull() {
        double[][] crossRankings = {
            { 1, 2 },
            { 2, 3 }
        };
        InstrumentationUI instance = new InstrumentationUI();
        instance.normalizeCrossRankings( crossRankings, null );
    }
    
    /**
     * Proves that normalizeCrossRankings() will reject null
     *  for the 2nd argument.
     */
    @Test( expected = NullPointerException.class )
    public void testNormalizeCrossRankingsSecondNull() {
        double[] columnTotals = {
            1, 2
        };
        InstrumentationUI instance = new InstrumentationUI();
        instance.normalizeCrossRankings( null, columnTotals );
    }
    
    /**
     * Proves that normalizeCrossRankings() will reject 
     *  arguments where the inner array lengths are not
     *  equal.
     */
    @Test( expected = IllegalArgumentException.class )
    public void testNormalizeCrossRankingsUnequalLengths() {
        double[][] crossRankings = {
            { 1, 2 },
            { 3, 4 }
        };
        double[] charTotals = {
            4
        };
        InstrumentationUI instance = new InstrumentationUI();
        instance.normalizeCrossRankings( crossRankings, charTotals );
    }
    
    /**
     * Proves that showResults() will reject null values.
     */
    @Test( expected = NullPointerException.class )
    public void testShowResultsNull() {
        InstrumentationUI instance = new InstrumentationUI();
        instance.showResults( null );
    }
    
    /**
     * Proves that showResults() rejects empty lists.
     */
    @Test( expected = IllegalArgumentException.class )
    public void testShowResultsEmpty() {
        List< Choice > choices = new LinkedList< Choice >();
        InstrumentationUI instance = new InstrumentationUI();
        instance.showResults( choices );
    }
    // END Destructive Tests
    // BEGIN Branch Coverage
    /**
     * Proves that getChoices() returns an empty list when the user exits too.
     */
    @Test
    public void testGetChoicesEarlyExit() {
        InstrumentationUI instance = new InstrumentationUI();
        List actualChoices = instance.getChoices();
        assertTrue( actualChoices.isEmpty() );
    }
    
    /**
     * Proves that getCharacteristics() returns an empty list when the user exits too.
     */
    @Test
    public void testgetCharacteristicsEarlyExit() {
        InstrumentationUI instance = new InstrumentationUI();
        List actualChoices = instance.getCharacteristics();
        assertTrue( actualChoices.isEmpty() );
    }
    
    /**
     * Proves the method returns false when the user cancels early.
     */
    @Test
    public void testGetCharacteristicRankingsEarlyExit() {
        int[] expected = {
            10, 40
        };
        InstrumentationUI instance = new InstrumentationUI();
        for ( int val : expected ) {
            // Check for the default value.
            if ( val == 10 )
                // Skip the default value.
                continue;
            instance.answers.add( Integer.toString( val ) );
        }
        List< Characteristic > chars = new LinkedList< Characteristic >();
        chars.add( new Characteristic( "color" ) );
        chars.add( new Characteristic( "price" ) );
        chars.add( new Characteristic( "speed" ) );
        assertFalse( instance.getCharacteristicRankings( chars, 10 ) );
    }
    
    /**
     * Prove that getCrossRankings() returns null when the user exits early.
     */
    @Test
    public void testGetCrossRankingsEarlyExit() {
        {
            List< Characteristic > chars = new LinkedList< Characteristic >();
            Characteristic chr = new Characteristic( "color" );
            chr.setRank( 10 );
            chars.add( chr );
            chr = new Characteristic( "price" );
            chr.setRank( 20 );
            chars.add( chr );
            chr = new Characteristic( "speed" );
            chr.setRank( 30 );
            chars.add( chr );
            chr = new Characteristic( "appearance" );
            chr.setRank( 40 );
            chars.add( chr );
            List< Choice > choices = new LinkedList< Choice >();
            choices.add( new Choice( "hp" ) );
            choices.add( new Choice( "dell" ) );
            double[][] input = { 
                { 5, 15, 20 }
                //{ 1, 5 },
                //{ 2, 6 },
                //{ 3, 7 },
                //{ 4, 8 }
            };
            InstrumentationUI instance = new InstrumentationUI();
            for ( int r = 0; r < input.length; ++r ) {
                for ( int c = 0; c < input[r].length; ++c ) {
                    instance.answers.add( Double.toString( input[r][c] ) );
                }
            }
            double[][] actual = instance.getCrossRankings( choices, chars, 10 );
            assertNull( actual );
        }
    }
    
    /**
     * Proves inputCrossRankings() returns null when the user exits early.
     */
    @Test
    public void inputCrossRankingsEarlyExit() {
        {
            List< Characteristic > chars = new LinkedList< Characteristic >();
            Characteristic chr = new Characteristic( "color" );
            chr.setRank( 10 );
            chars.add( chr );
            chr = new Characteristic( "price" );
            chr.setRank( 20 );
            chars.add( chr );
            chr = new Characteristic( "speed" );
            chr.setRank( 30 );
            chars.add( chr );
            chr = new Characteristic( "appearance" );
            chr.setRank( 40 );
            chars.add( chr );
            List< Choice > choices = new LinkedList< Choice >();
            choices.add( new Choice( "hp" ) );
            choices.add( new Choice( "dell" ) );
            double[][] input = { 
                { 5, 15, 20 }
            };
            InstrumentationUI instance = new InstrumentationUI();
            for ( int r = 0; r < input.length; ++r ) {
                for ( int c = 0; c < input[r].length; ++c ) {
                    instance.answers.add(
                        Double.toString( 
                            input[r][c] 
                        )
                    );
                }
            }
            double[][] actual =
                instance.inputCrossRankings( choices, chars, 10 );
            assertNull( actual );
        }
    }
    // END Branch Coverage
}
