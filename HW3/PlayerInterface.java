
/**
 * Holds player information such as guesses and wrong answers
 * 
 * Private Data:
 *  Guesses - a list of guesses
 *  Wrong Answers - a list of wrong guesses
 * 
 * @author Josh Gillham
 * @version 9-17-12
 */
public interface PlayerInterface {
    /**
     * Lets the player drop the game. The player will automatically lose.
     * 
     * Postconditions:
     *  player cannot do anymore actions
     * 
     * @throws IllegalArgumentException when the player is not in the game
     */
    public void resign();
    
    /**
     * Accesses a list of the player's guesses. Returns an empty string when
     *  there are no guesses otherwise the string contains letters.
     * 
     * @return the letters guessed
     */
    public String getHistory();
    
    /**
     * Accesses the player's score. Returns 0 at the beginning of the game
     *  otherwise the number of letters found in the game word.
     *  
     * @return the score
     */
    public int getScore();
    
}
