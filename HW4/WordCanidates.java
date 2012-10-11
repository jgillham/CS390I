import java.util.List;
import java.util.LinkedList;
import java.util.Iterator;

/**
 * Allows the game to have a partial set of words from the main dictionary.
 * 
 * @author Josh Gillham 
 * @version 10-9-12
 */
public class WordCanidates  {
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
     * Divides word canidates into smaller lists that correspond to status word
     *  patterns i.e. --a---.
     *  
     * Example:
     *  --a--- List1
     *  -a--a- List2
     *  ------ List3
     *  
     * @arg letter is the letter to divide the lists by.
     * 
     * @return maps status word patterns to lists of words with those patterns.
     */
    public java.util.Map< String, List< String > > subDivide( char letter ) {
        int length= wordCanidates.get( 0 ).length();
        StringBuilder basePattern= new StringBuilder();
        for( int i= 0; i < length; ++i ) {
            basePattern.append( '-' );
        }
        java.util.Map< String, List< String > > subLists= new java.util.HashMap< String, List< String > >(24);
        Iterator< String > i= wordCanidates.iterator();
        List< String > othersList= new java.util.ArrayList< String >(500);
        subLists.put( basePattern.toString(), othersList );
        while( i.hasNext() ) {
            String word= i.next();
            StringBuilder pattern= new StringBuilder( basePattern );
            int start= -1;
            int temp;
            while( ( temp= word.indexOf( letter, start + 1 ) ) > -1 ){
                start= temp;
                pattern.setCharAt( start, letter );
            }
            if( start != -1 ) {
                List< String > subList= subLists.get( pattern.toString() );
                if( subList == null ) {
                    subList= new java.util.ArrayList< String >(500);
                    subLists.put( pattern.toString(), subList );
                }
                subList.add( word );
            } else 
                othersList.add( word );
                
        }
        return subLists;
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
        int choose= 0;
        if( hasLetter.size() == 0 ){
            choose= doesntHaveLetter.size();
        }else if( doesntHaveLetter.size() == 0 ){
            choose= hasLetter.size();
        }else {
            //choose= chooseSet( hasLetter.size(), doesntHaveLetter.size() );
        }
        boolean result= false;
        if( choose == hasLetter.size() ) {
            wordCanidates= hasLetter;
            result= true;
        }else if( choose == doesntHaveLetter.size() ) {
            wordCanidates= doesntHaveLetter;
        }else
            throw new java.util.NoSuchElementException( "Choose does not match any size." );
        // This should never occur.
        if( wordCanidates.size() == 0 )
            throw new java.lang.AssertionError( "wordCanidates.size() is 0" );
        return result;
    }
    
    /** Helps eliminate( char ) decide which set to choose. */
    //abstract public int chooseSet( int hasLetterSize, int doesntHaveLetterSize );
    
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
            System.out.println( "word: " + word );
            System.out.println( "letter: " + letter );
            System.out.println( "position: " + position );
            int start= -1;
            System.out.println( "Start: " + start );
            while( ( start= word.indexOf( letter, start + 1 ) ) != position && start > -1 ){
                System.out.println( "Start: " + start );
            }
            System.out.println( "Start: " + start );
            if( start == -1 ) {
                i.remove();
            }
        }
        // This should never occur.
        if( wordCanidates.size() == 0 )
            throw new java.lang.AssertionError( "wordCanidates.size() is 0" );
    }
    
    /**
     * Retrieves a random word from the list.
     * 
     * @return the word
     */
    public String getRandomCanidate() {
        System.out.println( "wordCanidates.size(): " + wordCanidates.size() );
        int rand= (int)(Math.random() * wordCanidates.size());
        System.out.println( "rand: " + rand );
        return wordCanidates.get( rand );
    }
}

