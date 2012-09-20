
/**
 * This currently contains only empty bodies for test integrity.
 * 
 * @author Josh Gillham
 * @version 9-19-12
 */
public class Player implements PlayerInterface {
    /**
     * Initializes Player with the name.
     * 
     * @arg name the player's name
     * 
     * @throws NullPointerException when name is null
     * @throws IllegalArgumentsException when name is empty
     */
    public Player( String name ) throws NullPointerException, IllegalArgumentException {
        throw new UnsupportedOperationException();
    }
    
    /**
     * Accesses a list of the player's guesses. Returns an empty string when
     *  there are no guesses otherwise the string contains letters.
     * 
     * @return the letters guessed
     */
    public String getHistory() { return null; }
    
    /**
     * Accesses the player's score. Returns 0 at the beginning of the game
     *  otherwise the number of letters found in the game word.
     *  
     * @return the score
     */
    public int getScore() { return -1; }
}
