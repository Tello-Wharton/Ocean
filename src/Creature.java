import java.util.ArrayList;
import java.util.HashMap;
import java.util.Objects;

/**
 * Created by Aaron on 26/10/2015.
 */
public abstract class Creature {

    protected String name;

    protected int age;
    protected Location location;

    protected Creature(int age, Location location){
        this.age = age;
        this.location = location;
    }

    protected Creature(){}

    public abstract Creature getNewInstance(int age,Location location);

    public abstract Creature getAlpha();

    public String getName(){
        if(name.isEmpty()){
            return getAlpha().getName();
        }else {
            return name;
        }
    }

    protected void step(){
        age += 1;
    }

    protected double creationProbability(){
        return getValue(Constants.CREATION_PROBABILITY, getAlpha()).getValue().doubleValue();
    }

    protected double breedingProbability(){
        return getValue(Constants.BREEDING_PROBABILITY, getAlpha()).getValue().doubleValue();
    }

    protected int maxAge(){
        return getValue(Constants.MAXIMUM_AGE, getAlpha()).getValue().intValue();
    }

    protected int breedingAge(){
        return getValue(Constants.BREEDING_AGE, getAlpha()).getValue().intValue();
    }

    protected double nutritionalValue(){
        return getValue(Constants.NUTRITIONAL_VALUE, getAlpha()).getValue().doubleValue();
    }

    protected static Cell getValue(NumericalDataType field, Creature creature){
        return Constants.CREATURE_DATA[Constants.CF_KEY.indexOf(field)][Constants.CREATURE_KEY.indexOf(creature)];
    }

}
