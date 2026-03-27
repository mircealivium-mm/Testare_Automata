package Tema5;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.awt.*;
import java.time.Duration;
import java.util.List;

public class Exercitiu1 {

    WebDriver driver;

    @BeforeMethod
    public void setUp(){
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://practicesoftwaretesting.com/");

    }
    @AfterMethod
    public void tearDown() throws InterruptedException {
        Thread.sleep(5000);
        driver.quit();
    }

    @Test
    public void accesareCategorieProduse() {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));


            wait.until(ExpectedConditions.visibilityOfElementLocated(
                    By.xpath("//label[contains(text(),'Power Tools')]//preceding-sibling::input")
            ));
            driver.findElement(
                    By.xpath("//label[contains(text(),'Power Tools')]//preceding-sibling::input")
            ).click();


            wait.until(ExpectedConditions.visibilityOfElementLocated(
                    By.xpath("//label[contains(text(),'ForgeFlex Tools')]//preceding-sibling::input")
            ));
            driver.findElement(
                    By.xpath("//label[contains(text(),'ForgeFlex Tools')]//preceding-sibling::input")
            ).click();

        // Asteptam sa apara produsele filtrate
        wait.until(ExpectedConditions.numberOfElementsToBeMoreThan(
                By.className("card-title"), 1
        ));

// Luam toate titlurile produselor
        List<WebElement> produse = driver.findElements(By.className("card-title"));

// Numaram cate produse contin "ForgeFlex" in nume
        int contor = 0;
        for (WebElement produs : produse) {
            if (produs.getText().contains("ForgeFlex")) {
                contor++;
            }
        }

// Verificam ca sunt cel putin 2 produse
        Assert.assertTrue(contor >= 2, "Nu sunt cel putin 2 produse cu numele categoriei!");
        }

    }

