import java.util.*;

/**
 * Created by Aaron on 26/10/2015.
 *
 *
 */
public abstract class Creature {

    //The set of Creatures that this Creature eats
    protected HashSet<Creature> food;
    //The name of this Creature
    protected String name;
    //The Location this Creature is situated in
    protected Location location;
    //The Field this Creature belongs to
    protected Field field;
    //The age of this creature
    protected int age;
    //When the Creature's age is no longer less than this, it dies
    protected int maximumAge;

    protected double breedingProbability;

    protected int breedingAge;

    private boolean hasProcessed;

    private Random random;

    //Main constructor for creating a creature
    protected Creature(Location location, Field field){
        this.location = location;
        this.field = field;
        field.place(this,location);
        init();
    }

    protected Creature() {
        init();
    }

    //Call this once and only once, before any other instance of this creature type is created (creates an alpha)
    protected Creature(String name) {
        this.name = name;
        this.food = new HashSet<>();
    }

    //Initializes variables not given in the constructor
    private void init(){
        food = getSafeAlpha().getFood();
        name = getName();
        age = 0;
        maximumAge = maxAge();
        hasProcessed = false;
        random = RandomGenerator.getRandom();
        breedingProbability = breedingProbability();
        breedingAge = breedingAge();
    }

    //Returns the original Creature of this type created
    protected abstract Creature getAlpha();
    //Returns Creature at the desired location,
    public abstract Creature getRandomInstance(Location location, Field field);
    //Returns a newly born Creature
    public abstract Creature getNewborn(Location location);

    //Returns the name of this Creature
    public String getName(){
        if(name != null) {
            if (name.isEmpty()) {
                name = getSafeAlpha().getName();
                return name;
            }
        }
        return name;
    }

    //Increments a step of 1 year
    public void step(){
        age();

        birth();

    }

    //Calculates age and kills the creature if necessary
    protected void age(){
        age+= 1;
        if(age >= maxAge()){
            die();
        }
    }

    //Gets the creation probability of this Creature
    protected double creationProbability(){
        return getValue(Constants.CREATION_PROBABILITY).getValue().doubleValue();
    }
    //Gets the breeding probability of this Creature
    protected double breedingProbability(){
        return getValue(Constants.BREEDING_PROBABILITY).getValue().doubleValue();
    }
    //Gets the maximum age of this Creature
    protected int maxAge(){
        return getValue(Constants.MAXIMUM_AGE).getValue().intValue();
    }
    //Gets the breeding age of this Creature
    protected int breedingAge(){
        return getValue(Constants.BREEDING_AGE).getValue().intValue();
    }
    //Gets the nutritional value of this Creature
    protected double nutritionalValue(){
        return getValue(Constants.NUTRITIONAL_VALUE).getValue().doubleValue();
    }
    //Gets the value of a Cell for this Creature
    protected Cell getValue(NumericalDataType field){
        return Constants.CREATURE_DATA[Constants.CF_KEY.indexOf(field)][Constants.CREATURE_KEY.indexOf(getSafeAlpha())];
    }
    //Sets a random age for this Creature
    protected void setRandomAge(){
        age = (int) (maxAge() * RandomGenerator.getRandom().nextDouble());
    }
    //Gets the alpha of this Creature
    public Creature getSafeAlpha(){
        if(getAlpha() == null){
            throw new NullPointerException("All creatures should have an alpha defined");
        }else {
            return getAlpha();
        }
    }

    protected void die()throws DeadCreatureException{
        field.place(null,location);
        throw new DeadCreatureException();
    }

    public HashSet<Creature> getFood(){
        return food;
    }

    public void setFood(Creature... creatures){
        for(Creature creature : creatures){
            food.add(creature);
        }
    }

    public void setHasProcessed(boolean hasProcessed){
        this.hasProcessed = hasProcessed;
    }

    public boolean hasProcessed(){
        return hasProcessed;
    }

    private void birth(){
        if (age >= breedingAge) {
            if (breedingProbability > random.nextDouble()) {
                Location birthLocation = field.freeAdjacentLocation(location);
                if (birthLocation != null) {
                    getNewborn(birthLocation);
                }
            }
        }
    }
}
