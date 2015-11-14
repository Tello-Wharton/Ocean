/**
 * Created by Aaron on 26/10/2015.
 */
public class Sardine extends Fish {

    private static Creature ALPHA;

    private Sardine(Location location, Field field){
        super(location, field);
    }

    public Sardine(String name){
        super(name);
        ALPHA = this;
    }


    public Creature getRandomInstance(Location location, Field field){
        Creature c = new Sardine(location, field);
        c.setRandomAge();
        return c;
    }

    @Override
    protected Creature getAlpha() {
        return ALPHA;
    }

    @Override
    public Creature getNewborn(Location location) {
        return new Sardine(location, field);
    }


}
