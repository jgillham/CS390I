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
    /** Holds the default dictionary file. Should in the root of the project folder. */
    static public final String DICTIONARY_FILE= "smalldictionary.txt";
    /**
     * Initializes the dictionary. Creates a new instance of SetupUI.
     * 
     * @arg args command line arguments - not used.
     */
    static public void main( String[] args ){
        try{
            Dictionary.load( DICTIONARY_FILE );
        } catch( Exception e ) {
            e.printStackTrace();
            System.exit( 1 );
        }
        
        SetupUI setup= new SetupUI();
        Logic game= setup.inputSetupGame();
        setup.startGame();
        while( game.getGameState() == Logic.Statis.STARTED ){
            game.rotateTurn();
        }
        
    }
    
    /** Holds the teams for game setup. */
    private List< Manager > teams= new LinkedList< Manager >();
    /** Holds a copy of the Game Logic. */
    private Logic game= null;
    /** Holds a copy of the player name. */
    private String name= null;
    /** Holds the word length. */
    private int wordLength= 0;
    /** Holds the manager of the first team. */
    private Manager man= null;
    
    /**
     * Brings up the user interface.
     */
    public SetupUI( ){
        man= new Manager( "Default" );
        teams.add( man );
    }
    
    /**
     * Launches the Game UI.
     * 
     * @return the newly create GameUI.
     */
    public GameUI startGame() {
        GameUI UI= new GameUI( game );
        game.setGameEventsHandler(UI);
        return UI;
    }
    
    /**
     * Walk through the setup steps with the user.
     * 
     * @return a new game logic.
     */
    public Logic inputSetupGame() {
        Scanner userInput= new Scanner(System.in);
        // Get their name
        int tries= 0;
        String name= null;
        while( name == null && tries++ < 3 )
            name= inputPlayerName( userInput );
        // The player doesn't want to play?
        if( name == null )
            System.exit( 1 );
        
        // Add him to the first team.
        man.addPlayer( name );
        
        // Get the word length
        tries= 0;
        int wordLength= 0;
        while( wordLength == 0 && tries++ < 3 )
            wordLength= inputGameWordLength( userInput );
        
        // Now we have enough information to create the game.
        game= new Logic( teams, wordLength );
        
        // Get the maximum allowed guesses.
        tries= 0;
        int maxAttempts= 0;
        while( maxAttempts == 0 && tries++ < 3 )
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
        if( name.isEmpty() )
            return null;
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
        if( wordLength < Dictionary.MIN_WORDLENGTH || wordLength > Dictionary.MAX_WORDLENGTH )
            return 0;
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
