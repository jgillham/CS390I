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
     * Test the load with a null. The result should be an error
     */
    @Test( expected= java.lang.NullPointerException.class )
    public void testLoad_Null() {
        Dictionary.load( null );
    }
    
    /**
     * Test the load with an empty path. The result should be an error
     */
    @Test( expected= IllegalArgumentException.class )
    public void testLoad_Empty() {
        Dictionary.load( "" );
    }
    /** The file of the dictionary. */
    String dictionaryFile="";
    /** An instance of the dictionary. */
    Dictionary dictionary;
    /**
     * Test the load.
     */
    @Before
    public void testLoad() {
        Dictionary.load( dictionaryFile );
        dictionary= new Dictionary();
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
