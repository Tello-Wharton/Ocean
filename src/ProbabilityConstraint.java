/**
 * Created by Aaron on 5/11/2015.
 */
public class ProbabilityConstraint extends Constraint {
    private ErrorMessage errorMessage = ErrorMessage.getDataErrorMessage();

    public ProbabilityConstraint(){

    }
    @Override
    public void validate(Cell cell) {
        double value = cell.tempValue().doubleValue();
        if (value < 0 || value > 1){
            cell.setValid(false);
            errorMessage.addMessage(cell.getField().getName() + " must be between zero and one (inclusive)");
        }
    }
}
