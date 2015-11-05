import java.lang.reflect.InvocationTargetException;
import java.util.Collection;
import java.util.HashMap;
import java.util.Random;

/**
 * Created by Aaron on 29/10/2015.
 */
public class CreatureFactory {

    public static Creature[] CREATURES = {new Shark("Shark"), new Sardine("Sardine"), new Plankton("Plankton")};

    public CreatureFactory(){

    }

    public Creature getRandom(Location location) {
        Random generatedRandom = RandomGenerator.getRandom();
        double random = generatedRandom.nextDouble();
        double probability = 0;
        for (Creature creature : CREATURES) {
            probability += creature.creationProbability();
            if (random - probability < 0) {
                return creature.getNewInstance(0,location);
            }
        }
        return null;
    }

}
