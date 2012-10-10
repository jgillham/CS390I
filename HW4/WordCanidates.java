import java.util.Set;
import java.util.List;
import java.util.Iterator;
import java.util.TreeSet;

/**
 * Allows the game to have a partial set of words from the main dictionary.
 * 
 * @author Josh Gillham 
 * @version 10-9-12
 */
abstract public class WordCanidates  {
    /** Holds a list of potiential word canidates. */
    private Set< String > wordCanidates;
    
    /**
     * Initializes class variables.
     * 
     * @arg wordList is the list to use.
     */
    public WordCanidates( Set<String> wordList ) {
        wordCanidates= new TreeSet< String >( wordList );
    }
    
    /**
     * Accesses the remaining word canidates.
     * 
     * @return the number of canidates.
     */
    public int count() {
        return wordCanidates.size();
    }
    
    /**
     * Narrows down the list.
     * 
     * @arg letter is used to narrow down all words without that letter.
     * 
     * @throws NoSuchElementException when a class to the subclass returns a size
     *  that does not match any of the chooses.
     */
    public void eliminate( char letter ) throws java.util.NoSuchElementException {
        Iterator< String > i= wordCanidates.iterator();
        Set< String > hasLetter= new TreeSet< String >();
        Set< String > doesntHaveLetter= new TreeSet< String >();
        while( i.hasNext() ) {
            String word= i.next();
            if( word.indexOf( letter ) > -1 )
                hasLetter.add( word );
            else
                doesntHaveLetter.add( word );
        }
        int choose= chooseSet( hasLetter.size(), doesntHaveLetter.size() );
        if( choose == hasLetter.size() ) {
            wordCanidates= hasLetter;
        }else if( choose == doesntHaveLetter.size() ) {
            wordCanidates= doesntHaveLetter;
        }else
            throw new java.util.NoSuchElementException( "Choose does not match any size." );
    }
    
    abstract public int chooseSet( int hasLetterSize, int doesntHaveLetterSize );
}
