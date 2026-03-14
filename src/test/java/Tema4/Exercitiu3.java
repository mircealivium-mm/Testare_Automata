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

public class Exercitiu3 {
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

    public void openProduct() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("card-img-top")));
        List<WebElement> firstProductFromPage = driver.findElements(By.className("card-img-top"));
        firstProductFromPage.get(0).click();

        wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.cssSelector("img.figure-img.img-fluid")
        ));


        WebElement verifyVisbileProduct = driver.findElement(By.cssSelector("img.figure-img.img-fluid"));
        Assert.assertTrue(verifyVisbileProduct.isDisplayed(), "Imaginea produsului nu este vizibila");
        System.out.println("Imaginea produsului este vizibila:" + verifyVisbileProduct.isDisplayed());

        WebElement verifyAddToCartButton = driver.findElement(By.xpath("//button[@data-test='add-to-cart']"));
        Assert.assertTrue(verifyAddToCartButton.isDisplayed(), "Butonul add to cart nu este vizibil");
        System.out.println("Butonul Add to cart este vizibil:" + verifyAddToCartButton.isDisplayed());


    }

}
