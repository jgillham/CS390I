/**
 * With new features this may hold the player score and guesses.
 * 
 * @author Josh Gillham
 * @version 9-23-12
 */
public class Player {
    /** Holds the player name. */
    private String name;
    
    /**
     * Creates a new player.
     * 
     * @param name the name of the player.
     * 
     * @throws NullPointerException when the name is null.
     * @throws IllegalArgumentException when the name is empty.
     */
    public Player( String name ) throws NullPointerException, IllegalArgumentException {
        if( name == null )
            throw new NullPointerException();
            
        if( name.isEmpty() )
            throw new IllegalArgumentException();
            
        this.name= name;
    }
}
