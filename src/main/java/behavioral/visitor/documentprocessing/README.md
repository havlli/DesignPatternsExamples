# Document Processing
Suppose you have a document processing system with multiple types of documents such as PDF, Word, and HTML. You can use the Visitor pattern to define a common process for handling these documents, where the visitor interface defines methods for visiting each type of document, and the concrete visitor classes implement the specific logic for processing each document type.

First, let's define the visitor interface `DocumentVisitor` that contains methods for visiting each type of document:
```java
public interface DocumentVisitor {
    void visit(PdfDocument pdfDocument);
    void visit(WordDocument wordDocument);
    void visit(HtmlDocument htmlDocument);
}
```
Next, let's define the `Document` interface which will be implemented by each of the document types:
```java
public interface Document {
    void accept(DocumentVisitor visitor);
}
```
Now, let's define the concrete document types and their corresponding implementations of the `accept` method:
```java
public class PdfDocument implements Document {
    public void accept(DocumentVisitor visitor) {
        visitor.visit(this);
    }
    // Methods specific to PDF document type
}

public class WordDocument implements Document {
    public void accept(DocumentVisitor visitor) {
        visitor.visit(this);
    }
    // Methods specific to Word document type
}

public class HtmlDocument implements Document {
    public void accept(DocumentVisitor visitor) {
        visitor.visit(this);
    }
    // Methods specific to HTML document type
}
```
Finally, let's define the concrete visitor class `DocumentProcessor` that implements the `DocumentVisitor` interface and contains the specific logic for processing each document type:
```java
public class DocumentProcessor implements DocumentVisitor {
    public void visit(PdfDocument pdfDocument) {
        // Process PDF document
        System.out.println("Processing PDF document...");
    }

    public void visit(WordDocument wordDocument) {
        // Process Word document
        System.out.println("Processing Word document...");
    }

    public void visit(HtmlDocument htmlDocument) {
        // Process HTML document
        System.out.println("Processing HTML document...");
    }
}
```
Now, we can use the `DocumentProcessor` to process any type of document:
```java
public class DocumentClient {
    public static void main(String[] args) {
        Document[] documents = {new PdfDocument(), new WordDocument(), new HtmlDocument()};

        DocumentVisitor processor = new DocumentProcessor();

        // Process all documents
        for (Document document : documents) {
            document.accept(processor);
        }
    }
}
```
In this example, the Visitor pattern allows us to define a common process for handling multiple types of documents, while still allowing each document type to have its own specific implementation.