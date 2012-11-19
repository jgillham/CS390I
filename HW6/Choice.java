/**
* An alternative item or course of action.
* 
* @author Josh Gillham
* @version 10-29-12
*/
public class Choice {
    /** Holds the default score. */
    public static final int DEFAULT_SCORE = 0;
    /** Holds the final score. */
    private int finalScore = DEFAULT_SCORE;
    /** Holds the choice name. */
    private String name;
    
    /**
    * Constructor that sets the choice name.
    * Default finalScore is 0;
    * 
    * @param theName the name of this choice.
    * 
    * @throws NullPointerException if theName is null.
    */
    public Choice(String theName) {
        if ( theName == null )
            throw new NullPointerException( "theName cannot be null." );
        this.name = theName;
    }
    
    /**
     * Sets the final score.
     * 
     * @param newScore the new score.
     */
    public void setFinalScore(int newScore) {
        this.finalScore = newScore;
    }
    
    /**
     * Accesses the name.
     * 
     * @return the name.
     */
    public String getName() {
        return this.name;
    }
    
    /**
     * Accesses the final score.
     * 
     * @return the final score.
     */
    public int getFinalScore() {
        return this.finalScore;
    }
}
