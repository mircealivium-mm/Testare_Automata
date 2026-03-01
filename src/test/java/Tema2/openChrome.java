import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class openChrome {

    @Test
    public void openGoogleChrome() {
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.google.com");



    }

}