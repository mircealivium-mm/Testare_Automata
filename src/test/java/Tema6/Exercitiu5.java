package Tema6;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;

public class Exercitiu5 {

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

    // Primul test care ruleaza - verifica ca site-ul s-a deschis
    @Test(priority = -1)
    public void verificaTitluSite() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        wait.until(ExpectedConditions.titleContains("Practice Software Testing"));

        System.out.println("Titlu site: " + driver.getTitle());
        Assert.assertTrue(driver.getTitle().contains("Practice Software Testing"),
                "Titlul site-ului nu este corect!");
    }

    // Al doilea test - verifica ca search-ul functioneaza
    @Test(priority = 0)
    public void verificaCautareProdus() {
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

    // Al treilea test - verifica ca produsul se adauga in cos
    @Test(priority = 1)
    public void verificaAdaugareInCos() {
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

    // Al patrulea test - verifica deschiderea unui tab nou
    @Test(priority = 2)
    public void verificaTabNou() {
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

    // Al cincilea test - verifica refresh-ul paginii
    @Test(priority = 3)
    public void verificaRefresh() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        wait.until(ExpectedConditions.titleContains("Practice Software Testing"));
        String titluInainte = driver.getTitle();
        System.out.println("Titlu inainte de refresh: " + titluInainte);

        driver.navigate().refresh();

        wait.until(ExpectedConditions.titleContains("Practice Software Testing"));
        String titluDupa = driver.getTitle();
        System.out.println("Titlu dupa refresh: " + titluDupa);

        Assert.assertEquals(titluInainte, titluDupa,
                "Titlul s-a schimbat dupa refresh!");
    }
}