

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
        for( String choice: expected ) {
            instance.answers.add( choice );
        }
        List< Choice > actualChoices = instance.getChoices();
        Iterator< String > expI = expected.iterator();
        for( Choice actualChoice: actualChoices ) {
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
        for( String choice: expected ) {
            instance.answers.add( choice );
        }
        List< Choice > actualChoices = instance.getChoices();
        Iterator< String > expI = expected.iterator();
        for( Choice actualChoice: actualChoices ) {
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
        for( int val: expected ) {
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
        instance.getCharacteristicRankings( chars, 10 );
        int i = 0;
        for( Characteristic chr: chars ) {
            assertTrue( i < expected.length );
            assertEquals( expected[ i ], chr.getRank() );
            ++i;
        }
    }
    
    @Test
    public void testGetCrossRankings() {
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
        for( int r = 0; r < input.length; ++r ) {
            for( int c = 0; c < input[r].length; ++c ) {
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
        for( int r = 0; r < expected.length; ++r ) {
            for( int c = 0; c < expected[r].length; ++c ) {
                assertEquals( expected[r][c], actual[r][c], 0.1 );
            }
        }
    }
    
    @Test
    public void testGetCrossRankings2() {
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
        for( int r = 0; r < input.length; ++r ) {
            for( int c = 0; c < input[r].length; ++c ) {
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
        for( int r = 0; r < expected.length; ++r ) {
            for( int c = 0; c < expected[r].length; ++c ) {
                assertEquals( expected[r][c], actual[r][c], 0.1 );
            }
        }
    }
    
    @Test
    public void testShowResults() {
        List< Choice > choices = new LinkedList< Choice >();
        choices.add( new Choice( "hp" ) );
        choices.add( new Choice( "dell" ) );
        InstrumentationUI instance = new InstrumentationUI();
        instance.showResults( choices );
        assertEquals( 1, instance.messagesShown );
    }
}
