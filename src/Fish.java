import java.util.Iterator;

/**
 * Created by Aaron on 26/10/2015.
 */
public abstract class Fish extends Creature{
    protected double foodLevel;

    protected Fish(Location location, Field field) {
        super(location, field);

        foodLevel = foodLevel();
    }
    protected Fish(String name){
        super(name);
    }

    @Override
    public void step(){
        super.step();
        hungerCalculation();
        findFood();
    }

    protected void findFood(){

        Iterator<Location> iterator = field.adjacentLocations(location);

        while (iterator.hasNext()) {

            Location newLocation = iterator.next();
            Creature creature = field.getObjectAt(newLocation);
            if(creature!= null) {
                if (food.contains(creature.getAlpha())) {

                    field.place(null, location);
                    location = newLocation;
                    foodLevel+= creature.nutritionalValue();
                    field.place(this, location);
                    return;
                }
            }
        }

        swim();
    }

    protected void swim() {

        Location newLocation = field.freeAdjacentLocation(location);
        if(newLocation == null){
            die();
        }else {
            field.place(null,location);
            location = newLocation;
            field.place(this, location);
        }

    }

    protected void hungerCalculation(){
        foodLevel-= foodDelta();
        if(foodLevel <= 0){
            die();
        }
    }

    protected Double foodLevel(){
        return getValue(Constants.FOOD_LEVEL).getValue().doubleValue();
    }

    protected Double foodDelta(){
        return getValue(Constants.FOOD_DELTA).getValue().doubleValue();
    }
}
