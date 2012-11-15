

import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * Tests GraphicalUserInterface.
 *
 * @author  Josh Gillham
 * @version 11-12-12
 */
public class GraphicalUserInterfaceTest {
    // BEGIN Good Behavioral Tests
    /**
     * Prove that the default constructor produces no errors.
     */
    @Test
    public void testConstructor() {
        new GraphicalUserInterface();
    }
    /**
     * Proves the user can see the correct buttons by the presentation
     *  of the dialog.
     */
    @Test
    public void testInputYNQuestion() {
        GraphicalUserInterface instance = new GraphicalUserInterface();
        assertEquals( GraphicalUserInterface.YNAnswer.Yes, 
            instance.inputYNQuestion( 
                "For test purposes, click yes. Thank you." 
            )
        );
        assertEquals( GraphicalUserInterface.YNAnswer.No, 
            instance.inputYNQuestion( 
                "For test purposes, click no. Thank you."
            )
        );
        assertNull( instance.inputYNQuestion( 
            "For test purposes, click the X. Thank you."
        ) );
    }
    
    /**
     * Prove the user can see how to type in a response by the presentation
     *  of the dialog.
     */
    @Test
    public void testInputQuestion() {
        GraphicalUserInterface instance = new GraphicalUserInterface();
        assertEquals( "test", instance.inputQuestion( 
            "For test purposes, please type \"test\" " +
            "(no quotation marks) and click OK. Thank you."
        ) );
        assertNull( instance.inputQuestion(
            "For test purposes, please type \"test\" " +
            "(no quotation marks) and click Cancel. Thank you."
        ) );
        assertNull( instance.inputQuestion( 
            "For test purposes, please type \"test\" " +
            "(no quotation marks) and click the X. Thank you."
        ) );
    }
    
    /**
     * Prove that showMessage produces no errors.
     */
    @Test
    public void testShowMessage() {
        GraphicalUserInterface instance = new GraphicalUserInterface();
        instance.showMessage( "Ignore this. Thank you." );
    }
    // END Good Behavioral Tests
    // BEGIN Destructive Tests
    /**
     * Prove that inputYNQuestion() rejects null values.
     */
    @Test( expected = NullPointerException.class )
    public void testInputYNQuestion_wNull() {
        GraphicalUserInterface instance = new GraphicalUserInterface();
        instance.inputYNQuestion( null );
    }
    
    /**
     * Prove that inputQuestion() rejects null values.
     */
    @Test( expected = NullPointerException.class )
    public void testInputQuestion_wNull() {
        GraphicalUserInterface instance = new GraphicalUserInterface();
        instance.inputQuestion( null );
    }
    
    /**
     * Prove that showMessage() rejects null values.
     */
    @Test( expected = NullPointerException.class )
    public void testShowMessage_wNull() {
        GraphicalUserInterface instance = new GraphicalUserInterface();
        instance.showMessage( null );
    }
    // END Destructive Tests
}
