package structural.bridge.messagingsystem;

// Refined abstraction
public class EmailMessage extends Message {
    public EmailMessage(MessageSender messageSender) {
        super(messageSender);
    }

    @Override
    public void send(String recipient, String message) {
       messageSender.sendMessage("Email", recipient, message);
    }
}
