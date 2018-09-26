package ru.stqa.sqa;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import static org.junit.Assert.assertTrue;
import static org.openqa.selenium.support.ui.ExpectedConditions.titleIs;


public class TestMenu {
    private WebDriver driver;
    private WebDriverWait wait;


    @Before
    public void start () {
        driver = new ChromeDriver();
        wait = new WebDriverWait(driver, 10);



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
    public void testMenu() {
        driver.get("http://localhost/litecart/admin/");
        driver.findElement(By.cssSelector("[name=username]")).sendKeys("admin");
        driver.findElement(By.cssSelector("[type=password]")).sendKeys("123456");
        driver.findElement(By.cssSelector("[type=submit]")).click();
        driver.findElement(By.cssSelector("a[href*=appearance]")).click();
        wait.until(titleIs("Template | My Store"));
        assertTrue(isElementPresent(By.cssSelector("h1")));
        driver.findElement(By.cssSelector("a[href*=template]")).click();
        wait.until(titleIs("Template | My Store"));
        assertTrue(isElementPresent(By.cssSelector("h1")));
        driver.findElement(By.cssSelector("a[href*=logotype]")).click();
        wait.until(titleIs("Logotype | My Store"));
        assertTrue(isElementPresent(By.cssSelector("h1")));
        driver.findElement(By.cssSelector("a[href*=catalog]")).click();
        wait.until(titleIs("Catalog | My Store"));
        assertTrue(isElementPresent(By.cssSelector("h1")));
        driver.findElement(By.cssSelector("a[href*=product_groups]")).click();
        wait.until(titleIs("Product Groups | My Store"));
        assertTrue(isElementPresent(By.cssSelector("h1")));
        driver.findElement(By.cssSelector("a[href*=option_groups]")).click();
        wait.until(titleIs("Option Groups | My Store"));
        assertTrue(isElementPresent(By.cssSelector("h1")));
        driver.findElement(By.cssSelector("a[href*=manufacturers]")).click();
        wait.until(titleIs("Manufacturers | My Store"));
        assertTrue(isElementPresent(By.cssSelector("h1")));
        driver.findElement(By.cssSelector("a[href*=suppliers]")).click();
        wait.until(titleIs("Suppliers | My Store"));
        assertTrue(isElementPresent(By.cssSelector("h1")));
        driver.findElement(By.cssSelector("a[href*=delivery_statuses]")).click();
        wait.until(titleIs("Delivery Statuses | My Store"));
        assertTrue(isElementPresent(By.cssSelector("h1")));
        driver.findElement(By.cssSelector("a[href*=sold_out_statuses]")).click();
        wait.until(titleIs("Sold Out Statuses | My Store"));
        assertTrue(isElementPresent(By.cssSelector("h1")));
        driver.findElement(By.cssSelector("a[href*=quantity_units]")).click();
        wait.until(titleIs("Quantity Units | My Store"));
        assertTrue(isElementPresent(By.cssSelector("h1")));
        driver.findElement(By.cssSelector("li#doc-csv a[href*=csv]")).click();
        wait.until(titleIs("CSV Import/Export | My Store"));
        assertTrue(isElementPresent(By.cssSelector("h1")));
        driver.findElement(By.cssSelector("a[href*=countries]")).click();
        wait.until(titleIs("Countries | My Store"));
        assertTrue(isElementPresent(By.cssSelector("h1")));
        driver.findElement(By.cssSelector("a[href*=currencies]")).click();
        wait.until(titleIs("Currencies | My Store"));
        assertTrue(isElementPresent(By.cssSelector("h1")));
        driver.findElement(By.cssSelector("a[href*=customers]")).click();
        wait.until(titleIs("Customers | My Store"));
        assertTrue(isElementPresent(By.cssSelector("h1")));
        driver.findElement(By.cssSelector("li#doc-csv a[href*=csv]")).click();
        wait.until(titleIs("CSV Import/Export | My Store"));
        assertTrue(isElementPresent(By.cssSelector("h1")));
        driver.findElement(By.cssSelector("a[href*=newsletter]")).click();
        wait.until(titleIs("Newsletter | My Store"));
        assertTrue(isElementPresent(By.cssSelector("h1")));
        driver.findElement(By.cssSelector("a[href*=geo_zones]")).click();
        wait.until(titleIs("Geo Zones | My Store"));
        assertTrue(isElementPresent(By.cssSelector("h1")));
        driver.findElement(By.cssSelector("a[href*=languages]")).click();
        wait.until(titleIs("Languages | My Store"));
        assertTrue(isElementPresent(By.cssSelector("h1")));
        driver.findElement(By.cssSelector("li#app- a[href*=storage_encoding]")).click();
        wait.until(titleIs("Storage Encoding | My Store"));
        assertTrue(isElementPresent(By.cssSelector("h1")));
        driver.findElement(By.cssSelector("a[href*=modules]")).click();
        wait.until(titleIs("Job Modules | My Store"));
        assertTrue(isElementPresent(By.cssSelector("h1")));
        driver.findElement(By.cssSelector("li#doc-customer a[href*=customer]")).click();
        wait.until(titleIs("Customer Modules | My Store"));
        assertTrue(isElementPresent(By.cssSelector("h1")));
        driver.findElement(By.cssSelector("a[href*=shipping]")).click();
        wait.until(titleIs("Shipping Modules | My Store"));
        assertTrue(isElementPresent(By.cssSelector("h1")));
        driver.findElement(By.cssSelector("a[href*=payment]")).click();
        wait.until(titleIs("Payment Modules | My Store"));
        assertTrue(isElementPresent(By.cssSelector("h1")));
        driver.findElement(By.cssSelector("a[href*=order_total]")).click();
        wait.until(titleIs("Order Total Modules | My Store"));
        assertTrue(isElementPresent(By.cssSelector("h1")));
        driver.findElement(By.cssSelector("a[href*=order_success]")).click();
        wait.until(titleIs("Order Success Modules | My Store"));
        assertTrue(isElementPresent(By.cssSelector("h1")));
        driver.findElement(By.cssSelector("a[href*=order_action]")).click();
        wait.until(titleIs("Order Action Modules | My Store"));
        assertTrue(isElementPresent(By.cssSelector("h1")));
        driver.findElement(By.cssSelector("a[href*=orders]")).click();
        wait.until(titleIs("Orders | My Store"));
        assertTrue(isElementPresent(By.cssSelector("h1")));
        driver.findElement(By.cssSelector("a[href*=order_statuses]")).click();
        wait.until(titleIs("Order Statuses | My Store"));
        assertTrue(isElementPresent(By.cssSelector("h1")));
        driver.findElement(By.cssSelector("a[href*=pages]")).click();
        wait.until(titleIs("Pages | My Store"));
        assertTrue(isElementPresent(By.cssSelector("h1")));
        driver.findElement(By.cssSelector("a[href*=reports]")).click();
        wait.until(titleIs("Monthly Sales | My Store"));
        assertTrue(isElementPresent(By.cssSelector("h1")));
        driver.findElement(By.cssSelector("a[href*=most_sold_products]")).click();
        wait.until(titleIs("Most Sold Products | My Store"));
        assertTrue(isElementPresent(By.cssSelector("h1")));
        driver.findElement(By.cssSelector("a[href*=most_shopping_customers]")).click();
        wait.until(titleIs("Most Shopping Customers | My Store"));
        assertTrue(isElementPresent(By.cssSelector("h1")));
        driver.findElement(By.cssSelector("li#app- a[href*=settings]")).click();
        wait.until(titleIs("Settings | My Store"));
        assertTrue(isElementPresent(By.cssSelector("h1")));
        driver.findElement(By.cssSelector("a[href*=default]")).click();
        wait.until(titleIs("Settings | My Store"));
        assertTrue(isElementPresent(By.cssSelector("h1")));
        driver.findElement(By.cssSelector("a[href*=general]")).click();
        wait.until(titleIs("Settings | My Store"));
        assertTrue(isElementPresent(By.cssSelector("h1")));
        driver.findElement(By.cssSelector("a[href*=listings]")).click();
        wait.until(titleIs("Settings | My Store"));
        assertTrue(isElementPresent(By.cssSelector("h1")));
        driver.findElement(By.cssSelector("li#doc-advanced a[href*=advanced]")).click();
        wait.until(titleIs("Settings | My Store"));
        assertTrue(isElementPresent(By.cssSelector("h1")));
        driver.findElement(By.cssSelector("a[href*=security]")).click();
        wait.until(titleIs("Settings | My Store"));
        assertTrue(isElementPresent(By.cssSelector("h1")));
        driver.findElement(By.cssSelector("a[href*=slides]")).click();
        wait.until(titleIs("Slides | My Store"));
        assertTrue(isElementPresent(By.cssSelector("h1")));
        driver.findElement(By.cssSelector("a[href*=tax_classes]")).click();
        wait.until(titleIs("Tax Classes | My Store"));
        assertTrue(isElementPresent(By.cssSelector("h1")));
        driver.findElement(By.cssSelector("a[href*=tax_rates]")).click();
        wait.until(titleIs("Tax Rates | My Store"));
        assertTrue(isElementPresent(By.cssSelector("h1")));
        driver.findElement(By.cssSelector("a[href*=translations]")).click();
        wait.until(titleIs("Search Translations | My Store"));
        assertTrue(isElementPresent(By.cssSelector("h1")));
        driver.findElement(By.cssSelector("a[href*=scan]")).click();
        wait.until(titleIs("Scan Files For Translations | My Store"));
        assertTrue(isElementPresent(By.cssSelector("h1")));
        driver.findElement(By.cssSelector("li#doc-csv")).click();
        wait.until(titleIs("CSV Import/Export | My Store"));
        assertTrue(isElementPresent(By.cssSelector("h1")));
        driver.findElement(By.cssSelector("a[href*=users]")).click();
        wait.until(titleIs("Users | My Store"));
        assertTrue(isElementPresent(By.cssSelector("h1")));
        driver.findElement(By.cssSelector("a[href*=vqmods]")).click();
        wait.until(titleIs("vQmods | My Store"));
        assertTrue(isElementPresent(By.cssSelector("h1")));

    }


    @After
    public void stop () {
        driver.quit();
        driver = null;
    }
}

