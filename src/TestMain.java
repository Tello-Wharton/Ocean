import java.io.*;
import java.lang.reflect.Array;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

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

        writer.println(",Creation Probability,Breeding Probability,...");
        writer.println("Shark,1,2,3,");




        writer.close();


        List<String> file;
        try {
            file = Files.readAllLines(Paths.get("data.csv"), Charset.defaultCharset());

            for(String string : file){
                System.out.println(string);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }


    }


}
