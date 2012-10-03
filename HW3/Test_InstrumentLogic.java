import java.util.List;
import java.util.LinkedList;
/**
 * This class provides a scaffolding tool for test units. The purpose is 
 *  to set defaults arguments for the constructor, simplify setup, and retain values for testing.
 *  
 * @author  Josh Gillham
 * @version 9-23-12
 */
class Test_InstrumentLogic implements GameEvent {
    {
        Dictionary.load( SetupUI.DICTIONARY_FILE );
    }
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
    
    Player playerUp= null;
    Manager teamUp= null;
    String savedGameWord= null;        
    Manager gameWinningTeam= null;        
    boolean gameOver= false;        
    int statusWordChanges= 0;
    
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
    public Logic getInstance() {
        return new Logic( teams, wordLength );
    }
    
    /**
     * Gets a new instance of the Logic with a specific game word.
     * 
     * @arg word the game word
     * 
     * @return a Logic instance
     */
    public Logic getInstance( String word) {
        return new Logic( teams, word );
    }
    
    //public void teamUp( Manager team ){
    //    teamUp= team;
    //}
    //public void playerUp( Player player ){
    //    playerUp= player;
    //}
    public void gameWinner( Manager team ){
        gameWinningTeam= team;
    }
    public void gameOver() {
        gameOver= true;
    }
    public void changedStatusWord( String statusWord ) {
        ++statusWordChanges;
    }
}
