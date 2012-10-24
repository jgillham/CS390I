

import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * Tests the presentation of the UI to the user.
 *
 * @author  Josh Gillham
 * @version 10-23-12
 */
public class UITest {
    /**
     * Prove that the default constructor produces no errors.
     */
    @Test
    public void testConstructor() {
        new UI();
    }
    /**
     * Proves the user can see the correct buttons by the presentation of the dialog.
     */
    @Test
    public void testInputYNQuestion() {
        UI instance= new UI();
        assertEquals( UI.YNAnswer.Yes, instance.inputYNQuestion( "For test purposes, click yes. Thank you." ) );
        assertEquals( UI.YNAnswer.No, instance.inputYNQuestion( "For test purposes, click no. Thank you." ) );
    }
    
    /**
     * Prove the user can see how to type in a response by the presentation of the dialog.
     */
    @Test
    public void testInputQuestion() {
        UI instance= new UI();
        assertEquals( "test", instance.inputQuestion( "For test purposes, please type \"test\" "
                + "(no quotation marks) and click OK. Thank you." ) );
        assertNull( instance.inputQuestion( "For test purposes, please type \"test\" "
                + "(no quotation marks) and click Cancel. Thank you." ) );
    }
    
    /**
     * Prove that showMessage produces no errors.
     */
    @Test
    public void testShowMessage() {
        UI instance= new UI();
        instance.showMessage( "Ignore this. Thank you." );
    }
}
