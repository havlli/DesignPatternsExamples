
# Car Production
Imagine a car manufacturing company that has a production line where different parts of the car are assembled. Each department in the production line (e.g., engine assembly, body assembly, electrical assembly) has its own team of workers and machines. However, these departments need to work together to ensure that the final product, the car, is properly assembled.

To facilitate communication and coordination between the different departments, the company uses a mediator. The mediator in this case could be a production manager or a specialized computer system.

The mediator is responsible for managing the flow of information between the different departments. For example, if the engine assembly department completes its work, it notifies the mediator who then notifies the body assembly department that it can start working on its part of the car. Similarly, if the electrical assembly department encounters an issue, it notifies the mediator who then alerts the appropriate department to resolve the issue.
```java
// Mediator interface
public interface ProductionMediator {
    void notify(String department, String message);
}

// Concrete mediator class
public class ProductionManager implements ProductionMediator {
    private Map<String, Department> departments = new HashMap<>();

    public void addDepartment(String name, Department department) {
        departments.put(name, department);
        department.setMediator(this);
    }

    @Override
    public void notify(String department, String message) {
        departments.get(department).receiveMessage(message);
    }
}

// Colleague interface
public interface Department {
    void setMediator(ProductionMediator mediator);
    void receiveMessage(String message);
}

// Concrete colleague classes
public class EngineAssembly implements Department {
    private ProductionMediator mediator;

    @Override
    public void setMediator(ProductionMediator mediator) {
        this.mediator = mediator;
    }

    @Override
    public void receiveMessage(String message) {
        System.out.println("EngineAssembly received message: " + message);
    }

    public void completeWork() {
        mediator.notify("BodyAssembly", "EngineAssembly completed its work.");
    }
}

public class BodyAssembly implements Department {
    private ProductionMediator mediator;

    @Override
    public void setMediator(ProductionMediator mediator) {
        this.mediator = mediator;
    }

    @Override
    public void receiveMessage(String message) {
        System.out.println("BodyAssembly received message: " + message);
    }

    public void startWork() {
        System.out.println("BodyAssembly started its work.");
    }
}

public class ElectricalAssembly implements Department {
    private ProductionMediator mediator;

    @Override
    public void setMediator(ProductionMediator mediator) {
        this.mediator = mediator;
    }

    @Override
    public void receiveMessage(String message) {
        System.out.println("ElectricalAssembly received message: " + message);
    }

    public void encounterIssue() {
        mediator.notify("BodyAssembly", "ElectricalAssembly encountered an issue.");
    }
}

// Client code
public class Client {
    public static void main(String[] args) {
        ProductionMediator mediator = new ProductionManager();
        Department engineAssembly = new EngineAssembly();
        Department bodyAssembly = new BodyAssembly();
        Department electricalAssembly = new ElectricalAssembly();
        mediator.addDepartment("EngineAssembly", engineAssembly);
        mediator.addDepartment("BodyAssembly", bodyAssembly);
        mediator.addDepartment("ElectricalAssembly", electricalAssembly);
        engineAssembly.completeWork();
        electricalAssembly.encounterIssue();
        bodyAssembly.startWork();
    }
}
```
To ensure proper coordination between the different departments, a mediator interface is defined with a `notify()` method. The `ProductionManager` class implements the `ProductionMediator` interface and maintains a list of all departments involved in the car production.

Each department is represented as a `Department` interface with a `setMediator()` and a `receiveMessage()` method. The concrete colleague classes, `EngineAssembly`, `BodyAssembly`, and `ElectricalAssembly`, implement the `Department` interface and communicate with each other through the mediator, i.e., the `ProductionManager` class.

The `EngineAssembly` class, for instance, has a `completeWork()` method that notifies the mediator about the completion of its work, and the mediator then informs the `BodyAssembly` class that it can start its work. Similarly, the `ElectricalAssembly` class has an `encounterIssue()` method that alerts the mediator about the encountered issue, and the mediator informs the appropriate department to resolve the issue.

In the client code, the `main()` method creates instances of the mediator and the different departments involved in the car production, adds the departments to the mediator, and invokes the methods to simulate the production process. This example shows how the mediator design pattern can be used to manage the flow of communication and coordination between multiple objects in a complex system, such as a car production line.