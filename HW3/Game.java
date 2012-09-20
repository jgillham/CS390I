
/**
 * This is the instantiated Game class.
 * 
 * Currently the bodies of the methods will be mostly empty.
 * 
 * To begin, this will be used to verify the test itegrity.
 * 
 * @author Josh Gillham
 * @version 9-19-12
 */
public class Game implements GameInterface {
    /** The least guesses allowed that make the game interesting. */
    static public final int MIN_ATTEMPTS= 2;
    /** Empty unimplemented body. */
    public Game( int maxAttempts, int gameWordLength ) throws IllegalArgumentException
    { throw new UnsupportedOperationException(); }
    /** Empty unimplemented body. */
    public boolean makeGuess( PlayerInterface player, char letter ) 
    { throw new UnsupportedOperationException(); }
    /** Empty unimplemented body. */
    public String getWordStatus() 
    { throw new UnsupportedOperationException(); }
    /** Empty unimplemented body. */
    public ManagerInterface addTeam() 
    { throw new UnsupportedOperationException(); }
    /** Empty unimplemented body. */
    public ManagerInterface getActiveTeam() 
    { throw new UnsupportedOperationException(); }
    /** Empty unimplemented body. */
    public void startGame() 
    { throw new UnsupportedOperationException(); }
    /** Empty unimplemented body. */
    public void resignTeam( Manager manager ) throws java.util.NoSuchElementException, java.lang.NullPointerException 
    { throw new UnsupportedOperationException(); }
    /** Empty unimplemented body. */
    public void nextTeam() throws java.util.NoSuchElementException
    { throw new UnsupportedOperationException(); }
    /** Empty unimplemented body. */
    public int getNumberOfTeams()
    { throw new UnsupportedOperationException(); }
}
