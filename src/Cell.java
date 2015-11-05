import javax.swing.*;
import java.awt.*;
import java.util.HashSet;

/**
 * Created by Aaron on 5/11/2015.
 */
public class Cell {

    private NumericalDataType numericalDataType;
    private JTextField box;
    private Number value;
    private Number tempValue;
    private boolean valid;
    private TypeConstraint typeConstraint;
    private HashSet<Constraint> constraints;

    public Cell(NumericalDataType numericalDataType){
        this.numericalDataType = numericalDataType;

        init();
    }

    private void init() {
        box = new JTextField();

        tempValue = null;
        valid = false;
        typeConstraint = numericalDataType.getTypeConstraint();
        value = typeConstraint.getDefault();
        box.setText("" + value);
        constraints = numericalDataType.getConstraints();
    }


    public JTextField getBox() {
        return box;
    }

    public void setValue(Number value){
        this.value = value;
    }

    public Number getValue(){
        return value;
    }

    public void update(){
        tempValue = typeConstraint.updateNumber(this);
    }

    public void parseValue(){
        tempValue = typeConstraint.parseNumber(this);

        if(valid){
            for(Constraint constraint : constraints){
                constraint.validate(this);
            }
        }
        if (valid){
            value = tempValue;
        }else {
            box.setBackground(Color.red);
        }
        valid = false;
    }

    public void setValid(boolean bool){
        valid = bool;
    }

    public Number tempValue(){
        return tempValue;
    }

    public NumericalDataType getField(){
        return numericalDataType;
    }
}
