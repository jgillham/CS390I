import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * This test unit will test the behavior of SetupUI.
 *
 * TODO:
 *  Fully test SetupUI
 * 
 * @author  Josh Gillham
 * @version 9-23-12
 */
public class testSetupUI
{
    /**
     * Default constructor for test class testSetupUI
     */
    public testSetupUI()
    {
    }

    /**
     * Sets up the test fixture.
     *
     * Called before every test case method.
     */
    @Before
    public void setUp()
    {
    }

    /**
     * Tears down the test fixture.
     *
     * Called after every test case method.
     */
    @After
    public void tearDown()
    {
    }
    class BadSetupUser extends java.io.InputStream {
        String badInput;
        int index= 0;
        public BadSetupUser( String input ) {
            badInput= input;
        }
        
        public int read() {
            if( index >= badInput.length() )
                return -1;
            return (int)badInput.charAt( index++ );
        }
        
    }
    SetupUI setup= null;
    
    /**
     * Tests the constructor to ensure that it throws no errors.
     */
    @Before
    public void testConstructor() throws java.io.FileNotFoundException {
        setup= new SetupUI();
    }
    
    /**
     * Tests inputPlayerName.
     */
    @Test
    public void testInputPlayerName() {
        String result= setup.inputPlayerName( new java.util.Scanner( new BadSetupUser( "" ) ) );
        assertNull( result );
    }
}
