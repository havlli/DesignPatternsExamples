package behavioral.visitor.compilerdesign;

public class WhileNode implements ASTNode {
    // implementation of WhileNode

    @Override
    public void accept(ASTVisitor visitor) {
        visitor.visitWhileNode(this);
    }
}
