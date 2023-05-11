package behavioral.visitor.compilerdesign;

public interface ASTVisitor {
    void visitAssignmentNode(AssignmentNode node);
    void visitIfNode(IfNode node);
    void visitWhileNode(WhileNode node);
    void visitPrintNode(PrintNode node);
}
