# Compiler Design
In a compiler design, you might have multiple types of nodes in the Abstract Syntax Tree (AST). You can use the Visitor pattern to traverse the AST and perform various operations on the nodes, such as type checking or code generation.

Consider a scenario where we have multiple types of nodes in the Abstract Syntax Tree (AST) of a programming language, such as `AssignmentNode`, `IfNode`, `WhileNode`, and `PrintNode`. We want to traverse the AST and perform different operations on each type of node.

To accomplish this, we can use the Visitor pattern. First, we define a visitor interface `ASTVisitor` with methods for visiting each type of node:
```java
public interface ASTVisitor {
    void visitAssignmentNode(AssignmentNode node);
    void visitIfNode(IfNode node);
    void visitWhileNode(WhileNode node);
    void visitPrintNode(PrintNode node);
}
```
Next, we define an abstract syntax tree node interface `ASTNode` with an `accept()` method that takes a `Visitor` object as a parameter:
```java
public interface ASTNode {
    void accept(ASTVisitor visitor);
}
```
We then implement the `ASTNode` interface in each of our node classes, and define the `accept()` method for each class to call the appropriate method in the `Visitor` object:
```java
public class AssignmentNode implements ASTNode {
    // implementation of AssignmentNode

    public void accept(ASTVisitor visitor) {
        visitor.visitAssignmentNode(this);
    }
}

public class IfNode implements ASTNode {
    // implementation of IfNode

    public void accept(ASTVisitor visitor) {
        visitor.visitIfNode(this);
    }
}

public class WhileNode implements ASTNode {
    // implementation of WhileNode

    public void accept(ASTVisitor visitor) {
        visitor.visitWhileNode(this);
    }
}

public class PrintNode implements ASTNode {
    // implementation of PrintNode

    public void accept(ASTVisitor visitor) {
        visitor.visitPrintNode(this);
    }
}
```
Finally, we can create concrete visitor classes that implement the `ASTVisitor` interface and define the specific logic for each type of node:
```java
public class TypeCheckingVisitor implements ASTVisitor {
    public void visitAssignmentNode(AssignmentNode node) {
        // check the types of the left-hand and right-hand sides of the assignment
    }

    public void visitIfNode(IfNode node) {
        // check the type of the condition expression
    }

    public void visitWhileNode(WhileNode node) {
        // check the type of the condition expression
    }

    public void visitPrintNode(PrintNode node) {
        // check the type of the expression to be printed
    }
}

public class CodeGenerationVisitor implements ASTVisitor {
    public void visitAssignmentNode(AssignmentNode node) {
        // generate code for the assignment statement
    }

    public void visitIfNode(IfNode node) {
        // generate code for the if statement
    }

    public void visitWhileNode(WhileNode node) {
        // generate code for the while loop
    }

    public void visitPrintNode(PrintNode node) {
        // generate code for the print statement
    }
}
```
Now, when we want to perform an operation on the AST, we can create a visitor object and pass it to the `accept()` method of the root node of the AST. The visitor will then traverse the AST and call the appropriate methods for each type of node, allowing us to perform different operations on each type of node.