import java.util.SortedSet;
import java.util.TreeSet;
import java.util.Iterator;
import java.util.Map;

/**
 * Allows the game to have a partial set of words from the main dictionary.
 * 
 * @author Josh Gillham 
 * @version 10-9-12
 */
public class WordCanidates  {
    /** Holds a list of potiential word canidates. */
    private SortedSet< String > wordCanidates;
    /** Holds a string the same length of gameWord but with dashes in places where no player has guessed. */
    private StringBuilder statusWord= new StringBuilder();
    
    /**
     * Initializes class variables.
     * 
     * @arg wordList is the list to use.
     * 
     * @throws IllegalArgumentException when wordList.size() == 0.
     * @throws IllegalArgumentException when the length of the status word does not equal the length of
     *  the first word in the word list.
     * @throws NullPointerException when statusWord or wordList are null.
     */
    public WordCanidates( String statusWord, SortedSet<String> wordList ) {
        if( wordList == null )
            throw new NullPointerException();
        if( wordList == null )
            throw new NullPointerException();
        if( wordList.size() == 0 )
            throw new IllegalArgumentException();
        System.out.println( "statusWord: " + statusWord );
        System.out.println( "wordList.iterator().next(): " + wordList.iterator().next() );
        System.out.println( "statusWord.length(): " + statusWord.length() );
        System.out.println( "wordList.iterator().next().length(): " + wordList.iterator().next().length() );
        if( statusWord.length() != wordList.iterator().next().length() )
            throw new IllegalArgumentException();
        wordCanidates= new TreeSet< String >( wordList );
        this.statusWord= new StringBuilder( statusWord );
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
    public Map< String, SortedSet< String > > subDivide( char letter ) {
        int length= wordCanidates.iterator().next().length();
        StringBuilder basePattern= this.statusWord;
        java.util.Map< String, SortedSet< String > > subLists= new java.util.HashMap< String, SortedSet< String > >(24);
        Iterator< String > i= wordCanidates.iterator();
        SortedSet< String > othersList= new TreeSet< String >();
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
                SortedSet< String > subList= subLists.get( pattern.toString() );
                if( subList == null ) {
                    subList= new TreeSet< String >();
                    subLists.put( pattern.toString(), subList );
                }
                subList.add( word );
            } else 
                othersList.add( word );
                
        }
        return subLists;
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
        Iterator< String > i= wordCanidates.iterator();
        for( int pos= 0; pos < rand; ++pos ) {
            i.next();
        }
        return i.next();
    }
}

