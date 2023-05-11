package behavioral.visitor.documentprocessing;

public class PdfDocument implements Document {
    @Override
    public void accept(DocumentVisitor visitor) {
        visitor.visit(this);
    }
    // Methods specific to PDF document type
}
