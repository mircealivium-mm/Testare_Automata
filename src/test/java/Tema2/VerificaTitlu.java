import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class VerificaTitlu {

    WebDriver driver;

    @BeforeMethod
    public void setUp() {
        driver = new ChromeDriver();
        driver.get("https://www3.fsonline.app/seriale/");
    }

    @Test
    public void verificaTitlu() {
        String titlu = driver.getTitle();
        System.out.printf("Titlul este" +" "+ titlu);

        Assert.assertNotNull(titlu);
        Assert.assertTrue(titlu.contains("Seriale Online Subtitrate"));
    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }
}