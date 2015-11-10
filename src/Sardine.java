/**
 * Created by Aaron on 26/10/2015.
 */
public class Sardine extends Fish {

    private static Creature ALPHA;

    public Sardine(Location location){
        super(location);
    }

    public Sardine(String name){
        super(name);
        ALPHA = this;
    }

    public Sardine() {

    }

    public Creature getRandomInstance(Location location){
        Creature c = new Sardine(location);
        c.setRandomAge();
        return c;
    }

    @Override
    protected Creature getAlpha() {
        return ALPHA;
    }

    @Override
    public Creature getNewborn() {
        return new Sardine();
    }

    @Override
    public void step() {

    }
}
