import java.util.List;
import java.util.LinkedList;
import java.util.Iterator;

/**
 * The Manager class handles players in a team. Responsible for keeping a player roster and 
 *  rotating the players. Will hold addition information as more features are added on.
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
    private int playerUp= 0;
    /** Holds the name of team. */
    private String teamName;
    
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
    public Manager( String name ) throws NullPointerException, IllegalArgumentException {
        if( name == null )
            throw new NullPointerException();
        if( name.isEmpty() ) 
            throw new IllegalArgumentException();
        this.teamName= name;
    }
    
    /**
     * Creates a new player in the Manager class and adds him to the list.
     * 
     * @arg name the player name.
     * 
     * @return the new player.
     * 
     * @throws an IllegalArgumentException when the player's name is empty.
     * @throws an NullPointerException when the player's name is null.
     * 
     * Empty unimplemented body.
     */
    public Player addPlayer( String name ) throws IllegalArgumentException, NullPointerException  {
        Player newPlayer= new Player( name );
        roster.add( newPlayer );
        return newPlayer;
    }
    
    /**
     * Gets the score of the team.
     * 
     * @return the score.
     * 
     * Empty unimplemented body.
     */
    //public int getScore()
    //{ throw new UnsupportedOperationException(); }
    
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
    public Player getPlayerUp() throws java.util.NoSuchElementException {
        // Cannot use this method when the roster is empty.
        if( getRosterSize() == 0 )
            throw new java.util.NoSuchElementException();
        // If the iterator has gone past the end then start back at the beginning.
        if( playerUp == getRosterSize() )
            playerUp= 0;
        return roster.get( playerUp );
    }
    
    /**
     * Gets the roster size with List.size().
     * 
     * @return the number of players on the team.
     * 
     * Empty unimplemented body.
     */
    public int getRosterSize() {
        return roster.size();
    }
    
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
    //public void nextPlayer()
    //{ throw new UnsupportedOperationException(); }
    
    /**
     * Accesses the name of the team.
     * 
     * @return the team name.
     * 
     * Empty unimplemented body.
     */
    //public String getName()
    //{ throw new UnsupportedOperationException(); }
    
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
    //public void resignPlayer( Player player ) throws java.util.NoSuchElementException
    //{ throw new UnsupportedOperationException(); }
}
