package behavioral.visitor.documentprocessing;

public class DocumentProcessor implements DocumentVisitor {
    @Override
    public void visit(PdfDocument pdfDocument) {
        // Process PDF document
        System.out.println("Processing PDF document...");
    }

    @Override
    public void visit(WordDocument wordDocument) {
        // Process Word document
        System.out.println("Processing Word document...");
    }

    @Override
    public void visit(HtmlDocument htmlDocument) {
        // Process HTML document
        System.out.println("Processing HTML document...");
    }
}
