package behavioral.template.automatedtesting;

public abstract class TestRunner {
    public void executeTest() {
        setUpEnvironment();
        runTest();
        verifyResults();
    }

    protected abstract void setUpEnvironment();
    protected abstract void runTest();
    protected abstract void verifyResults();
}
