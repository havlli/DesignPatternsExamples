package behavioral.visitor.compilerdesign;

public class TypeCheckingVisitor implements ASTVisitor {
    @Override
    public void visitAssignmentNode(AssignmentNode node) {
        // check the types of the left-hand and right-hand sides of the assignment
    }

    @Override
    public void visitIfNode(IfNode node) {
        // check the type of the condition expression
    }

    @Override
    public void visitWhileNode(WhileNode node) {
        // check the type of the condition expression
    }

    @Override
    public void visitPrintNode(PrintNode node) {
        // check the type of the expression to be printed
    }
}
