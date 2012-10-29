import java.util.List;
import java.util.ArrayList;
import javax.swing.JOptionPane;
/**
* Graphical user interface for decision support application.
*/
public class GraphicalUserInterface implements UserInterface {
public List<Choice> getChoices() {
List<Choice> choices = new ArrayList<Choice>();
/* Your code here */
return choices;
}
public List<Characteristic> getCharacteristics() {
List<Characteristic> characteristics = new ArrayList<Characteristic>();
/* Your code here */
return characteristics;
}
public void getCharacteristicRankings(List<Characteristic> characteristics,
int defaultValue) {
/* Your code here */
}
public double[][] getCrossRankings(List<Choice> choices,
List<Characteristic> characteristics,
int defaultValue) {
double[][] crossRankings =
new double[choices.size()][characteristics.size()];
/* Your code here */
return crossRankings;
}
public void showResults(List<Choice> choices) {
/* Your code here */
}
}
