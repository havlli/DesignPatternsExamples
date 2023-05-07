package behavioral.mediator.carproduction;

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

    @Override
    public void startWork() {
        mediator.notify("BodyAssembly", "EngineAssembly started its work.");
    }

    @Override
    public void encounterIssue() {
        mediator.notify("BodyAssembly", "EngineAssembly encountered issue.");
    }
}
