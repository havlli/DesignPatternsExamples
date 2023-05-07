package behavioral.mediator.atcsystem;

public class Flight {
    private String flightName;
    private String currentAltitude;
    private AirTrafficControlTower controlTower;

    public Flight(String flightName, AirTrafficControlTower controlTower) {
        this.flightName = flightName;
        this.controlTower = controlTower;
    }

    public void setAltitude(String altitude) {
        this.currentAltitude = altitude;
        controlTower.sendWarning(this, "Altitude is " + altitude);
    }

    public void sendWarning(Flight flight, String warning) {
        if (flight != this) {
            System.out.println("Flight " + this.flightName + " received warning: " + flight.getFlightName() + " : " + warning);
        }
    }

    public String getFlightName() {
        return flightName;
    }

    public String getCurrentAltitude() {
        return currentAltitude;
    }
}
