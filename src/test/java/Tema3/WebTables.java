import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class WebTables {

    WebDriver driver;

    @BeforeMethod
    public void setup() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://demoqa.com/webtables");

    }

    @Test
    public void addRecordTest() throws InterruptedException {
        driver.findElement(By.xpath("//button[@id='addNewRecordButton']")).click();

        Thread.sleep(1000);

        driver.findElement(By.xpath("//input[@id='firstName']")).sendKeys("Test");
        driver.findElement(By.xpath("//input[@id='lastName']")).sendKeys("User");
        driver.findElement(By.xpath("//input[@id='userEmail']")).sendKeys("test@email.com");
        driver.findElement(By.xpath("//input[@id='age']")).sendKeys("35");
        driver.findElement(By.xpath("//input[@id='salary']")).sendKeys("1000");
        driver.findElement(By.xpath("//input[@id='department']")).sendKeys("IT");

        WebElement submitButton = driver.findElement(By.xpath("//button[text()='Submit']"));
        Assert.assertNotNull(submitButton);
        Assert.assertTrue(submitButton.isDisplayed());
        submitButton.click();

        Thread.sleep(2000);

    }

    @AfterMethod
    public void tearDown() throws InterruptedException {
        Thread.sleep(3000);
        driver.quit();
    }
}