import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.openqa.selenium.interactions.Actions;

public class Demoqa {

    @Test
    public void textBoxTest() throws InterruptedException {
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://demoqa.com/text-box");

        WebElement fullName = driver.findElement(By.id("userName"));
        WebElement email = driver.findElement(By.id("userEmail"));
        WebElement currentAddress = driver.findElement(By.id("currentAddress"));
        WebElement permanentAddress = driver.findElement(By.id("permanentAddress"));

        WebElement submit = driver.findElement(By.id("submit"));

        fullName.sendKeys("Mircea");
        email.sendKeys("test@itschool.com");
        currentAddress.sendKeys("Bucharest");
        permanentAddress.sendKeys("Bucharest");

        Actions actions = new Actions(driver);
        actions.scrollToElement(submit).perform();
        actions.moveToElement(submit).click().perform();

        Thread.sleep(2000);

        WebElement output = driver.findElement(By.id("output"));
        Assert.assertTrue(output.isDisplayed());
    }
}