/**
 * Created by Aaron on 26/10/2015.
 */
public class Shark extends Fish {
    private static Double creationProbability;
    private static boolean generateProbability = true;

    public Shark(){

    }
    @Override
    public void step() {

    }

    @Override
    protected Double generateProbability() {
        return null;
    }

    @Override
    public Creature birth() {
        return this;
    }
}
