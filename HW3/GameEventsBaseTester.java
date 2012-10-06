
/**
 * Provides a basic implementation of GameEvent.
 * 
 * @author Josh Gillham
 * @version 10-4-12
 */
public class GameEventsBase implements GameEvent {
    Player playerUp= null;
    Manager teamUp= null;
    //String savedGameWord= null;   
    Manager gameWinningTeam= null;        
    boolean gameOver= false;
     //public void teamUp( Manager team ){
    //    teamUp= team;
    //}
    public void playerUp( Player player ){
        playerUp= player;
    }
    public void gameWinner( Manager team ){
        gameWinningTeam= team;
    }
    public void gameOver( String gameWord ) {
        gameOver= true;
    }
    public void changedStatusWord( String statusWord ) {
    }
}
