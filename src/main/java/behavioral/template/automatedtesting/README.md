# Automated Testing
In an automated testing system, you might have a common test execution process that needs to be executed for different types of tests. By using the Template Method Pattern, you can define the basic structure of the test execution process in a base class, and then allow subclasses to implement their own logic for specific steps of the process, such as setting up the test environment, executing the test, or verifying the results.
```java
// Base class for test execution
abstract class TestRunner {
    // Template method to execute test
    public void executeTest() {
        // Step 1: Set up test environment
        setUpEnvironment();
        // Step 2: Execute test
        runTest();
        // Step 3: Verify test results
        verifyResults();
    }

    // Abstract methods to be implemented by subclasses
    protected abstract void setUpEnvironment();
    protected abstract void runTest();
    protected abstract void verifyResults();
}

// Subclass for specific type of test
class LoginTestRunner extends TestRunner {
    @Override
    protected void setUpEnvironment() {
        // Implementation for setting up environment for login test
        System.out.println("Setting up environment for login test...");
    }

    @Override
    protected void runTest() {
        // Implementation for running login test
        System.out.println("Running login test...");
    }

    @Override
    protected void verifyResults() {
        // Implementation for verifying login test results
        System.out.println("Verifying login test results...");
    }
}

// Subclass for another type of test
class RegistrationTestRunner extends TestRunner {
    @Override
    protected void setUpEnvironment() {
        // Implementation for setting up environment for registration test
        System.out.println("Setting up environment for registration test...");
    }

    @Override
    protected void runTest() {
        // Implementation for running registration test
        System.out.println("Running registration test...");
    }

    @Override
    protected void verifyResults() {
        // Implementation for verifying registration test results
        System.out.println("Verifying registration test results...");
    }
}

// Client code that uses the test runners
public class TestRunnerClient {
    public static void main(String[] args) {
        // Execute login test
        TestRunner loginTestRunner = new LoginTestRunner();
        loginTestRunner.executeTest();

        // Execute registration test
        TestRunner registrationTestRunner = new RegistrationTestRunner();
        registrationTestRunner.executeTest();
    }
}
```
In the above code, we have a base class `TestRunner` that defines the overall structure of the test execution process using a template method `executeTest()`. The template method consists of three steps: `setUpEnvironment()`, `runTest()`, and `verifyResults()`. These steps are left as abstract methods, which means that the specific implementation of these methods will be provided by the subclasses.

We then have two subclasses `LoginTestRunner` and `RegistrationTestRunner` that inherit from the `TestRunner` base class. These subclasses provide their own implementation for the three abstract methods defined in the base class, which allows them to customize the test execution process for their specific type of test.

Finally, we have a client code `TestRunnerClient` that uses the test runner objects to execute tests. We create an instance of `LoginTestRunner` and `RegistrationTestRunner` and call the `executeTest()` method on them to execute the corresponding tests.

With this design, we can easily add more types of tests by creating new subclasses of `TestRunner` and providing their own implementation for the abstract methods. This promotes code reusability and makes the test execution process flexible and extensible.