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
        for( int r = 0; r < choices.size(); ++r ) {
            int choiceTotal = 0;
            for( int c = 0; c < characs.size(); ++ c ) {
                 choiceTotal += characs.get( c ).getRank() * crossRankings[r][c];
            }
            choices.get( r ).setFinalScore( choiceTotal );
        }
    }
}
