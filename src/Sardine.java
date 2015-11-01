/**
 * Created by Aaron on 26/10/2015.
 */
public class Sardine extends Fish {

    public static String NAME;
    public static Creature ALPHA;

    public Sardine(int age, Location location){
        super(age, location);
    }

    public Sardine(String name){
        super();
        NAME = name;
        ALPHA = this;
    }

    public Creature getNewInstance(int age, Location location){
        return new Sardine(age,location);
    }

    @Override
    public Creature getAlpha() {
        return ALPHA;
    }
}
