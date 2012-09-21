 
/**
 * Currently this will have only empty bodies for test itegrity.
 * 
 * @author Josh Gillham
 * @version 9-19-12
 */
public class Dictionary implements DictionaryInterface {
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
    static public DictionaryInterface getInstance( String file )
    { throw new UnsupportedOperationException(); }
    
    /** Empty unimplemented body. */
    private Dictionary()
    { throw new UnsupportedOperationException(); }
    
    /** Empty unimplemented body. */
    public String getWord( int length )
    { throw new UnsupportedOperationException(); }
    
}
