package src;

import src.Controllers.Values;
import src.Controllers.Simulation;

public class App {
    public static void main(String[] args) {
        Values values = new Values(5, 3);
        Simulation simulation = new Simulation(values);
        simulation.start(false);
    }
}
