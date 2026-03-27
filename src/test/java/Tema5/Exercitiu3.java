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

public class Exercitiu3 {

    WebDriver driver;

    @BeforeMethod
    public void setUp() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://practicesoftwaretesting.com/");
    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }

    @Test
    public void searchBoxTest() {

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        // Pasul 1:
        WebElement searchBox = wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.xpath("//input[@data-test='search-query']")));
        searchBox.sendKeys("Hammer");
        searchBox.submit();

        // Pasul 2:
        wait.until(ExpectedConditions.textToBePresentInElementLocated(
                By.cssSelector(".card-title"), "Hammer"));

        // Pasul 3:
        WebElement firstProduct = wait.until(ExpectedConditions.elementToBeClickable(
                By.className("card-img-top")));
        firstProduct.click();

        // Pasul 4:
        wait.until(ExpectedConditions.urlContains("/product/"));

        // Pasul 5:
        WebElement addToCart = wait.until(ExpectedConditions.elementToBeClickable(
                By.xpath("//button[@data-test='add-to-cart']")));
        addToCart.click();

        // Pasul 6:
        WebElement cartBadge = wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.xpath("//span[@data-test='cart-quantity']")));
        wait.until(ExpectedConditions.textToBePresentInElement(cartBadge, "1"));

        // Pasul 7:
        cartBadge.click();

        // Pasul 8:
        wait.until(ExpectedConditions.urlContains("/checkout"));

        // Pasul 9:
        WebElement productInCart = wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.xpath("//*[@data-test='product-title']")));
        Assert.assertTrue(productInCart.getText().contains("Hammer"),
                "Produsul Hammer nu este in cos!");

        // Pasul 10:
        WebElement quantity = wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.xpath("//input[@data-test='product-quantity']")));
        Assert.assertEquals(quantity.getAttribute("value"), "1",
                "Cantitatea nu este 1!");

        // Pasul 11:
        WebElement productPrice = wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.xpath("//*[@data-test='product-price']")));
        Assert.assertTrue(productPrice.isDisplayed(),
                "Pretul nu este afisat in cos!");
    }
}