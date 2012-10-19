import javax.swing.JOptionPane;
/**
 * Features
 * -Starts the program.
 * 
 * @author Josh Gillham
 * @version 10-18-12
 */
public class Launch {
    static public void main( String[] args ) {
        int result= JOptionPane.showConfirmDialog( null, "Pick a object. I bet I can guess what you're thinking...",
        "Continue?", JOptionPane.YES_NO_OPTION );
        if( result == 1 ) // No
            JOptionPane.showMessageDialog( null, "NO! Why you sir are no fun!" );
        else // Yes
            JOptionPane.showMessageDialog( null, "Get ready to be amazed!" );
    }
}
