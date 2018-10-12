package ru.stqa.sqa;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.io.File;
import java.util.concurrent.TimeUnit;

import static org.junit.Assert.assertEquals;

public class TestAddNewProduct {

    private WebDriver driver;

    @Before
    public void start() {
        driver = new ChromeDriver();
    }


    @Test
    public void testAddNewProduct () {
        driver.get("http://localhost/litecart/admin/");
        driver.findElement(By.cssSelector("[name=username]")).sendKeys("admin");
        driver.findElement(By.cssSelector("[type=password]")).sendKeys("123456");
        driver.findElement(By.cssSelector("[type=submit]")).click();
        driver.get("http://localhost/litecart/admin/?app=catalog&doc=catalog");
        int before = driver.findElements(By.cssSelector(".row")).size();
        driver.findElement(By.xpath("//a[contains(.,  'Add New Product')]")).click();
        driver.findElement(By.xpath("//label[contains(.,  'Enabled')]")).click();
        driver.findElement(By.cssSelector("[name ^= name]")).sendKeys("Test1");
        driver.findElement(By.cssSelector("[name = code]")).sendKeys("1234");
        driver.findElement(By.cssSelector("[name ^= product_groups]")).click();
        driver.findElement(By.cssSelector("[name = quantity]")).sendKeys("100");
        File image = new File("src/test/java/ru/stqa/sqa/4351634.jpg");
        String path = image.getAbsolutePath();
        driver.findElement(By.cssSelector("[type = file]")).sendKeys(path);
        driver.findElement(By.cssSelector("[name = date_valid_from]")).sendKeys("12022002");
        driver.findElement(By.cssSelector("[name = date_valid_to]")).sendKeys("12022020");
        driver.findElement(By.xpath("//a[contains(.,  'Information')]")).click();
        driver.findElement(By.cssSelector("[name = manufacturer_id]")).click();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.manage().timeouts().implicitlyWait(0, TimeUnit.SECONDS);
        chooseSelect("[name = manufacturer_id]");
        driver.findElement(By.cssSelector("[name = keywords]")).sendKeys("Test");
        driver.findElement(By.cssSelector("[name ^= short_description]")).sendKeys("Test");
        driver.findElement(By.cssSelector("[name ^= description]")).sendKeys("TestTestTest");
        driver.findElement(By.cssSelector("[name ^= head_title]")).sendKeys("test");
        driver.findElement(By.cssSelector("[name ^= meta_description]")).sendKeys("test");
        driver.findElement(By.xpath("//a[contains(.,  'Prices')]")).click();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.manage().timeouts().implicitlyWait(0, TimeUnit.SECONDS);
        driver.findElement(By.cssSelector("[name= purchase_price]")).sendKeys("20");
        chooseSelect("[name = purchase_price_currency_code]");
        driver.findElement(By.cssSelector("[name *= USD]")).sendKeys("20");
        driver.findElement(By.cssSelector("[name *= EUR]")).sendKeys("20");
        driver.findElement(By.xpath("//button[contains(.,  'Save')]")).click();
        int after = driver.findElements(By.cssSelector(".row")).size();
        assertEquals(before, after - 1);








    }

    private void chooseSelect(String s) {
        WebElement manufacturer = driver.findElement(By.cssSelector(s));
        Select manufactureerSelect = new Select(manufacturer);
        manufactureerSelect.selectByIndex(1);
    }

    @After
    public void stop () {
        driver.quit();
        driver = null;
    }

}
