package behavioral.mediator.carproduction;

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
        mediator.notify("ElectricalAssembly", "BodyAssembly started its work.");
    }

    @Override
    public void completeWork() {
        mediator.notify("ElectricalAssembly", "BodyAssembly completed its work.");
    }

    @Override
    public void encounterIssue() {
        mediator.notify("ElectricalAssembly", "BodyAssembly encountered issue.");
    }
}
