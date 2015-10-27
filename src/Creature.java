/**
 * Created by Aaron on 26/10/2015.
 */
public abstract class Creature {
    protected int age;
    protected int lifespan;

    public Creature(){
        String className = this.getClass().getName();
        Constants.CREATION_PROBABILITIES.put(className, generateProbability());

    }

    public abstract void step();

    protected abstract Double generateProbability();

    public abstract Creature birth();

    private void name(){
        this.getClass().getName();
    }
}
