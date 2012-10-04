/**
 * Allows the Logic to send messages to the GameUI as the game changes.
 * 
 * @author Josh Gillham
 * @version 9-20-12
 */
public interface GameEvent {
    /**
     * Called when the game is finished.
     */
    public void gameOver();
    
    /**
     * Called when the teams are rotated.
     * 
     * @arg team is team who is ready to guess.
     */
    //public void teamUp( Manager team );
    
    /**
     * Called when the players are rotated.
     * 
     * @arg player the player with the turn to guess.
     */
    public void playerUp( Player player );
    
    /**
     * Called when one team wins the game.
     * 
     * @arg team the winning team
     */
    public void gameWinner( Manager team );
    
    /**
     * Lets the UI know when an underscore is replaced
     *  with a letter.
     * 
     * @arg statusWord the new status word.
     */
    public void changedStatusWord( String statusWord );
}
