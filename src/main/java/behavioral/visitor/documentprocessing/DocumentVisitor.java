package behavioral.visitor.documentprocessing;

public interface DocumentVisitor {
    void visit(PdfDocument pdfDocument);
    void visit(WordDocument wordDocument);
    void visit(HtmlDocument htmlDocument);
}
