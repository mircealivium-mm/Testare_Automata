package Tema4;

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
import java.util.List;

public class Exercitiu4 {
    WebDriver driver;

    @BeforeMethod

    public void setUp() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://practicesoftwaretesting.com/");

    }

    @AfterMethod

    public void tearDown() throws InterruptedException {
        Thread.sleep(3000);
        driver.quit();
    }

    @Test

    public void selectFilterTest() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.xpath("//label[contains(text(),'Power Tools')]//preceding-sibling::input")
        ));

        WebElement selectFilter = driver.findElement(
                By.xpath("//label[contains(text(),'Power Tools')]//preceding-sibling::input")
        );
        selectFilter.click();


        wait.until(ExpectedConditions.stalenessOf(
                driver.findElement(By.className("card-img-top"))
        ));

        wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.className("card-img-top")
        ));

        List<WebElement> produse = wait.until(
                ExpectedConditions.visibilityOfAllElementsLocatedBy(
                        By.className("card-img-top")
                )
        );

        Assert.assertTrue(produse.size() > 0, "Nu exista produse dupa filtrare!");
        System.out.println("Numar produse gasite dupa filtrare: " + produse.size());
    }

}
