package behavioral.template.automatedtesting;

public class Client {
    public static void main(String[] args) {
        TestRunner loginTestRunner = new LoginTestRunner();
        loginTestRunner.executeTest();

        TestRunner registrationTestRunner = new RegistrationTestRunner();
        registrationTestRunner.executeTest();
    }
}
