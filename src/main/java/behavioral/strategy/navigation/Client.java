package behavioral.strategy.navigation;

import java.util.List;

public class Client {
    public static void main(String[] args) {
        NavigationApp navigationApp = new NavigationApp(new FastestRouteStrategy());
        List<String> directions = navigationApp.getDirections("New York", "Los Angeles");

        navigationApp.setNavigationStrategy(new ScenicRouteStrategy());
        directions = navigationApp.getDirections("New York", "Los Angeles");

        navigationApp.setNavigationStrategy(new TollFreeStrategy());
        directions = navigationApp.getDirections("New York", "Los Angeles");
    }
}
