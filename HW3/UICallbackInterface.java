
/**
 * This will provide a message infrastructure between the UI and the main.
 * 
 * @author Josh Gillham
 * @version 9-20-12
 */
public interface UICallbackInterface {
    /**
     * Called when the player will make a guess.
     * 
     * @arg letter the guess
     * 
     * @return true if the guess was found or false if not.
     * 
     * @throws IllegalArgumentException if letter is not alphabetic.
     */
    public boolean playerToMakeGuess( char letter ) throws IllegalArgumentException;
    
    /**
     * Called when the player will make a guess.
     * 
     * @arg letter the guess
     * 
     * @return true if the guess was found or false if not.
     * 
     * @throws IllegalArgumentException if word is empty or contains non-alphabetic characters.
     * @throws NullPointerException if word is null.
     */
    public boolean playerToMakeGuess( String word ) throws IllegalArgumentException, java.lang.NullPointerException;
    
    /**
     * Called when the admin sets up the game.
     * 
     * @arg maxAttempts the highest guesses to get the game word.
     * @arg wordLen the length of the game word.
     * 
     * @throws IllegalArgumentException if wordLen is less than Dictionary.MIN_WORDLENGTH
     *  or greater than Dictionary.MAX_WORDLENGTH or if maxAttempts is less than Game.MIN_ATTEMPTS.
     */
    public void completedSetup( int maxAttempts, int wordLen ) throws IllegalArgumentException;
}
