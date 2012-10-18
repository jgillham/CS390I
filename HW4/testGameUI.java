import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * Tests the class GameUI.
 *
 * @author  Josh Gillham
 * @version 9-23-12
 */
public class testGameUI {
    
    /**
     * Tests the constructor to make sure there are no errors.
     */
    @Test
    public void testConstructor() throws Exception {
        SetupBase wrapGame= new SetupBase();
        wrapGame.addManager( "Default" );
        wrapGame.addPlayer( "Default" );
        Logic game= new Logic( wrapGame.getTeams(), 5 );
        new GameUI( game );
    }
}
