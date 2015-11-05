import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;

/**
 * Created by Aaron on 1/11/2015.
 */
public class OptionsBoard extends JFrame {

    private Simulator simulator;
    private static ErrorMessage errorMessage = ErrorMessage.getDataErrorMessage();

    boolean canRun;
    GridLayout dataLayout;
    JPanel data;
    JPanel board;
    JPanel buttons;

    JTextField[][] textFields;
    JLabel[] fields;

    public OptionsBoard(Simulator simulator){
        this.simulator = simulator;

        setResizable(false);

        canRun = true;
        dataLayout = new GridLayout();
        data = new JPanel();
        board = new JPanel();
        buttons = new JPanel();
        board.setLayout(new GridBagLayout());

        textFields = new JTextField[Constants.CREATURE_DATA.length][Constants.CREATURE_DATA[0].length];
        fields = new JLabel[Constants.CREATURE_FIELDS.length];

        init();
        pack();

        setVisible(true);
    }

    private void init() {
        GridBagConstraints c;
        c = new GridBagConstraints();
        c.gridy = 0;

        data.setOpaque(false);
        data.setLayout(dataLayout);
        dataLayout.setColumns(Constants.CREATURE_DATA.length + 1);
        dataLayout.setRows(Constants.CREATURE_DATA[0].length + 1);
        addHeader();
        addRows();
        board.add(data, c);
        data.setVisible(true);

        c = new GridBagConstraints();
        c.gridy = 1;
        addButtons();
        board.add(buttons, c);

        board.setBackground(Color.WHITE);
        add(board);

    }

    private void addRows() {
        int x = 0;
        int y = 0;
        for(Creature creature : Constants.CREATURES){
            JLabel label = new JLabel(creature.getName());
            label.setForeground(Color.black);
            addComponent(label);
            for(Cell[] cells : Constants.CREATURE_DATA){
                JTextField textField = cells[y].getBox();
                textField.setColumns(6);
                textField.addFocusListener(new TextBoxListener(textField,Constants.CREATURE_FIELDS[x]));
                textFields[x][y] = textField;
                x+= 1;
                addComponent(textField);
            }
            x = 0;
            y+= 1;
        }
    }

    private void addHeader(){
        addSpace();
        for(NumericalDataType field : Constants.CREATURE_FIELDS){
            addComponent(field.getBox());
        }
    }

    private void addSpace() {
        JPanel panel = new JPanel();
        panel.setOpaque(false);
        data.add(panel);
    }

    private void addComponent(Component component){
        JPanel panel = new JPanel();
        panel.setOpaque(false);
        panel.add(component);
        data.add(panel);
    }

    private void addButtons(){
        JPanel panel = new JPanel();
        panel.setOpaque(false);

        JButton run = new JButton("Run");
        run.addActionListener(new RunListener());
        JButton okay = new JButton("Apply");
        okay.addActionListener(new ApplyListener());
        JButton cancel = new JButton("Cancel");

        panel.add(run);
        panel.add(okay);
        panel.add(cancel);
        panel.setVisible(true);

        buttons = panel;

    }

    private class ApplyListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            for(Cell[] cells : Constants.CREATURE_DATA){
                for(Cell cell : cells){
                    cell.parseValue();
                }
            }
            errorMessage.show("Creature Data Error");
            errorMessage.clearMessage();
        }
    }



    private class RunListener implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            RandomGenerator.initialiseWithSeed(100);
            simulator.populateField();
        }
    }

    private class TextBoxListener implements FocusListener{

        JTextField textField;
        JLabel title;

        public TextBoxListener(JTextField textField, NumericalDataType field){
            this.title = field.getBox();
            this.textField = textField;
        }

        @Override
        public void focusGained(FocusEvent e) {
            title.setForeground(Color.black);
            textField.setBackground(Color.WHITE);
        }

        @Override
        public void focusLost(FocusEvent e) {

        }
    }


}
