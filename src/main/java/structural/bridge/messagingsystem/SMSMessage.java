package structural.bridge.messagingsystem;

// Refined abstraction
public class SMSMessage extends Message {
    public SMSMessage(MessageSender messageSender) {
        super(messageSender);
    }

    @Override
    public void send(String recipient, String message) {
        messageSender.sendMessage("SMS", recipient, message);
    }
}
