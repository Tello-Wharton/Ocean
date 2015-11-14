/**
 * Created by Aaron on 26/10/2015.
 */
public class Shark extends Fish {

    private static Creature ALPHA;

    private Shark(Location location, Field field) {
        super(location, field);
    }

    public Shark(String name){
        super(name);
        ALPHA = this;
    }

    public Creature getRandomInstance(Location location, Field field){
        Creature c = new Shark(location, field);
        c.setRandomAge();
        return c;
    }

    @Override
    protected Creature getAlpha() {
        return ALPHA;
    }

    @Override
    public Creature getNewborn(Location location) {
        return new Shark(location, field);
    }



}
