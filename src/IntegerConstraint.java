import javax.swing.*;

/**
 * Created by Aaron on 5/11/2015.
 */
public class IntegerConstraint implements TypeConstraint {
    private static ErrorMessage errorMessage = ErrorMessage.getDataErrorMessage();
    public IntegerConstraint(){}

    @Override
    public Number parseNumber(Cell cell) {
        JTextField box = cell.getBox();
        try{
            cell.setValid(true);
            return Integer.parseInt(box.getText());
        }catch (NumberFormatException e){
            cell.setValid(false);
            errorMessage.addMessage(cell.getField().getName() + " may only be an integer");
            return cell.getValue();
        }
    }

    @Override
    public Number updateNumber(Cell cell) {
        JTextField box = cell.getBox();
        try{
            return Integer.parseInt(box.getText());
        }catch (NumberFormatException e){
            cell.setValid(false);
            errorMessage.addMessage(cell.getField().getName() + " may only be an integer");
            return cell.getValue();
        }
    }

    @Override
    public Number getDefault() {
        return new Integer(0);
    }
}
