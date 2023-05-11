package behavioral.template.automatedtesting;

public class RegistrationTestRunner extends TestRunner {
    @Override
    protected void setUpEnvironment() {
        System.out.println("Setting up environment for registration test...");
    }

    @Override
    protected void runTest() {
        System.out.println("Running registration test...");
    }

    @Override
    protected void verifyResults() {
        System.out.println("Verifying registration test results...");
    }
}
