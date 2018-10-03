package ru.stqa.sqa;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;


import java.util.*;



import static org.junit.Assert.assertFalse;


public class TestMenu {
    private WebDriver driver;


    @Before
    public void start () {
        driver = new ChromeDriver();

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
        int x = driver.findElements(By.cssSelector("li#app-")).size();
        for (int i=0; i< x; i++) {
            ArrayList<WebElement> menu = new ArrayList<>(driver.findElements(By.cssSelector("li#app-")));
            WebElement app = menu.get(i);
            app.click();
            assertFalse(!isElementPresent(By.cssSelector("h1")));
            if (driver.findElements(By.cssSelector(".docs")).size() > 0) {
                menu = new ArrayList<>(driver.findElements(By.cssSelector("li#app-")));
                app = menu.get(i);
                int y = app.findElements(By.cssSelector("li")).size();
                for (int j = 1; j < y; j++) {
                    menu = new ArrayList<>(driver.findElements(By.cssSelector("li#app-")));
                    app = menu.get(i);
                    ArrayList<WebElement> m = new ArrayList<>(app.findElements(By.cssSelector("li")));
                    WebElement a = m.get(j);
                    a.click();
                    assertFalse(!isElementPresent(By.cssSelector("h1")));
                    menu = new ArrayList<>(driver.findElements(By.cssSelector("li#app-")));
                    menu.get(i);
                }
            }


            }
        }






    @After
    public void stop () {
        driver.quit();
        driver = null;
    }
}

