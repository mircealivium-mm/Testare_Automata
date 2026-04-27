package Tema9.tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.*;
import Tema9.pages.HomePage;
import Tema9.pages.ProductPage;
import Tema9.pages.CartPage;

public class ProductTests {

    private WebDriver driver;
    private static final String PRODUCT_NAME = "Hammer";

    @BeforeMethod
    public void setUp() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }

    // =============================================
    // Test 1 – Adaugare produs in cos
    // =============================================
    @Test
    public void testAddProductToCart() {

        // 1. Deschide aplicatia
        HomePage homePage = new HomePage(driver);
        homePage.openApplication();

        // 2 & 3. Selecteaza produsul + acceseaza pagina de detalii
        ProductPage pageProduct = homePage.clickOnProduct(PRODUCT_NAME);

        // 4. Salveaza numele produsului intr-o variabila
        String savedProductName = pageProduct.getProductName();

        // 5. Adauga produsul in cos
        CartPage cartPage = pageProduct.addToCart();

        // 6. Acceseaza pagina de cart
        cartPage.goToCart();

        // 7. Verifica faptul ca produsul apare in cos
        Assert.assertTrue(
                cartPage.isProductInCart(savedProductName),
                "Produsul " + savedProductName + " nu se afla in cart!"
        );
    }

    // =============================================
    // Test 2 – Verificare detalii produs
    // =============================================
    @Test
    public void testProductDetails() {

        // 1. Deschide aplicatia
        HomePage homePage = new HomePage(driver);
        homePage.openApplication();

        // 2 & 3. Selecteaza produsul + acceseaza pagina de detalii
        ProductPage productPage = homePage.clickOnProduct(PRODUCT_NAME);

        // 4a. Verifica numele produsului NU este gol
        String productName = productPage.getProductName();
        Assert.assertFalse(
                productName.isEmpty(),
                "Numele produsului este gol!"
        );

        // 4b. Verifica pretul produsului este mai mare decat 0
        double productPrice = productPage.getProductPriceAsDouble();
        Assert.assertTrue(
                productPrice > 0,
                "Pretul produsului nu este mai mare decat 0! Pret actual: " + productPrice
        );
    }

    @AfterMethod
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}