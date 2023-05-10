package behavioral.strategy.navigation;

import java.util.List;

public class TollFreeStrategy implements NavigationStrategy {
    @Override
    public List<String> getDirections(String origin, String destination) {
        // Implementation of algorithm to find the route with the fewest tolls
        return List.of();
    }
}
