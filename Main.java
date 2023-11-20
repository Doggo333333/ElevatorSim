/*
Sankalp Rawoorkar
CS 245
This project is a simulation of an elevator.
*/

public class Main {
    public static void main(String[] args) {
        String configFile;

        if (args.length > 0) {
            configFile = args[0];
        } else {
            configFile = "config.properties";
        }

        // initialize and run the simulation with the specified config file
        Simulation simulation = new Simulation(configFile);
        simulation.runSimulation();
    }
}
