
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
 * @version 9-19-12
 */
public interface LogicInterface{
    /**
     * Submits a guess. The guess is game word. If the letter is contained in the word
     *  then true is returned.
     * 
     * Preconditions:
     *  startGame must have been called successfully
     *  player must have been added with a call to Manager.addPlayer()
     *  player must be on the active team
     *  
     * Postconditions:
     *  getActiveTeam().nextPlayer() is called
     *  letter is added to the history of guesses
     *  If the guess was correct, the score is incremented.
     *  
     * 
     * @arg playerID is the id of the player generated by the manager
     * @arg letter is the letter to guess
     * 
     * @return True if the guess is found in the word
     * 
     * @throws NullPointerException when player is null.
     * @throws NoSuchElementException when the player is not on the active team.
     * @throws IllegalArgumentException when letter is not a letter i.e. '?' or '9'
     */
    public boolean makeGuess( PlayerInterface player, char letter );
    
    /**
     * Adds a new team and returns the manager of the team.
     * 
     * Preconditions:
     *  startGame() must not have been called.
     * 
     * @return the manager of the new team.
     * 
     * @throws Exception if startGame has already been Called
     */
    //public ManagerInterface addTeam() throws Exception;
    
    /**
     * Gets the team whose turn to guess.
     * 
     * Preconditions:
     *  at least one call to addTeam()
     */
    //public ManagerInterface getActiveTeam();
    
    /**
     * Starts a new game.
     * 
     * Preconditons:
     *  at least one call to addTeam()
     *  at least one call to Manager.addPlayer()
     *  
     * @throw Exception when the preconditions are not met
     */
    //public void startGame();
    
    /**
     * Removes a team from the game. The team will automatically lose. If there is no teams
     *  left in the game, there is no winner. If there is one team left, that team is the
     *  winner. If there are two or more, the game resumes.
     * 
     * Preconditions:
     *  manager must have been created with addTeam().
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
    public void resignTeam( Manager manager ) throws java.util.NoSuchElementException, java.lang.NullPointerException;
    
    /**
     * Rotates teams. Moves the active team to the next team in the game to make a guess.
     * 
     * Preconditions:
     *  at least one call to addTeam()
     * 
     * @throws NoSuchElementException when getNumberOfTeams() == 0
     */
    public void nextTeam() throws java.util.NoSuchElementException;
    
    /**
     * Accesses the number of teams in the game. Returns 0 when Game is first created.
     * 
     * @return the number of teams
     */
    //public int getNumberOfTeams();
    
    
}
