# Chain of Responsibility Pattern
The Chain of Responsibility pattern is a design pattern that promotes loose coupling and flexibility in your code. It achieves this by creating a chain of objects, where each object in the chain has the ability to handle a specific type of request.

When a request comes in, it is passed down the chain from one object to the next until it is handled. This way, the sender of the request doesn't need to know anything about the objects that will handle it or how they work. It only needs to know how to send the request, and the objects in the chain will take care of the rest.

In addition to promoting loose coupling and flexibility, the Chain of Responsibility pattern also makes it easy to add new handlers to the chain. You can simply create a new object that handles a specific type of request and add it to the end of the chain. This way, you can easily extend the functionality of your code without having to modify existing code.

Here are some examples of when you might want to use the Chain of Responsibility pattern:

-   When you have a set of objects that can handle a request, but you don't know which one will handle it until runtime. In this case, you can create a chain of handlers and pass the request down the chain until it is handled.

-   When you want to decouple the sender of a request from the receiver(s). The sender doesn't need to know which object will handle the request, and the receiver(s) don't need to know who sent the request.

-   When you want to add new handlers to the chain without modifying existing code. You can simply create a new object that handles a specific type of request and add it to the end of the chain.

Overall, the Chain of Responsibility pattern is a powerful tool for promoting loose coupling, flexibility, and extensibility in your code.

### Example
```java
public abstract class Handler {
    protected Handler successor;

    public void setSuccessor(Handler successor) {
        this.successor = successor;
    }

    public abstract void handleRequest(Request request);
}

public class ConcreteHandler1 extends Handler {
    @Override
    public void handleRequest(Request request) {
        if (request.getType() == RequestType.TYPE1) {
            System.out.println("ConcreteHandler1 handles request " + request);
        } else if (successor != null) {
            successor.handleRequest(request);
        }
    }
}

public class ConcreteHandler2 extends Handler {
    @Override
    public void handleRequest(Request request) {
        if (request.getType() == RequestType.TYPE2) {
            System.out.println("ConcreteHandler2 handles request " + request);
        } else if (successor != null) {
            successor.handleRequest(request);
        }
    }
}

public class Request {
    private final RequestType type;

    public Request(RequestType type) {
        this.type = type;
    }

    public RequestType getType() {
        return type;
    }

    @Override
    public String toString() {
        return "Request{" +
                "type=" + type +
                '}';
    }
}

public enum RequestType {
    TYPE1, TYPE2
}

public class ChainOfResponsibilityDemo {
    public static void main(String[] args) {
        Handler h1 = new ConcreteHandler1();
        Handler h2 = new ConcreteHandler2();
        h1.setSuccessor(h2);

        // Send requests to the first handler
        h1.handleRequest(new Request(RequestType.TYPE1));
        h1.handleRequest(new Request(RequestType.TYPE2));
    }
}
```
In this example, we have two concrete handlers, `ConcreteHandler1` and `ConcreteHandler2`, which handle requests of type `TYPE1` and `TYPE2`, respectively. Both handlers have a `successor` field which refers to the next handler in the chain.

The `handleRequest()` method of each handler checks if it can handle the request. If it can, it handles it and returns. If it can't, it passes the request to its successor (if it has one) using the `handleRequest()` method of the successor.

In the `main()` method of `ChainOfResponsibilityDemo`, we create a chain of handlers by setting the successor of `h1` to `h2`. We then send two requests to `h1`, one of type `TYPE1` and one of type `TYPE2`. The first request is handled by `ConcreteHandler1`, and the second request is handled by `ConcreteHandler2`.