package Tema6;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Exercitiu2 {

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
    public void testNavigareIntreTaburi() {

        // Pasul 1: Deschidem primul site si salvam id-ul tabului
        driver.get("https://practicesoftwaretesting.com/");
        String tab1 = driver.getWindowHandle();

        // Pasul 2: Deschidem un tab nou
        driver.switchTo().newWindow(WindowType.TAB);

        // Pasul 3: Navigam pe al doilea site si salvam id-ul tabului
        driver.get("https://google.com");
        String tab2 = driver.getWindowHandle();

        // Pasul 4: Verificam titlul tabului 2
        System.out.println("Titlu Tab 2: " + driver.getTitle());
        Assert.assertTrue(driver.getTitle().contains("Google"),
                "Titlul tab 2 nu este corect!");

        // Pasul 5: Ne mutam pe primul tab
        driver.switchTo().window(tab1);

        // Pasul 6: Verificam titlul tabului 1
        System.out.println("Titlu Tab 1: " + driver.getTitle());
        Assert.assertTrue(driver.getTitle().contains("Practice Software Testing"),
                "Titlul tab 1 nu este corect!");
    }
}