# Visitor Pattern
The Visitor Pattern is a behavioral design pattern that allows you to separate the algorithm from the object structure on which it operates. It provides a way to add new operations to existing object structures without modifying the structures themselves.

The pattern involves two main components: the Visitor and the Visitable. The Visitor represents the algorithm, while the Visitable represents the object structure on which the algorithm operates. The Visitable objects accept a Visitor object, which then performs some operation on the object.

In this pattern, the Visitable objects are not responsible for knowing how to perform the operation, and the Visitor is not responsible for knowing the structure of the object. This separation of concerns allows for greater flexibility and extensibility in the system.

Overall, the Visitor Pattern is useful when you have a complex object structure and need to perform different operations on that structure. It allows you to add new operations to the system without modifying the existing code.

### Examples
1. [Document processing]()
2. [Compiler design]()
3. [GUI framework]()
4. [Database querying]()

### Simple Example
Let's say we have a computer network that consists of different types of devices, such as routers, switches, and servers. We want to be able to perform different types of operations on these devices, such as configuring them or collecting data from them. However, we don't want to modify the device classes themselves to add these operations.

To solve this problem, we can use the Visitor pattern. We create a Visitor interface that has methods for each operation we want to perform on the devices. We then create a Visitable interface that has an accept() method that takes a Visitor object as an argument. Each device class implements the Visitable interface, and provides its own implementation of the accept() method.
```java
// Visitor interface
interface NetworkDeviceVisitor {
    void visit(Router router);
    void visit(Switch switchDevice);
    void visit(Server server);
}

// Visitable interface
interface NetworkDevice {
    void accept(NetworkDeviceVisitor visitor);
}

// Router class
class Router implements NetworkDevice {
    public void accept(NetworkDeviceVisitor visitor) {
        visitor.visit(this);
    }

    // Methods specific to router
    public void configure() {
        System.out.println("Configuring router...");
    }
}

// Switch class
class Switch implements NetworkDevice {
    public void accept(NetworkDeviceVisitor visitor) {
        visitor.visit(this);
    }

    // Methods specific to switch
    public void collectData() {
        System.out.println("Collecting data from switch...");
    }
}

// Server class
class Server implements NetworkDevice {
    public void accept(NetworkDeviceVisitor visitor) {
        visitor.visit(this);
    }

    // Methods specific to server
    public void monitor() {
        System.out.println("Monitoring server...");
    }
}

// Concrete visitor class
class NetworkDeviceConfigVisitor implements NetworkDeviceVisitor {
    public void visit(Router router) {
        router.configure();
    }

    public void visit(Switch switchDevice) {
        switchDevice.collectData();
    }

    public void visit(Server server) {
        server.monitor();
    }
}

// Client code
public class NetworkClient {
    public static void main(String[] args) {
        NetworkDevice[] devices = {new Router(), new Switch(), new Server()};

        NetworkDeviceVisitor configVisitor = new NetworkDeviceConfigVisitor();

        // Configure routers and collect data from switches
        for (NetworkDevice device : devices) {
            device.accept(configVisitor);
        }
    }
}
```
The code defines two interfaces: `NetworkDeviceVisitor` and `NetworkDevice`. `NetworkDeviceVisitor` defines the visit methods for each type of network device, while `NetworkDevice` defines the accept method that accepts a `NetworkDeviceVisitor`.

The code also defines three classes that implement `NetworkDevice`: `Router`, `Switch`, and `Server`. Each of these classes defines their own implementation of the `accept` method that calls the appropriate visit method on the passed-in `NetworkDeviceVisitor`.

The `NetworkDeviceConfigVisitor` class is the concrete implementation of the `NetworkDeviceVisitor` interface. It implements the visit methods for each type of network device, where each method performs the specific operation for that device type.

Finally, the `NetworkClient` class demonstrates the usage of this pattern. It creates an array of `NetworkDevice` objects and a `NetworkDeviceConfigVisitor` object. It then calls the `accept` method on each `NetworkDevice` object with the `NetworkDeviceConfigVisitor` object as an argument, which performs the appropriate operation on each device based on its type.