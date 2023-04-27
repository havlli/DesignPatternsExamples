package structural.bridge.messagingsystem;

// Concrete implementation
public class SMSSender implements MessageSender {
    @Override
    public void sendMessage(String messageType, String recipient, String message) {
        System.out.println("Sending message of type " + messageType + " to " + recipient + " with content: " + message);
    }
}
