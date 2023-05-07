package behavioral.mediator.carproduction;

import java.util.HashMap;
import java.util.Map;

public class ProductionManager implements ProductionMediator {
    private Map<String, Department> departments = new HashMap<>();

    @Override
    public void addDepartment(String name, Department department) {
        departments.put(name, department);
        department.setMediator(this);
    }

    @Override
    public void notify(String department, String message) {
        departments.get(department).receiveMessage(message);
    }
}
