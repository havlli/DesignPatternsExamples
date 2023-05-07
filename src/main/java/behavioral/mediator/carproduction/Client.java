package behavioral.mediator.carproduction;

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
