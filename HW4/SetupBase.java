import java.util.List;
import java.util.LinkedList;
/**
 * Provides a setup helper for the Logic class. Makes adding teams and players much easier.
 * 
 * @author Josh Gillham
 * @version 10-4-12
 */
public class SetupBase {    
    /** Hold the team setup. */
    private List< Manager > teams= new LinkedList< Manager >();
    /** Retains the first player to be added.*/
    private Player firstPlayer= null;
    /** Retains the first team to be added.*/
    private Manager firstTeam= null;
    /** Retains the last team to be added. */
    private Manager lastTeam= null;
    /**
     * Load the dictionary file. If this fails, the entire game will fail because
     *  there is no word to choose.
     */
    {
        try {
            Dictionary.load( SetupUI.DICTIONARY_FILE );
        }catch( Exception e ) {}
    }
    
    
    /** 
     * Simplifies adding a manager and retains the first manager to be added.
     * 
     * @param name the team name
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
     * @param name the player name
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
     * Accesses teams.
     * 
     * @return the teams.
     */
    public List< Manager > getTeams() {
        return teams;
    }
}
