import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created by Aaron on 26/10/2015.
 */
public class Constants {
    public static Double TOTAL_CREATION_PROBABILITY = 0.0;
    public static HashMap<String,HashMap<Creature,Number>> CREATURE_CONSTANTS = new HashMap<String,HashMap<Creature,Number>>();

    public static String CREATION_PROBABILITY = "Creation Probability";
    public static String BREEDING_PROBABILITY = "Breeding Probability";
    public static String MAXIMUM_AGE = "Maximum Age";
    public static String BREEDING_AGE = "Breeding Age";
    public static String NUTRITIONAL_VALUE = "Nutritional Value";
    public static String[] CREATURE_FIELDS = {CREATION_PROBABILITY,BREEDING_PROBABILITY,MAXIMUM_AGE,BREEDING_AGE,NUTRITIONAL_VALUE};





    static{
        for(String name : CREATURE_FIELDS){
            HashMap<Creature,Number> classValue = new HashMap<Creature,Number>();
            for(Creature c : CreatureFactory.CREATURES) {
                classValue.put(c,0.1);
            }
            CREATURE_CONSTANTS.put(name,classValue);
        }


    }





}
