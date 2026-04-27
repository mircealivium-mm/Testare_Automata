package Tema9.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.List;

public class CartPage extends BasePage {

    @FindBy(css = "[data-test='nav-cart']")
    private WebElement cartIcon;

    @FindBy(css = "[data-test='product-title']")
    private List<WebElement> cartItemNames;

    @FindBy(css = "[data-test='product-price']")
    private List<WebElement> cartItemPrices;

    public CartPage(WebDriver driver) {
        super(driver);
    }

    public void goToCart() {
        // ✅ Asteapta sa dispara toastul inainte de click
        wait.until(ExpectedConditions.invisibilityOfElementLocated(
                By.cssSelector(".toast-success")
        ));
        click(cartIcon);
    }

    public boolean isProductInCart(String productName) {
        for (WebElement item : cartItemNames) {
            if (item.getText().equals(productName)) {
                return true;
            }
        }
        return false;
    }

    public String getProductPriceFromCart(String productName) {
        for (int i = 0; i < cartItemNames.size(); i++) {
            if (cartItemNames.get(i).getText().equals(productName)) {
                return cartItemPrices.get(i).getText();
            }
        }
        return null;
    }
}