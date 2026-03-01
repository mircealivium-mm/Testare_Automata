import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class VerificaTitlulPaginii {
    WebDriver driver;

    @BeforeMethod
    public void Verificare() {
        driver = new ChromeDriver();
        driver.get("https://Example.com");


    }

    @Test
    public void VerificaTitlul() {
        String titlul = driver.getTitle();
        System.out.println("Titlul paginii este" + " " + titlul);
        Assert.assertTrue(titlul.contains("Example Domain"));

    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }
}
