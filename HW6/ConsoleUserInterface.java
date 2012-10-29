import java.util.List;
import java.util.ArrayList;
/**
* Console user interface for decision support application.
*/
public class ConsoleUserInterface implements UserInterface {
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
    throw new UnsupportedOperationException();
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
    throw new UnsupportedOperationException();
}
}
