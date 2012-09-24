import java.util.List;
import java.util.LinkedList;

/**
 * Provides the saffolding to get the game up and running. Prompts 
 *  the user for the word length and max attempts. Creates a new Logic 
 *  and GameUI instance when the user is ready to play.
 *  
 * The API will be generic so that this game can be run from the console
 *  or with a swing pane.
 * 
 * @author Josh Gillham
 * @version 9-23-12
 */
public class SetupUI{
    /**
     * Initializes the dictionary. Creates a new instance of SetupUI.
     * 
     * @arg args command line arguments - not used.
     */
    static public void main( String[] args )
    { throw new UnsupportedOperationException(); }
    
    /** Holds the teams for game setup. */
    private List< Manager > teams= new LinkedList< Manager >();
    /** Holds a copy of the Game Logic. */
    private Logic game= null;
    
    /**
     * Brings up the user interface.
     */
    public SetupUI( )
    { throw new UnsupportedOperationException(); }
}
