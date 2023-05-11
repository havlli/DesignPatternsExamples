package behavioral.visitor.documentprocessing;

public class WordDocument implements Document {
    @Override
    public void accept(DocumentVisitor visitor) {
        visitor.visit(this);
    }

    // Method specific to Word document type
}
