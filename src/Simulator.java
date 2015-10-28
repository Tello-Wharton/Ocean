

/**
 * Created by Aaron on 27/10/2015.
 */
public class Simulator {

    SimulatorView view;
    Field field;


    public static void main(String[] args){
        new Simulator();
    }

    public Simulator(){
        view = new SimulatorView(100,100);
        view.setVisible(true);
        populateField();

        System.out.println(Constants.CREATURE_CONSTANTS);

    }

    public void populateField(){
        field = new Field(100,100);
        view.showStatus(0, field);

    }
}
