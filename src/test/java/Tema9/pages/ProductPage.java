package Tema9.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ProductPage extends BasePage {

    @FindBy(css = "[data-test='product-name']")
    private WebElement productName;

    @FindBy(css = "[data-test='unit-price']")
    private WebElement productPrice;

    @FindBy(css = "[data-test='add-to-cart']")
    private WebElement addToCartButton;

    public ProductPage(WebDriver driver) {
        super(driver);
    }

    public String getProductName() {
        return getText(productName);
    }

    public String getProductPrice() {
        return getText(productPrice);
    }

    public double getProductPriceAsDouble() {
        String priceText = getText(productPrice);
        String cleanPrice = priceText.replace("$", "").trim();
        return Double.parseDouble(cleanPrice);
    }

    public CartPage addToCart() {
        click(addToCartButton);
        return new CartPage(driver);
    }
}