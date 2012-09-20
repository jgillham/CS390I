 
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
    
    /** Empty unimplemented body. */
    public DictionaryInterface getInstance( String file )
    { throw new UnsupportedOperationException(); }
    /** Empty unimplemented body. */
    public String getWord( int length )
    { throw new UnsupportedOperationException(); }
    
}
