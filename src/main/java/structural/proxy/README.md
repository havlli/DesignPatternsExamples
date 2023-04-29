# Proxy Pattern
The Proxy Design Pattern is a structural design pattern that allows you to provide a surrogate or placeholder object for another object. The proxy object acts as an intermediary between the client and the actual object, hiding the details of the object's creation and management from the client. The client interacts with the proxy object as if it were the real object, but the proxy object forwards requests to the real object when appropriate.

The primary motivation for using the Proxy Design Pattern is to add an additional level of indirection to support distributed, controlled, or intelligent access to objects. The Proxy can be used to enhance the functionality of an existing object, to reduce the cost of creating an object, or to restrict access to an object. By encapsulating an object behind a proxy, you can modify its behavior without changing its code, providing a way to implement cross-cutting concerns such as caching, logging, or security.

The Proxy Design Pattern is commonly used in situations where creating and managing the real object is expensive, such as when the object resides on a remote server or when the object requires heavy computation. In these situations, the proxy object can be created and initialized quickly and can provide immediate feedback to the client while the real object is being created or processed.

The Proxy Design Pattern is also used to implement access control, by restricting access to an object through a proxy that checks the client's credentials or permissions before forwarding the request to the real object.

Overall, the Proxy Design Pattern provides a way to control access to an object and to add additional functionality without changing the object's code, making it a powerful and flexible design pattern that is widely used in modern software systems.

There are several types of Proxy Design Pattern, each with its own specific use case. Here are some of the most common types of Proxy Pattern:

1.  Virtual Proxy: This type of proxy is used to defer the creation of expensive objects until they are actually needed. The virtual proxy acts as a stand-in for the actual object and creates the real object only when it is needed.
2.  Remote Proxy: This type of proxy is used to represent an object that exists in a remote location, such as a server. The remote proxy provides a local representation of the remote object, allowing the client to interact with it as if it were local.
3.  Protection Proxy: This type of proxy is used to control access to an object by adding an additional layer of security. The protection proxy checks whether the client has the necessary permissions to access the object before allowing the client to interact with it.
4.  Smart Proxy: This type of proxy is used to add additional functionality to an object without modifying its code. The smart proxy intercepts method calls to the object and performs additional tasks before or after the method call, such as caching, logging, or synchronization.

Each type of Proxy Pattern has its own specific use case and benefits, and choosing the right type of proxy depends on the requirements of your application.

### Example
Suppose you have an interface `Image` that represents an image file, and a concrete implementation of that interface called `RealImage`. The `RealImage` class is expensive to create, so you want to create a proxy object that will create the `RealImage` object only when it is needed. Here's the code for the `Image` interface:
```java
public interface Image {
    void display();
}
```
And here's the code for the `RealImage` class:
```java
public class RealImage implements Image {
    private String fileName;

    public RealImage(String fileName) {
        this.fileName = fileName;
        loadImageFromDisk();
    }

    private void loadImageFromDisk() {
        System.out.println("Loading " + fileName);
    }

    public void display() {
        System.out.println("Displaying " + fileName);
    }
}
```
To create the `ProxyImage`, we'll create a class that implements the `Image` interface and has a `RealImage` object as a member variable. Here's the code for the `ProxyImage` class:
```java
public class ProxyImage implements Image {
    private RealImage realImage;
    private String fileName;

    public ProxyImage(String fileName) {
        this.fileName = fileName;
    }

    public void display() {
        if (realImage == null) {
            realImage = new RealImage(fileName);
        }
        realImage.display();
    }
}
```
Now, when we want to display an image, we create a `ProxyImage` object instead of a `RealImage` object. The `display()` method of the `ProxyImage` object will create the `RealImage` object only if it is needed, and then call the `display()` method of the `RealImage` object.

Here's an example usage of the `ProxyImage` class:
```java
Image image1 = new ProxyImage("cat.jpg");
Image image2 = new ProxyImage("dog.jpg");

// The RealImage objects for cat.jpg and dog.jpg haven't been created yet.

image1.display(); // This will create the RealImage object for cat.jpg and display it.
image1.display(); // This will display the cached RealImage object for cat.jpg.

image2.display(); // This will create the RealImage object for dog.jpg and display it.
```
In this example, the `ProxyImage` class acts as a substitute for the `RealImage` class. It controls access to the `RealImage` object, creating it only when it is needed.