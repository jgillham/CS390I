import java.util.List;
import java.util.LinkedList;
import java.util.Iterator;

/**
 * The Manager class handles players in a team. Responsible for keeping a player roster and the
 *  teams score.
 * 
 * Keeps a list of Guesses for players in list.
 * Keeps a running total of wrong answers.
 * 
 * @author Josh Gillham
 * @version 9-18-12
 */
public class Manager {

    /** Keeps a list of players. Hides direct access to the player's data. */
    private List< Player > roster= new LinkedList< Player >();
    /** The number of successful guesses. */
    private int score= 0;
    /** Refers to the player with the turn next. */
    private Iterator playerUp;
    
    /**
     * Creates a new empty team.
     * 
     * @arg name the team name.
     * 
     * @throws NullPointerException if is name is null.
     * @throws IllegalArgumentException if name is empty.
     * 
     * Empty unimplemented body.
     */
    public Manager( String name )
    { throw new UnsupportedOperationException(); }
    
    /**
     * Creates a new player in the Manager class and adds him to the list.
     * 
     * @arg name the player name.
     * 
     * @return the new player.
     * 
     * @throws an IllegalArgumentException when the player's name is invalid.
     * @throws an NullPointerException when the player's name is null.
     * 
     * Empty unimplemented body.
     */
    public Player addPlayer( String name )
    { throw new UnsupportedOperationException(); }
    
    /**
     * Gets the score of the team.
     * 
     * @return the score.
     * 
     * Empty unimplemented body.
     */
    public int getScore()
    { throw new UnsupportedOperationException(); }
    
    /**
     * Gets the players whose turn it is to guess.
     * 
     * Preconditions:
     *  addPlayer must have been successfully called at least once.
     * 
     * @return the player.
     * 
     * @throws NoSuchElementException when getRosterSize() == 0.
     * 
     * Empty unimplemented body.
     */
    public Player getPlayerUp()
    { throw new UnsupportedOperationException(); }
    
    /**
     * Gets the roster size with List.size().
     * 
     * @return the number of players on the team.
     * 
     * Empty unimplemented body.
     */
    public int getRosterSize()
    { throw new UnsupportedOperationException(); }
    
    /**
     * Sets the player up to the next player in the line up.
     * 
     * Preconditions:
     *  addPlayer must have been successfully called at least once.
     * 
     * @throws NoSuchElementException when getRosterSize() == 0.
     * 
     * Empty unimplemented body.
     */
    public void nextPlayer()
    { throw new UnsupportedOperationException(); }
    
    /**
     * Accesses the name of the team.
     * 
     * @return the team name.
     * 
     * Empty unimplemented body.
     */
    public String getName()
    { throw new UnsupportedOperationException(); }
    
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
     *  
     *  Empty unimplemented body.
     */
    public void resignPlayer( Player player ) throws java.util.NoSuchElementException
    { throw new UnsupportedOperationException(); }
}
