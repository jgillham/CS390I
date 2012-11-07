

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
            { 0.5D, 0.4D, 0.3D, 0.2D },
            { 0.5D, 0.6D, 0.7D, 0.8D }
        };
        double[] expectedFinalScore = {
            10D * 0.5D + 0.4D * 20D + 0.3D * 30D + 0.2D * 40D,
            10D * 0.5D + 0.6D * 20D + 0.7D * 30D + 0.8D * 40D
        };
        double max = Math.max( expectedFinalScore[0], expectedFinalScore[1] );
        expectedFinalScore[0] = expectedFinalScore[0] * 100 / max;
        expectedFinalScore[1] = expectedFinalScore[1] * 100 / max;
        Decider.calculateFinalScores( choices, chars, crossRankings );
        assertEquals( expectedFinalScore.length, choices.size() );
        for( int i = 0; i < choices.size(); ++i ) {
            assertEquals( (int)expectedFinalScore[ i ], choices.get( i ).getFinalScore() );
        }
    }
    
    @Test
    public void testCalculateFinalScores2() {
        List< Characteristic > chars = new LinkedList< Characteristic >();
        Characteristic chr = new Characteristic( "color" );
        chr.setRank( 1 );
        chars.add( chr );
        chr = new Characteristic( "price" );
        chr.setRank( 2 );
        chars.add( chr );
        List< Choice > choices = new LinkedList< Choice >();
        choices.add( new Choice( "hp" ) );
        choices.add( new Choice( "dell" ) );
        double[][] crossRankings = { 
            { 0.25D, 0.25D },
            { 0.75D, 0.75D }
        };
        double[] expectedFinalScore = {
            1D * 0.25D + 0.25D * 2D,
            1D * 0.75D + 0.75D * 2D
        };
        double max = Math.max( expectedFinalScore[0], expectedFinalScore[1] );
        expectedFinalScore[0] = expectedFinalScore[0] * 100 / max;
        expectedFinalScore[1] = expectedFinalScore[1] * 100 / max;
        Decider.calculateFinalScores( choices, chars, crossRankings );
        assertEquals( expectedFinalScore.length, choices.size() );
        for( int i = 0; i < choices.size(); ++i ) {
            assertEquals( (int)expectedFinalScore[ i ], choices.get( i ).getFinalScore() );
        }
    }
    
    @Test
    public void testCalculateUnnormalizedFinalScores() {
        List< Characteristic > chars = new LinkedList< Characteristic >();
        Characteristic chr = new Characteristic( "color" );
        chr.setRank( 1 );
        chars.add( chr );
        chr = new Characteristic( "price" );
        chr.setRank( 2 );
        chars.add( chr );
        List< Choice > choices = new LinkedList< Choice >();
        choices.add( new Choice( "hp" ) );
        choices.add( new Choice( "dell" ) );
        double[][] crossRankings = { 
            { 0.25D, 0.25D },
            { 0.75D, 0.75D }
        };
        double[] expectedFinalScore = {
            1D * 0.25D + 0.25D * 2D,
            1D * 0.75D + 0.75D * 2D
        };
        double[] actual = Decider.calculateUnnormalizedFinalScores( choices, chars, crossRankings );
        assertEquals( expectedFinalScore.length, choices.size() );
        assertEquals( expectedFinalScore.length, actual.length );
        for( int i = 0; i < choices.size(); ++i ) {
            assertEquals( expectedFinalScore[ i ], actual[ i ], 0.001 );
        }
    }
    @Test
    public void testFindMax() {
        double[] data = {
            1, 2, 3, 2.9, 1.1
        };
        assertEquals( 3, Decider.findMax( data ), 0.0001 );
    }
    
    @Test
    public void testNormalizeValues() {
        double[] data = {
            1, 2, 3, 2.9, 1.1
        };
        int[] expected = {
            33, 67,  100, 97, 37
        };
        int[] actual = Decider.normalizeValues( data, 3D, 100D );
        assertEquals( expected.length, actual.length );
        for( int i = 0; i < expected.length; ++i ) {
            assertEquals( expected[ i ], actual[ i ] );
        }
        
    }
    
}
