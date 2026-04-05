package Tema6;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.time.Duration;

public class Exercitiu6 {

    WebDriver driver;

    @BeforeTest
    public void setUp() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://practicesoftwaretesting.com/");
    }

    @AfterTest
    public void tearDown() {
        driver.quit();
    }

    // Grupul "navigare"
    @Test(groups = {"navigare"})
    public void verificaTitluSite() {
        driver.get("https://practicesoftwaretesting.com/");
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        wait.until(ExpectedConditions.titleContains("Practice Software Testing"));
        System.out.println("Titlu site: " + driver.getTitle());
        Assert.assertTrue(driver.getTitle().contains("Practice Software Testing"),
                "Titlul site-ului nu este corect!");
    }

    @Test(groups = {"navigare"})
    public void verificaRefresh() {
        driver.get("https://practicesoftwaretesting.com/");
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        wait.until(ExpectedConditions.titleContains("Practice Software Testing"));
        String titluInainte = driver.getTitle();

        driver.navigate().refresh();

        wait.until(ExpectedConditions.titleContains("Practice Software Testing"));
        String titluDupa = driver.getTitle();

        System.out.println("Titlu inainte: " + titluInainte);
        System.out.println("Titlu dupa refresh: " + titluDupa);
        Assert.assertEquals(titluInainte, titluDupa,
                "Titlul s-a schimbat dupa refresh!");
    }

    // Grupul "cautare"
    @Test(groups = {"cautare"})
    public void verificaCautareHammer() {
        driver.get("https://practicesoftwaretesting.com/");
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        WebElement searchBox = wait.until(ExpectedConditions.elementToBeClickable(
                By.xpath("//input[@data-test='search-query']")));
        searchBox.sendKeys("Hammer");
        searchBox.submit();

        wait.until(ExpectedConditions.textToBePresentInElementLocated(
                By.className("card-title"), "Hammer"));

        WebElement primulRezultat = driver.findElement(By.className("card-title"));
        System.out.println("Primul rezultat: " + primulRezultat.getText());
        Assert.assertTrue(primulRezultat.getText().contains("Hammer"),
                "Rezultatele cautarii nu contin Hammer!");
    }

    @Test(groups = {"cautare"})
    public void verificaCautarePliers() {
        driver.get("https://practicesoftwaretesting.com/");
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        WebElement searchBox = wait.until(ExpectedConditions.elementToBeClickable(
                By.xpath("//input[@data-test='search-query']")));
        searchBox.sendKeys("Pliers");
        searchBox.submit();

        wait.until(ExpectedConditions.textToBePresentInElementLocated(
                By.className("card-title"), "Pliers"));

        WebElement primulRezultat = driver.findElement(By.className("card-title"));
        System.out.println("Primul rezultat: " + primulRezultat.getText());
        Assert.assertTrue(primulRezultat.getText().contains("Pliers"),
                "Rezultatele cautarii nu contin Pliers!");
    }

    // Grupul "cos"
    @Test(groups = {"cos"})
    public void verificaAdaugareInCos() {
        driver.get("https://practicesoftwaretesting.com/");
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        WebElement searchBox = wait.until(ExpectedConditions.elementToBeClickable(
                By.xpath("//input[@data-test='search-query']")));
        searchBox.sendKeys("Hammer");
        searchBox.submit();

        wait.until(ExpectedConditions.textToBePresentInElementLocated(
                By.className("card-title"), "Hammer"));
        driver.findElement(By.className("card-img-top")).click();

        wait.until(ExpectedConditions.urlContains("/product/"));
        WebElement addToCart = wait.until(ExpectedConditions.elementToBeClickable(
                By.xpath("//button[@data-test='add-to-cart']")));
        addToCart.click();

        WebElement cartBadge = wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.xpath("//span[@data-test='cart-quantity']")));
        wait.until(ExpectedConditions.textToBePresentInElement(cartBadge, "1"));

        System.out.println("Cantitate cos: " + cartBadge.getText());
        Assert.assertEquals(cartBadge.getText(), "1",
                "Cantitatea din cos nu este 1!");
    }

    // Grupul "tab"
    @Test(groups = {"tab"})
    public void verificaTabNou() {
        driver.get("https://practicesoftwaretesting.com/");
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        String tabPrincipal = driver.getWindowHandle();

        driver.switchTo().newWindow(WindowType.TAB);
        driver.get("https://google.com");

        System.out.println("Titlu tab nou: " + driver.getTitle());
        Assert.assertTrue(driver.getTitle().contains("Google"),
                "Tabul nou nu contine Google!");

        driver.switchTo().window(tabPrincipal);

        System.out.println("Titlu tab principal: " + driver.getTitle());
        Assert.assertTrue(driver.getTitle().contains("Practice Software Testing"),
                "Nu suntem pe tabul principal!");
    }
}