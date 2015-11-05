import java.awt.*;
import java.util.HashSet;


/**
 * Created by Aaron on 5/11/2015.
 */
public class TotalProbabilityConstraint extends Constraint {

    private ErrorMessage errorMessage = ErrorMessage.getDataErrorMessage();
    private HashSet<Cell> cells;
    public TotalProbabilityConstraint(){
        cells = new HashSet<Cell>();
    }

    @Override
    public void validate(Cell cell) {
        cells.add(cell);
        double probability = 0;
        for(Cell c : cells){
            c.update();
            probability+= c.tempValue().doubleValue();
        }
        if (probability < 0 || probability > 1){
            cell.getField().getBox().setForeground(Color.red);
            errorMessage.addMessage(cell.getField().getName() + " must have a total between zero and one (inclusive)");
        }

    }
}
