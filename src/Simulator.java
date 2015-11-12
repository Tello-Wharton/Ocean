import java.awt.*;
import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;
import java.util.Random;

/**
 * Created by Aaron on 27/10/2015.
 */
public class Simulator {

    SimulatorView view;
    Field field;
    CreatureFactory cf;


    public static void main(String[] args){
        RandomGenerator.initialiseWithSeed(100);
        Constants.init();
        new Simulator();
    }

    public Simulator(){
        view = new SimulatorView(100,100);
        view.setVisible(true);
        view.setColor(Plankton.class, Color.green);
        view.setColor(Sardine.class, Color.blue);
        view.setColor(Shark.class, Color.black);
        cf = new CreatureFactory();
        populateField();
        new OptionsBoard(this);
    }

    public void populateField(){
        field = cf.populateField();
        view.showStatus(1, field);
    }


}
