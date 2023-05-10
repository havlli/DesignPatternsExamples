# Navigation
Navigation applications can use the strategy pattern to provide users with different options for finding directions. For example, a user might have the option to choose the fastest route, the most scenic route, or the route with the fewest tolls.

First, we define an interface for our navigation strategies:
```java
public interface NavigationStrategy {
    public List<String> getDirections(String origin, String destination);
}
```
Next, we can create concrete implementations of the `NavigationStrategy` interface for each option:
```java
public class FastestRouteStrategy implements NavigationStrategy {
    public List<String> getDirections(String origin, String destination) {
        // Implementation of algorithm to find the fastest route
        return directions;
    }
}

public class ScenicRouteStrategy implements NavigationStrategy {
    public List<String> getDirections(String origin, String destination) {
        // Implementation of algorithm to find the most scenic route
        return directions;
    }
}

public class TollFreeRouteStrategy implements NavigationStrategy {
    public List<String> getDirections(String origin, String destination) {
        // Implementation of algorithm to find the route with the fewest tolls
        return directions;
    }
}
```
Then, we create a `NavigationApp` class that accepts a `NavigationStrategy` as a parameter and uses it to provide directions:
```java
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
```
Finally, we can use the `NavigationApp` class to provide different options for finding directions to the user:
```java
NavigationApp app = new NavigationApp(new FastestRouteStrategy());
List<String> directions = app.getDirections("New York", "Los Angeles");

// User selects the most scenic route
app.setNavigationStrategy(new ScenicRouteStrategy());
directions = app.getDirections("New York", "Los Angeles");

// User selects the route with the fewest tolls
app.setNavigationStrategy(new TollFreeRouteStrategy());
directions = app.getDirections("New York", "Los Angeles");
```
In this example, the `NavigationStrategy` interface and its concrete implementations encapsulate the different algorithms for finding directions, and the `NavigationApp` class provides a way to switch between them at runtime. This makes the code more modular and extensible, allowing for easy addition of new navigation options in the future.