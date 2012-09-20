
/**
 * The Manager class handles players in a team.
 * 
 * Keeps a list of players. Hides direct access to the player's data.
 * Keeps a list of Guesses for players in list.
 * Keeps a running total of wrong answers.
 * 
 * Private Data:
 *  Players - a linkedlist of players
 *  Score - number of successful guesses
 *  Player up - the player who has the turn to guess
 * 
 * @author Josh Gillham
 * @version 9-18-12
 */
public interface ManagerInterface
{
    /**
     * Creates a new player in the Manager class and adds him to the list.
     * 
     * @return the id of the new player.
     * 
     * @throws an IllegalArgumentException when the player's name is invalid.
     * @throws an NullPointerException when the player's name is null.
     */
    public PlayerInterface addPlayer( String name );
    /**
     * The manager can kick a player off the list.\
     * 
     * Preconditions:
     *  addPlayer must have been successfully called at least once.
     * 
     * @return true if the kick was successful or false if not.
     * 
     * @throws an NullPointerException when player is null
     */
    public boolean kickPlayer( PlayerInterface player );
    
    /**
     * Gets the score of the team.
     * 
     * @return the score.
     */
    public int getScore();
    
    /**
     * Gets the players whose turn it is to guess.
     * 
     * Preconditions:
     *  addPlayer must have been successfully called at least once.
     * 
     * @return the player.
     * 
     * @throws NoSuchElementException when getRosterSize() == 0.
     */
    public PlayerInterface getPlayerUp();
    
    /**
     * Gets the roster size with List.size().
     * 
     * @return the number of players on the team.
     */
    public int getRosterSize();
    
    /**
     * Sets the player up to the next player in the line up.
     * 
     * Preconditions:
     *  addPlayer must have been successfully called at least once.
     * 
     * @throws NoSuchElementException when getRosterSize() == 0.
     */
    public void nextPlayer();
    
    /**
     * Accesses the name of the team.
     * 
     * @return the team name
     */
    public String getName();
    
    /**
     * Removes the player from the roster and changes the player up as needed.
     * 
     * Preconditions:
     *  The player must have been created with addPlayer() successfully
     * 
     * Postconditions:
     *  The player no longer exists on the roster.
     *  
     * @throws NoSuchElementException when getRosterSize() == 0 or the player is
     *  not on the roster.
     */
    public void resignPlayer( Player player ) throws java.util.NoSuchElementException;
}
