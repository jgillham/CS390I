import java.util.List;
import java.util.ArrayList;
/**
* User interface for decision support application.
*/
public interface UserInterface {
    /**
     * Accesses the list of choices.
     * 
     * @return the list of choices.
     */
    List<Choice> getChoices();
    /**
     * Accesses the list of characteristics.
     * 
     * @return the list of characteristics.
     */
    List<Characteristic> getCharacteristics();
    /**
     * Accesses the charactistics rankings.
     * 
     * @param alc the list of characteristics.
     * @param defaultValue is the default value.
     */
    void getCharacteristicRankings(List<Characteristic> alc, int defaultValue);
    /** Accesses the cross rankings. */
    double[][] getCrossRankings( List<Choice> choices, List<Characteristic> characteristics,
      int defaultValue);
    /** Displays the results. */
    void showResults(List<Choice> choices);
}
