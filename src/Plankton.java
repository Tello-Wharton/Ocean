/**
 * Created by Aaron on 26/10/2015.
 */
public class Plankton extends Creature {

    public static String NAME;
    public static Creature ALPHA;

    public Plankton(int age, Location location){
        super(age, location);
    }

    public Plankton(String name){
        super();
        NAME = name;
        ALPHA = this;
    }

    public Creature getNewInstance(int age, Location location){
        return new Plankton(age,location);
    }

    @Override
    public Creature getAlpha() {
        return ALPHA;
    }

}
