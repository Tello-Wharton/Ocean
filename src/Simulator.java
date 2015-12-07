import javax.swing.*;
import java.awt.*;
import java.lang.reflect.InvocationTargetException;
import java.util.*;

/**
 * Created by Aaron on 27/10/2015.
 */
public class Simulator {
    private static Simulator currentSimulator;

    private SimulatorView view;
    private Field field;
    private Field emptyField;
    private CreatureFactory cf;
    private int step;
    private int width,height;


    public static void main(String[] args){
        RandomGenerator.initialiseWithSeed(100);
        Constants.init();
        CreatureFactory.init();
        new Simulator();
    }

    public Simulator(){
        width = 100;
        height = 100;

        view = new SimulatorView(width,height);
        view.setVisible(true);
        view.setColor(Plankton.class, Color.green);
        view.setColor(Sardine.class, Color.blue);
        view.setColor(Shark.class, Color.black);
        cf = new CreatureFactory();

        currentSimulator = this;

        populateField();
        new OptionsBoard();
    }

    public void populateField(){
        step = 0;
        field = cf.populateField();

        emptyField = new Field(field.getWidth(),field.getDepth());

        view.showStatus(step, field);
    }

    public void step(int steps) throws FieldEmptyException{

        for(int a = 0; a < steps; a++) {
            step += 1;
            for (int x = 0; x < field.getWidth(); x++) {
                for (int y = 0; y < field.getDepth(); y++) {
                    try {
                        field.getObjectAt(x, y).setHasProcessed(false);
                    } catch (NullPointerException e) {

                    }
                }
            }

            int emptySlots = 0;


            for (int x = 0; x < field.getWidth(); x++) {
                for (int y = 0; y < field.getDepth(); y++) {
                    try {
                        Creature creature = field.getObjectAt(x, y);
                        if (!creature.hasProcessed()) {
                            creature.step();
                            creature.setHasProcessed(true);
                        }
                    } catch (NullPointerException e) {
                        emptySlots += 1;
                    } catch (DeadCreatureException e) {

                    }

                }

            }


            if (emptySlots >= field.getWidth() * field.getDepth()) {
                view.showStatus(step - 1, field);
                throw new FieldEmptyException();
            }
        }
        view.showStatus(step, field);
    }



    public static Simulator getCurrentSimulator(){
        return currentSimulator;
    }
}
