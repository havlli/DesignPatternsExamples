package behavioral.visitor.compilerdesign;

public interface ASTNode {
    void accept(ASTVisitor visitor);
}
