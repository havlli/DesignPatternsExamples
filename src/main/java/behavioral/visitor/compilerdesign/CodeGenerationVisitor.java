package behavioral.visitor.compilerdesign;

public class CodeGenerationVisitor implements ASTVisitor {
    @Override
    public void visitAssignmentNode(AssignmentNode node) {
        // generate code for the assignment statement
    }

    @Override
    public void visitIfNode(IfNode node) {
        // generate code for the if statement
    }

    @Override
    public void visitWhileNode(WhileNode node) {
        // generate code for the while loop
    }

    @Override
    public void visitPrintNode(PrintNode node) {
        // generate code for the print statement
    }
}
