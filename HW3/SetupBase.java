import java.util.List;
import java.util.LinkedList;
/**
 * Provides a basic setup for Logic.
 * 
 * @author Josh Gillham
 * @version 10-4-12
 */
public class SetupBase {
    
    /** Hold the team setup. */
    List< Manager > teams= new LinkedList< Manager >();
    /** Has the default word length. */
    int wordLength= Dictionary.MIN_WORDLENGTH;
    /** Retains the first player to be added.*/
    Player firstPlayer= null;
    /** Retains the first team to be added.*/
    Manager firstTeam= null;
    /** Retains the last team to be added. */
    Manager lastTeam= null;
    
    public SetupBase() throws java.io.FileNotFoundException {
        Dictionary.load( SetupUI.DICTIONARY_FILE );
    }
    
    /** 
     * Simplifies adding a manager and retains the first manager to be added.
     * 
     * @arg name the team name
     * 
     * @return the new manager
     */
    public Manager addManager( String name ) {
        Manager man= new Manager( name );
        teams.add( man );
        if( firstTeam == null )
            firstTeam= man;
        return lastTeam=man;
    }
    
    /**
     * Simplifies adding a player to a team and retains the first player added.
     * 
     * @arg name the player name
     * 
     * @return the new player
     */
    public Player addPlayer( String name ) {
        if( lastTeam == null )
            addManager( "Default" );
        Player player= lastTeam.addPlayer( name );
        if( firstPlayer == null )
            firstPlayer= player;
        return player;
    }
    
    /**
     * Gets a new instance of the Logic.
     * 
     * @return a Logic instance
     */
    public Logic getGame() {
        return new Logic( teams, wordLength );
    }
    
    /**
     * Gets a new instance of the Logic with a specific game word.
     * 
     * @arg word the game word
     * 
     * @return a Logic instance
     */
    public Logic getGame( String word) {
        return new Logic( teams, word );
    }
}
