package Tema3;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Submit {

    WebDriver driver;

    @BeforeMethod
    public void setUp() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://demoqa.com/automation-practice-form");
    }

    @Test
    public void submitButtonTest() throws InterruptedException {
        WebElement firstName = driver.findElement(By.xpath("//input[@placeholder = 'First Name']"));
        WebElement lastName = driver.findElement(By.xpath("//input[@id = 'lastName']"));
        WebElement email = driver.findElement(By.xpath("//input[@id='userEmail']"));
        WebElement mobileNumber = driver.findElement(By.xpath("//input[@id='userNumber']"));
        WebElement subjects = driver.findElement(By.xpath("//input[@id='subjectsInput']"));
        firstName.sendKeys("Test");
        lastName.sendKeys("User");
        email.sendKeys("test@email.com");
        mobileNumber.sendKeys("0733558899");
        subjects.sendKeys("Automation");

        WebElement gender = driver.findElement(By.xpath("//label[text()='Male']"));
        gender.click();

        WebElement submitButton = driver.findElement(By.xpath("//button[text()='Submit']"));
        Assert.assertNotNull(submitButton);
        Assert.assertTrue(submitButton.isDisplayed());
        submitButton.click();

        Thread.sleep(2000);

        WebElement modal = driver.findElement(By.xpath("//div[@class='modal-content']"));
        Assert.assertTrue(modal.isDisplayed());

        WebElement closeButton = driver.findElement(By.xpath("//button[text()='Close']"));
        closeButton.click();
    }



    @AfterMethod
    public void tearDown() throws InterruptedException {
        Thread.sleep(3000);
        driver.quit();
    }
}
