import java.util.Random;

/**
 * Created by Aaron on 29/10/2015.
 */
public class CreatureFactory {

    public static Creature SHARK = new Shark("Shark");
    public static Creature SARDINE = new Sardine("Sardine");
    public static Creature PLANKTON = new Plankton("Plankton");

    public static Creature[] CREATURES = {SHARK, SARDINE, PLANKTON};
    public static void init(){

    }

    public CreatureFactory(){

    }

    public Creature getRandom(Location location) {
        Random generatedRandom = RandomGenerator.getRandom();
        double random = generatedRandom.nextDouble();
        double probability = 0;
        for (Creature creature : CREATURES) {
            probability += creature.creationProbability();
            if (random - probability < 0) {
                return creature.getRandomInstance(location);
            }
        }
        return null;
    }

}
