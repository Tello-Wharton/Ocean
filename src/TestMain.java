import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.lang.reflect.Array;
import java.util.Collection;
import java.util.Iterator;

/**
 * Created by Aaron on 26/10/2015.
 */
public class TestMain {
    public static void main(String args[]){

        PrintWriter writer = null;
        try {
            writer = new PrintWriter("data.csv", "UTF-8");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }

        writer.println("");
        writer.println("The second line");

        writer.close();
    }


}
