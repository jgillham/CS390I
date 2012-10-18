
/**
 * Provides a test intrument for GameEvent. Used by the test classes.
 * 
 * @author Josh Gillham
 * @version 10-4-12
 */
abstract class GameEventsBaseTester implements GameEvent {
    /** Retains information as the callbacks take place. */
    public int badGuesses= 0;
    /** Retains information as the callbacks take place. */
    public int errorGuesses= 0;
    /** Retains information as the callbacks take place. */
    public int ambiguousGuesses= 0;
    /** Retains information as the callbacks take place. */
    public Player playerUp= null;
    /** Retains information as the callbacks take place. */
    public Manager teamUp= null;
    /** Retains information as the callbacks take place. */
    public Manager gameWinningTeam= null;
    /** Retains information as the callbacks take place. */
    public boolean gameOver= false;
    /** Retains information as the callbacks take place. */
    public int statusWordChanges= 0;
    
    /** Used for anomymous classes. */
    public abstract void makeAssertions();
    
    /** Updates callback stats. */
    public void changedStatusWord( String statusWord ) {
        ++statusWordChanges;
    }
    /** Updates callback stats. */
    public void playerUp( Player player ){
        playerUp= player;
    }
    /** Updates callback stats. */
    public void gameWinner( Manager team ){
        gameWinningTeam= team;
    }
    /** Updates callback stats. */
    public void gameOver( String gameWord ) {
        gameOver= true;
    }
        
    /** Makes a guess and keeps stats on the results. */
    public void guess( Logic game, char c ){
        try {
            if( !game.makeGuess( c ) )
                ++badGuesses;
        }catch( Logic.AmbiguousGuessException e ){
            ++ambiguousGuesses;
        }catch( IllegalArgumentException e ) {
            ++errorGuesses;
        }catch( Logic.PlayerOutOfTurnException e ) {
            e.printStackTrace();
        }
    }
    /** Makes a guess and keeps stats on the results. */
    public void guess( Logic game, String guess ){
        try {
            if( !game.makeGuess( guess ) )
                ++badGuesses;
        }catch( Logic.AmbiguousGuessException e ){
            ++ambiguousGuesses;
        }catch( IllegalArgumentException e ) {
            ++errorGuesses;
        }catch( Logic.PlayerOutOfTurnException e ) {
            e.printStackTrace();
        }
    }
}
