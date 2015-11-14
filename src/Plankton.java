import java.util.HashSet;

/**
 * Created by Aaron on 26/10/2015.
 */
public class Plankton extends Creature {

    private static Creature ALPHA;



    private Plankton(Location location, Field field){
        super(location, field);
    }

    public Plankton(String name){
        super(name);
        ALPHA = this;
    }

    public Creature getRandomInstance(Location location, Field field){
        Creature c = new Plankton(location, field);
        c.setRandomAge();
        return c;
    }

    @Override
    protected Creature getAlpha(){
        return ALPHA;
    }

    @Override
    public Creature getNewborn(Location location) {
        return new Plankton(location, field);
    }


}
