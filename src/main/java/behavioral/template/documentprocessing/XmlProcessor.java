package behavioral.template.documentprocessing;

public class XmlProcessor extends DocumentProcessor {
    @Override
    protected void parseDocument() {
        System.out.println("Parsing XML document...");
    }

    @Override
    protected void formatContent() {
        System.out.println("Formatting XML document...");
    }

    @Override
    protected void generateOutput() {
        System.out.println("Generating XML document...");
    }
}
