package behavioral.strategy.navigation;

import java.util.List;

public class NavigationApp {
    private NavigationStrategy navigationStrategy;

    public NavigationApp(NavigationStrategy navigationStrategy) {
        this.navigationStrategy = navigationStrategy;
    }

    public void setNavigationStrategy(NavigationStrategy navigationStrategy) {
        this.navigationStrategy = navigationStrategy;
    }

    public List<String> getDirections(String origin, String destination) {
        return navigationStrategy.getDirections(origin, destination);
    }
}
