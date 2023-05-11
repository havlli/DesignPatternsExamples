package behavioral.visitor.documentprocessing;

public class HtmlDocument implements Document {
    @Override
    public void accept(DocumentVisitor visitor) {
        visitor.visit(this);
    }

    // Methods specific to HTML document type
}
