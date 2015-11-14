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
    private CreatureFactory cf;
    private int step;


    public static void main(String[] args){
        RandomGenerator.initialiseWithSeed(100);
        Constants.init();
        CreatureFactory.init();
        new Simulator();
    }

    public Simulator(){
        view = new SimulatorView(100,100);
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
        view.showStatus(step, field);
    }

    public void step(){
        step+=1;
        for(int x = 0; x < field.getWidth(); x++){
            for(int y = 0; y < field.getDepth(); y++) {
                try {
                    field.getObjectAt(x,y).setHasProcessed(false);
                }catch (NullPointerException e){

                }
            }
        }


        for(int x = 0; x < field.getWidth(); x++){
            for(int y = 0; y < field.getDepth(); y++) {
                try {
                    Creature creature = field.getObjectAt(x,y);
                    if (!creature.hasProcessed()) {
                        creature.step();
                        creature.setHasProcessed(true);
                    }
                }catch (NullPointerException e){

                }catch (DeadCreatureException e){
                    field.place(null,x,y);
                }

            }
        }
        view.showStatus(step, field);
    }

    public static Simulator getCurrentSimulator(){
        return currentSimulator;
    }

}
