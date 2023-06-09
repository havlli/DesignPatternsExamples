## Adapter Pattern
The Adapter Pattern is a structural design pattern that allows objects with incompatible interfaces to work together. It involves creating a new object that adapts the interface of an existing object to match the interface that the client expects.

The Adapter Pattern has three main components:
1.  ***Client:*** The client is the object that wants to use a specific interface that is not compatible with the interface of the existing object.
2.  ***Adaptee:*** The adaptee is the object that has the interface that the client cannot use directly.
3.  ***Adapter:*** The adapter is the object that adapts the interface of the adaptee to match the interface that the client expects.


The Adapter Pattern can be useful in various scenarios such as:
-   When you want to reuse an existing class that does not have the interface that you need.
-   When you want to create a class that can work with multiple existing classes with different interfaces.
-   When you want to create a class that can work with legacy code or external libraries that have different interfaces.

The Adapter Pattern can be implemented in two ways: class adapters and object adapters.
-   **Class Adapter:** In a class adapter, the adapter class inherits from both the client and the adaptee classes. It can then override the methods of the adaptee class to match the interface of the client class. This approach requires multiple inheritance, which is not available in all programming languages.
-   **Object Adapter:** In an object adapter, the adapter class contains an instance of the adaptee class and implements the interface of the client class. It then delegates the calls to the adaptee object. This approach uses composition instead of inheritance, making it more flexible and compatible with more programming languages.


Overall, the Adapter Pattern allows you to create a new object that can work with existing objects that have incompatible interfaces, without changing the existing objects or the client code.

Examples of Adapter Pattern:
1. [**Database Adapter**](https://github.com/havlli/DesignPatternsExamples/blob/master/src/main/java/structural/adapter/Database%20Adapter.md)
2. [**XML Adapter**](https://github.com/havlli/DesignPatternsExamples/blob/master/src/main/java/structural/adapter/XML%20Adapter.md)
3. [**Messaging Adapter**](https://github.com/havlli/DesignPatternsExamples/blob/master/src/main/java/structural/adapter/Messaging%20Adapter.md)
3. [**Socket Adapters**](https://github.com/havlli/DesignPatternsExamples/blob/master/src/main/java/structural/adapter/Socket%20Adapters.md)
3. [**Legacy Code Integration**](https://github.com/havlli/DesignPatternsExamples/blob/master/src/main/java/structural/adapter/Legacy%20Code%20Integration.md)
4. [**Third-Party API Integration**](https://github.com/havlli/DesignPatternsExamples/blob/master/src/main/java/structural/adapter/Third-Party%20API%20Integration.md)