import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

/**
 * Created by Aaron on 26/10/2015.
 */
public class Constants {
    public static Double TOTAL_CREATION_PROBABILITY = 0.0;


    public static String CREATION_PROBABILITY = "Creation Probability";
    public static String BREEDING_PROBABILITY = "Breeding Probability";
    public static String MAXIMUM_AGE = "Maximum Age";
    public static String BREEDING_AGE = "Breeding Age";
    public static String NUTRITIONAL_VALUE = "Nutritional Value";
    public static String[] CREATURE_FIELDS = {CREATION_PROBABILITY,BREEDING_PROBABILITY,MAXIMUM_AGE,BREEDING_AGE,NUTRITIONAL_VALUE};

    public static ArrayList<String> CF_KEY = new ArrayList<String>(Arrays.asList(CREATURE_FIELDS));
    public static ArrayList<Creature> CREATURE_KEY = new ArrayList<Creature>(Arrays.asList(CreatureFactory.CREATURES));


    //Formatting Data Types
    public static String[] INTEGERS = {MAXIMUM_AGE,BREEDING_AGE};
    public static String[] DOUBLES = {CREATION_PROBABILITY,BREEDING_PROBABILITY,NUTRITIONAL_VALUE};
    //Make Arrays
    public static ArrayList<String> INTEGERS_LIST = new ArrayList<String>(Arrays.asList(INTEGERS));
    public static ArrayList<String> DOUBLES_LIST = new ArrayList<String>(Arrays.asList(DOUBLES));


    public static Number[][] CREATURE_DATA;

    static{
        CREATURE_DATA = new Number[CF_KEY.size()][CREATURE_KEY.size()];
        for(int x = 0; x < CREATURE_DATA.length; x++){
            for(int y = 0; y < CREATURE_DATA[0].length; y++){
                Number number = new Double(0);
                String field = CF_KEY.get(x);
                if(INTEGERS_LIST.contains(field)){
                    number = new Integer(0);
                }
                if(DOUBLES_LIST.contains(field)){
                    number = new Double(0);
                }

                CREATURE_DATA[x][y] = number;
            }
        }
    }





}
