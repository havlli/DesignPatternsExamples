# Document Processing
In a document processing system, you might have a common document processing process that needs to be executed for different types of documents. By using the Template Method Pattern, you can define the basic structure of the document processing process in a base class, and then allow subclasses to implement their own logic for specific steps of the process, such as parsing the document, formatting the content, or generating output.
```java
// Base class for document processing
abstract class DocumentProcessor {
    // Template method to process document
    public void processDocument() {
        // Step 1: Parse document
        parseDocument();
        // Step 2: Format content
        formatContent();
        // Step 3: Generate output
        generateOutput();
    }

    // Abstract methods to be implemented by subclasses
    protected abstract void parseDocument();
    protected abstract void formatContent();
    protected abstract void generateOutput();
}

// Subclass for processing XML documents
class XmlProcessor extends DocumentProcessor {
    @Override
    protected void parseDocument() {
        // Implementation for parsing XML document
        System.out.println("Parsing XML document...");
    }

    @Override
    protected void formatContent() {
        // Implementation for formatting XML content
        System.out.println("Formatting XML content...");
    }

    @Override
    protected void generateOutput() {
        // Implementation for generating XML output
        System.out.println("Generating XML output...");
    }
}

// Subclass for processing CSV documents
class CsvProcessor extends DocumentProcessor {
    @Override
    protected void parseDocument() {
        // Implementation for parsing CSV document
        System.out.println("Parsing CSV document...");
    }

    @Override
    protected void formatContent() {
        // Implementation for formatting CSV content
        System.out.println("Formatting CSV content...");
    }

    @Override
    protected void generateOutput() {
        // Implementation for generating CSV output
        System.out.println("Generating CSV output...");
    }
}

// Client code that uses the document processors
public class DocumentProcessorClient {
    public static void main(String[] args) {
        // Process XML document
        DocumentProcessor xmlProcessor = new XmlProcessor();
        xmlProcessor.processDocument();

        // Process CSV document
        DocumentProcessor csvProcessor = new CsvProcessor();
        csvProcessor.processDocument();
    }
}
```
In the above code, we have a base class `DocumentProcessor` that defines the overall structure of the document processing process using a template method `processDocument()`. The template method consists of three steps: `parseDocument()`, `formatContent()`, and `generateOutput()`. These steps are left as abstract methods, which means that the specific implementation of these methods will be provided by the subclasses.

We then have two subclasses `XmlProcessor` and `CsvProcessor` that inherit from the `DocumentProcessor` base class. These subclasses provide their own implementation for the three abstract methods defined in the base class, which allows them to customize the document processing process for their specific type of document.

Finally, we have a client code `DocumentProcessorClient` that uses the document processor objects to process documents. We create an instance of `XmlProcessor` and `CsvProcessor` and call the `processDocument()` method on them to process the corresponding documents.

With this design, we can easily add more types of documents by creating new subclasses of `DocumentProcessor` and providing their own implementation for the abstract methods. This promotes code reusability and makes the document processing flexible and extensible.