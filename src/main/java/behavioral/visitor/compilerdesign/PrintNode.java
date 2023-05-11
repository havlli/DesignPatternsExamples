package behavioral.visitor.compilerdesign;

public class PrintNode implements ASTNode {
    // implementation of PrintNode

    @Override
    public void accept(ASTVisitor visitor) {
        visitor.visitPrintNode(this);
    }
}
