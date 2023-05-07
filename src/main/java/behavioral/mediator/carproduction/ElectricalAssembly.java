package behavioral.mediator.carproduction;

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

    @Override
    public void encounterIssue() {
        mediator.notify("BodyAssembly", "ElectricalAssembly encountered an issue!");
    }

    @Override
    public void startWork() {
        mediator.notify("EngineAssembly", "ElectricalAssembly started work!");
    }

    @Override
    public void completeWork() {
        mediator.notify("EngineAssembly", "ElectricalAssembly encountered an issue!");
    }
}
