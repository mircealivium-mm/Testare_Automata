package Tema8;

public class MainTestRunner {
    public static void main(String[] args) {
        TestCase test1 = new LoginTest("Login valid user");
        TestCase test2 = new SearchTest("Search produs Hammer");

        test1.runTest();
        test2.runTest();
    }
}
