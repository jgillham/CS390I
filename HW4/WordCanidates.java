import java.util.List;
import java.util.LinkedList;
import java.util.Iterator;

/**
 * Allows the game to have a partial set of words from the main dictionary.
 * 
 * @author Josh Gillham 
 * @version 10-9-12
 */
abstract public class WordCanidates  {
    /** Holds a list of potiential word canidates. */
    private List< String > wordCanidates;
    
    /**
     * Initializes class variables.
     * 
     * @arg wordList is the list to use.
     * 
     * @throws IllegalArgumentException when wordList.size() == 0.
     */
    public WordCanidates( List<String> wordList ) {
        if( wordList.size() == 0 )
            throw new IllegalArgumentException();
        wordCanidates= new LinkedList< String >( wordList );
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
     * @return true if the word canidates contain the letter OR
     *         false if they do not.
     * 
     * @throws NoSuchElementException when a class to the subclass returns a size
     *  that does not match any of the chooses.
     */
    public boolean eliminate( char letter ) throws java.util.NoSuchElementException {
        Iterator< String > i= wordCanidates.iterator();
        List< String > hasLetter= new LinkedList< String >();
        List< String > doesntHaveLetter= new LinkedList< String >();
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
            return true;
        }else if( choose == doesntHaveLetter.size() ) {
            wordCanidates= doesntHaveLetter;
            return false;
        }else
            throw new java.util.NoSuchElementException( "Choose does not match any size." );
    }
    
    /** Helps eliminate( char ) decide which set to choose. */
    abstract public int chooseSet( int hasLetterSize, int doesntHaveLetterSize );
    
    /**
     * Narrows down the list.
     * 
     * @arg letter is used to narrow down all words without that letter.
     * @arg position the index where the letter should be found.
     */
    public void mustHave( char letter, int position ) throws java.util.NoSuchElementException {
        Iterator< String > i= wordCanidates.iterator();
        while( i.hasNext() ) {
            String word= i.next();
            // Try to find a character at this position.
            int start= -1;
            while( ( start= word.indexOf( letter, start + 1 ) ) != position && start > -1 ){}
            if( start == -1 ) {
                i.remove();
            }
        }
    }
    
    /**
     * Retrieves a random word from the list.
     * 
     * @return the word
     */
    public String getRandomCanidate() {
        int rand= (int)(Math.random() * wordCanidates.size());
        return wordCanidates.get( rand );
    }
}
