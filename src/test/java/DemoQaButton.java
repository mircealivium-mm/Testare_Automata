import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class DemoQaButton {

    @Test
    public void button() {
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://demoqa.com/buttons"); // ⚠️ URL corectat: /buttons nu /button

        WebElement clickMe = driver.findElement(By.xpath("//button[text()='Click Me']"));
        clickMe.click();

        boolean outputMsg = driver.findElement(By.id("dynamicClickMessage")).isDisplayed();
        Assert.assertTrue(outputMsg, "Mesajul nu este afisat");

        System.out.println(outputMsg);

        driver.quit(); // ✅ Închide browserul după test
    }
}