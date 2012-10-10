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
public class WordCanidates  {
    /** Holds a list of potiential word canidates. */
    private Set< String > wordCanidates;
    
    /**
     * Initializes class variables.
     * 
     * @arg wordList is the list to use.
     */
    public WordCanidates( List<String> wordList ) {
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
     * 
     */
    public Set< String >[] subDivide( char letter ) {
        Iterator< String > i= wordCanidates.iterator();
        Set< String >[] subSets= new TreeSet< String >[2];
        Set< String > hasLetter= new TreeSet< String >();
        Set< String > doesntHaveLetter= new TreeSet< String >();
        while( i.hasNext() ) {
            String word= i.next();
            if( word.indexOf( letter ) > -1 )
                hasLetter.add( word );
            else
                doesntHaveLetter.add( word );
        }
        Set< String > smaller, larger;
        if( hasLetter.size() > doesntHaveLetter.size() ){
            smaller= doesntHaveLetter;
            larger= hasLetter;
        }else {
            smaller= hasLetter;
            larger= doesntHaveLetter;
        }
        
        float ratio= smaller.size() / larger.size();
        if( ratio > .7 ){
            wordCanidates= doesntHaveLetter;
        }else{
            wordCanidates= larger;
        }
    }
}
