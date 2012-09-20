
/**
 * This is the instantiated Game class.
 * 
 * Currently the bodies of the methods will be mostly empty.
 * 
 * To begin, this will be used to verify the test itegrity.
 * 
 * @author Josh Gillham
 * @version 9-19-12
 */
public class Game implements GameInterface {

    public Game( int maxAttempts, int gameWordLength ){
        throw new IllegalArgumentException();
    }
    /**
     * Submits a guess. The guess is game word. If the letter is contained in the word
     *  then true is returned.
     * 
     * @arg playerID is the id of the player generated by the manager
     * @arg letter is the letter to guess
     * 
     * @return True if the guess is found in the word
     * 
     * @throws IllegalArgumentException when playerID does not represent a player
     * @throws IllegalArgumentException when letter is not a letter i.e. '?' or '9'
     */
    public boolean makeGuess( PlayerInterface player, char letter ) {
        return false;
    }
    /**
     * Gets the current word with underscores representing unguessed letters.
     * 
     * Used by the GUI to display to the players.
     * 
     * @return the word with underscores
     */
    public String getWordStatus() {
        return null;
    }
    
    /**
     * Adds a new team and returns the manager of the team.
     * 
     * @return the manager of the new team.
     */
    public ManagerInterface addTeam() {
        return null;
    }
    
    /**
     * Gets the team whose turn to guess.
     * 
     * Preconditions:
     *  at least one call to addTeam()
     *  at least one call to Manager.addPlayer()
     *  startGame() must have been called.
     * 
     * 
     */
    public ManagerInterface getActiveTeam() {
        return null;
    }
    
    /**
     * Starts a new game.
     * 
     * Preconditons:
     *  at least one call to addTeam()
     *  at least one call to Manager.addPlayer()
     */
    public void startGame() {
        return;
    }
}
