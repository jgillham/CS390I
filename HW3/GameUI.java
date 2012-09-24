
/**
 * Handles the input from the user and displaying game statuses in response
 *  to game events.
 *  
 * This can be either a console prompt or a java swing panel.
 * 
 * When the player makes a guess or takes another game action, the GameUI
 *  will call methods in the Logic class.
 * 
 * @author Josh Gillham
 * @version 9-23-12
 */
public class GameUI implements GameEvent {
    /**
     * Creates a new instance of GameUI. Responds to user input and takes
     *  game actions.
     *  
     * @arg gameLogic the logic to take game actions on.
     * 
     * @throw NullPointerException when gameLogic is null.
     */
    public GameUI( Logic gameLogic )
    { throw new UnsupportedOperationException(); }
    /** Empty unimplemented body.*/
    public void changedStatusWord( String statusWord )
    { throw new UnsupportedOperationException(); }
    /** Empty unimplemented body. */
    public void gameOver()
    { throw new UnsupportedOperationException(); }
    /** Empty unimplemented body. */
    public void teamUp( Manager team )
    { throw new UnsupportedOperationException(); }
    /** Empty unimplemented body. */
    public void playerUp( Player player )
    { throw new UnsupportedOperationException(); }
    /** Empty unimplemented body. */
    public void gameWinner( Manager team )
    { throw new UnsupportedOperationException(); }
}
