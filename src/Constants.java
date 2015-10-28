import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created by Aaron on 26/10/2015.
 */
public class Constants {
    public static Double TOTAL_CREATION_PROBABILITY = 0.0;
    public static HashMap<String,HashMap<String,Double>> CREATURE_CONSTANTS = new HashMap<String,HashMap<String,Double>>();
    public static String[] CREATURE_FIELDS = {"Creation Probability","Breeding Probability","Maximum Age","Breeding Age","Nutritional Value"};

    static{
        for(String name : CREATURE_FIELDS){
            CREATURE_CONSTANTS.put(name,new HashMap<String,Double>());
        }
    }

    public static void init(){
        Creature.init();
        System.out.println(CREATURE_CONSTANTS);
    }


}
