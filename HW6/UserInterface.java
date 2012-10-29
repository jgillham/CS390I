import java.util.List;
import java.util.ArrayList;
/**
* User interface for decision support application.
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
