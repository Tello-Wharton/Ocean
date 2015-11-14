import javax.swing.*;
import javax.swing.event.CaretEvent;
import javax.swing.event.CaretListener;

import java.awt.*;

/**
 * Created by Aaron on 13/11/2015.
 */
public class OptionsTextBoxRefresher implements CaretListener {

    JTextField textField;
    JLabel title;

    public OptionsTextBoxRefresher(JTextField textField, NumericalDataType field){
        this.title = field.getBox();
        this.textField = textField;

    }


    @Override
    public void caretUpdate(CaretEvent e) {
        title.setForeground(Color.black);
        textField.setBackground(Color.WHITE);
        OptionsBoard.getCurrentOptionsBoard().canRun(false);
    }
}