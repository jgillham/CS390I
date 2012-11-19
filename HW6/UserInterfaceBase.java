import java.util.List;
import java.util.ArrayList;
import java.util.Iterator;
/**
* User interface for decision support application.
* 
* @author Josh Gillham
* @version 10-29-12
*/
public abstract class UserInterfaceBase implements UserInterface {
    /** Carries the answer to a yes or no question. */
    enum YNAnswer {
        Yes, No
    }
    
    /**
     * Creates a yes or no dialog displaying the message.
     * 
     * @param message is the text to display.
     * 
     * @return is an enum showing the result OR null if the user clicks the X
     * 
     * @throws NullPointerException if message is null.
     */
    public abstract YNAnswer inputYNQuestion( String message );
    
    /**
     * Creates an input dialog displaying the message.
     * 
     * @param message is the text to display.
     * 
     * @return the user input OR null if the user clicked cancel or the X.
     * 
     * @throws NullPointerException if message is null.
     */
    public abstract String inputQuestion( String message );
    
    /**
     * Displays a dialog with the message.
     * 
     * @param message is the text to display.
     * 
     * @throws NullPointerException if message is null.
     */
    public abstract void showMessage( String message );
    
    /**
     * Asks the user for a list of choice canidates.
     * 
     * @return the list of choices 
     *  OR an empty list when the user cancels early.
     */
    public List<Choice> getChoices() {
        List<Choice> choices = new ArrayList<Choice>();
        String chr = null;
        do {
            chr = inputQuestion( "Enter a decision canidate. " +
                "Should be a noun, for example, daisy. Hit cancel after " +
                "hitting Ok for the last canidate:"
            );
            if ( chr != null )
                choices.add( new Choice( chr ) );
        } while( chr != null );
        return choices;
    }
    
    /**
     * Asks the user for a list of characteristics.
     * 
     * @return the list of characteristics 
     *  OR an empty list when the user cancels early.
     */
    public List<Characteristic> getCharacteristics() {
        List<Characteristic> characteristics = 
            new ArrayList<Characteristic>();
        String chr = null;
        do {
            chr = inputQuestion( "Enter a characteristic. Should " +
                "be an adjective for example, flowers have a color. Hit " +
                "cancel after hitting Ok for the last characteristic:"
            );
            if ( chr != null )
                characteristics.add( new Characteristic( chr ) );
        } while( chr != null );
        return characteristics;
    }
    
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
     * @throws IllegalArgumentException if characteristics is empty.
     * 
     * @return true if the user completes the process 
     *  OR false if the user cancels.
     */
    public boolean getCharacteristicRankings( 
            List<Characteristic> characteristics, int defaultValue) {
        if ( characteristics.isEmpty() )
            throw new IllegalArgumentException(
                "Characteristics cannot be empty."
            );
        boolean userCompleted = true;
        String chr = null;
        String defaultChar = characteristics.get( 0 ).getName();
        Iterator< Characteristic > i = characteristics.iterator();
        Characteristic aChar = i.next();
        aChar.setRank( defaultValue );
        while ( i.hasNext() ) {
            aChar = i.next();
            chr = inputQuestion( "If importance of " + defaultChar + " was " +
                defaultValue + ", how would you rate " + aChar.getName() + ":"
            );
            if ( chr != null ) {
                aChar.setRank( Integer.parseInt( chr ) );
            }
            else {
                userCompleted = false;
                break;
            }
        } 
        return userCompleted;
    }
    
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
            int defaultValue) {
        double[][] crossRankings = inputCrossRankings(
            choices, characteristics, defaultValue
        );
        if ( crossRankings != null ) {
            double[] charTotals = calculateColumnTotals( crossRankings );
            normalizeCrossRankings( crossRankings, charTotals );
        }
        return crossRankings;
    }
    
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
     * @throws IllegalArgumentException if choices or characteristics is empty.
     */
    public double[][] inputCrossRankings( List<Choice> choices,
            List<Characteristic> characteristics,
            int defaultValue ) {
        if ( choices.isEmpty() || characteristics.isEmpty() )
            throw new IllegalArgumentException(
                "Choices or characteristics cannot be empty."
            );
        double[][] crossRankings =
            new double[choices.size()][characteristics.size()];
        String defaultChoice = choices.get( 0 ).getName();
        String chr;
        for ( int c = 0; c < characteristics.size(); ++c ) {
            crossRankings[0][c] = defaultValue;
            for ( int r = 1; r < choices.size(); ++r ) {
                chr = inputQuestion( "In terms of " + 
                    characteristics.get( c ).getName() +
                    ", if " + defaultChoice +  " was rated a " + defaultValue +
                    " how would you rate " + choices.get( r ).getName() + "." );
                if ( chr != null ) {
                    double rank = Double.parseDouble( chr );
                    crossRankings[r][c] = rank;
                }
                else return null;
            }
        }
        return crossRankings;
    }
    
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
     * @throws IllegalArgumentException if crossRankings has no columns.
     */
    public double[] calculateColumnTotals( double[][] crossRankings ) {
        if ( crossRankings[0].length == 0 )
            throw new IllegalArgumentException(
                "crossRankings cannot have only 1 column."
            );
        double[] charTotals = new double[ crossRankings[0].length ];
        for ( int c = 0; c < crossRankings[0].length; ++c ) {
            charTotals[c] = 0;
            for ( int r = 0; r < crossRankings.length; ++r ) {             
                charTotals[c] += crossRankings[r][c];
            }
        }
        return charTotals;
    }
    
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
     * @throws IllegalArgumentException if the number of columns in 
     *  crossRankings is not equal to the length in charTotals.
     */
    public void normalizeCrossRankings( double[][] crossRankings, 
            double[] charTotals ) {
        if ( crossRankings[0].length != charTotals.length )
            throw new IllegalArgumentException(
                "Columns in crossRankings is not the same length" +
                " as charTotals"
            );
        for ( int r = 0; r < crossRankings.length; ++r ) {
            for ( int c = 0; c < crossRankings[0].length; ++c ) {
                crossRankings[r][c] /= charTotals[c];
            }
        }
    }
    
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
     * @throws IllegalArgumentException if choices is empty.
     */
    public void showResults( List<Choice> choices ) {
        if ( choices.isEmpty() )
            throw new IllegalArgumentException(
                "Choices cannot be empty."
            );
        StringBuilder results = new StringBuilder();
        for ( Choice choice : choices ) {
            results.append( "The final score of " );
            results.append( choice.getName() );
            results.append( " is " );
            results.append( choice.getFinalScore() );
            results.append( ".\n" );
        }
        showMessage( results.toString() );
    }
}
