
/**
 * Provides a test intrument for GameEvent.
 * 
 * @author Josh Gillham
 * @version 10-4-12
 */
abstract class GameEventsBaseTester implements GameEvent {
    int badGuesses= 0;
    int errorGuesses= 0;
    int ambiguousGuesses= 0;
    
    Player playerUp= null;
    Manager teamUp= null;
    //String savedGameWord= null;   
    Manager gameWinningTeam= null;        
    boolean gameOver= false;
     //public void teamUp( Manager team ){
    //    teamUp= team;
    //}
    public int statusWordChanges= 0;
    public void changedStatusWord( String statusWord ) {
        ++statusWordChanges;
    }
    public void playerUp( Player player ){
        playerUp= player;
    }
    public void gameWinner( Manager team ){
        gameWinningTeam= team;
    }
    public void gameOver( String gameWord ) {
        gameOver= true;
    }
        
    public abstract void makeAssertions();
    public void guess( Logic game, char c ){
        System.out.println( "guess: " + c );
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
    public void guess( Logic game, String guess ){
        System.out.println( "guess: " + guess );
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
