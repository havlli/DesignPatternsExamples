package behavioral.template.automatedtesting;

public class LoginTestRunner extends TestRunner {
    @Override
    protected void setUpEnvironment() {
        System.out.println("Setting up environment for login test...");
    }

    @Override
    protected void runTest() {
        System.out.println("Running login test...");
    }

    @Override
    protected void verifyResults() {
        System.out.println("Verifying login test results...");
    }
}
