/**
 * Created by Aaron on 26/10/2015.
 */
public class Shark extends Fish {

    public static String NAME;
    public static Creature ALPHA;

    public Shark(int age, Location location) {
        super(age, location);
    }

    public Shark(String name){
        super();
        NAME = name;
        ALPHA = this;
    }

    public Creature getNewInstance(int age, Location location){
        return new Shark(age,location);
    }

    @Override
    public Creature getAlpha() {
        return ALPHA;
    }

}
