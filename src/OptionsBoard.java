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

    JButton setSeed;
    JTextField seed;
    JButton run;
    JButton apply;
    JButton pause;
    JButton step;
    JButton slowSteps;
    JButton jumpTo;
    JTextField jump;


    boolean paused;

    public OptionsBoard(){


        setResizable(false);




        creatureDataBoard = new CreatureDataBoard();
        board = new JPanel();
        buttons = new JPanel();
        board.setLayout(new BorderLayout());

        init();
        pack();

        setVisible(true);

        currentOptionsBoard = this;
    }

    private void init() {


        board.add(creatureDataBoard, BorderLayout.CENTER);
        creatureDataBoard.setVisible(true);


        addButtons();
        board.add(buttons, BorderLayout.SOUTH);

        board.setBackground(Color.WHITE);
        add(board);

        paused = true;

    }

    private void addButtons(){
        JPanel panel = new JPanel();
        panel.setOpaque(false);

        setSeed = new JButton("Set Seed:");
        seed = new JTextField(10);
        setSeed.addActionListener(new setSeedListener());
        run = new JButton("Run");
        run.addActionListener(new RunListener());
        run.setEnabled(false);
        apply = new JButton("Apply");
        apply.addActionListener(new ApplyListener());
        pause = new JButton("Pause");
        pause.addActionListener(new PauseListener());
        step = new JButton("Step");
        step.addActionListener(new StepListener());
        slowSteps = new JButton("Step >");
        slowSteps.addActionListener(new slowStepsListener());
        jumpTo = new JButton("Step By:");
        jump = new JTextField(5);
        jumpTo.addActionListener(new jumpToListener(jump));

        panel.add(setSeed);
        panel.add(seed);
        panel.add(run);
        panel.add(apply);
        panel.add(pause);
        panel.add(step);
        panel.add(slowSteps);
        panel.add(jumpTo);
        panel.add(jump);
        panel.setVisible(true);

        buttons = panel;

    }

    public void canRun(boolean canRun){
        apply.setEnabled(!canRun);
        setSeed.setEnabled(!canRun);
        run.setEnabled(canRun);
    }

    private class ApplyListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            updateSeed();

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
            updateSeed();
            run.setEnabled(false);
            setSeed.setEnabled(false);
            Simulator.getCurrentSimulator().populateField();

        }
    }

    private class StepListener implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            try {
                Simulator.getCurrentSimulator().step(1);
            }catch (FieldEmptyException exception){

            }
        }
    }

    private class slowStepsListener implements ActionListener{

        Simulator simulator;

        @Override
        public void actionPerformed(ActionEvent e) {
            simulator = Simulator.getCurrentSimulator();
            paused = false;

            Thread thread = new Thread() {
                @Override
                public void run() {
                    while (true) {
                        try {
                            simulator.step(1);
                        }catch (FieldEmptyException exception){
                            paused = true;
                        }
                        try {
                            Thread.sleep(100);
                        } catch (InterruptedException ex) {
                            Thread.currentThread().interrupt();
                        }
                        if(paused)break;
                    }
                }
            };

            thread.start();


        }
    }

    public static OptionsBoard getCurrentOptionsBoard(){
        return currentOptionsBoard;
    }

    private class PauseListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            paused = true;
        }
    }

    private class jumpToListener implements ActionListener {

        Simulator simulator;
        JTextField jump;

        public jumpToListener(JTextField jump) {
            this.jump = jump;
        }

        @Override
        public void actionPerformed(ActionEvent e) {

            simulator = Simulator.getCurrentSimulator();

            try {
                simulator.step(Integer.parseInt(jump.getText()));
            }catch (NumberFormatException exception){
                ErrorMessage.getDataErrorMessage().addMessage("Steps must be an integer");
            }catch (FieldEmptyException exception){

            }
        }
    }

    private class setSeedListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            updateSeed();
        }
    }

    public void updateSeed(){
        try {
            RandomGenerator.initialiseWithSeed(Integer.parseInt(seed.getText()));
        }catch (NumberFormatException exception) {
            ErrorMessage.getDataErrorMessage().addMessage("Seed must be an integer");
        }
    }


}
