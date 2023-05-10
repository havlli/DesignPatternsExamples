package behavioral.strategy.navigation;

import java.util.List;

public interface NavigationStrategy {
    public List<String> getDirections(String origin, String destination);
}
