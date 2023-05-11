package behavioral.visitor.documentprocessing;

public class Client {
    public static void main(String[] args) {
        Document[] documents = {new PdfDocument(), new WordDocument(), new HtmlDocument()};

        DocumentVisitor processor = new DocumentProcessor();

        // Process all documents
        for (Document document : documents) {
            document.accept(processor);
        }
    }
}
