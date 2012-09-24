import java.util.List;
import java.util.Iterator;

/**
 * 
 * Allows other objects to take actions on the game logic.
 * 
 * When game is created, it will create a new instance of manger and retain the reference.
 * 
 * A team may have only one player or it may have many players. The game will know which 
 * team is up to bat. The manager should in-turn know which player is up to bat.
 * 
 * Constructor:
 *  Accepts the word length and the max attempts.
 * 
 * Private data summary:
 *  A list of teams (Manager classes)
 *  Guess list
 *  Total Wrong Guesses
 *  Game Word
 *  active team reference
 *  
 * 
 * @author Josh Gillham
 * @version 9-23-12
 */
public class Logic{
    /** The default guesses. */
    static public final int DEFAULT_ATTEMPTS= 5;
    /** The least guesses allowed that make the game interesting. */
    static public final int MIN_ATTEMPTS= 2;
    
    private String gameWord;
    private List< Manager > gameTeams;
    private List< String > guesses;
    private Iterator activeTeam;
    
    /**
     * Checks to make sure teams has no teams with empty rosters. Makes sure there is at least one player
     *  and one team. Makes sure the word length is allowed in the dictionary.
     *  
     * @arg teams the teams for the game.
     * @arg gameWordLength the length of the game word.
     * 
     * @throws NoSuchElementException when teams is empty or any Manager.getRosterSize() returns 0.
     * @throws IllegalArgumentException when gameWordLength is less than Dictionary.MIN_WORDLENGTH
     *  and greater than Dictionary.MAX_WORDLENGTH.
     */
    public Logic( java.util.List< Manager > teams, int gameWordLength ) throws IllegalArgumentException
    { throw new UnsupportedOperationException(); }
    
    /**
     * Checks to make sure teams has no teams with empty rosters. Makes sure there is at least one player
     *  and one team. The gameWord must not be empty or null.
     *  
     * @arg teams the teams for the game.
     * @arg gameWordLength the length of the game word.
     * 
     * @throws NoSuchElementException when teams is empty or any Manager.getRosterSize() returns 0.
     * @throws IllegalArgumentException when gameWord is empty.
     * @throws NullPointerException when gameWord is null.
     */
    public Logic( java.util.List< Manager > teams, String gameWord ) throws IllegalArgumentException
    { throw new UnsupportedOperationException(); }
    
    /**
     * Submits a guess. The guess is game word. If the letter is contained in the word
     *  then true is returned.
     * 
     * Postconditions:
     *  rotateTurn() is called
     *  letter is added to the history of guesses
     *  If the guess was correct, the score is incremented.
     *  If the entire word is guessed, GameEvent.gameWinner is called.
     *  else if the max attempts have been used up, GameEvent.gameOver is called.
     * 
     * @arg letter is the letter to guess
     * 
     * @return True if the guess is found in the word
     * 
     * @throws IllegalArgumentException when letter is not a letter i.e. '?' or '9'
     */
    public boolean makeGuess( char letter )
    { throw new UnsupportedOperationException(); }
    
    /**
     * Removes a team from the game. The team will automatically lose. If there is no teams
     *  left in the game, there is no winner. If there is one team left, that team is the
     *  winner. If there are two or more, the game resumes.
     * 
     * Preconditions:
     *  manager's team must be in the game.
     *  
     * Postconditions:
     *  The manager's team is no longer in the game.
     * 
     * @arg manager the manager of the team to remove.
     * 
     * @throws NoSuchElementException when the manager's team is not in the game.
     * @throws NullPointerException when the manager is null
     */
    //public void resignTeam( Manager manager ) throws java.util.NoSuchElementException, java.lang.NullPointerException;
    
    /**
     * Rotates teams. Moves the active team to the next team in the game to make a guess.
     *  
     * Postconditions:
     *  active team is set to the next team
     *  GameEvent.teamUp() is called
     *  getActiveTeam().nextPlayer() is called
     *  GameEvent.playerUp() is called
     *  
     */
    //public void rotateTurn() throws java.util.NoSuchElementException
    //{ throw new UnsupportedOperationException(); }
    
    /**
     * Accesses the number of teams in the game. Returns 0 when Game is first created.
     * 
     * @return the number of teams
     */
    //public int getNumberOfTeams();
    
    /**
     * Sets the GameEvents handler. Used to pass messages back to the UI. Note that
     *  handler can be null and that will unset the event handler.
     *  
     * @arg handler the new event handler
     */
    public void setGameEventsHandler( GameEvent handler )
    { throw new UnsupportedOperationException(); }
    
    /**
     * Gets the guesses remaining.
     * 
     * @return the number of attempts remaining.
     */
    public int getAttempts()
    { throw new UnsupportedOperationException(); }
}
