package Tema5;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;

public class Exercitiu2 {

    WebDriver driver;

    @BeforeMethod
    public void setUp() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://practicesoftwaretesting.com/");
    }

    @AfterMethod
    public void tearDown() throws InterruptedException {
        Thread.sleep(5000);
        driver.quit();
    }

    @Test

    public void deschideUnProdus() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

//1
        WebElement drillCheckBox = wait.until(ExpectedConditions.elementToBeClickable(
                By.xpath("//label[contains(text(),'Drill')]//preceding-sibling::input")));
        drillCheckBox.click();



//2
        wait.until(ExpectedConditions.numberOfElementsToBeMoreThan(By.className("card-img-top"), 0));

//        wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("card-img-top")));

//        driver.findElements(By.className("card-img-top")).get(0).click();

//3
       WebElement primulProdus = wait.until(ExpectedConditions.elementToBeClickable(By.className("card-img-top")));
       primulProdus.click();

// 4
        wait.until(ExpectedConditions.urlContains("/product/"));

//5

        WebElement butonAdaugaInCos = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[@data-test='add-to-cart']")));
        butonAdaugaInCos.click();

//6
        WebElement cantitateCos =wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[@data-test='cart-quantity']")));
        cantitateCos.click();

//7
        Assert.assertTrue(cantitateCos.isDisplayed(), "Cosul nu este vizibil");

        Assert.assertEquals(cantitateCos.getText(), "1", "Cantitatea nu este 1");


    }

}
