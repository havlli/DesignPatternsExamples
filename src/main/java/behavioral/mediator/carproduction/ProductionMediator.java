package behavioral.mediator.carproduction;

public interface ProductionMediator {
    void notify(String department, String message);
    void addDepartment(String name, Department department);
}
