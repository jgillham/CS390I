import java.util.List;
import java.util.LinkedList;
import java.util.Scanner;

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
public class SetupUI {
    /**
     * Initializes the dictionary. Creates a new instance of SetupUI.
     * 
     * @arg args command line arguments - not used.
     */
    static public void main( String[] args ){
        new SetupUI();
    }
    
    /** Holds the teams for game setup. */
    private List< Manager > teams= new LinkedList< Manager >();
    /** Holds a copy of the Game Logic. */
    private Logic game= null;
    private String name= null;
    private int wordLength= 0;
    
    /**
     * Brings up the user interface.
     */
    public SetupUI( ){
        Scanner userInput= new Scanner(System.in);
        System.out.println( "Enter your name:" );
        name= userInput.next();
        Manager man= new Manager( "Default" );
        teams.add( man );
        man.addPlayer( name );
        
        System.out.println( "Whats the word length:" );
        wordLength= userInput.nextInt();
        
        game= new Logic( teams, wordLength );
        new GameUI( game );
        
    }
}
