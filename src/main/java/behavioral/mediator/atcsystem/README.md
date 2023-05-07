# Air Traffic Control System
In this system, the ATC tower acts as a mediator between the pilots of various flights. The ATC system tracks the flights and provides the pilots with information about the position and altitude of other planes in the airspace. The ATC system also helps to prevent collisions by directing pilots to avoid certain areas or change their altitude or course.
```java
// Colleague class
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

// Mediator class
public class AirTrafficControlTower {
    private List<Flight> flights = new ArrayList<>();

    public void registerFlight(Flight flight) {
        flights.add(flight);
    }

    public void sendWarning(Flight flight, String warning) {
        flights.stream()
                .filter(f -> f != flight)
                .forEach(f -> f.sendWarning(flight, warning));
    }
}

// Client code
public class Client {
    public static void main(String[] args) {
        AirTrafficControlTower controlTower = new AirTrafficControlTower();
        Flight f1 = new Flight("ABC123", controlTower);
        Flight f2 = new Flight("DEF456", controlTower);
        Flight f3 = new Flight("GHI789", controlTower);

        controlTower.registerFlight(f1);
        controlTower.registerFlight(f2);
        controlTower.registerFlight(f3);

        f1.setAltitude("1000 feet");
        f2.setAltitude("2000 feet");
    }
}
```
`Flight` is a concrete colleague class that interacts with other colleagues via the `AirTrafficControlTower` mediator.

The `Flight` class has a `setAltitude` method which sets the current altitude of the flight and also sends a warning to other flights via the `AirTrafficControlTower` mediator. The `registerFlight` method is implemented because `Flight` is a colleague, but it does not need to do anything in this case. The `sendWarning` method is also implemented to display the warning for other flights.

`AirTrafficControlTower` keeps track of all the flights that are registered with it and sends warnings to all other flights except the flight that triggered the warning.

Finally, in the client code, we create three flights and register them with the `AirTrafficControlTower` mediator. Then we set the altitude of two of the flights and see the warnings being sent to the other flights.