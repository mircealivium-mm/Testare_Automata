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

public class Exercitiu4 {

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
    public void testDeschidereProdusInTabNou() {

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        // Pasul 1: Salvam id-ul tabului principal
        String tabPrincipal = driver.getWindowHandle();

        // Pasul 2: Cautam produse din categoria "Hammer"
        WebElement searchBox = wait.until(ExpectedConditions.elementToBeClickable(
                By.xpath("//input[@data-test='search-query']")));
        searchBox.sendKeys("Hammer");
        searchBox.submit();

        // Pasul 3: Asteptam sa apara produsele
        wait.until(ExpectedConditions.textToBePresentInElementLocated(
                By.className("card-title"), "Hammer"));

        // Pasul 4: Salvam link-ul paginii produsului
        WebElement primulProdus = wait.until(ExpectedConditions.elementToBeClickable(
                By.className("card-img-top")));
        String linkProdus = primulProdus.findElement(By.xpath("./..")).getAttribute("href");

        // Pasul 5: Deschidem un tab nou si navigam pe pagina produsului
        driver.switchTo().newWindow(WindowType.TAB);
        driver.get(linkProdus);

        // Pasul 6: Verificam ca pagina produsului s-a deschis corect
        wait.until(ExpectedConditions.urlContains("/product/"));
        Assert.assertTrue(driver.getTitle().contains("Practice Software Testing"),
                "Pagina produsului nu s-a incarcat corect!");
        System.out.println("Titlu tab nou: " + driver.getTitle());

        // Pasul 7: Revenim pe tabul principal
        driver.switchTo().window(tabPrincipal);

        // Pasul 8: Verificam ca suntem pe tabul principal
        Assert.assertTrue(driver.getTitle().contains("Practice Software Testing"),
                "Nu suntem pe tabul principal!");
        System.out.println("Titlu tab principal: " + driver.getTitle());

        // Pasul 9: Facem refresh pe tabul principal
        driver.navigate().refresh();

        // Pasul 10: Verificam ca pagina s-a reincarcat corect dupa refresh
        wait.until(ExpectedConditions.titleContains("Practice Software Testing"));
        Assert.assertTrue(driver.getTitle().contains("Practice Software Testing"),
                "Pagina nu s-a reincarcat corect dupa refresh!");
        System.out.println("Pagina dupa refresh: " + driver.getTitle());
    }
}