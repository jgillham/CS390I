import java.util.List;
/**
 * User interface for decision support application.
 * 
 * @author Josh Gillham
 * @version 11-5-12
 */
public interface UserInterface {
    List<Choice> getChoices();
    List<Characteristic> getCharacteristics();
    void getCharacteristicRankings(List<Characteristic> alc,
        int defaultValue);
    double[][] getCrossRankings(
        List<Choice> choices,
        List<Characteristic> characteristics,
        int defaultValue);
    void showResults(List<Choice> choices);
}
