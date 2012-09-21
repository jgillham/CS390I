
/**
 * Responsible for loading the word data bank and also for retrieving a random word.
 * 
 * Dictionary will be a singleton.
 * 
 * @author Josh Gillham
 * @version 9-17-12
 */
public interface DictionaryInterface{
    /**
     * Finds a random word from the dictionary.
     * 
     * @arg length is the length of the word to find
     * 
     * @return the random word
     * 
     * @throw IllegalArgumentException when the length is less than MIN_WORDLENGTH or greater than MAX_WORDLENGTH
     */
    public String getWord( int length );
}
