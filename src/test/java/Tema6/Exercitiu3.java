package Tema6;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Exercitiu3 {

    WebDriver driver;

    @BeforeMethod
    public void setUp() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }

    @Test
    public void testInchidereTab() {

        // Pasul 1: Deschidem primul site si salvam id-ul tabului
        driver.get("https://practicesoftwaretesting.com/");
        String tab1 = driver.getWindowHandle();

        // Pasul 2: Deschidem un tab nou
        driver.switchTo().newWindow(WindowType.TAB);

        // Pasul 3: Navigam pe al doilea site
        driver.get("https://google.com");

        // Pasul 4: Inchidem tabul 2
        driver.close();

        // Pasul 5: Revenim pe primul tab
        driver.switchTo().window(tab1);

        // Pasul 6: Verificam ca suntem pe pagina corecta
        System.out.println("Titlu Tab 1: " + driver.getTitle());
        Assert.assertTrue(driver.getTitle().contains("Practice Software Testing"),
                "Nu suntem pe pagina corecta!");
    }
}