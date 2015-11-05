import javax.swing.*;

/**
 * Created by Aaron on 5/11/2015.
 */
public class DoubleConstraint implements TypeConstraint {

    private static ErrorMessage errorMessage = ErrorMessage.getDataErrorMessage();
    public DoubleConstraint(){}

    @Override
    public Number parseNumber(Cell cell) {
        JTextField box = cell.getBox();
        try{
            cell.setValid(true);
            return Double.parseDouble(box.getText());
        }catch (NumberFormatException e){
            cell.setValid(false);
            errorMessage.addMessage(cell.getField().getName() + " may only be a decimal number");
            return cell.getValue();
        }
    }

    @Override
    public Number updateNumber(Cell cell) {
        JTextField box = cell.getBox();
        try{
            return Double.parseDouble(box.getText());
        }catch (NumberFormatException e){
            cell.setValid(false);
            errorMessage.addMessage(cell.getField().getName() + " may only be a decimal number");
            return cell.getValue();
        }
    }

    @Override
    public Number getDefault() {
        return new Double(0);
    }
}
