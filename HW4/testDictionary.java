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
 * -test getSet
 * @author  Josh Gillham
 * @version 9-23-12
 */
public class testDictionary {
    
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
        Dictionary.dispose();
        Dictionary.load( dictionaryFile );
        dictionary= new Dictionary();
    }
    
    /**
     * Test getWord with bad lengths. The result should a null.
     */
    @Test
    public void testGetWord_TooSmall() {
        assertNull( dictionary.getWord( 2 ) );
    }
    
    /**
     * Test getWord with bad lengths. The result should a null.
     */
    @Test
    public void testGetWord_TooLarge() {
        assertNull( dictionary.getWord( 6 ) );
    }
    
    /**
     * I had a problem with it giving me the file name instead of a word.
     */
    @Test
    public void testGetWords_NotTheFileName() {
        String word= Dictionary.getInstance().getWord( 3 );
        if( dictionaryFile.equalsIgnoreCase( word ) )
            fail( "Word is the file name." );
    }
    
    /**
     * 
     */
    @Test
    public void testGetWords_CorrectWords() {
        java.util.List< String > words= new java.util.LinkedList< String >();
        words.add( "cat" );
        words.add( "mouse" );
        words.add( "hat" );
        String word= Dictionary.getInstance().getWord( 3 );
        assertTrue( words.contains( word ) );
    }
    
    @Test
    public void testDepositWord() {
        Dictionary.getInstance().depositWord( "maneater" );
    }
    
    @Test( expected= IllegalArgumentException.class )
    public void testDepositWord_Empty() {
        Dictionary.getInstance().depositWord( "" );
    }
    @Test( expected= NullPointerException.class )
    public void testDepositWord_Null() {
        Dictionary.getInstance().depositWord( null );
    }
    
}
