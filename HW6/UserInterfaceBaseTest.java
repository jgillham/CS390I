

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
    /** Provides a test instrument for UserInterface. */
    class InstrumentationUI extends UserInterfaceBase {
        /** Holds a list of answers to yes or no questions. */
        public Queue< YNAnswer > answersYN = new LinkedList< YNAnswer >();
        /** Holds a list of answers to text questions. */
        public Queue< String > answers = new LinkedList< String >();
        /** Counts the number of messages shown. */
        public int messagesShown = 0;
        /** Povides a empty constructor. */
        public InstrumentationUI( ) {
        }
        /**
         * Provides a constructor with the first answers. 
         * 
         * @param nextYN is the next answer to a yes or no question.
         * @param nextQuestion is the next answer to a text question.
         */
        public InstrumentationUI( YNAnswer nextYN, String nextQuestion ) {
            this.answersYN.add( nextYN );
            this.answers.add( nextQuestion );
        }
        
        /**
         * Gets the first preloaded answer off the queue.
         * 
         * @param message is not used.
         * 
         * @return the preloaded yes or no answer.
         */
        public YNAnswer inputYNQuestion( String message ) {
            return this.answersYN.poll();
        }
        
        /**
         * Gets the first preloaded text answer off the queue.
         * 
         * @param message is not used.
         * 
         * @return the preloaded text answer.
         */
        public String inputQuestion( String message ) { 
            return this.answers.poll();
        }
        
        /**
         * Counts the number of times this method is called.
         * 
         * @param message is not used.
         */
        public void showMessage( String message ) { 
            ++messagesShown;
        }
    }
    
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
    public void testGetCharacteristicRankings_wNull() {
        InstrumentationUI instance = new InstrumentationUI();
        instance.getCharacteristicRankings( null, 10 );
    }
    
    /**
     * Proves that getCrossRankings() will reject
     *  a null value in the 2nd argument.
     */
    @Test( expected = NullPointerException.class )
    public void testGetCrossRankings_w2ndNull() {
        List< Choice > choices = new LinkedList< Choice >();
        choices.add( new Choice( "hp" ) );
        choices.add( new Choice( "dell" ) );
        InstrumentationUI instance = new InstrumentationUI();
        instance.getCrossRankings( choices, null, 10 );
    }
    
    /**
     * Proves that getCrossRankings() will reject
     *  a null value in the 1st argument.
     */
    @Test( expected = NullPointerException.class )
    public void testGetCrossRankings_w1stNull() {
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
     * Proves that inputCrossRankings() will reject
     *  a null value in the 2nd argument.
     */
    @Test( expected = NullPointerException.class )
    public void testInputCrossRankings_w2ndNull() {
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
    public void testInputCrossRankings_w1stNull() {
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
     * Proves that calculateColumnTotals() will reject null
     *  values.
     */
    @Test( expected = NullPointerException.class )
    public void testCalculateColumnTotals_wNull() {
        InstrumentationUI instance = new InstrumentationUI();
        instance.calculateColumnTotals( null );
    }
    
    /**
     * Proves that normalizeCrossRankings() will reject null
     *  for the 1st argument.
     */
    @Test( expected = NullPointerException.class )
    public void testNormalizeCrossRankings_w1stNull() {
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
    public void testNormalizeCrossRankings_w2ndNull() {
        double[] columnTotals = {
            1, 2
        };
        InstrumentationUI instance = new InstrumentationUI();
        instance.normalizeCrossRankings( null, columnTotals );
    }
    
    /**
     * Proves that showResults() will reject null values.
     */
    @Test( expected = NullPointerException.class )
    public void testShowResults_wNull() {
        InstrumentationUI instance = new InstrumentationUI();
        instance.showResults( null );
    }
    // END Destructive Tests
}
