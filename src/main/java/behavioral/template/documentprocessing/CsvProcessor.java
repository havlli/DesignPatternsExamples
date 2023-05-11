package behavioral.template.documentprocessing;

public class CsvProcessor extends DocumentProcessor {
    @Override
    protected void parseDocument() {
        System.out.println("Parsing CSV document...");
    }

    @Override
    protected void formatContent() {
        System.out.println("Formatting CSV document...");
    }

    @Override
    protected void generateOutput() {
        System.out.println("Generating CSV output...");
    }
}
