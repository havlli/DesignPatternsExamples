
# Command Pattern

The Command pattern is a behavioral design pattern that encapsulates a request or action as an object, allowing for the requester to be decoupled from the receiver. This allows for more flexible and extensible systems where different requests can be easily added and removed without affecting the rest of the system.

In this pattern, there are four key components:

1.  Command: This is an interface that defines the `execute()` method, which encapsulates the action to be performed.

2.  Concrete Command: These are concrete implementations of the `Command` interface that encapsulate specific actions.

3.  Receiver: This is the object that performs the action.

4.  Invoker: This is the object that requests the action to be performed. It contains a reference to the `Command` object and calls its `execute()` method.


Here's an overview of how the Command pattern works:

1.  The `Invoker` object requests an action to be performed by setting a `Command` object on itself.

2.  The `Command` object encapsulates the action and holds a reference to the `Receiver` object that will perform the action.

3.  The `Invoker` object then calls the `execute()` method on the `Command` object, which in turn calls the appropriate method on the `Receiver` object to perform the action.

4.  The `Receiver` object performs the requested action.


One of the key benefits of using the Command pattern is that it allows for flexibility and extensibility in the system. New commands can easily be added without changing the `Invoker` or `Receiver` objects, which allows for easier maintenance and modification of the system.

### Examples

-   [**Simple Example**](https://github.com/havlli/DesignPatternsExamples/tree/master/src/main/java/behavioral/command/simpleexample) with design approach described
-   [**GUI applications**](https://github.com/havlli/DesignPatternsExamples/tree/master/src/main/java/behavioral/command/guiaplication), where buttons or menus can be associated with different commands.
-   Multi-level undo/redo operations in text editors or graphics applications.
-   [**Remote control**](https://github.com/havlli/DesignPatternsExamples/tree/master/src/main/java/behavioral/command/remotecontrol) systems, where different commands can be sent over a network to control devices.
-   Transactional systems, where a set of operations can be grouped together as a single transaction.