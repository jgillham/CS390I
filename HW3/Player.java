
/**
 * Holds player information such as guesses and wrong answers. This is
 *  currently unused but will be used when new features are added.
 * 
 * Private Data:
 *  Guesses - a list of guesses
 *  Wrong Answers - a list of wrong guesses
 * 
 * @author Josh Gillham
 * @version 9-17-12
 */
public class Player {
    /**
     * Creates a new player.
     * 
     * @arg name the name of the player.
     * 
     * @throws NullPointerException when the name is null.
     * @throws IllegalArgumentException when the name is empty.
     * 
     * Empty unimplemented body.
     */
    public Player( String name ) throws NullPointerException, IllegalArgumentException
    { throw new UnsupportedOperationException(); }
    
    /**
     * Accesses the name of the player.
     * 
     * @return the player name.
     */
    //public String getName()
    //{ throw new UnsupportedOperationException(); }
    
    /**
     * Accesses a list of the player's guesses. Returns an empty string when
     *  there are no guesses otherwise the string contains letters.
     * 
     * @return the letters guessed
     */
    //public String getHistory()
    //{ throw new UnsupportedOperationException(); }
    
    /**
     * Accesses the player's score. Returns 0 at the beginning of the game
     *  otherwise the number of letters found in the game word.
     *  
     * @return the score
     */
    //public int getScore()
    //{ throw new UnsupportedOperationException(); }
}
