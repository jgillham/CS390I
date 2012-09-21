
/**
 * This will provide a message infrastructure between the UI and the main.
 * 
 * @author Josh Gillham
 * @version 9-20-12
 */
public interface SetupEvent {
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
