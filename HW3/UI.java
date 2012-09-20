
/**
 * Provides an infrastructure to allow the UI to respond to game events.
 * 
 * @author Josh Gillham
 * @version 9-20-12
 */
public interface UI
{
    /**
     * Will announce that the game has finished.
     */
    public void gameOver();
    
    /**
     * Will announce which team whose turn it is to guess.
     * 
     * @arg team the Manager class for the team with the turn.
     */
    public void teamUp( Manager team );
    
    /**
     * Announces which player whose turn it is to guess.
     * 
     * @arg player the player with the turn
     */
    public void playerUp( Player player );
    
    /**
     * Announces the team that won the game.
     * 
     * @arg team the winning team
     */
    public void gameWinnder( Manager team );
}
