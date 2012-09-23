
/**
 * Responsible for loading the word data bank and also for retrieving a random word.
 * 
 * @author Josh Gillham
 * @version 9-17-12
 */
public class Dictionary{
    /** The smallest word in the dictionary. */
    static public final int MIN_WORDLENGTH= 3;
    /** The largest word in the dictionary. */
    static public final int MAX_WORDLENGTH= 7;
    
    
    /**
     * Loads the dictionary file.
     * 
     * @arg file the dictionary file to load.
     * 
     * Empty unimplemented body.
     */
    static public void load( String file )
    { throw new UnsupportedOperationException(); }
    
    /**
     * Finds a random word from the dictionary.
     * 
     * @arg length is the length of the word to find
     * 
     * @return the random word
     * 
     * @throw IllegalArgumentException when the length is less than MIN_WORDLENGTH 
     *   or greater than MAX_WORDLENGTH
     */
    static public String getWord( int length )
    { throw new UnsupportedOperationException(); }
}
