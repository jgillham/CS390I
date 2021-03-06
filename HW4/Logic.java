import java.util.List;
import java.util.LinkedList;
import java.util.Iterator;
import java.util.Set;
import java.util.Map;
import java.util.SortedSet;
import java.util.TreeSet;
import java.lang.StringBuilder;

/**
 * Controls the game. Updates the UI. Determines the outcome of the game. Allows player to take action on the game
 * 
 * @author Josh Gillham
 * @version 9-23-12
 */
public class Logic{
    /** The default guesses. */
    static public final int DEFAULT_ATTEMPTS= 5;
    /** The least guesses allowed that make the game interesting. */
    static public final int MIN_ATTEMPTS= 2;
    /** The default word size. */
    static public final int DEFAULT_WORD_SIZE= 5;
    /** Used to show the game state. */
    static public enum Statis {
        STARTED,
        OVER,
        WINNER
    }
    
    /** Thrown to signal when a guess has been repeated. */
    public class AmbiguousGuessException extends Exception {}
    /** Thrown to signal bad constructor arguments where teams contain empty rosters. */
    public class EmptyTeamsException extends Exception {}
    /** Thrown to signal bad constructor arguments when the team's list is empty. */
    public class NoTeamsException extends Exception {}
    /** Thrown when makeGuess() is called twice in a row. */
    public class PlayerOutOfTurnException extends Exception {}
    
    /** Holds the potiential words. */
    protected WordCanidates wordCanidates;
    
    /** Holds the teams in the game. */
    private List< Manager > gameTeams;
    /** Holds the guess made. */
    private SortedSet< String > guesses= new TreeSet< String >();
    /** Refers to the team with the turn to guess. */
    private int activeTeam= 0;
    /** Holds the call back for events during the game. Allows this class to send messages to the UI. */
    private GameEvent eventHandler= null;
    /** Holds the maximum guess allowed during the game. */
    private int maxGuesses= DEFAULT_ATTEMPTS;
    /** True if the player still needs to take a turn. */
    private boolean playerInTurn= true;
    /** Holds the game statis. */
    private Statis gameState= Statis.STARTED;
    
    /**
     * Checks to make sure teams has no teams with empty rosters. Makes sure there is at least one player
     *  and one team. The gameWord must not be empty or null.
     *  
     * @param teams the teams for the game.
     * @param gameWordLength the length of the game word.
     * 
     * @throws EmptyTeamsException when any Manager.getRosterSize() returns 0.
     * @throws NoTeamsException when teams is empty.
     * @throws IllegalArgumentException when gameWordLength is out of range
     *  of the dictionary limits.
     */
    public Logic( List< Manager > teams, int gameWordLength ) throws EmptyTeamsException, NoTeamsException  {
        if( !Dictionary.getInstance().checkWordLength( gameWordLength ) )
            throw new IllegalArgumentException();
        
        checkTeams( teams );
        wordCanidates= new WordCanidates( makeStatusWord( gameWordLength ), Dictionary.getInstance().getSet( gameWordLength ) );
        
        gameTeams= teams;
    }
    
    /**
     * Checks to make sure teams has no teams with empty rosters. Makes sure there is at least one player
     *  and one team. The gameWord must not be empty or null.
     * 
     * PostConditions:
     * -wordCanidates has at least one word.
     * 
     * @param teams the teams for the game.
     * @param gameWord the word to guess
     * 
     * @throws EmptyTeamsException when any Manager.getRosterSize() returns 0.
     * @throws NoTeamsException when teams is empty.
     * @throws IllegalArgumentException when gameWord is empty
     * @throws NullPointerException when gameWord is null.
     */
    public Logic( List< Manager > teams, String gameWord ) throws EmptyTeamsException, NoTeamsException  {
        if( gameWord == null )
            throw new NullPointerException();
        if( gameWord.isEmpty() )
            throw new IllegalArgumentException();
        
        this.checkTeams( teams );
        
        this.gameTeams= teams;
        
        SortedSet< String > temp= new TreeSet< String >();
        temp.add( gameWord );
        this.wordCanidates= new WordCanidates( makeStatusWord( gameWord.length() ), temp );
    }
    
    /**
     * Checks the teams argument for a bad value.
     * 
     * @param teams a list of teams.
     * 
     * @throws EmptyTeamsException when any Manager.getRosterSize() returns 0.
     * @throws NoTeamsException when teams is empty.
     */
    private final void checkTeams( List< Manager > teams ) throws EmptyTeamsException, NoTeamsException {
        if( teams.size() == 0 )
            throw new NoTeamsException();
        
        // Make sure all teams have at least one player.
        for( Manager team: teams ) {
            if( team.getRosterSize() == 0 )
                throw new EmptyTeamsException();
        }
    }
    
    /**
     * Initializes the statusWord.
     * 
     * @param wordLength the length of the word.
     * 
     * @returns the status word.
     * 
     * @throws IllegalArgumentException when word length is less than 1.
     */
    public String makeStatusWord( int wordLength ) {
        if( wordLength < 1 )
            throw new IllegalArgumentException();
        StringBuilder statusWord= new StringBuilder();
        for( int i= 0; i < wordLength; ++i )
            statusWord.append( '-' );
        return statusWord.toString();
    }
    
    /**
     * Submits a guess. If the guess is not a letter, an error is thrown. If
     *  the letter has been guessed before an error is thrown. Else, the 
     *  guess is noted and the game word is searched for the letter. For
     *  ever letter that was found, the game updates the status word 
     *  replacing the mask with the letter. If any letter is found the
     *  function returns true and eventHandler.changedStatusWord is called,
     *  otherwise the function returns false.
     * 
     * Postconditions:
     *  List of guesses grows.
     *  Status word is updated for each letter found.
     *  eventHandler.changedStatusWord is called if any letter is found.
     *  Player is now off turn.
     * 
     * @param letter is the letter to guess
     * 
     * @return True if the guess is found in the word
     * 
     * @throws IllegalArgumentException when letter is not a letter i.e. '?' or '9'
     * @throws AmbiguousGuessException when the letter is already guessed.
     * @throws PlayerOutOfTurnException when the player has already guessed. Called
     *  should also call rotateTurn() after this method everytime unless an error
     *  is thrown.
     */
    public boolean makeGuess( char letter ) throws AmbiguousGuessException, PlayerOutOfTurnException {
        if( !playerInTurn )
            throw new PlayerOutOfTurnException();
        if( !Character.isLetter( letter ) )
            throw new IllegalArgumentException();
        letter= Character.toLowerCase( letter );
        String guess= Character.toString( letter );
        // Make sure this guess has never been guessed before.
        for( String oldGuess: guesses ) {
            if( oldGuess.length() == guess.length() )
                if( guess.equalsIgnoreCase( oldGuess ) )
                    throw new AmbiguousGuessException( );
        }
        // Add this guess to the list.
        this.guesses.add( guess );
        this.playerInTurn= false;
        boolean found= false;
        Map< String, SortedSet< String > > subLists= wordCanidates.subDivide( letter );
        Set< String > keys= subLists.keySet();
        String selectedKey= null;
        if( keys.size() == 1 ) {
            selectedKey= keys.iterator().next();
        } else {
            selectedKey= chooseKey( subLists );
        }
        if( selectedKey == null )
            throw new java.lang.AssertionError( "Key was not selected." );
            
        SortedSet< String > subList= subLists.get( selectedKey );
        wordCanidates= new WordCanidates( selectedKey, subList );
        if( selectedKey.indexOf( letter ) > -1 ) {
            found= true;
            // Show the UI the new found letters.
            if( this.eventHandler != null && found )
                this.eventHandler.changedStatusWord( wordCanidates.getStatusWord() );
        }
        return found;
    }
    
    /**
     * Chooses the key randomly.
     * 
     * @param keys the set of keys.
     * 
     * @return the key.
     */
    public String chooseKey( Map< String, SortedSet< String > > subLists ) {
        if( subLists == null )
            throw new NullPointerException();
        if( subLists.size() == 0 )
            throw new IllegalArgumentException();
        List< String > keyList= new LinkedList< String >( subLists.keySet() );
        int index= (int)(Math.random() * keyList.size() );
        return keyList.get( index );
    }
    
    /**
     * Submits a guess. If the guess length is only 1 characterIf the guess contains a non-letter, an error is thrown. If
     *  the letter has been guessed before an error is thrown. Else, the 
     *  guess is noted and the game word is compared to that word.
     * 
     * Preconditions:
     *  -rotate turn must have been called.
     * 
     * Post Conditions:
     *  -Player is not in turn.
     *  
     * @param word is a guess for the game word.
     * 
     * @return True if the guess is the game word.
     * 
     * @throws NullPointerException when word is null.
     * @throws IllegalArgumentException when word is empty or not equal to the length of the game word.
     * @throws IllegalArgumentException when the guess contains non-letters i.e. '?' or '9'
     * @throws AmbiguousGuessException when the guess is already guessed.
     */
    public boolean makeGuess( String word ) throws AmbiguousGuessException, PlayerOutOfTurnException {
        if( !playerInTurn )
            throw new PlayerOutOfTurnException();
        if( word == null )
            throw new NullPointerException();
            
        if( word.length() == 1 ) {
            return this.makeGuess( word.charAt( 0 ) );
            
        }else if( word.length() != this.wordCanidates.getWordLength() ) {
            throw new IllegalArgumentException();
        }
        for( int i= 0; i < word.length(); ++i ) {
            if( !Character.isLetter( word.charAt( i ) ) )
                throw new IllegalArgumentException();
        }
        this.guesses.add( word );
        this.playerInTurn= false;
        boolean wins= false;
        if( wins= chooseWord( word ) ) {
            SortedSet< String > temp= new TreeSet< String >();
            temp.add( word );
            wordCanidates= new WordCanidates( word, temp );
            if( this.eventHandler != null )
                this.eventHandler.changedStatusWord( word );
        }
        return wins;
    }
    
    /**
     * Checks the set to see if word is contained in the list of words. If it is
     *  the player is given a random chance out of the set to win the game.
     * 
     * Post Conditions:
     *  -Words from bad guesses are removed from the set.
     * 
     * @param word is the word to check.
     * 
     * @return true if guess wins the game.
     */
    public boolean chooseWord( String word ) {
        if( word == null )
            throw new NullPointerException();
        if( word.isEmpty() )
            throw new IllegalArgumentException();
        if( wordCanidates.contains( word ) ) {
            int rand= (int)( Math.random() * wordCanidates.size() );
            if( rand == 0 )
                return true;
            wordCanidates.remove( word );
        }
        return false;
    }
    
    /**
     * Can be called as much as the caller would like. Should be called to rotate the turns and
     *  prompt the UI to receive the next guess. If the word is completely guessed, the game is
     *  over and one team is the winner. If there are no more guesses remaining, the game
     *  is over and there is no winner. If the current player has not maid a guess, the call is
     *  ignored. Else, the players and teams are rotated and the game signals the UI that the
     *  next player can guess.
     *  
     * Postconditions:
     *  The current team's players are rotated.
     *  The teams are rotated.
     *  The play up on the active team is in-turn.
     *  
     */
    public void rotateTurn()  {
        // Check to see if all the letters are guessed.
        if( wordCanidates.getStatusWord().indexOf( '-' ) == -1 ){
            this.gameState= Statis.WINNER;
            if( this.eventHandler != null )
                this.eventHandler.gameWinner( this.gameTeams.get( activeTeam ) );
            return;
        }
        // Check to see if there no guesses remaining
        if( this.guesses.size() >= this.maxGuesses ){
            this.gameState= Statis.OVER;
//             if( this.gameWord== null )
//                 this.gameWord= wordCanidates.getRandomCanidate();
            if( this.eventHandler != null )
                this.eventHandler.gameOver( wordCanidates.getRandomCanidate() );
            return;
        }
        // Make sure its the player's turn.
        this.playerInTurn= true;
        // Player still needs to make a guess.
        if( this.playerInTurn ) {
            if( this.eventHandler != null )
                this.eventHandler.playerUp( this.gameTeams.get( this.activeTeam ).getPlayerUp() );
            return;
        }
        // Rotate players
        this.gameTeams.get( activeTeam ).nextPlayer();
        // Rotate the teams
        if( this.activeTeam == this.gameTeams.size() - 1 )
            this.activeTeam= 0;
        else
            ++this.activeTeam;
        // Notify UI
        if( this.eventHandler != null )
            this.eventHandler.playerUp( this.gameTeams.get( this.activeTeam ).getPlayerUp() );
    }
    
    /**
     * Sets the GameEvents handler. Used to pass messages back to the UI. Note a
     *  null handler will unset the event handler.
     *  
     * Post Conditions:
     *  -game event handler will now receive events.
     *  
     * @param handler the new event handler
     */
    public void setGameEventsHandler( GameEvent handler ) {
        this.eventHandler= handler;
        if( this.eventHandler != null ) {
            // Show the initial state of the status word.
            this.eventHandler.changedStatusWord( wordCanidates.getStatusWord().toString() );
            // First player to guess.
            this.eventHandler.playerUp( gameTeams.get( activeTeam ).getPlayerUp()  );
        }
    }
    
    /**
     * Gets the remaining guesses.
     * 
     * @return the number of guesses remaining.
     */
    public int getRemainingGuesses() {
        return maxGuesses - this.guesses.size();
    }
    
    /**
     * Accesses the game state which tells whether the game is in progress, over ect.
     * 
     * @return the game statis.
     */
    public Statis getGameState() {
        return gameState;
    }
    
    /**
     * Sets the max guesses.
     * 
     * Post Conditions:
     * -The max guesses is set.
     * 
     * @param nMaxGuesses the new number of maximum guesses.
     * 
     * @return the number of attempts remaining.
     * 
     * @throws IllegalArgumentException when nMaxGuesses < Logic.MIN_ATTEMPTS.
     */
    public void setMaxAttempts( int nMaxGuesses ) {
        if( nMaxGuesses < MIN_ATTEMPTS )
            throw new IllegalArgumentException();
        this.maxGuesses= nMaxGuesses;
    }
    
    /**
     * Used to access the history of guesses for all players and all teams.
     * 
     * @return an array of guesses.
     */
    public String[] getGuesses() {
        String[] guessesList= new String[guesses.size()];
        int i= 0;
        for( String guess: guesses ) {
            guessesList[ i++ ]= guess;
        }
        return guessesList;
    }
}
