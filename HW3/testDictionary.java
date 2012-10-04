import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import java.lang.NullPointerException;


/**
 * This unit test will check the integrity of the Dictionary class.
 * TODO
 * -TEST checkWordLength
 * -test depositWord
 * @author  Josh Gillham
 * @version 9-23-12
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
    public void testLoad_Null() throws java.io.FileNotFoundException {
        Dictionary.load( null );
    }
    
    /**
     * Test the load with an empty path. The result should be an error
     */
    @Test( expected= IllegalArgumentException.class )
    public void testLoad_Empty() throws java.io.FileNotFoundException {
        Dictionary.load( "" );
    }
    /** The file of the dictionary. */
    String dictionaryFile= "testwords.txt";
    /** An instance of the dictionary. */
    Dictionary dictionary;
    /**
     * Test the load.
     */
    @Before
    public void testLoad() throws java.io.FileNotFoundException {
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
        dictionary.getWord( Dictionary.LARGEST_WORD + 1 );
    }
    
    /**
     * 
     */
    @Test
    public void testNotTheFileName() {
        String word= Dictionary.getWord( 3 );
        if( dictionaryFile.equalsIgnoreCase( word ) )
            fail( "Word is the file name." );
    }
    
    /**
     * 
     */
    @Test
    public void testCorrectWords() {
        String[] words={
            "cat",
            "mouse",
            "hat"
        };
        String word= Dictionary.getWord( 3 );
        System.out.println( "word: " + word );
        boolean found= false;
        for( String listWord: words ) {
            System.out.println( "listWord: " + listWord );
            if( word.equalsIgnoreCase(listWord) ){
                found= true; break;
            }
        }
        assertTrue( found );
    }
    
}
