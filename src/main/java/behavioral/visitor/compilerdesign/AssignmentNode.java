package behavioral.visitor.compilerdesign;

public class AssignmentNode implements ASTNode {
    // implementation of AssignmentNode

    @Override
    public void accept(ASTVisitor visitor) {
        visitor.visitAssignmentNode(this);
    }
}
