import java.util.List;
import java.util.ArrayList;
/**
* Console user interface for decision support application.
* 
* @author Josh Gillham
* @version 10-28-12
*/
public class ConsoleUserInterface implements UserInterface {
    /**
     * Accesses the list of choices.
     * 
     * @return the list of choices.
     */
    public List<Choice> getChoices() {
        throw new UnsupportedOperationException();
//         List<Choice> choices = new ArrayList<Choice>();
//         return choices;
    }
    
    /**
     * Accesses the list of characteristics.
     * 
     * @return the list of characteristics.
     */
    public List<Characteristic> getCharacteristics() {
        throw new UnsupportedOperationException();
//         List<Characteristic> characteristics = new ArrayList<Characteristic>();
//         return characteristics;
    }
    
    /**
     * Accesses the characteristic rankings.
     * 
     * @param characteristics the list of characteristics.
     * @param defaultValue the default ranking value.
     */
    public void getCharacteristicRankings(List<Characteristic> characteristics,
      int defaultValue) {
        throw new UnsupportedOperationException();
    }
    
    /**
     * Accesses a table of the cross rankings.
     * 
     * @param choices the list of choices.
     * @param characteristics the list of characteristics.
     * @param defaultValue the default value for the rankings.
     * 
     * @return a 2-D array (table) of the cross rankings.
     */
    public double[][] getCrossRankings(List<Choice> choices,
      List<Characteristic> characteristics,
      int defaultValue) {
        throw new UnsupportedOperationException();
//         double[][] crossRankings =
//         new double[choices.size()][characteristics.size()];
//         return crossRankings;
    }
    
    /**
     * Displays the results.
     * 
     * @param choices the list of choices.
     */
    public void showResults(List<Choice> choices) {
        throw new UnsupportedOperationException();
    }
}
