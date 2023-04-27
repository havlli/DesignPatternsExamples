# Bridge Pattern
The Bridge design pattern is a structural design pattern that decouples an abstraction from its implementation so that the two can vary independently. In other words, it allows you to separate the interface or abstraction from the implementation details, which can vary independently.

The pattern achieves this by creating two separate class hierarchies: one for the abstraction and another for the implementation. The abstraction defines the interface or the high-level functionality that clients use, while the implementation provides the concrete implementation of the abstraction.

The Bridge pattern allows the client code to work with the abstraction without knowing the implementation details. The client can choose the implementation at runtime and switch between different implementations easily, without having to modify the abstraction or the client code. This provides a high degree of flexibility and modularity in the system design.

The Bridge pattern is particularly useful when you have multiple variants of a system or when you need to support different platforms or devices with varying capabilities. It also helps to avoid a class explosion problem that can arise when you have a large number of classes for each possible combination of the abstraction and implementation.

Overall, the Bridge pattern promotes loose coupling and high cohesion between the abstraction and implementation, making the system more flexible, maintainable, and extensible.

### **Examples**
1. [Platform Renderer](https://github.com/havlli/DesignPatternsExamples/tree/master/src/main/java/structural/bridge/platformrenderer) - with more explanation
2. [GUI ToolKit](https://github.com/havlli/DesignPatternsExamples/tree/master/src/main/java/structural/bridge/guitoolkit)
3. [Audio/Video Player](https://github.com/havlli/DesignPatternsExamples/tree/master/src/main/java/structural/bridge/avplayer)
4. [Messaging System](https://github.com/havlli/DesignPatternsExamples/tree/master/src/main/java/structural/bridge/messagingsystem)
5. [Payment Gateways](https://github.com/havlli/DesignPatternsExamples/tree/master/src/main/java/structural/bridge/paymentgateways)