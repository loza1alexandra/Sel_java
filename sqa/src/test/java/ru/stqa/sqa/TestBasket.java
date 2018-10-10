package ru.stqa.sqa;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.ArrayList;

import static org.openqa.selenium.support.ui.ExpectedConditions.textToBePresentInElement;

public class TestBasket {
    private WebDriver driver;
    private WebDriverWait wait;


    @Before
    public void start() {
        DesiredCapabilities caps = new DesiredCapabilities();
        driver = new FirefoxDriver(caps);
        wait = new WebDriverWait(driver, 30);

    }
    public boolean isElementPresent (By locator) {
        try {
            driver.findElement(locator);
            return true;
        } catch (NoSuchElementException ex) {
            return false;
        }
    }


    @Test
    public void testBasket() {
        for (int i=0; i<3; i++) {
            addProductToBasket();
        }

        driver.findElement(By.xpath("//a[contains(.,  'Checkout')]")).click();
        int j = driver.findElements(By.cssSelector(".dataTable .item:not([class=header]")).size();
        j=j-1;
        for (int k = 0; k < j; k++) {
            deleteFromBasket();
        }
 }




    private void deleteFromBasket() {
        ArrayList<WebElement> products = new ArrayList<>(driver.findElements(By.cssSelector(".dataTable tr")));
        driver.findElement(By.xpath("//button[contains(.,  'Remove')]")).click();
        wait.until(ExpectedConditions.stalenessOf(products.get(1)));
        //products = new ArrayList<>(driver.findElements(By.cssSelector(".dataTable tr")));
    }

    private void addProductToBasket() {
        driver.get("http://localhost/litecart/en/");
        driver.findElement(By.cssSelector("div#box-most-popular a:first-child")).click();
        if (isElementPresent(By.cssSelector("select")) == true) {
        driver.findElement(By.cssSelector("select")).click();
        driver.findElement(By.cssSelector("option:not([selected]")).click();
       }
        WebElement quantityItem = driver.findElement(By.cssSelector("span.quantity"));
        String item = quantityItem.getText();
        int itemInt = Integer.parseInt(item);
        itemInt = itemInt +1;
        String itemNew = Integer.toString(itemInt);

        driver.findElement(By.xpath("//button[contains(.,  'Add To Cart')]")).click();
        wait.until(textToBePresentInElement(quantityItem, itemNew));
    }
    /@After
    public void stop () {
        driver.quit();
        driver = null;
   }
}
