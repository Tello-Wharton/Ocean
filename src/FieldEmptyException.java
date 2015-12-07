import javax.swing.*;

/**
 * Created by tellowha on 07/12/2015.
 */
public class FieldEmptyException extends RuntimeException {
    public FieldEmptyException(){
        super("Everything is dead");
        JOptionPane.showMessageDialog(new JFrame(), "All of the creatures are dead", "End of simulation", JOptionPane.INFORMATION_MESSAGE);
    }
}
