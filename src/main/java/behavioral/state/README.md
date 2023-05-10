Socket Adapters
Socket Adapters


# State Pattern
State pattern is a behavioral design pattern that allows an object to change its behavior when its internal state changes. The pattern encapsulates state-specific behavior and delegates the behavior to an object that represents the state. This allows the object to appear to change its class at runtime, depending on its current state.

The State pattern is particularly useful when an object needs to change its behavior dynamically based on its internal state, and when the number of states is relatively large. The pattern allows for a clear separation of concerns, by separating state-specific behavior from the object's general behavior.

The State pattern is made up of the following components:

1. Context: This is the object whose behavior changes based on its internal state. It maintains a reference to the current state object and delegates state-specific behavior to that object.

2. State: This is the interface or abstract class that defines the state-specific behavior. It declares the methods that the context can call to perform state-specific behavior.

3. Concrete State: These are the concrete implementations of the State interface or abstract class. Each concrete state implements the behavior associated with a particular state of the context.


The State pattern is often used in situations where an object can have a large number of states and the behavior of the object needs to change dynamically based on its internal state. It can be useful in many domains, such as finance, gaming, and simulation.

### Examples
1. [Order Processing](https://github.com/havlli/DesignPatternsExamples/tree/master/src/main/java/behavioral/state/orderprocessing)
2. [Vending Machine](https://github.com/havlli/DesignPatternsExamples/tree/master/src/main/java/behavioral/state/vendingmachine)
3. [Video Player](https://github.com/havlli/DesignPatternsExamples/tree/master/src/main/java/behavioral/state/videoplayer)
4. [ATM Machine](https://github.com/havlli/DesignPatternsExamples/tree/master/src/main/java/behavioral/state/atmmachine)