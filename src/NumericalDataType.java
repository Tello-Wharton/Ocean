import javax.swing.*;
import java.awt.*;
import java.util.Arrays;
import java.util.HashSet;

/**
 * Created by Aaron on 3/11/2015.
 */
public class NumericalDataType {
    protected String name;
    protected String formattedName;
    protected TypeConstraint typeConstraint;
    protected HashSet<Constraint> constraints;
    protected JLabel box;

    public NumericalDataType(String formattedName, String name, TypeConstraint typeConstraint){
        this.formattedName = formattedName;
        this.name = name;
        this.typeConstraint = typeConstraint;

        init();

    }

    private void init() {
        constraints = new HashSet<Constraint>();
        box = new JLabel(formattedName);
        box.setForeground(Color.black);
    }

    public String getName(){
        return name;
    }

    public void addConstraints(Constraint... c){
        constraints.addAll(Arrays.asList(c));
    }

    public HashSet<Constraint> getConstraints() {
        return constraints;
    }

    public TypeConstraint getTypeConstraint() {
        return typeConstraint;
    }

    public JLabel getBox() {
        return box;
    }
}
