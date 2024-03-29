import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

// this is where the default values are stored. These values are only used if the file does not exist.
public class Configuration {
    // the properties object is used to store configuration settings
    private final Properties properties = new Properties();

    // default values for each configuration setting, used if the properties file is not found
    private static final String DEFAULT_STRUCTURE = "linked";
    private static final int DEFAULT_FLOORS = 32;
    private static final double DEFAULT_PASSENGERS = 0.03;
    private static final int DEFAULT_ELEVATORS = 1;
    private static final int DEFAULT_ELEVATOR_CAPACITY = 10;
    private static final int DEFAULT_DURATION = 500;

    public Configuration(String filename) {
        try {
            // if given a file it will load it with the values in the file, however if not it will use default values.
            properties.load(new FileInputStream(filename));
        } catch (IOException e) {
            // this catches the error message and then runs the code with default values.
            setDefaultProperties();
        }
    }
    private void setDefaultProperties() {
        properties.setProperty("structures", DEFAULT_STRUCTURE);
        properties.setProperty("floors", Integer.toString(DEFAULT_FLOORS));
        properties.setProperty("passengers", Double.toString(DEFAULT_PASSENGERS));
        properties.setProperty("elevators", Integer.toString(DEFAULT_ELEVATORS));
        properties.setProperty("elevatorCapacity", Integer.toString(DEFAULT_ELEVATOR_CAPACITY));
        properties.setProperty("duration", Integer.toString(DEFAULT_DURATION));
    }

    // getters
    public int  getFloors() {
        return Integer.parseInt(properties.getProperty("floors", String.valueOf(DEFAULT_FLOORS)));
    }

    public double getPassengerProbability() {
        return Double.parseDouble(properties.getProperty("passengers", String.valueOf(DEFAULT_PASSENGERS)));
    }

    public int getElevators() {
        return Integer.parseInt(properties.getProperty("elevators", String.valueOf(DEFAULT_ELEVATORS)));
    }

    public int getElevatorCapacity() {
        return Integer.parseInt(properties.getProperty("elevatorCapacity", String.valueOf(DEFAULT_ELEVATOR_CAPACITY)));
    }

    public int getDuration() {
        return Integer.parseInt(properties.getProperty("duration", String.valueOf(DEFAULT_DURATION)));
    }

}

