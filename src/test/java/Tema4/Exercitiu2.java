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
        Thread.sleep(3000);
        driver.quit();
    }

    @Test

    public void identifySearchBar() {
        WebElement searchBar = driver.findElement(By.xpath("//input[@placeholder='Search']"));
        searchBar.sendKeys("hammer");

        WebElement enterButton = driver.findElement(By.xpath("//button[@data-test='search-submit']"));
        enterButton.click();

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[@data-test='search-submit']")));
        System.out.println("Rezultatele afisate");

        List<WebElement> product = driver.findElements(By.className("card-img-top"));
        Assert.assertTrue(product.size()>0, "Nu a fost gasit nici un rezultat");
        System.out.println("Numarul de rezultate gasite:" + product.size());


    }




}
