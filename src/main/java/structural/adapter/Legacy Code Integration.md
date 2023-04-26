## Legacy Code Integration
When integrating legacy code with new code, you may need to adapt the interface of the legacy code to match the interface of the new code. For example, let's say you have a legacy `Logger` class that has a `log()` method that takes a message as a string. However, your new code expects a `Logger` interface with a `logMessage()` method that takes a Message object. To make the Logger class work with the new code, you can create an adapter that adapts the `Logger` interface to the `Logger` class.```java
```java
public class LoggerAdapter implements Logger {
    private LegacyLogger legacyLogger;

    public LoggerAdapter(LegacyLogger legacyLogger) {
        this.legacyLogger = legacyLogger;
    }

    // Override the methods from Logger interface
    public void logMessage(Message message) {
        String messageText = message.getText();
        legacyLogger.log(messageText);
    }
}
```