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
    /** Has the default word length. */
    private int wordLength= Dictionary.MIN_WORDLENGTH;
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
     * 
     * @throws Logic.EmptyTeamsException when the teams have empty rosters.
     * @throws Logic.NoTeamsException when there are no teams.
     */
    public Logic getGame( ) throws Logic.EmptyTeamsException, Logic.NoTeamsException{
        return new Logic( teams, wordLength );
    }
    
    /**
     * Gets a new instance of the Logic.
     * 
     * @arg wordLength the length of the word to choose.
     * 
     * @return a Logic instance
     * 
     * @throws Logic.EmptyTeamsException when the teams have empty rosters.
     * @throws Logic.NoTeamsException when there are no teams.
     */
    public Logic getGame( int wordLength ) throws Logic.EmptyTeamsException, Logic.NoTeamsException {
        this.wordLength= wordLength;
        return new Logic( teams, wordLength );
    }
    
    /**
     * Gets a new instance of the Logic with a specific game word.
     * 
     * @arg word the game word
     * 
     * @return a Logic instance
     * 
     * @throws Logic.EmptyTeamsException when the teams have empty rosters.
     * @throws Logic.NoTeamsException when there are no teams.
     */
    public Logic getGame( String word) throws Logic.EmptyTeamsException, Logic.NoTeamsException {
        this.wordLength= word.length();
        return new Logic( teams, word );
    }
}
