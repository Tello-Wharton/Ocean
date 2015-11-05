import javax.swing.*;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by Aaron on 4/11/2015.
 */
public class ErrorMessage {
    private static ErrorMessage DATA_ERROR_MESSAGE = new ErrorMessage();

    public static ErrorMessage getDataErrorMessage() {
        return DATA_ERROR_MESSAGE;
    }

    private Set<String> messages;

    private ErrorMessage() {
        messages = new HashSet<String>();
    }

    public void addMessage(String m){
        messages.add(m);
    }

    public boolean show(String error){
        String message = "";
        if(messages.size() > 0) {
            for(String m : messages){
                message+= m;
                message+= "\n";
            }
            JOptionPane.showMessageDialog(new JFrame(), message, error, JOptionPane.ERROR_MESSAGE);
            return true;
        }
        return false;
    }

    public void clearMessage(){
        messages = new HashSet<String>();
    }
}
