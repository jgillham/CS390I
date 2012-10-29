

import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import java.util.Queue;
import java.util.LinkedList;

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
        List< Choices > expected = new List< Choices >();
        expected.add( "color" );
        expected.add( "price" );
        expected.add( "speed" );
        InstrumentationUI instance = new InstrumentationUI();
        for( String choice: expected ) {
            instance.add( choice );
        }
        List< Choice > actual = instance.getChoices();
        assertEquals( expected, actual );
    }
}
