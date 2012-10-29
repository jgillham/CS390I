import java.util.List;
import java.util.ArrayList;
import javax.swing.JOptionPane;
/**
* Graphical user interface for decision support application.
* 
* @author Josh Gillham
* @version 10-29-12
*/
public class GraphicalUserInterface implements UserInterface {
    /**
     * Accesses the choices.
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
     * Accesses the list of characteristics rankings.
     * 
     * @param characteristics the list of characteristics.
     * @param defaultValue hte default value for a ranking.
     */
    public void getCharacteristicRankings(List<Characteristic> characteristics,
      int defaultValue) {
          throw new UnsupportedOperationException();
    }
    
    /**
     * Accesses a table of the cross rankings.
     * 
     * @param choices a list of choices.
     * @param characteristics a list of characteristics.
     * @param defaultValue is the default ranking.
     * 
     * @return a table of the cross rankings.
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
     * Shows the results.
     * 
     * @param choices the list of choices.
     */
    public void showResults(List<Choice> choices) {
        throw new UnsupportedOperationException();
    }
}
