

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
public class UserInterfaceTest {
    class InstrumentationUI extends UserInterface {
        public Queue< YNAnswer > answersYN = new LinkedList< YNAnswer >();
        public Queue< String > answers = new LinkedList< String >();
        public InstrumentationUI( ) {
        }
        public InstrumentationUI( YNAnswer nextYN, String nextQuestion ) {
            this.answersYN.add( nextYN );
            this.answers.add( nextQuestion );
        }
        public YNAnswer inputYNQuestion( String message ) {
            return this.answersYN.poll();
        }
        public String inputQuestion( String message ) { 
            return this.answers.poll();
        }
        public void showMessage( String message ) { 
        }
    }
    
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
            assertEquals( expI.next(), actualChoice );
        }
    }
    
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
            assertEquals( expI.next(), actualChoice );
        }
    }
    
    
    
    @Test
    public void testGetCharacteristicRankings() {
        int[] expected = {
            1, 2, 3, 4, 5, 6  
        };
        InstrumentationUI instance = new InstrumentationUI();
        for( int val: expected ) {
            instance.answers.add( Integer.toString( val ) );
        }
        List< Characteristic > chars = new LinkedList< Characteristic >();
        chars.add( new Characteristic( "color" ) );
        chars.add( new Characteristic( "price" ) );
        chars.add( new Characteristic( "speed" ) );
        instance.getCharacteristicRankings( chars, 1 );
        int i = 0;
        for( Characteristic chr: chars ) {
            assertTrue( i < expected.length );
            assertEquals( expected[ i ], chr.getRank() );
        }
    }
}
