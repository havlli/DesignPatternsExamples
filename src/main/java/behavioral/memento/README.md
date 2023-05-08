# Memento
The Memento design pattern is a behavioral pattern that allows you to capture and save the internal state of an object without exposing its implementation details, and later restore it to that state. This pattern is useful when you want to provide an undo/redo functionality or to store and retrieve object's state in a persistent storage.

The pattern consists of three main components:

-   Originator: An object that has an internal state that needs to be saved and restored.
-   Memento: An object that represents the saved state of the Originator.
-   Caretaker: An object that is responsible for keeping track of the Mementos and restoring the state of the Originator.

The Originator creates a Memento object that contains a snapshot of its current state. This Memento object is then passed to the Caretaker for safekeeping. The Originator can also restore its state from a Memento object that is provided by the Caretaker.

The Memento pattern is useful in situations where you need to maintain a history of an object's state, such as in an undo/redo functionality or in a database rollback operation. It allows you to store an object's state in a way that is independent of the object's implementation, and later restore it to that state.

In summary, the Memento pattern provides a way to capture and save the internal state of an object, and later restore it to that state without exposing its implementation details.

### Example
```java
// Originator class
public class Document {
    private String content;

    public Document(String content) {
        this.content = content;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Memento save() {
        return new Memento(content);
    }

    public void restore(Memento memento) {
        content = memento.getContent();
    }

    // Memento class
    public static class Memento {
        private final String content;

        private Memento(String content) {
            this.content = content;
        }

        private String getContent() {
            return content;
        }
    }
}

// Caretaker class
public class DocumentHistory {
    private final Stack<Document.Memento> mementos = new Stack<>();

    public void save(Document document) {
        mementos.push(document.save());
    }

    public void undo(Document document) {
        if (!mementos.isEmpty()) {
            Document.Memento memento = mementos.pop();
            document.restore(memento);
        }
    }
}

// Client code
public class Client {
    public static void main(String[] args) {
        Document document = new Document("Hello World!");
        DocumentHistory history = new DocumentHistory();

        // save initial state
        history.save(document);

        // make some changes to the document
        document.setContent("Lorem ipsum dolor sit amet.");
        history.save(document);

        document.setContent("Consectetur adipiscing elit.");
        history.save(document);

        // undo changes
        history.undo(document); // document content: "Consectetur adipiscing elit."
        history.undo(document); // document content: "Lorem ipsum dolor sit amet."
        history.undo(document); // document content: "Hello World!"
    }
}
```
In this example, the `Document` class is the Originator, responsible for storing and restoring its state. It has a `save()` method that creates a new Memento object with a snapshot of the current state and returns it. It also has a `restore()` method that takes a Memento object and sets the state of the Document to the state captured in the Memento.

The `DocumentHistory` class is the Caretaker, responsible for storing and managing the Memento objects. It has a stack of Memento objects that it can use to undo changes to the Document.

The `Client` class demonstrates how the pattern works by creating a new `Document` object and making changes to its state. It saves the state of the Document using the `DocumentHistory` object, and then later undoes the changes using the Memento objects stored in the `DocumentHistory` object.