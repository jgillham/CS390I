

import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import java.util.List;
import java.util.LinkedList;

/**
 * The test class DeciderTest.
 *
 * @author  Josh Gillham
 * @version 11-5-12
 */
public class DeciderTest {
    @Test
    public void testCalculateFinalScores() {
        List< Characteristic > chars = new LinkedList< Characteristic >();
        Characteristic chr = new Characteristic( "color" );
        chr.setRank( 10 );
        chars.add( chr );
        chr = new Characteristic( "price" );
        chr.setRank( 20 );
        chars.add( chr );
        chr = new Characteristic( "speed" );
        chr.setRank( 30 );
        chars.add( chr );
        chr = new Characteristic( "appearance" );
        chr.setRank( 40 );
        chars.add( chr );
        List< Choice > choices = new LinkedList< Choice >();
        choices.add( new Choice( "hp" ) );
        choices.add( new Choice( "dell" ) );
        double[][] crossRankings = { 
            { 0.5, 0.4, 0.3, 0.2 },
            { 0.5, 0.6, 0.7, 0.8 }
        };
        double[] expectedFinalScore = {
            10 * 0.5 + 0.4 * 20 + 0.3 * 30 + 0.2 * 40,
            10 * 0.5 + 0.6 * 20 + 0.7 * 30 + 0.8 * 40,
        };
        double max = Math.max( expectedFinalScore[0], expectedFinalScore[1] );
        expectedFinalScore[0] /= max;
        expectedFinalScore[1] /= max;
        Decider.calculateFinalScores( choices, chars, crossRankings );
    }
    
}
