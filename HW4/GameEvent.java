/**
 * Allows the Logic to send messages to the GameUI as the game changes.
 * 
 * @author Josh Gillham
 * @version 9-20-12
 */
public interface GameEvent {
    /**
     * Called when the game is finished.
     * 
     * @param gameWord is the word goal for the game.
     */
    public void gameOver( String gameWord );
    
    /**
     * Called when the players are rotated.
     * 
     * @param player the player with the turn to guess.
     */
    public void playerUp( Player player );
    
    /**
     * Called when one team wins the game.
     * 
     * @param team the winning team
     */
    public void gameWinner( Manager team );
    
    /**
     * Lets the UI know when an underscore is replaced
     *  with a letter.
     * 
     * @param statusWord the new status word.
     */
    public void changedStatusWord( String statusWord );
}
