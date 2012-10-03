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
    static public final String DICTIONARY_FILE= "smalldictionary.txt";
    /**
     * Initializes the dictionary. Creates a new instance of SetupUI.
     * 
     * @arg args command line arguments - not used.
     */
    static public void main( String[] args ){
        SetupUI setup= new SetupUI();
        setup.inputSetupGame();
        setup.startGame();
        
    }
    
    /** Holds the teams for game setup. */
    private List< Manager > teams= new LinkedList< Manager >();
    /** Holds a copy of the Game Logic. */
    private Logic game= null;
    /** Holds a copy of the player name. */
    private String name= null;
    /** Holds the word length. */
    private int wordLength= 0;
    
    private Manager man= null;
    
    /**
     * Brings up the user interface.
     */
    public SetupUI( ){
        man= new Manager( "Default" );
    }
    
    public GameUI startGame() {
        return new GameUI( game );
    }
    
    public Logic inputSetupGame() {
        Scanner userInput= new Scanner(System.in);
        int tries= 0;
        String name= null;
        while( tries++ < 3 )
            name= inputPlayerName( userInput );
            
        if( name == null )
            System.exit( 1 );
        
        teams.add( man );
        man.addPlayer( name );
        
        tries= 0;
        int wordLength= 0;
        while( tries++ < 3 )
            wordLength= inputGameWordLength( userInput );
            
        game= new Logic( teams, wordLength );
        
        tries= 0;
        int maxAttempts= 0;
        while( tries++ < 3 )
            maxAttempts= inputMaxAttempts( userInput );
        
        game.setMaxAttempts( maxAttempts );
        
        return game;
    }
    
    /**
     * Listens for the player's name and throws out bad input.
     * 
     * @arg inputScanner gets the next input
     * 
     * @return the name 
     * @return null if the input was bad.
     */
    public String inputPlayerName( Scanner inputScanner ) {
        System.out.println( "Enter your name:" );
        String name= inputScanner.next();
        return name;
    }
    
    /**
     * Listens for the game word length.
     * 
     * @arg inputScanner gets the next input.
     * 
     * @return the word length.
     */
    public int inputGameWordLength( Scanner inputScanner ) {
        System.out.println( "Whats the word length:" );
        int wordLength= inputScanner.nextInt();
        return wordLength;
    }
    
    /**
     * Listens for the game word length.
     * 
     * @arg inputScanner gets the next input.
     * 
     * @return the word length.
     */
    public int inputMaxAttempts( Scanner inputScanner ) {
        System.out.println( "Whats is the max tries to win the game?" );
        int attempts= inputScanner.nextInt();
        return attempts;
    }
}
