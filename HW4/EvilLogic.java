import java.util.List;
import java.util.LinkedList;
import java.util.Iterator;
import java.util.Set;
import java.util.Map;
import java.util.SortedSet;

/**
 * Now the game logic will make playing the game harder by always stacking the odds against the player. After a
 *  guess, by picking the guess letter combination with the largest group, the player will always get the worst
 *  luck.
 * 
 * @author Josh Gillham
 * @version 10-18-12
 */
public class EvilLogic extends Logic{
    
    /**
     * Checks to make sure teams has no teams with empty rosters. Makes sure there is at least one player
     *  and one team. The gameWord must not be empty or null.
     *  
     * @param teams the teams for the game.
     * @param gameWordLength the length of the game word.
     * 
     * @throws EmptyTeamsException when any Manager.getRosterSize() returns 0.
     * @throws NoTeamsException when teams is empty.
     * @throws IllegalArgumentException when gameWordLength is out of range
     *  of the dictionary limits.
     */
    public EvilLogic( List< Manager > teams, int gameWordLength ) throws EmptyTeamsException, NoTeamsException  {
        super( teams, gameWordLength );
    }
    
    /**
     * Checks to make sure teams has no teams with empty rosters. Makes sure there is at least one player
     *  and one team. The gameWord must not be empty or null.
     *  
     * @param teams the teams for the game.
     * @param gameWord the word to guess
     * 
     * @throws EmptyTeamsException when any Manager.getRosterSize() returns 0.
     * @throws NoTeamsException when teams is empty.
     * @throws IllegalArgumentException when gameWord is empty
     * @throws NullPointerException when gameWord is null.
     */
    public EvilLogic( List< Manager > teams, String gameWord ) throws EmptyTeamsException, NoTeamsException  {
        super( teams, gameWord );
    }
    
    /**
     * This is the evil way to choose the key. This will pick the key that is associated
     *  with the largest set therefore making it harder for the player to win the game.
     *  
     * @param keys a set of keys.
     * @param subLists the map with the keys and lists.
     * 
     * @return the key
     * 
     * @throws IllegalArgumentException when subLists.size() == 0.
     * @throws NullPointerException when subLists is null.
     */
    @Override
    public String chooseKey( Map< String, SortedSet< String > > subLists ) {
        if( subLists == null )
            throw new NullPointerException();
        if( subLists.size() == 0 )
            throw new IllegalArgumentException();
        Set< String > keys= subLists.keySet( );
        String selectedKey= null;
        int max= 0;
        Iterator< String > i= keys.iterator();
        // Go though each set and settle on the largest group.
        while( i.hasNext() ){
            String key= i.next();
            // Get the associated list.
            SortedSet< String > subList= subLists.get( key );
            // Default to largest.
            if( max < subList.size() ) {
                max= subList.size();
                selectedKey= key;
            }
        }
        return selectedKey;
    }
    
    /**
     * Checks the set to see if word is contained in the list of words. If it is
     *  the player is given a random chance out of the set to win the game.
     * 
     * @param word is the word to check.
     * 
     * @return true if guess wins the game.
     * 
     * @throws NullPointerException when word is null.
     * @throws IllegalArgumentException when word is empty.
     */
    @Override
    public boolean chooseWord( String word ) {
        if( word == null )
            throw new NullPointerException();
        if( word.isEmpty() )
            throw new IllegalArgumentException();
        if( wordCanidates.contains( word ) ) {
            // The player can only win when there is one word left in the set.
            if( wordCanidates.size() == 1 )
                return true;
            wordCanidates.remove( word );
        }
        return false;
    }
}
