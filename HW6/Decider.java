import java.util.List;

/**
 * Decision support utility. Includes the bootstrapper and central routines.
 * 
 * @author Josh Gillham
 * @version 10-28-12
 */
public class Decider {
    /**
     * Bootstrappes the DSS.
     * 
     * @param args not used.
     */
    public static void main(String[] args) {
        final int STANDARD = 10;
        List<Choice> choices;
        List<Characteristic> characteristics;
        double[][] crossRankings;
        UserInterface ui;
        ui = new GraphicalUserInterface();
        //ui = new ConsoleUserInterface(); 
        choices = ui.getChoices();
        characteristics = ui.getCharacteristics();
        ui.getCharacteristicRankings(characteristics, STANDARD);
        crossRankings = ui.getCrossRankings(choices, characteristics, 
        STANDARD);
        calculateFinalScores(choices, characteristics, crossRankings);
        ui.showResults(choices);
    }
    
    /**
     * Fill in the finalScore attribute for every choice.
     * 
     * @param choices the choices under consideration.
     * @param characs is the characterists per choice.
     * @param crossRankings is the importance rank.
     */
    //Changed to public
    public static void calculateFinalScores(List<Choice> choices, 
            List<Characteristic> characs, double[][] crossRankings) {
        double[] finalScores = calculateUnnormalizedFinalScores( choices,
            characs, crossRankings
        );
        double max = findMax( finalScores );
        int[] normalized = normalizeValues( finalScores, max, 100D );
        int i = 0;
        for( Choice choice: choices ) {
            choice.setFinalScore( normalized[ i++ ] );
        }
    }
    
    /**
     * Normalizes the array of values with the max.
     * 
     * @param values the array of values.
     * @param max the maximum value to normalize by.
     * @param threshHold is the value that the maximum value maps to.
     * 
     * @return the normalized array.
     */
    static public int[] normalizeValues( double[] values, double max, double threshHold ) {
        int[] ret = new int[values.length];
        for( int i = 0; i < values.length; ++i ) {
            ret[i] = (int)(values[ i++ ] * threshHold / max);
        }
        return ret;
    }
    
    /**
     * Finds the maximum value in an array.
     * 
     * @values the array of values
     * 
     * @return the max.
     */
    static public double findMax( double[] values ) {
        double max = 0;
        for( double value: values ) {
            if( max < value )
                max = value;
        }
        return max;
    }
    
    /**
     * Calculates the unnormalized final score which is the the cross ranking of 
     *  each characteristic per choice multiplied by the characteristic rank.
     * 
     * @param choices is the list of choices.
     * @param characs is the list of characteristics.
     * @param crossRankings is the ranking of the choice x characteristics.
     * 
     * @return the unnormalized final scores.
     */
    static public double[] calculateUnnormalizedFinalScores( List<Choice> choices, 
            List<Characteristic> characs, double[][] crossRankings ) {
        double[] finalScores = new double[choices.size()];
        for( int r = 0; r < choices.size(); ++r ) {
            double choiceTotal = 0;
            for( int c = 0; c < characs.size(); ++ c ) {
                 choiceTotal += characs.get( c ).getRank() * crossRankings[r][c];
            }
            finalScores[ r ] = choiceTotal;
        }
        return finalScores;
    }
}
