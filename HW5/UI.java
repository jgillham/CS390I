import javax.swing.JOptionPane;
/**
 * Handles the interaction with the user. This abstraction provides a functional method of testing
 *  the code in the Logic.
 * 
 * @author Josh Gillham
 * @version 10-21-12
 */
class UI {
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
     */
    public YNAnswer inputYNQuestion( String message ) { 
        int result= JOptionPane.showConfirmDialog( null, message, "", JOptionPane.YES_NO_OPTION );
        if( result == 1 )
            return YNAnswer.No;
        else if( result == 0 )
            return YNAnswer.Yes;
        return null;
    }
    
    /**
     * Creates an input dialog displaying the message.
     * 
     * @param message is the text to display.
     * 
     * @return the user input OR null if the user clicked cancel or the X.
     */
    public String inputQuestion( String message ) {
        return JOptionPane.showInputDialog( message );
    }
    
    /**
     * Displays a dialog with the message.
     * 
     * @param message is the text to display.
     */
    public void showMessage( String message ) { 
        JOptionPane.showMessageDialog( null, message );
    }
}
