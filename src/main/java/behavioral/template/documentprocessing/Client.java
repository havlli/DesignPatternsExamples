package behavioral.template.documentprocessing;

public class Client {
    public static void main(String[] args) {
        DocumentProcessor xmlProcessor = new XmlProcessor();
        xmlProcessor.processDocument();

        DocumentProcessor csvProcessor = new CsvProcessor();
        csvProcessor.processDocument();
    }
}
