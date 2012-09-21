
/**
 * Responsible for loading the word data bank and also for retrieving a random word.
 * 
 * Dictionary will be a singleton.
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
     * Empty unimplemented body.
     * getInstance finds the instance of the singleton and the file is disregarded, but, if
     *  no instance exists, a new dictionary class is created and the file is loaded.
     * 
     * @arg file the dictionary file to load.
     * 
     * @return the Dictionary instance
     */
    static public Dictionary getInstance( String file )
    { throw new UnsupportedOperationException(); }
    
    /** Empty unimplemented body. */
    private Dictionary()
    { throw new UnsupportedOperationException(); }
    
    /**
     * Finds a random word from the dictionary.
     * 
     * @arg length is the length of the word to find
     * 
     * @return the random word
     * 
     * @throw IllegalArgumentException when the length is less than MIN_WORDLENGTH or greater than MAX_WORDLENGTH
     */
    public String getWord( int length )
    { throw new UnsupportedOperationException(); }
}
