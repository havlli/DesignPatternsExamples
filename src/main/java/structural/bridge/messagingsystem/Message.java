package structural.bridge.messagingsystem;

// Abstraction
public abstract class Message {
    protected MessageSender messageSender;

    public Message(MessageSender messageSender) {
        this.messageSender = messageSender;
    }

    public abstract void send(String recipient, String message);
}
