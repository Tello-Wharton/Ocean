import java.util.ArrayList;
import java.util.HashMap;
import java.util.Objects;

/**
 * Created by Aaron on 26/10/2015.
 */
public abstract class Creature {

    protected int age;
    protected static ArrayList<String> CREATURES = new ArrayList<String>();





    public static void init() {
        for(HashMap<String, Double> map : Constants.CREATURE_CONSTANTS.values()){
            for(String name : CREATURES) {
                map.put(name, 0.0);
            }
        }

    }

    public static double getValue(String name, String className){
        return Constants.CREATURE_CONSTANTS.get(name).get(className);
    }

    public class SubFinder{
        public SubFinder(){
            System.out.println(this.getClass().getDeclaringClass());
        }
    }

}
