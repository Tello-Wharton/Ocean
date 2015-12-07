import javax.swing.*;

/**
 * Created by Aaron on 14/11/2015.
 */
public class DeadCreatureException extends RuntimeException {
    public DeadCreatureException(){
        super("I am dead :D");
    }
}
