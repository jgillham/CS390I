import java.util.List;
/**
* Decision support utility.
*/
public class Decider {
public static void main(String[] args) {
final int STANDARD = 10;
List<Choice> choices;
List<Characteristic> characteristics;
double[][] crossRankings;
UserInterface ui;
ui = new ConsoleUserInterface(); // or ui = new GraphicalUserInterface();
choices = ui.getChoices();
characteristics = ui.getCharacteristics();
ui.getCharacteristicRankings(characteristics, STANDARD);
crossRankings = ui.getCrossRankings(choices, characteristics, STANDARD);
calculateFinalScores(choices, characteristics, crossRankings);
ui.showResults(choices);
}
/** Fill in the finalScore attribute for every choice. */
private static void calculateFinalScores(List<Choice> choices,
List<Characteristic> characs,
double[][] crossRankings) {
/* Your code here */
}
}
