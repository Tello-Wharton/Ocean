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


    private static ErrorMessage errorMessage = ErrorMessage.getDataErrorMessage();
    private static OptionsBoard currentOptionsBoard;


    CreatureDataBoard creatureDataBoard;
    JPanel board;
    JPanel buttons;

    JButton run;
    JButton apply;
    JButton step;

    public OptionsBoard(){


        setResizable(false);




        creatureDataBoard = new CreatureDataBoard();
        board = new JPanel();
        buttons = new JPanel();
        board.setLayout(new GridBagLayout());

        init();
        pack();

        setVisible(true);

        currentOptionsBoard = this;
    }

    private void init() {
        GridBagConstraints c;
        c = new GridBagConstraints();
        c.gridy = 0;

        board.add(creatureDataBoard, c);
        creatureDataBoard.setVisible(true);

        c = new GridBagConstraints();
        c.gridy = 1;
        addButtons();
        board.add(buttons, c);

        board.setBackground(Color.WHITE);
        add(board);

    }

    private void addButtons(){
        JPanel panel = new JPanel();
        panel.setOpaque(false);

        run = new JButton("Run");
        run.addActionListener(new RunListener());
        run.setEnabled(false);
        apply = new JButton("Apply");
        apply.addActionListener(new ApplyListener());
        step = new JButton("Step");
        step.addActionListener(new StepListener());

        panel.add(run);
        panel.add(apply);
        panel.add(step);
        panel.setVisible(true);

        buttons = panel;

    }

    public void canRun(boolean canRun){
        apply.setEnabled(!canRun);
        run.setEnabled(canRun);
    }

    private class ApplyListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {

            creatureDataBoard.parseData();
            if(!errorMessage.show("Creature Data Error")){
                canRun(true);
            }
            errorMessage.clearMessage();

        }
    }

    private class RunListener implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            run.setEnabled(false);
            Simulator.getCurrentSimulator().populateField();

        }
    }

    private class StepListener implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            Simulator.getCurrentSimulator().step();
        }
    }

    public static OptionsBoard getCurrentOptionsBoard(){
        return currentOptionsBoard;
    }
}
