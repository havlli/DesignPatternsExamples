package behavioral.mediator.carproduction;

public interface Department {
    void setMediator(ProductionMediator mediator);
    void receiveMessage(String message);
    void startWork();
    void completeWork();
    void encounterIssue();
}
