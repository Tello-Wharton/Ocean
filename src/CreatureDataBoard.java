import javax.swing.*;
import java.awt.*;
/**
 * Created by Aaron on 13/11/2015.
 */
public class CreatureDataBoard extends JPanel{

    private int width;
    private int height;

    public CreatureDataBoard(){
        setOpaque(false);

        width = Constants.CREATURE_DATA.length;
        height = Constants.CREATURE_DATA[0].length;

        setLayout(new GridLayout(height + 1, width + 1));

        addHeader();
        addRows();

        setVisible(true);
    }

    private void addHeader() {
        addSpace();
        for(NumericalDataType field : Constants.CF_KEY){
            addComponent(field.getBox());
        }
    }

    private void addComponent(Component component){
        JPanel panel = new JPanel();
        panel.setOpaque(false);
        panel.add(component);
        add(panel);
    }

    private void addSpace() {
        JPanel panel = new JPanel();
        panel.setOpaque(false);
        add(panel);
    }

    private void addRows() {
        int x = 0;
        int y = 0;
        for(Creature creature : Constants.CREATURES){
            JLabel label = new JLabel(creature.getName());
            label.setForeground(Color.black);
            addComponent(label);
            for(Cell[] cells : Constants.CREATURE_DATA){
                try {
                    JTextField textField = cells[y].getBox();
                    textField.setColumns(6);
                    textField.addCaretListener(new OptionsTextBoxRefresher(textField, Constants.CF_KEY.get(x)));

                    addComponent(textField);
                }catch (NullPointerException e){
                    addSpace();
                }
                x+= 1;
            }
            x = 0;
            y+= 1;
        }
    }

    public void parseData() {
        for (Cell[] cells : Constants.CREATURE_DATA) {
            for (Cell cell : cells) {
                try {
                    cell.parseValue();
                }catch (NullPointerException e){

                }
            }
        }
    }
}
