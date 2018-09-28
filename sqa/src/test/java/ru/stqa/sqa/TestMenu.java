package ru.stqa.sqa;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.ArrayList;

import static org.junit.Assert.assertFalse;
import static org.openqa.selenium.support.ui.ExpectedConditions.titleIs;


public class TestMenu {
    private WebDriver driver;
    //private WebDriverWait wait;


    @Before
    public void start () {
        driver = new ChromeDriver();
        //wait = new WebDriverWait(driver, 10);



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
        String s = driver.findElement(By.cssSelector(".name")).getText();
        WebElement menu;
        //ArrayList<WebElement> m = new ArrayList<>(driver.findElements(By.cssSelector(".name")));
    while (s == "vQmods") {
        ArrayList<WebElement> m = new ArrayList<>(driver.findElements(By.cssSelector(".name")))

    }
        //int i = 0;
        //driver.findElements(By.cssSelector(".name"));
        String s = driver.findElement(By.cssSelector(".name")).getText();
        System.out.println(s);
        //driver.findElement(By.cssSelector(".name")).click();
        //assertFalse(isElementPresent(By.cssSelector("h1")));

        //for (WebElement menu : driver.findElements(By.cssSelector(".name"))) {
           //menu.click();
            //wait.until(titleIs("webinar - Поиск в Google"))
            //if (menu.findElements(By.cssSelector("h1")).size() > 0) {
                //areElementsPresent = true;
            //} else {
                //areElementsPresent = false;
            //}
            //assertFalse(!areElementsPresent);
        }

        //}
        //driver.findElement(By.cssSelector("a[href*=appearance]")).click();
        //wait.until(titleIs("Template | My Store"));
        //assertTrue(isElementPresent(By.cssSelector("h1")));



    @After
    public void stop () {
        driver.quit();
        driver = null;
    }
}

