package Tema3;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class PracticeForm {

    WebDriver driver;

    @BeforeMethod
    public void setUp() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://demoqa.com/automation-practice-form");
    }

    @Test
    public void firstNameTest() {
        WebElement firstName = driver.findElement(By.xpath("//input[@placeholder = 'First Name']"));
        Assert.assertNotNull(firstName);
        Assert.assertTrue(firstName.isDisplayed());
        firstName.sendKeys("Test");
    }



    @AfterMethod
    public void tearDown() {
        driver.quit();
    }
}
