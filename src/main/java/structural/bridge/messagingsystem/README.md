## Messaging System
In the context of messaging systems, the Bridge pattern can be used to separate the message format from the actual messaging protocol. This allows for greater flexibility in integrating different messaging systems into an application.

In this example, the `MessageSender` interface represents the implementation hierarchy, and the `Message` class represents the abstraction hierarchy. The `EmailMessage` class is a refined abstraction that uses the `MessageSender` interface to send email messages. The `EmailSender` and `SMSSender` classes are concrete implementations of the `MessageSender` interface that send email and SMS messages, respectively. The `Application` class is the client that creates an `EmailSender` object, an `EmailMessage` object, and calls the `send()` method on the `EmailMessage` object.
```java
// Abstraction
public abstract class Message {
    protected MessageSender messageSender;

    public Message(MessageSender messageSender) {
        this.messageSender = messageSender;
    }

    public abstract void send(String recipient, String message);
}

// Refined Abstraction
public class EmailMessage extends Message {
    public EmailMessage(MessageSender messageSender) {
        super(messageSender);
    }

    public void send(String recipient, String message) {
        messageSender.sendMessage("Email", recipient, message);
    }
}

// Implementation
public interface MessageSender {
    void sendMessage(String messageType, String recipient, String message);
}

// Concrete Implementation
public class SMSSender implements MessageSender {
    public void sendMessage(String messageType, String recipient, String message) {
        // send SMS message
    }
}

public class EmailSender implements MessageSender {
    public void sendMessage(String messageType, String recipient, String message) {
        // send email message
    }
}

// Client
public class Application {
    public static void main(String[] args) {
        MessageSender messageSender = new EmailSender();
        Message emailMessage = new EmailMessage(messageSender);
        emailMessage.send("john@example.com", "Hello from the Bridge pattern!");
    }
}
```