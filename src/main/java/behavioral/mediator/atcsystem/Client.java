package behavioral.mediator.atcsystem;

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
