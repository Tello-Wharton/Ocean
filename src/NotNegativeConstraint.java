/**
 * Created by Aaron on 5/11/2015.
 */
public class NotNegativeConstraint extends Constraint{
    private ErrorMessage errorMessage = ErrorMessage.getDataErrorMessage();

    public NotNegativeConstraint(){}

    @Override
    public void validate(Cell cell) {
        if (cell.tempValue().doubleValue() < 0){
            cell.setValid(false);
            errorMessage.addMessage(cell.getField().getName() + " cannot be negative");
        }
    }
}
