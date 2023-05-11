package behavioral.visitor.compilerdesign;

public class IfNode implements ASTNode {
    // implementation of IfNode

    @Override
    public void accept(ASTVisitor visitor) {
        visitor.visitIfNode(this);
    }
}
