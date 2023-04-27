package structural.bridge.messagingsystem;

// Client
public class Application {
    public static void main(String[] args) {
        MessageSender messageSender = new EmailSender();
        Message message = new EmailMessage(messageSender);
        message.send("Stony Tark", "some message");

        messageSender = new SMSSender();
        message = new SMSMessage(messageSender);
        message.send("Stone Tark", "some message");
    }
}
