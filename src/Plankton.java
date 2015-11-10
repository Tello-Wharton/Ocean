import java.util.HashSet;

/**
 * Created by Aaron on 26/10/2015.
 */
public class Plankton extends Creature {

    private static Creature ALPHA;

    public Plankton(){

    }

    public Plankton(Location location){
        super(location);
    }

    public Plankton(String name){
        super(name);
        ALPHA = this;
    }

    public Creature getRandomInstance(Location location){
        Creature c = new Plankton(location);
        c.setRandomAge();
        return c;
    }

    @Override
    protected Creature getAlpha(){
        return ALPHA;
    }

    @Override
    public Creature getNewborn() {
        return new Plankton();
    }

    @Override
    public void step() {

    }

}
