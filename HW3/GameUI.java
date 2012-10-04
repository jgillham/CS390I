import java.util.Scanner;
/**
 * Handles the input from the user and displaying game statuses in response
 *  to game events. Will be either a console prompt or a java swing panel. 
 *  Methods in the Logic class are called when the player makes a guess or 
 *  takes another game action.
 *  
 * Note: GameEvent methods are tested in testGameEvent
 * 
 * @author Josh Gillham
 * @version 9-23-12
 */
public class GameUI implements GameEvent {
    /** Holds a reference to the game. */
    private Logic gameLogic;
    /** Holds the game word but with masked letters where no player has guessed. */
    private String statusWord;
    
    /**
     * Displays the game interface to the players.
     * 
     * @arg gameLogic the logic to take game actions on.
     * 
     * @throw NullPointerException when gameLogic is null.
     */
    public GameUI( Logic gameLogic ) {
        if( gameLogic == null )
            throw new NullPointerException();
        this.gameLogic= gameLogic;
    }
    
    /**
     * Called after a guess is made. Displays the status word to the user.
     * 
     * @arg statusWord the word with some letters masked with underscores.
     * 
     * Empty unimplemented body.
     */
    public void changedStatusWord( String statusWord ) {
        this.statusWord= statusWord;
        // Show the current progress on guessing.
        System.out.println( statusWord );
    }
    
    /**
     * Called when the game is finished. Announces the end of the game
     *  to the players.
     * 
     * Empty unimplemented body.
     */
    public void gameOver( String gameWord ) {
        // Show the word nobody could guess.
        System.out.println( gameWord );
        System.out.println( "Game has finished." );
    }
    
    /**
     * Called teams are rotated. Announces the team whose turn
     *  it is to guess.
     * 
     * @arg team the team to take a turn.
     * 
     * Empty unimplemented body.
     */
    //public void teamUp( Manager team )
    //{ throw new UnsupportedOperationException(); }
    
    /**
     * Called when players are rotated. Announces the next 
     *  player with the turn to guess.
     * 
     * @arg player the player with the turn to guess.
     * 
     * Empty unimplemented body.
     */
    public void playerUp( Player player ) {
        Scanner inputScanner= new Scanner( System.in );
        // Prompt the user.
        System.out.println( "Make a guess:" );
        String input= inputScanner.next();
        if( input.length() > 1 )
            System.out.println( "Only one letter please." );
        else {
            try{
                boolean result= gameLogic.makeGuess( input.charAt( 0 ) );
                // Display feedback.
                if( result )
                    System.out.println( "Good guess!" );
                else
                    System.out.println( "Sorry that was a bad guess!" );
            } catch( IllegalArgumentException e ){
                // Bad input could be a symbol or maybe the letter is alread guessed.
                System.out.println( e.getMessage() );
            }
        }        
    }
    
    /**
     * Called when one team wins the game. Announces the winner.
     * 
     * @arg team the winner.
     * 
     * Empty unimplemented body.
     */
    public void gameWinner( Manager team ) {
        System.out.println( statusWord );
        System.out.println( "Player won the game!" );
    }
}
