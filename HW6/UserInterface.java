import java.util.List;
/**
 * User interface for decision support application.
 * 
 * @author Josh Gillham
 * @version 11-5-12
 */
public interface UserInterface {
    /**
     * Asks the user for a list of choice canidates.
     * 
     * @return the list of choices 
     *  OR an empty list when the user cancels early.
     */
    public List<Choice> getChoices();
    
    /**
     * Asks the user for a list of characteristics.
     * 
     * @return the list of characteristics 
     *  OR an empty list when the user cancels early.
     */
    public List<Characteristic> getCharacteristics();
    
    /**
     * Asks the user to rank each characteristic using the
     *  defaultValue as the measuring stick.
     * 
     * Preconditions:
     * -expects characteristics to have at least 1 element.
     * 
     * Post Conditions:
     * -Each characteristic rank is set by the user input.
     * 
     * @param characteristics the list of characteristics.
     * @param defaultValue hte default value for a ranking.
     * 
     * @throws NullPointerException if characteristics is null.
     * 
     * @return true if the user completes the process 
     *  OR false if the user cancels.
     */
    public boolean getCharacteristicRankings( 
            List<Characteristic> characteristics, int defaultValue);
    
    /**
     * Ask the user to rank each choice canidate in the terms
     *  of each characteristic. The user is asked to rank the
     *  canidate in comparision to another canidate at the
     *  defaultValue.
     * 
     * Preconditions:
     * -expects choices and characteristics to have at least one entry.
     * 
     * @param choices a list of choices.
     * @param characteristics a list of characteristics.
     * @param defaultValue is the default ranking.
     * 
     * @return the 2D array of cross rankings where the columns are 
     *  characteristics and the rows are choices
     *  OR null if the user cancels.
     * 
     * @throws NullPointerException if choices or characteristics is null.
     */
    public double[][] getCrossRankings( List<Choice> choices,
            List<Characteristic> characteristics,
            int defaultValue);
    
    /**
     * Asks the user to rank each characteristic in terms of a
     *  choice canidate.
     * 
     * Preconditions:
     * -expects choices and characteristics to have at least one entry.
     * 
     * @param choices the list canidates.
     * @param characteristics the list adjectives.
     * @param defaultValue is the measuring stick.
     * 
     * @return a 2D array with the characteristics in the columns
     *  and choices in the rows 
     *  OR null if the user cancels the process.
     * 
     * @throws NullPointerException if choices or characteristics is null.
     */
    public double[][] inputCrossRankings( List<Choice> choices,
            List<Characteristic> characteristics,
            int defaultValue );
    
    /**
     * Calculates the totals of each column in a 2D table.
     * 
     * Preconditions:
     * -expects crossRankings to have at least 1 column.
     * 
     * @param crossRankings the table.
     * 
     * @return an array with each element representing the
     *  column total.
     *  
     * @throws NullPointerException if crossRankings is null.
     */
    public double[] calculateColumnTotals( double[][] crossRankings );
    
    /**
     * Normalizes data in a column of a 2D table with an array of column
     *  totals. The max value will be 1.0.
     * 
     * Preconditions:
     * -expects the number of columns in crossRankings to be the length 
     *  of charTotals.
     * 
     * Post Conditions:
     * -crossRankings is normalized by the values in charTotals.
     *  
     * @param crossRankings the table of data to normalize.
     * @param charTotals the array of column totals.
     * 
     * @throws NullPointerException if crossRankings or charTotals is null.
     */
    public void normalizeCrossRankings( double[][] crossRankings, 
            double[] charTotals );
    
    /**
     * Displays to the user the final ranking of each choice
     *  canidate.
     * 
     * Preconditions:
     * -expects choices to have at least 1 entry.
     * 
     * @param choices the list of choices.
     * 
     * @throws NullPointerException if choices is null.
     */
    public void showResults( List<Choice> choices );
}
