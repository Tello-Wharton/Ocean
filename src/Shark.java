/**
 * Created by Aaron on 26/10/2015.
 */
public class Shark extends Fish {

    private static Creature ALPHA;

    public Shark(Location location) {
        super(location);
    }

    public Shark(String name){
        super(name);
        ALPHA = this;
    }

    public Shark() {
        super();
    }

    public Creature getRandomInstance(Location location){
        Creature c = new Shark(location);
        c.setRandomAge();
        return c;
    }

    @Override
    protected Creature getAlpha() {
        return ALPHA;
    }

    @Override
    public Creature getNewborn() {
        return new Shark();
    }

    @Override
    public void step() {

    }

}
