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
     * @return the list of canidates.
     */
    List<Choice> getChoices();
    /**
     * Asks the user for a list of characteristics.
     * 
     * @return the list of characteristics.
     */
    List<Characteristic> getCharacteristics();
    /**
     * Asks the user to rank each characteristic using the
     *  defaultValue as the measuring stick.
     * 
     * Post Conditions:
     * -Changes the data in each Characteristic in alc.
     *  
     * @param alc the list of characteristics.
     * @param defaultValue the measuring stick.
     */
    void getCharacteristicRankings(List<Characteristic> alc,
        int defaultValue);
    /**
     * Ask the user to rank each choice canidate in the terms
     *  of each characteristic. The user is aked to rank the
     *  canidate in comparision to another canidate at the
     *  defaultValue.
     * 
     * @param choices the list of choice canidates.
     * @param characteristics the list characteristics.
     * @param defaultValue the measuring stick.
     * 
     * @return the 2D array of cross rankings where the columns
     *  are characteristics and the rows are choices.
     */
    double[][] getCrossRankings(
        List<Choice> choices,
        List<Characteristic> characteristics,
        int defaultValue);
    /**
     * Displays to the user the final ranking of each choice
     *  canidate.
     * 
     * @param choices the list of choices.
     */
    void showResults(List<Choice> choices);
}
