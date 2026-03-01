import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Refactorizare {

    WebDriver driver;

    @BeforeMethod
    public void setUp() {
        driver = new ChromeDriver();
    }

    @Test
    public void navigareExample() {
        driver.get("https://example.com/");
    }

    @Test
    public void navigareApple() {
        driver.get("https://www.apple.com/");
    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }
}