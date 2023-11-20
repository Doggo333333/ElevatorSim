public class Passenger {
    private int currentFloor;
    private int destinationFloor;
    private boolean inElevator;
    private int waitTime;
    private Elevator requestedElevator;

    public Passenger(int currentFloor, int destinationFloor) {
        if (currentFloor < 1 || destinationFloor < 1 || currentFloor == destinationFloor) {
            throw new IllegalArgumentException("Invalid floor numbers");
        }
        this.currentFloor = currentFloor;
        this.destinationFloor = destinationFloor;
        this.inElevator = false;
        this.waitTime = 0;
    }

    public void exitElevator() {
        if (inElevator && requestedElevator.getCurrentFloor() == destinationFloor) {
            inElevator = false;
            requestedElevator.releasePassenger(this);
            requestedElevator = null;
        }
    }

    // Getters
    public int getCurrentFloor() { return currentFloor; }
    public int getDestinationFloor() { return destinationFloor; }
    public boolean isInElevator() { return inElevator; }
    public int getWaitTime() { return waitTime; }
    public void incrementWaitTime() {
        this.waitTime++;
    }

}
