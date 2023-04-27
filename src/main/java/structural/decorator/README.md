# Decorator Pattern
The Decorator pattern is a design pattern that allows you to add behavior to an object dynamically at runtime. It is a structural pattern that involves wrapping an object in another object, which adds additional functionality or modifies the behavior of the original object without changing its structure.

The main idea behind the Decorator pattern is to provide a flexible way to add functionality to an object without having to create a new subclass for every possible combination of features. This makes it easy to add new functionality to an existing object hierarchy without modifying the existing classes.

In Java, the Decorator pattern can be implemented using the following steps:

1.  Define an interface or abstract class that represents the base component.
2.  Define one or more concrete classes that implement the base component.
3.  Define an abstract decorator class that implements the same interface as the base component.
4.  Define one or more concrete decorator classes that extend the abstract decorator class and add additional functionality.
5.  Create objects by wrapping the base component in one or more decorator objects.

Here's an example that demonstrates how the Decorator pattern can be used to add additional functionality to a basic coffee object:
```java
// Step 1: Define the base component interface
interface Coffee {
    double getCost();
    String getDescription();
}

// Step 2: Define the concrete component class
class SimpleCoffee implements Coffee {
    @Override
    public double getCost() {
        return 1.0;
    }

    @Override
    public String getDescription() {
        return "Simple coffee";
    }
}

// Step 3: Define the abstract decorator class
abstract class CoffeeDecorator implements Coffee {
    protected final Coffee decoratedCoffee;

    public CoffeeDecorator(Coffee decoratedCoffee) {
        this.decoratedCoffee = decoratedCoffee;
    }

    public double getCost() {
        return decoratedCoffee.getCost();
    }

    public String getDescription() {
        return decoratedCoffee.getDescription();
    }
}

// Step 4: Define one or more concrete decorator classes
class Milk extends CoffeeDecorator {
    public Milk(Coffee decoratedCoffee) {
        super(decoratedCoffee);
    }

    public double getCost() {
        return super.getCost() + 0.5;
    }

    public String getDescription() {
        return super.getDescription() + ", milk";
    }
}

class Whip extends CoffeeDecorator {
    public Whip(Coffee decoratedCoffee) {
        super(decoratedCoffee);
    }

    public double getCost() {
        return super.getCost() + 0.7;
    }

    public String getDescription() {
        return super.getDescription() + ", whipped cream";
    }
}

// Step 5: Create objects by wrapping the base component in one or more decorator objects
public class DecoratorPatternExample {
    public static void main(String[] args) {
        Coffee coffee = new SimpleCoffee();
        System.out.println(coffee.getDescription() + " costs $" + coffee.getCost());

        Coffee coffeeWithMilk = new Milk(coffee);
        System.out.println(coffeeWithMilk.getDescription() + " costs $" + coffeeWithMilk.getCost());

        Coffee coffeeWithMilkAndWhip = new Whip(coffeeWithMilk);
        System.out.println(coffeeWithMilkAndWhip.getDescription() + " costs $" + coffeeWithMilkAndWhip.getCost());
    }
}
```
In this example, we start by defining the base `Coffee` interface, which has two methods: `getCost()` and `getDescription()`. Then, we define a concrete class `SimpleCoffee` that implements this interface.

Next, we define an abstract `CoffeeDecorator` class that implements the `Coffee` interface and has a `Coffee` object as a member variable.