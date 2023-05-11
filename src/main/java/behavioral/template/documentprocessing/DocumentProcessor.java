package behavioral.template.documentprocessing;

public abstract class DocumentProcessor {
    public void processDocument() {
        parseDocument();
        formatContent();
        generateOutput();
    }

    protected abstract void parseDocument();
    protected abstract void formatContent();
    protected abstract void generateOutput();
}
