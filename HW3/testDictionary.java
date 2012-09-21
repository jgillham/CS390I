

import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import java.lang.NullPointerException;


/**
 * This unit test will check the integrity of the Dictionary class.
 *
 * @author  Josh Gillham
 * @version 9-19-12
 */
public class testDictionary
{
    /**
     * Default constructor for test class testDictionary
     */
    public testDictionary()
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
    
    /**
     * Test the getInstance with a null. The result should be an error
     */
    @Test( expected= java.lang.NullPointerException.class )
    public void testGetInstance_Null() {
        DictionaryInterface d= Dictionary.getInstance( null );
    }
    
    /**
     * Test the getInstance with an empty. The result should be an error
     */
    @Test( expected= IllegalArgumentException.class )
    public void testGetInstance_Empty() {
        DictionaryInterface d= Dictionary.getInstance( "" );
    }
    
    String dictionaryFile="";
    DictionaryInterface dictionary= Dictionary.getInstance( dictionaryFile );
    /**
     * Test the getInstance.
     */
    @Before
    public void testGetInstance() {
        dictionary= Dictionary.getInstance( dictionaryFile );
    }
    
    /**
     * Test getWord with bad lengths. The result should be an error.
     */
    @Test( expected= IllegalArgumentException.class )
    public void testGetWord_TooSmall() {
        dictionary.getWord( Dictionary.MIN_WORDLENGTH - 1 );
    }
    
    /**
     * Test getWord with bad lengths. The result should be an error.
     */
    @Test( expected= IllegalArgumentException.class )
    public void testGetWord_TooLarge() {
        dictionary.getWord( Dictionary.MIN_WORDLENGTH + 1 );
    }
    
}
