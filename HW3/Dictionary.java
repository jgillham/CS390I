 
/**
 * Currently this will have only empty bodies for test itegrity.
 * 
 * @author Josh Gillham
 * @version 9-19-12
 */
public class Dictionary implements DictionaryInterface {
    static public final int MIN_WORDLENGTH= 3;
    static public final int MAX_WORDLENGTH= 7;
    /**
     * getInstance finds the instance of the singleton and the file is disregarded, but, if
     *  no instance exists, a new dictionary class is created and the file is loaded.
     * 
     * @arg file the dictionary file to load.
     * 
     * @return the Dictionary instance
     */
    public DictionaryInterface getInstance( String file ) {
        return null;
    }
    
    /**
     * Finds a random word from the dictionary.
     * 
     * @arg length is the length of the word to find
     * 
     * @return the random word
     */
    public String getWord( int length ) {
        return null;
    }
}
