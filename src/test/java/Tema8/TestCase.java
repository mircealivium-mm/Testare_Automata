package Tema8;

public class TestCase {
    protected String name;

    public TestCase(String name) {
        this.name = name;
    }

    public void runTest() {
        System.out.println("Rulare test" + name);
    }
}
