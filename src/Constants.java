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

    public static NumericalDataType[] CREATURE_FIELDS = {CREATION_PROBABILITY,BREEDING_PROBABILITY,MAXIMUM_AGE,BREEDING_AGE,NUTRITIONAL_VALUE};
    public static Creature[] CREATURES = CreatureFactory.CREATURES;

    public static ArrayList<NumericalDataType> CF_KEY;
    public static ArrayList<Creature> CREATURE_KEY;

    public static Cell[][] CREATURE_DATA;

    public static void init(){
        CF_KEY = new ArrayList<NumericalDataType>(Arrays.asList(CREATURE_FIELDS));
        CREATURE_KEY = new ArrayList<Creature>(Arrays.asList(CREATURES));

        CREATION_PROBABILITY.addConstraints(new TotalProbabilityConstraint(), new ProbabilityConstraint());
        BREEDING_PROBABILITY.addConstraints(new ProbabilityConstraint());
        MAXIMUM_AGE.addConstraints(new NotNegativeConstraint());
        BREEDING_AGE.addConstraints(new NotNegativeConstraint());


        CREATURE_DATA = new Cell[CREATURE_FIELDS.length][CREATURES.length];

        for(int x = 0; x < CREATURE_FIELDS.length; x++){
            for(int y = 0; y < CREATURES.length; y ++){
                CREATURE_DATA[x][y] = new Cell(CREATURE_FIELDS[x]);
            }
        }
    }
}
