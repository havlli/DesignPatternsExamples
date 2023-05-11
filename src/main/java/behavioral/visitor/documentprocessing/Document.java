package behavioral.visitor.documentprocessing;

public interface Document {
    void accept(DocumentVisitor visitor);
}
