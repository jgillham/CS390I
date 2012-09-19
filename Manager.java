
/**
 * The Manager class handles players in a team.
 * 
 * Keeps a list of players. Hides direct access to the player's data.
 * Keeps a list of Guesses for players in list.
 * Keeps a running total of wrong answers.
 * 
 * Private Data:
 *  Players - a linkedlist of players
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public interface Manager
{
    /**
     * Creates a new player in the Manager class and adds him to the list.
     * 
     * @return the id of the new player
     */
    public int newPlayer();
    /**
     * The manager can kick a player off the list.\
     * 
     * @return true if the kick was successful
     */
    public boolean kickPlayer( int playerID );
}
