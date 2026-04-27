package Tema9.pages;

import Tema9.pages.ProductPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.List;

public class HomePage extends BasePage {

    private static final String URL = "https://practicesoftwaretesting.com";

    @FindBy(css = "[data-test='product-name']")
    private List<WebElement> productNames;

    public HomePage(WebDriver driver) {
        super(driver);
    }

    public void openApplication() {
        driver.get(URL);
    }

    public ProductPage clickOnProduct(String productName) {
        wait.until(ExpectedConditions.visibilityOfAllElements(productNames));

        for (WebElement product : productNames) {
            if (getText(product).equals(productName)) {
                click(product);
                return new ProductPage(driver);
            }
        }
        throw new RuntimeException("Produsul nu a fost gasit: " + productName);
    }
}