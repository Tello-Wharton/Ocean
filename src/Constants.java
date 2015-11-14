import java.util.ArrayList;
import java.util.Arrays;

/**
 * Created by Aaron on 26/10/2015.
 */
public class Constants {

    public static NumericalDataType CREATION_PROBABILITY = new NumericalDataType("<html><center>Creation<br/>Probability</center></html>", "Creation Probability", new DoubleConstraint());
    public static NumericalDataType BREEDING_PROBABILITY = new NumericalDataType("<html><center>Breeding<br/>Probability</center></html>", "Breeding Probability", new DoubleConstraint());
    public static NumericalDataType MAXIMUM_AGE = new NumericalDataType("<html><center>Maximum<br/>Age</center></html>", "Maximum Age", new IntegerConstraint());
    public static NumericalDataType BREEDING_AGE = new NumericalDataType("<html><center>Breeding<br/>Age</center></html>", "Breeding Age", new IntegerConstraint());
    public static NumericalDataType NUTRITIONAL_VALUE = new NumericalDataType("<html><center>Nutritional<br/>Value</center></html>", "Nutritional Value", new DoubleConstraint());
    public static NumericalDataType FOOD_LEVEL = new NumericalDataType("<html><center>Food<br/>Level</center></html>", "Food level", new DoubleConstraint());
    public static NumericalDataType FOOD_DELTA = new NumericalDataType("<html><center>Food<br/>Depreciation</center></html>", "Food Depreciation", new DoubleConstraint());

    public static NumericalDataType[] CREATURE_FIELDS = {CREATION_PROBABILITY,BREEDING_PROBABILITY,MAXIMUM_AGE,BREEDING_AGE,NUTRITIONAL_VALUE};
    public static NumericalDataType[] FISH_FIELDS = {FOOD_LEVEL,FOOD_DELTA};

    public static Creature[] CREATURES = CreatureFactory.CREATURES;

    public static ArrayList<NumericalDataType> CF_KEY;
    public static ArrayList<Creature> CREATURE_KEY;

    public static Cell[][] CREATURE_DATA;

    public static void init(){
        CF_KEY = new ArrayList<NumericalDataType>();
        CF_KEY.addAll(Arrays.asList(CREATURE_FIELDS));
        CF_KEY.addAll(Arrays.asList(FISH_FIELDS));

        CREATURE_KEY = new ArrayList<Creature>(Arrays.asList(CREATURES));

        CREATION_PROBABILITY.addConstraints(new TotalProbabilityConstraint(), new ProbabilityConstraint());
        BREEDING_PROBABILITY.addConstraints(new ProbabilityConstraint());
        MAXIMUM_AGE.addConstraints(new NotNegativeConstraint());
        BREEDING_AGE.addConstraints(new NotNegativeConstraint());

        FOOD_LEVEL.addConstraints(new NotNegativeConstraint());


        CREATURE_DATA = new Cell[CF_KEY.size()][CREATURE_KEY.size()];

        for(int y = 0; y < CREATURES.length; y ++){
            int x = 0;
            for(NumericalDataType numericalDataType : CREATURE_FIELDS){
                CREATURE_DATA[x][y] = new Cell(numericalDataType);
                x+= 1;
            }
            for(NumericalDataType numericalDataType : FISH_FIELDS){
                if(CREATURES[y] instanceof Fish) {
                    CREATURE_DATA[x][y] = new Cell(numericalDataType);
                }
                x+= 1;
            }

        }
    }
}
