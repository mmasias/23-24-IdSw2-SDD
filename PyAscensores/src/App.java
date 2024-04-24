import Controllers.InitialValues;
import Controllers.Simulation;

public class App {
    public static void main(String[] args) {
        InitialValues values = new InitialValues(5, 3);
        Simulation simulation = new Simulation(values);
        simulation.start();
    }
}
