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
     * @param gameLogic the logic to take game actions on.
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
     * @param statusWord the word with some letters masked with underscores.
     */
    public void changedStatusWord( String statusWord ) {
        this.statusWord= statusWord;
    }
    
    /**
     * Called when the game is finished. Announces the end of the game
     *  to the players.
     *  
     * @param gameWord is the word goal for the game.
     */
    public void gameOver( String gameWord ) {
        // Show the word nobody could guess.
        System.out.println( "Word: " + gameWord );
        System.out.println( "Game over. Sorry!" );
    }
    
    /**
     * Called when players are rotated. Announces the next 
     *  player with the turn to guess.
     * 
     * @param player the player with the turn to guess.
     */
    public void playerUp( Player player ) {
        Scanner inputScanner= new Scanner( System.in );
        // Show game status'
        System.out.println( "Remaining Guesses: " + gameLogic.getRemainingGuesses() );
        System.out.println( "Word: " + statusWord );
        String[] oldGuesses= gameLogic.getGuesses();
        if( oldGuesses != null  ) {
            boolean first= true;
            System.out.print( "Guesses: " );
            for( String guess: oldGuesses ) {
                if( !first )
                    System.out.print( ", " );
                else
                    first=false;
                System.out.print( guess );
            }
            System.out.print( '\n' );
        }
        // Prompt the user.
        System.out.println( "Make a guess (a letter or the whole word):" );
        String input= inputScanner.next();
        if( input.length() == statusWord.length() || input.length() == 1 ) {
            try{
                boolean result= gameLogic.makeGuess( input );
                // Display feedback.
                if( result )
                    System.out.println( "Good guess!" );
                else
                    System.out.println( "Sorry that was a bad guess!" );
            } catch( IllegalArgumentException e ){
                // Bad input could be a symbol or maybe the letter is alread guessed.
                System.out.println( "Guesses should contain only letter(s)." );
            } catch( Logic.AmbiguousGuessException e ) {
                System.out.println( "That letter has alread been guessed." );
            } catch( Logic.PlayerOutOfTurnException e ) {
                e.printStackTrace();
            }
        } else
            System.out.println( "A letter or the whole word please." );
        System.out.println();
    }
    
    /**
     * Called when one team wins the game. Announces the winner.
     * 
     * @param team the winner.
     */
    public void gameWinner( Manager team ) {
        System.out.println( "Word: " + statusWord );
        System.out.println( "Player won the game!" );
    }
}
