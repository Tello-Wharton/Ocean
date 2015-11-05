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
        int x = 100;
        int y = 100;
        field = new Field(x,y);
        for(int a = 0; a < field.getWidth(); a++){
            for(int b = 0; b < field.getDepth(); b++){
                Location location = new Location(a,b);
                field.place(cf.getRandom(location),location);
            }
        }
        view.showStatus(1, field);


    }
}
