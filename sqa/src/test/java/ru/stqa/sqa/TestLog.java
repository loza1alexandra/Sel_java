package ru.stqa.sqa;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.ArrayList;

public class TestLog {
    private WebDriver driver;
    public ArrayList<WebElement> goods;

    @Before
    public void start() {
        driver = new ChromeDriver();
    }

    @Test
    public void testLog () {
        driver.get("http://localhost/litecart/admin/");
        driver.findElement(By.cssSelector("[name=username]")).sendKeys("admin");
        driver.findElement(By.cssSelector("[type=password]")).sendKeys("123456");
        driver.findElement(By.cssSelector("[type=submit]")).click();
        driver.get("http://localhost/litecart/admin/?app=catalog&doc=catalog&category_id=1");
        goods = new ArrayList<>(driver.findElements(By.cssSelector("i.fa.fa-pencil")));
        for (int i = 0; i<goods.size(); i++) {
            goods.get(i).click();
            driver.manage().logs().get("browser").forEach(l -> System.out.println(l));
            driver.get("http://localhost/litecart/admin/?app=catalog&doc=catalog&category_id=1");
            goods = new ArrayList<>(driver.findElements(By.cssSelector("i.fa.fa-pencil")));
        }



    }


    @After
    public void stop () {
        driver.quit();
        driver = null;
    }
}

