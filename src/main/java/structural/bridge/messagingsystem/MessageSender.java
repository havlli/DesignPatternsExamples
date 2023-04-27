package structural.bridge.messagingsystem;

// Implementation
public interface MessageSender {
    void sendMessage(String messageType, String recipient, String message);
}
