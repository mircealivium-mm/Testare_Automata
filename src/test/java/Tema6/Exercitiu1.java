package Tema6;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Exercitiu1 {

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
    public void testDouaTaburi() {

        // a) Deschidem primul site
        driver.get("https://practicesoftwaretesting.com/");
        String tab1 = driver.getWindowHandle();

        // b) Deschidem un tab nou
        driver.switchTo().newWindow(WindowType.TAB);

        // c) Accesam alt site in tabul nou
        driver.get("https://google.com");
        String tab2 = driver.getWindowHandle();

        // d) Afisam titlul ambelor taburi

        // Titlul tabului 2 (suntem deja pe el)
        System.out.println("Titlu Tab 2: " + driver.getTitle());

        // Ne mutam pe primul tab si afisam titlul
        driver.switchTo().window(tab1);
        System.out.println("Titlu Tab 1: " + driver.getTitle());
    }
}
