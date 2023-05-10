# Strategy Pattern
The strategy pattern is a design pattern that allows you to define a family of algorithms, encapsulate each one, and make them interchangeable. It enables you to change the behavior of an object at runtime, without directly changing the code of the object.

The strategy pattern involves two main components: the context and the strategy. The context is the object that uses the strategy and is responsible for invoking its behavior. The strategy is the interface that defines the algorithm to be executed.

The idea behind the strategy pattern is to encapsulate the behavior of an object, allowing it to change its behavior at runtime, without affecting the code that uses it. This can make the code more modular and easier to maintain, as the behavior of an object can be changed without having to modify the object itself.

In essence, the strategy pattern allows you to separate the behavior of an object from the object itself, enabling you to switch out different behaviors as needed.

### Examples
1.  Sorting Algorithms: In programming, sorting is a common task that involves arranging a collection of data in a specific order. There are various sorting algorithms such as Bubble Sort, Merge Sort, and Quick Sort, which can be implemented using the strategy pattern.

2.  Payment Gateways: Payment gateways are services that authorize and process transactions between a merchant and a customer's bank. Different payment gateways use different algorithms to process transactions. The strategy pattern can be used to encapsulate these algorithms and make them interchangeable.

3.  Navigation: Navigation applications can use the strategy pattern to provide users with different options for finding directions. For example, a user might have the option to choose the fastest route, the most scenic route, or the route with the fewest tolls.

### Simple Example
Suppose we are building a game that has different levels of difficulty. We want to implement a strategy pattern to encapsulate the different levels of difficulty and make them interchangeable at runtime.
```java
// Define the strategy interface
public interface DifficultyLevel {
    public int getMultiplier();
}

// Implement the strategies
public class EasyLevel implements DifficultyLevel {
    public int getMultiplier() {
        return 1;
    }
}

public class MediumLevel implements DifficultyLevel {
    public int getMultiplier() {
        return 2;
    }
}

public class HardLevel implements DifficultyLevel {
    public int getMultiplier() {
        return 3;
    }
}

// Use the strategies
public class Game {
    private DifficultyLevel difficultyLevel;

    public Game(DifficultyLevel difficultyLevel) {
        this.difficultyLevel = difficultyLevel;
    }

    public void setDifficultyLevel(DifficultyLevel difficultyLevel) {
        this.difficultyLevel = difficultyLevel;
    }

    public int calculateScore(int score) {
        return score * difficultyLevel.getMultiplier();
    }
}
```
In this example, we define a `DifficultyLevel` interface that defines the strategy. We then implement the `DifficultyLevel` interface with the `EasyLevel`, `MediumLevel`, and `HardLevel` classes, each with their own `getMultiplier()` method.

Finally, we use the `DifficultyLevel` interface in the `Game` class. The `Game` class takes a `DifficultyLevel` object as a parameter and calculates the score using the `getMultiplier()` method of the strategy. The `Game` class also provides a `setDifficultyLevel()` method to allow for changing the strategy at runtime.