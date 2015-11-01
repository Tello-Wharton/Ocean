import javax.swing.*;
import java.awt.*;
import java.util.Collection;
import java.util.HashMap;
import java.util.Set;

/**
 * Created by Aaron on 1/11/2015.
 */
public class OptionsBoard extends JFrame {

    GridLayout layout;
    JPanel board;

    public OptionsBoard(){
        setSize(100, 100);

        layout = new GridLayout();
        board = new JPanel();
        board.setLayout(layout);
        init();
        board.setBackground(Color.WHITE);
        board.setVisible(true);
        add(board);
        pack();
        setVisible(true);
    }

    private void init() {
        layout.setColumns(Constants.CREATURE_DATA.length + 1);
        layout.setRows(Constants.CREATURE_DATA[0].length + 1);
        addHeader();
        addRows();
    }

    private void addRows() {
        for(Creature creature : CreatureFactory.CREATURES){
            JLabel label = new JLabel(creature.getName());
            addComponent(label);
            for(String field : Constants.CREATURE_FIELDS){
                JTextField textField = new JTextField(Constants.CREATURE_DATA[Constants.CF_KEY.indexOf(field)][Constants.CREATURE_KEY.indexOf(creature)].toString(),6);
                addComponent(textField);
            }
        }
    }

    private void addHeader(){
        addSpace();
        for(String field : Constants.CREATURE_FIELDS){
            JLabel label = new JLabel(field);
            addComponent(label);
        }
    }

    private void addSpace() {
        JPanel panel = new JPanel();
        panel.setOpaque(false);
        board.add(panel);
    }

    private void addComponent(Component component){
        JPanel panel = new JPanel();
        panel.setOpaque(false);
        panel.add(component);
        board.add(panel);
    }



}
