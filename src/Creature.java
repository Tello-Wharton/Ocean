import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Objects;

/**
 * Created by Aaron on 26/10/2015.
 */
public abstract class Creature {

    protected HashSet<Creature> food;
    protected String name;
    protected Location location;
    protected int age;
    protected int maximumAge;

    protected Creature(Location location){
        this.location = location;

        init();
    }

    protected Creature(String name) {
        this.name = name;
        this.food = new HashSet<>();
    }

    protected Creature() {
        init();
    }

    private void init(){
        food = getSafeAlpha().getFood();
        name = getName();
        age = 0;
        maximumAge = maxAge();
    }

    protected abstract Creature getAlpha();
    public abstract Creature getRandomInstance(Location location);
    public abstract Creature getNewborn();

    public String getName(){
        if(name.isEmpty()){
            name = getSafeAlpha().getName();
            return name;
        }else {
            return name;
        }
    }

    public abstract void step();

    protected double creationProbability(){
        return getValue(Constants.CREATION_PROBABILITY, getSafeAlpha()).getValue().doubleValue();
    }

    protected double breedingProbability(){
        return getValue(Constants.BREEDING_PROBABILITY, getSafeAlpha()).getValue().doubleValue();
    }

    protected int maxAge(){
        return getValue(Constants.MAXIMUM_AGE, getSafeAlpha()).getValue().intValue();
    }

    protected int breedingAge(){
        return getValue(Constants.BREEDING_AGE, getSafeAlpha()).getValue().intValue();
    }

    protected double nutritionalValue(){
        return getValue(Constants.NUTRITIONAL_VALUE, getSafeAlpha()).getValue().doubleValue();
    }

    protected static Cell getValue(NumericalDataType field, Creature creature){
        return Constants.CREATURE_DATA[Constants.CF_KEY.indexOf(field)][Constants.CREATURE_KEY.indexOf(creature)];
    }

    protected void setRandomAge(){
        age = (int) (maxAge() * RandomGenerator.getRandom().nextDouble());
    }

    public Creature getSafeAlpha(){
        if(getAlpha() == null){
            throw new NullPointerException("All creatures should have an alpha defined");
        }else {
            return getAlpha();
        }
    }

    protected void age(){
        age+= 1;
        if(age >= maxAge()){
            //die
        }
    }

    public HashSet<Creature> getFood(){
        return food;
    }

}
