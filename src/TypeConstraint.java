import javax.swing.*;

/**
 * Created by Aaron on 5/11/2015.
 */
public interface TypeConstraint {
    Number parseNumber(Cell data);
    Number updateNumber(Cell cell);
    Number getDefault();
}
