
/**
 * Responsible for loading the word data bank and also for retrieving a random word.
 * 
 * Dictionary will be a singleton.
 * 
 * @author Josh Gillham
 * @version 9-17-12
 */
public interface Dictionary{
    /**
     * getInstance finds the instance of the singleton and the file is disregarded, but, if
     *  no instance exists, a new dictionary class is created and the file is loaded.
     * 
     * @arg file the dictionary file to load.
     * 
     * @return the Dictionary instance
     */
    public Dictionary getInstance( String file );
    
    /**
     * Finds a random word from the dictionary.
     * 
     * @arg length is the length of the word to find
     * 
     * @return the random word
     */
    public String getWord( int length );
}
