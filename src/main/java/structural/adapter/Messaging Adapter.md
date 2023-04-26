## Messaging Adapter
In some messaging systems, we may need to convert messages between different formats or protocols, each of which has its own message schema and message broker API. An adapter can be used to abstract away the differences between these systems and provide a consistent interface for the application.
```java
public interface Message {
    String getPayload();
    void setPayload(String payload);
}

public class JmsMessage {
    private String text;
    
    public String getText() {
        return text;
    }
    
    public void setText(String text) {
        this.text = text;
    }
}

public class MessageAdapter implements Message {
    private JmsMessage jmsMessage;
    
    public String getPayload() {
        return jmsMessage.getText();
    }
    
    public void setPayload(String payload) {
        jmsMessage.setText(payload);
    }
    
    public static MessageAdapter fromJmsMessage(JmsMessage jmsMessage) {
        MessageAdapter adapter = new MessageAdapter();
        adapter.jmsMessage = jmsMessage;
        return adapter;
    }
    
    public static JmsMessage toJmsMessage(Message message) {
        JmsMessage jmsMessage = new JmsMessage();
        jmsMessage.setText(message.getPayload());
        return jmsMessage;
    }
}
```
In this example, we define a `Message` interface that provides a consistent API for getting and setting message payloads. We then define a `JmsMessage` class that represents a message in the Java Messaging System (JMS), which has a different API for getting and setting message data. We create a `MessageAdapter` class that implements the `Message` interface and maps between the two message formats using static methods `fromJmsMessage` and `toJmsMessage`, which convert between the two formats using a consistent interface.