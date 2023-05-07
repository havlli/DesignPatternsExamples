package behavioral.mediator.atcsystem;

import java.util.ArrayList;
import java.util.List;

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
