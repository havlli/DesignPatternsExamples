# Mediator Pattern
Mediator design pattern is a behavioral design pattern that defines an object that encapsulates the communication between a set of objects. The mediator acts as an intermediary and controls the communication and interaction between these objects.

The main idea behind the Mediator pattern is to reduce the dependencies between communicating objects. Instead of having each object directly communicate with other objects, they all communicate through the mediator. This helps to simplify the interactions between objects, making the system more flexible and easier to maintain.

In this pattern, the Mediator object is responsible for managing the communication between the participating objects. It receives messages from the objects and forwards them to the appropriate recipients. It can also broadcast messages to all of the objects, ensuring that everyone is kept up to date with the latest information.

Overall, the Mediator pattern is useful when a system has many objects that need to communicate with each other, but it becomes difficult to manage the interactions between them. By using a mediator, the complexity of the system is reduced, making it easier to maintain and extend over time.

## Examples
1. [Chat Room Application](https://github.com/havlli/DesignPatternsExamples/tree/master/src/main/java/behavioral/mediator/chatroom)
2. [Air Traffic Control System](https://github.com/havlli/DesignPatternsExamples/tree/master/src/main/java/behavioral/mediator/atcsystem)
3. [Car Production Line](https://github.com/havlli/DesignPatternsExamples/tree/master/src/main/java/behavioral/mediator/carproduction)