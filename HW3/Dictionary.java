import java.util.List;
import java.util.ArrayList;
import java.io.File;
import java.util.Scanner;

/**
 * Responsible for loading the word data bank and also for retrieving a random word.
 * 
 * @author Josh Gillham
 * @version 9-23-12
 */
public class Dictionary{
    /** The smallest allowed word in the dictionary. */
    static public final int MIN_WORDLENGTH= 3;
    /** The largest allowed word in the dictionary. */
    static public final int MAX_WORDLENGTH= 7;
    /** Keeps the word data bank. */
    static List<String> words= new ArrayList<String>(5000);
    
    
    /**
     * Loads the dictionary file.
     * 
     * @arg file the dictionary file to load.
     * 
     * @throws NullPointerException when file is null.
     * @throws IllegalArgumentException when file is empty.
     * @throws another error when file is bad.
     * 
     * Empty unimplemented body.
     */
    static public void load( String file ) throws NullPointerException, java.io.FileNotFoundException {
        if( file == null )
            throw new NullPointerException();
            
        if( file.isEmpty() )
            throw new IllegalArgumentException();
        
        // Read in each word line by line
        File src= new File( file );
        Scanner input= new Scanner( src );
        while( input.hasNext() ) {
            words.add( input.next() );
        }
    }
    
    /**
     * Finds a random word from the dictionary.
     * 
     * Preconditions:
     *  Word data bank must have at least one word.
     * 
     * @arg length is the length of the word to find.
     * 
     * @return the random word.
     * 
     * @throw IllegalArgumentException when the length is less than MIN_WORDLENGTH 
     *   or greater than MAX_WORDLENGTH
     */
    static public String getWord( int length )throws java.util.NoSuchElementException {
        if( words.size() == 0 )
            throw new java.util.NoSuchElementException();
            
        if( length < MIN_WORDLENGTH || length > MAX_WORDLENGTH )
            throw new IllegalArgumentException();
        // Get a random word
        int randomIndex= (int)( Math.random() * words.size() );
        return words.get( randomIndex );
    }
        
}
