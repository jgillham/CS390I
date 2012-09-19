
/**
 * Holds player information such as guesses and wrong answers
 * 
 * Private Data:
 *  Guesses - a list of guesses
 *  Wrong Answers - a list of wrong guesses
 * 
 * @author Josh Gillham
 * @version 9-17-12
 */
public interface Player {
    /**
     * Adds the letter to the list of guesses. If goodGuess is false, then 
     *  increments the wrong answers counter by 1.
     * 
     * @arg letter the guess
     * @arg goodGuess true if the letter is found in the goal word
     */
    public void recordGuess( char letter, boolean goodGuess );
}
