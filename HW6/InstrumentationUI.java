import java.util.Queue;
import java.util.LinkedList;

/**
 * Provides a test instrument for UserInterface.
 * 
 * @author Josh Gillham
 * @version 11-16-12
 */
class InstrumentationUI extends UserInterfaceBase {
    /** Holds a list of answers to yes or no questions. */
    public Queue< YNAnswer > answersYN = new LinkedList< YNAnswer >();
    /** Holds a list of answers to text questions. */
    public Queue< String > answers = new LinkedList< String >();
    /** Counts the number of messages shown. */
    public int messagesShown = 0;
    /** Povides a empty constructor. */
    public InstrumentationUI( ) {
    }
    /**
     * Provides a constructor with the first answers. 
     * 
     * @param nextYN is the next answer to a yes or no question.
     * @param nextQuestion is the next answer to a text question.
     */
    public InstrumentationUI( YNAnswer nextYN, String nextQuestion ) {
        this.answersYN.add( nextYN );
        this.answers.add( nextQuestion );
    }
    
    /**
     * Gets the first preloaded answer off the queue.
     * 
     * @param message is not used.
     * 
     * @return the preloaded yes or no answer.
     */
    public YNAnswer inputYNQuestion( String message ) {
        return this.answersYN.poll();
    }
    
    /**
     * Gets the first preloaded text answer off the queue.
     * 
     * @param message is not used.
     * 
     * @return the preloaded text answer.
     */
    public String inputQuestion( String message ) { 
        return this.answers.poll();
    }
    
    /**
     * Counts the number of times this method is called.
     * 
     * @param message is not used.
     */
    public void showMessage( String message ) { 
        ++messagesShown;
    }
}