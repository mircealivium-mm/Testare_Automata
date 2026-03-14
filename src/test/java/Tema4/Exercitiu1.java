package Tema4;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Exercitiu1 {
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

    public void verificaTitlulPaginii() {
        String titlulAsteptat = "Practice Software Testing - Toolshop - v5.0";
        String titlulReal = driver.getTitle();
        Assert.assertEquals(titlulReal, titlulAsteptat, "Titlul nu corespunde");
        System.out.println("Titlul paginii este:" + titlulReal);


    }

    @Test
    public void verificaLogoul() {
        WebElement logo = driver.findElement(By.xpath("//a[@class='navbar-brand']"));
        Assert.assertTrue(logo.isDisplayed(), "Logo-ul nu este vizibil");
        System.out.println("Logo-ul este vizibil: " + logo.isDisplayed());
    }
}
