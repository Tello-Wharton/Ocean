import java.util.ArrayList;
import java.util.HashMap;
import java.util.Objects;

/**
 * Created by Aaron on 26/10/2015.
 */
public abstract class Creature {

    protected int age;
    protected Location location;

    protected Creature(int age, Location location){
        this.age = age;
        this.location = location;
    }

    protected Creature(){}

    public abstract Creature getNewInstance(int age,Location location);

    public abstract Creature getAlpha();

    protected void step(){
        age += 1;
    }

    protected double creationProbability(){
        return getValue(Constants.CREATION_PROBABILITY, getAlpha()).doubleValue();
    }

    protected double breedingProbability(){
        return getValue(Constants.BREEDING_PROBABILITY, getAlpha()).doubleValue();
    }

    protected int maxAge(){
        return (int) getValue(Constants.MAXIMUM_AGE, getAlpha()).intValue();
    }

    protected int breedingAge(){
        return getValue(Constants.BREEDING_AGE, getAlpha()).intValue();
    }

    protected double nutritionalValue(){
        return getValue(Constants.NUTRITIONAL_VALUE, getAlpha()).doubleValue();
    }

    protected static Number getValue(String name, Creature creature){
        return Constants.CREATURE_CONSTANTS.get(name).get(creature);
    }

}
